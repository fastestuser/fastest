package client.blogic.testing.atcal;

import client.blogic.testing.atcal.apl.APLLValue;
import client.blogic.testing.atcal.apl.CallExpr;
import client.blogic.testing.atcal.apl.CodeBlock;
import client.blogic.testing.atcal.generators.Generator;
import client.blogic.testing.atcal.parser.AtcalBaseVisitor;
import client.blogic.testing.atcal.parser.AtcalLexer;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import client.blogic.testing.atcal.z.ast.ZVar;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import common.z.AbstractTCase;
import common.z.SpecUtils;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 05/06/15.
 */
public class AtcalEvaluator extends AtcalBaseVisitor<ConcreteTCase> {
    private final AbstractTCase abstractTCase;    // abstract test case to refine
    private ZExprSchema zExprSchema;              // ATCAL's AST representation of the abstract test case to refine
    private String preamble;                      // programming language code (defined in this rule and/or imported)
    private Map<String, ATCALType> datatypes;     // declared data types (types namespace)
    private CodeBlock refinedLawsCode;            // APL code resulting from the evaluation of the refinement laws
    private String plCode;                        // programming language code included in the rule
    private CallExpr uut;                         // APL code to call the unit under test
    private String epilogue;                      // programming language code (defined in this rule and/or imported)
    private final Generator codegen;              // code generator
    private final String concreteTCaseName;       // name of the concrete test case to generate

    /**
     * Creates a new ATCAL evaluator for the given abstract test case.
     *
     * @param abstractTCase the abstract test case to refine
     * @param codegen       the target refinement language
     */
    public AtcalEvaluator(AbstractTCase abstractTCase, Generator codegen) {
        this.abstractTCase = abstractTCase;
        // Translate the abstract test case into a Z schema expression of ATCAL's AST for simpler processing.
        this.zExprSchema = Atcal.ATCToZExpr(abstractTCase);
        // preload the default data types (INT, FLOAT, STRING) in the types namespace.
        this.datatypes = Maps.newHashMap();
        datatypes.put("INT", IntType.getInstance());
        datatypes.put("FLOAT", new FloatType());
        datatypes.put("STRING", new StringType());

        try {
            // load pre-defined data types of target language from library
            URL typeLibUrl = this.getClass().getClassLoader().getResource("atcal/" + codegen.getTargetLanguage() + "_datatypes.atcal");
            if (typeLibUrl != null) {
                String typeLib = Resources.toString(typeLibUrl, Charsets.UTF_8);
                AtcalParser parser = parseAtcalFile(typeLib);
                TypesEvaluator typesEvaluator = new TypesEvaluator(datatypes);
                datatypes.putAll(typesEvaluator.visitDatatypes(parser.datatypes()));
            }

            // load default preamble
            URL preambleUrl = this.getClass().getClassLoader().getResource("atcal/" + codegen.getTargetLanguage() + "_preamble.atcal");
            if (preambleUrl != null) {
                String preamblePath = Resources.toString(preambleUrl, Charsets.UTF_8);
                AtcalParser parser = parseAtcalFile(preamblePath);
                this.preamble = getPlCode(parser.preamble().PLCODE(0));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.codegen = codegen;
        this.concreteTCaseName = SpecUtils.getAxParaName(abstractTCase).replaceAll("_TCASE", "_CTCASE");
    }

    private AtcalParser parseAtcalFile(String fileName) {
        // Tokenize ATCAL refinement rule.
        ANTLRInputStream input = new ANTLRInputStream(fileName);
        AtcalLexer lexer = new AtcalLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new AtcalParser(tokens);
    }

    private String getPlCode(TerminalNode plcode) {
        // The plcode in the preamble is a antlr token that includes the delimiting keywords that should be removed.
        String tokenText = plcode.getText();
        return tokenText.substring(10, tokenText.length() - 8);   // remove delimiting keywords
    }

    @Override
    public ConcreteTCase visitRefinementRule(@NotNull AtcalParser.RefinementRuleContext ctx) {
        String ruleName = ctx.ID().getText();

        // Get preamble if present.
        if (ctx.preamble() != null) {
            String plcode = getPlCode(ctx.preamble().PLCODE(0));
            this.preamble += plcode + "\n";
        }

        // Evaluate data type declarations if present
        if (ctx.datatypes() != null) {
            TypesEvaluator typesEval = new TypesEvaluator(datatypes);
            this.datatypes.putAll(typesEval.visit(ctx.datatypes()));
        }

        LValueFactory lValueFactory = new LValueFactory();

        Map<String, ConstantMapper> zVarConstantMaps = Maps.newHashMap();

        // Evaluate refinement laws
        for (AtcalParser.LawContext lawCtx : ctx.laws().law()) {
            RefinementLawEvaluator refLawEval =
                    new RefinementLawEvaluator(zExprSchema, null, datatypes, lValueFactory, zVarConstantMaps);
            this.refinedLawsCode = refLawEval.visit(ctx.laws());
        }

        // Get optional programming language
        this.plCode = "";
        if (ctx.PLCODE() != null)
            this.plCode = ctx.PLCODE().getText();

        // Evaluate the UUT
        CallExpr uutCall = UUTEval(ctx.uut(), lValueFactory);

        // Get preamble if present
        this.epilogue = "";
        if (ctx.epilogue() != null) {
            String plcode = getPlCode(ctx.epilogue().PLCODE(0));
            this.epilogue += plcode + "\n";
        }

        // Generate calls to dump functions to capture the changes in state variables
        String dumpCalls = codegen.getDumpCode(lValueFactory.getLValues());


        // Generate the final refined code with the code generator
        String refinedCode = refinedLawsCode.getStmtList().stream().map(
                e -> codegen.generate(e)).collect(Collectors.joining("\n"));

        // Assemble the final test case code
        String testCaseCode = (Strings.nullToEmpty(preamble) +
                refinedCode + plCode + "\n" + codegen.generate(uutCall) + "\n" + epilogue + dumpCalls).trim();

        // Generate a new concrete test case with the result of the refinement.
        return new ConcreteTCase(concreteTCaseName, this.codegen.getTargetLanguage(), testCaseCode, zExprSchema,
                abstractTCase, zVarConstantMaps);
    }

    /**
     * Generates a UUT call expression using a given lvalues factory to look up the arguments values.
     *
     * @param uutCtx        the UUT context to evaluate
     * @param lValueFactory the lvalues factory
     * @return a call expression that invokes the UUT
     */
    private CallExpr UUTEval(AtcalParser.UutContext uutCtx, LValueFactory lValueFactory) {
        List<APLLValue> uutCallArgs = Lists.transform(uutCtx.args().ID(), tn -> lValueFactory.getLValue(tn.getText()));
        return new CallExpr(uutCtx.ID().getText(), uutCallArgs);
    }
}
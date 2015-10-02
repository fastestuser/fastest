package client.blogic.testing.atcal;

import client.blogic.testing.atcal.apl.APLLValue;
import client.blogic.testing.atcal.apl.APLStmt;
import client.blogic.testing.atcal.apl.CallExpr;
import client.blogic.testing.atcal.generators.Generator;
import client.blogic.testing.atcal.parser.AtcalBaseVisitor;
import client.blogic.testing.atcal.parser.AtcalParser;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import common.z.SpecUtils;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 05/06/15.
 */
public class AtcalEvaluator extends AtcalBaseVisitor<ConcreteTCase> {
    private ZExprSchema atc;                      // abstract test case to refine
    private String preamble;                      // programming language code (defined in this rule and/or imported)
    private Map<String, ATCALType> datatypes;     // declared data types (types namespace)
    private List<APLStmt> refinedLawsCode;        // APL code resulting from the evaluation of the refinement laws
    private String plCode;                        // programming language code included in the rule
    private CallExpr uut;                         // APL code to call the unit under test
    private String epilogue;                      // programming language code (defined in this rule and/or imported)
    private final Generator codegen;              // code generator
    private final String concreteTCaseName;       // name of the concrete test case to generate

    // Helper function to simplify converting lists of terminal nodes into lists of strings
    private static final Function<TerminalNode, String> TERMINAL_TOSTRING = new Function<TerminalNode, String>() {
        @Override
        public String apply(TerminalNode o) {
            return o.getText();
        }
    };

    /**
     * Creates a new ATCAL evaluator for the given abstract test case.
     *
     * @param atc the abstract test case.
     */
    public AtcalEvaluator(ZExprSchema atc, Generator codegen, String concreteTCaseName) {
        this.atc = atc;
        // preload the default data types (INT, FLOAT, STRING) in the type namespace.
        this.datatypes = Maps.newHashMap();
        datatypes.put("INT", IntType.getInstance());
        datatypes.put("FLOAT", new FloatType());
        datatypes.put("STRING", new StringType());
        this.codegen = codegen;
        this.concreteTCaseName = concreteTCaseName;
    }

    @Override
    public ConcreteTCase visitRefinementRule(@NotNull AtcalParser.RefinementRuleContext ctx) {
        String ruleName = ctx.ID().getText();

        // Get preamble if present
        this.preamble = "";
        if (ctx.preamble() != null) {
            for (AtcalParser.PlcodeContext plcodeContext : ctx.preamble().plcode()) {
                this.preamble += visit(plcodeContext) + "\n";
            }
        }

        // Evaluate data type declarations if present
        if (ctx.datatypes() != null) {
            TypesEvaluator typesEval = new TypesEvaluator(datatypes);
            this.datatypes.putAll(typesEval.visit(ctx.datatypes()));
        }

        LValueFactory lValueFactory = new LValueFactory();

        // Evaluate refinement laws
        RefinementLawEvaluator refLawEval = new RefinementLawEvaluator(atc, null, datatypes, lValueFactory);
        this.refinedLawsCode = refLawEval.visit(ctx.laws());

        // Get optional programming language
        this.plCode = "";
        if (ctx.plcode() != null)
            this.plCode = ctx.getChild(1).getText();

        // Evaluate the UUT
        List<String> uutArgs = Lists.transform(ctx.uut().args().ID(), TERMINAL_TOSTRING);
        CallExpr uutCall = new CallExpr(ctx.uut().ID().getText(), uutArgs);

        // Get preamble if present
        this.epilogue = "";
        if (ctx.epilogue() != null) {
            for (AtcalParser.PlcodeContext plcodeContext : ctx.epilogue().plcode()) {
                this.epilogue += visit(plcodeContext) + "\n";
            }
        }

        // Generate the final refined code with the code generator
        String refinedCode = refinedLawsCode.stream().map(e -> codegen.generate(e)).collect(Collectors.joining("\n"));

        // Assemble the final test case code
        String testCaseCode = preamble + refinedCode + plCode + "\n" + codegen.generate(uutCall) + epilogue;

        // Generate a new concrete test case with the result of the refinement.
        return new ConcreteTCase(concreteTCaseName, this.codegen.getTargetLanguage(), testCaseCode);
    }
}
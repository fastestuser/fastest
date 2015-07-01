package org.fastest.atcal;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fastest.atcal.apl.APLExpr;
import org.fastest.atcal.apl.APLLValue;
import org.fastest.atcal.apl.APLStmt;
import org.fastest.atcal.apl.CallExpr;
import org.fastest.atcal.generators.PerlGen;
import org.fastest.atcal.parser.AtcalBaseVisitor;
import org.fastest.atcal.parser.AtcalParser;
import org.fastest.atcal.z.ast.ZExprSchema;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Cristian on 05/06/15.
 */
public class AtcalEvaluator extends AtcalBaseVisitor<String> {
    // Helper function to simplify converting lists of terminal nodes into lists of strings
    private static final Function<TerminalNode, String> TERMINAL_TOSTRING = new Function<TerminalNode, String>() {
        @Override
        public String apply(TerminalNode o) {
            return o.getText();
        }
    };
    private ZExprSchema atc;                      // abstract test case to refine
    private String preamble;                      // programming language code (defined in this rule and/or imported)
    private Map<String, ATCALType> datatypes;     // declared data types (types namespace)
    private List<APLStmt> refinedLawsCode;        // APL code resulting from the evaluation of the refinement laws
    private String plCode;                        // programming language code included in the rule
    private CallExpr uut;                         // APL code to call the unit under test
    private String epilogue;                      // programming language code (defined in this rule and/or imported)
    private final Generator generator;            // code generator

    /**
     * Create a new ATCAL evaluator for the given abstract test case.
     * @param atc the abstract test case.
     */
    public AtcalEvaluator(ZExprSchema atc, Generator generator) {
        this.atc = atc;
        // preload the default data types (INT, FLOAT, STRING) in the type namespace.
        this.datatypes = Maps.newHashMap();
        datatypes.put("INT", IntType.getInstance());
        datatypes.put("FLOAT", new FloatType());
        datatypes.put("STRING", new StringType());
        this.generator = generator;
    }

    @Override
    public String visitRefinementRule(@NotNull AtcalParser.RefinementRuleContext ctx) {
        String ruleName = ctx.ID().getText();

        // todo: get preamble code
        this.preamble = "";

        // evaluate data type declarations if present
        if (ctx.datatypes() != null) {
            TypesEvaluator typesEval = new TypesEvaluator(datatypes);
            this.datatypes.putAll(typesEval.visit(ctx.datatypes()));
        }

        LValueFactory lValueFactory = new LValueFactory();

        // evaluate refinement laws
        RefinementLawEvaluator refLawEval = new RefinementLawEvaluator(atc, null, datatypes, lValueFactory);
        this.refinedLawsCode = refLawEval.visit(ctx.laws());

        // todo: get programming code
        this.plCode = "";

        // evaluate the UUT
        List<String> uutArgs = Lists.transform(ctx.uut().args().ID(), TERMINAL_TOSTRING);
        CallExpr uutCall = new CallExpr(ctx.uut().ID().getText(), uutArgs);

        // todo: get epilogue code
        this.epilogue = "";

        String decls = "";
        for(APLLValue lvalue: lValueFactory.getLValues()){
            decls += lvalue.getType().toString() + " " + lvalue.getName() + "\n";
        }

        // return the final string representation of the concrete test case
        return preamble + decls + refinedLawsCode.stream().map(e -> generator.generate(e)).collect(Collectors.joining("\n")) +
                plCode + "\n" + generator.generate(uutCall) + epilogue;
    }
}
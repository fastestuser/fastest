package org.fastest.atcal;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.fastest.atcal.parser.AtcalBaseVisitor;
import org.fastest.atcal.parser.AtcalParser;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Cristian on 15/05/15.
 */
public class TypesEvaluator extends AtcalBaseVisitor<Map<String, ATCALType>> {

    private final TypeEvaluator typeEval;

    // Helper function to simplify converting lists of terminal nodes into lists of strings
    private static final Function<TerminalNode, String> TERMINAL_TOSTRING = new Function<TerminalNode, String>() {
        @Override
        public String apply(TerminalNode o) {
            return o.getText();
        }
    };

    public TypesEvaluator() {
        this.typeEval = new TypeEvaluator();
    }

    @Override
    public Map<String, ATCALType> visitDatatypes(@NotNull AtcalParser.DatatypesContext ctx) {
        Map<String, ATCALType> types = Maps.newHashMap();
        for (AtcalParser.TypeDecContext typeDecContext : ctx.typeDec()) {
            // TODO: What happens if the type already exists?
            types.putAll(visit(typeDecContext));
        }
        return super.visitDatatypes(ctx);
    }

    @Override
    public Map<String, ATCALType> visitTypeDec(@NotNull AtcalParser.TypeDecContext ctx) {
        return ImmutableMap.of(ctx.ID().getText(), this.typeEval.visit(ctx.type()));
    }

    // Private nested class to evaluate individual types
    private static class TypeEvaluator extends AtcalBaseVisitor<ATCALType> {

        @Override
        public ATCALType visitIntType(@NotNull AtcalParser.IntTypeContext ctx) {
            return new IntType();
        }

        @Override
        public ATCALType visitFloatType(@NotNull AtcalParser.FloatTypeContext ctx) {
            return new FloatType();
        }

        @Override
        public ATCALType visitStringType(@NotNull AtcalParser.StringTypeContext ctx) {
            return new StringType();
        }

        @Override
        public ATCALType visitArrayType(@NotNull AtcalParser.ArrayTypeContext ctx) {
            return new ArrayType(ctx.ID().getText(), Integer.valueOf(ctx.NUMBER().getText()));
        }

        @Override
        public ATCALType visitEnumType(@NotNull AtcalParser.EnumTypeContext ctx) {
            String enumName = ctx.ID().getText();
            Collection<String> elements = Collections2.transform(ctx.args().ID(), TERMINAL_TOSTRING);
            return new EnumType(enumName, elements);
        }

        @Override
        public ATCALType visitRecordType(@NotNull AtcalParser.RecordTypeContext ctx) {
            Map<String, ATCALType> fields = Maps.newHashMap();
            for (int i = 1; i < ctx.ID().size(); i++) {
                fields.put(ctx.ID(i).toString(), visit(ctx.type(i - 1)));
            }
            return new RecordType(fields);
        }

        @Override
        public ATCALType visitContractType(@NotNull AtcalParser.ContractTypeContext ctx) {
            return new ContractType(ctx.ID(0).getText(), Lists.transform(ctx.args(0).ID(), TERMINAL_TOSTRING),
                    ctx.ID(1).getText(), Lists.transform(ctx.args(1).ID(), TERMINAL_TOSTRING),
                    ctx.ID(2).getText(), Lists.transform(ctx.args(2).ID(), TERMINAL_TOSTRING));
        }
    }
}

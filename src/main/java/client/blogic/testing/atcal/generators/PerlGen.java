package client.blogic.testing.atcal.generators;

import client.blogic.testing.atcal.ContractType;
import client.blogic.testing.atcal.apl.*;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * The Perl generator translates the APL code into a Perl program.
 * Created by Cristian on 26/06/15.
 */
public class PerlGen implements Generator {

    @Override
    public String getTargetLanguage() {
        return "perl";
    }

    @Override
    public String getDumpCode(Collection<APLLValue> lvaluesSet) {
        String dumpCode = lvaluesSet.stream().map(
                lvalue -> "$state->{'" + lvalue.getName() + "'} = \\" + generate(lvalue) + ";"
        ).collect(Collectors.joining("\n"));

        dumpCode += "\n__fastest_dump($state);";

        return dumpCode;
    }

    public String generate(APLStmt aplStmt) {
        if (aplStmt instanceof AssignStmt) {
            return generate((AssignStmt) aplStmt);
        } else if (aplStmt instanceof CallExpr) {
            return generate((CallExpr) aplStmt) + ";";
        } else if (aplStmt instanceof SetterCallStmt) {
            return generate((SetterCallStmt) aplStmt);
        } else if (aplStmt instanceof ConstructorCallStmt) {
            return generate((ConstructorCallStmt) aplStmt);
        } else if (aplStmt instanceof ArrayDeclStmt) {
            return "";  // perl does not require array declaration
        } else {
            throw new RuntimeException("Unsupported APL statement.");
        }
    }

    private String generate(AssignStmt assignStmt) {
        String lvalueStr = PerlGen.generate(assignStmt.getLvalue());
        String exprStr = null;
        APLExpr expr = assignStmt.getExpr();
        if (expr instanceof APLVar) {
            exprStr = PerlGen.generate((APLVar) assignStmt.getExpr());
        } else if (expr instanceof CallExpr) {
            exprStr = PerlGen.generate((CallExpr) assignStmt.getExpr());
        } else if (expr instanceof ConsExpr) {
            exprStr = PerlGen.generate((ConsExpr) assignStmt.getExpr());
        } else if (expr instanceof LongExpr) {
            exprStr = PerlGen.generate((LongExpr) assignStmt.getExpr());
        } else if (expr instanceof StringExpr) {
            exprStr = PerlGen.generate((StringExpr) assignStmt.getExpr());
        } else {
            throw new RuntimeException("Unsupported expression in APL statement.");
        }

        return lvalueStr + " = " + exprStr + ";";
    }

    private static String generate(APLLValue lvalue) {
        if (lvalue instanceof APLVar) {
            return "$" + lvalue.getName();
        } else if (lvalue instanceof APLArray) {
            return "@" + lvalue.getName();
        } else if (lvalue instanceof APLArray.APLArrayIndex) {
            APLArray.APLArrayIndex varIdx = (APLArray.APLArrayIndex) lvalue;
            return "$" + varIdx.getParent().getName() + "[" + varIdx.getIndex() + "]";
        } else {
            throw new RuntimeException("Unsupported APL lvalue type:" + lvalue);
        }
    }

    private static String generate(StringExpr stringExpr) {
        return "\"" + stringExpr.getValue() + "\"";
    }

    private static String generate(LongExpr longExpr) {
        return Long.toString(longExpr.getValue());
    }

    private static String generate(ConsExpr consExpr) {
        return consExpr.getValue();
    }

    private static String generate(String s) {
        return "$" + s;
    }

    private static String generate(CallExpr callExpr) {
        return callExpr.getFunName() + "(" + callExpr.getArgs().stream().map(PerlGen::generate).collect(Collectors.joining(",")) + ")";
    }

    private static String generate(SetterCallStmt setterCallStmt) {
        String constructor = ((ContractType) setterCallStmt.getLvalue().getType()).getConstructor();
        if (constructor.equals("HASH")) {
            return generate(setterCallStmt.getLvalue().getName()) + "->{" + generate(setterCallStmt.getExprs().get(0)) + "} = " +
                    generate(setterCallStmt.getExprs().get(1)) + ";";
        } else {
            String setterCall = constructor + "(" +
                    setterCallStmt.getExprs().stream().map(PerlGen::generate).collect(Collectors.joining(",")) + ")";
            return "$" + setterCallStmt.getLvalue().getName() + "->" + setterCall + ";";
        }
    }

    private static String generate(ConstructorCallStmt constructorCallStmt) {
        if (((ContractType) (constructorCallStmt.getLvalue().getType())).getConstructor().equals("HASH"))
            return "";

        ContractType type = (ContractType) constructorCallStmt.getLvalue().getType();
        String module = type.getModule();
        String constructor = type.getConstructor();
        String constructorCall = module + "->" + constructor + "(" + constructorCallStmt.getExprs().stream().map(PerlGen::generate).collect(Collectors.joining(",")) + ")";
        return "$" + constructorCallStmt.getLvalue().getName() + "=" + constructorCall + ";";
    }
}

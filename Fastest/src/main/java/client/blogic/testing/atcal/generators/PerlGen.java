package client.blogic.testing.atcal.generators;

import client.blogic.testing.atcal.apl.*;

import java.util.stream.Collectors;

/**
 * The Perl generator translates the APL code into a Perl program.
 * Created by Cristian on 26/06/15.
 */
public class PerlGen implements Generator {

    public String generate(APLStmt aplStmt) {
        if (aplStmt instanceof AssignStmt) {
            return generate((AssignStmt) aplStmt);
        } else if (aplStmt instanceof CallExpr) {
            return generate((CallExpr) aplStmt) + ";";
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
}

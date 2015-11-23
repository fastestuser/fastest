package client.blogic.testing.refinement;

import common.z.AbstractTCase;

/**
 * This module stores all the information related to a concrete test case
 *
 * @author Hache
 */

public class ConcreteTCase {
    private String preamble; //
    private String epilogue; //
    private String declarations;
    private String assignments;
    private String concreteTCaseName; //
    private AbstractTCase abstractTCase; //
    private String opName; //
    private String targetLanguage; //
    private String initDecls;
    private String uutLine;
    private String plCode;
    private String warnings;

    public void setPreamble(String preable) {
        this.preamble = preable;
    }

    public void setInitDeclarations(String initDecls) {
        this.initDecls = initDecls;
    }

    public void setEpilogue(String epilogue) {
        this.epilogue = epilogue;
    }

    public String getPreamble() {
        return preamble;
    }

    public String getInitDeclarations() {
        return initDecls;
    }

    public String getEpilogue() {
        return epilogue;
    }

    public void setConcreteTCaseName(String concreteTCaseName) {
        this.concreteTCaseName = concreteTCaseName;
    }

    public String getConcreteTCaseName() {
        return concreteTCaseName;
    }

    public void setAbstractTCase(AbstractTCase abstractTCase) {
        this.abstractTCase = abstractTCase;
    }

    public AbstractTCase getAbstractTCase() {
        return abstractTCase;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getOpName() {
        return opName;
    }

    public void setLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public String getLanguage() {
        return targetLanguage;
    }

    public String getDeclarations() {
        return declarations;
    }

    public void setDeclarations(String declarations) {
        this.declarations = declarations;
    }

    public String getAssignments() {
        return assignments;
    }

    public void setAssignments(String assignments) {
        this.assignments = assignments;
    }

    public String getUutLine() {
        return uutLine;
    }

    public void setUutLine(String uutLine) {
        this.uutLine = uutLine;
    }

    public String getPlCode() {
        return plCode;
    }

    public void setPlCode(String plcode) {
        this.plCode = plcode;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public boolean hasWarnings() {
        return !warnings.isEmpty();
    }

}
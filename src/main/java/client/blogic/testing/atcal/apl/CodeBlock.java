package client.blogic.testing.atcal.apl;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * This class represents a block of code of the APL intermediate representation.
 * Created by Cristian on 19/10/15.
 */
public class CodeBlock {

    /**
     * The block of code holds a list of APL statements
     */
    private final List<APLStmt> stmtList;

    /**
     * Creates a new block of code
     */
    public CodeBlock() {
        this.stmtList = Lists.newArrayList();
    }

    /**
     * Adds a new APL statement to the block of code
     * @param aplStmt   the APL statement to add
     */
    public void addStmt(APLStmt aplStmt) {
        this.stmtList.add(aplStmt);
    }

    /**
     * Gets the list of APL statements in the block of code
     * @return  a list of APL statements
     */
    public List<APLStmt> getStmtList() {
        return stmtList;
    }

    /**
     * Joins a given block of code at the end of this one.
     * @param codeBlock     the block of code to join
     */
    public void join(CodeBlock codeBlock) {
        this.stmtList.addAll(codeBlock.stmtList);
    }
}

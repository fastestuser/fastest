package client.blogic.testing.atcal;

/**
 * Created by Cristian on 07/08/15.
 */

import client.blogic.testing.atcal.z.ast.ZExprConst;
import client.blogic.testing.atcal.z.ast.ZExprSchema;
import com.google.common.collect.ImmutableMap;
import common.z.AbstractTCase;

import java.util.Map;

/**
 * This class represents an immutable refined test case.
 */
public class ConcreteTCase {

    private final String name;
    private final String language;
    private final String code;
    private final AbstractTCase abstractTCase;
    private final ZExprSchema zExprSchema;
    private final ImmutableMap<Long, ZExprConst> bijectionMap = null;

    /**
     * Returns a new immutable instance of a refined test case
     *
     * @param language the programming language
     * @param code     the code of the program
     */
    public ConcreteTCase(String name, String language, String code, ZExprSchema zExprSchema, AbstractTCase abstractTCase) {
        this.name = name;
        this.language = language;
        this.code = code;
        this.abstractTCase = abstractTCase;
        this.zExprSchema = zExprSchema;
    }

    /**
     * Gets the name of the concrete test case.
     *
     * @return the name of the concrete test case
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the programming language of the concrete test case.
     *
     * @return the programming language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the program code of the concrete test case.
     *
     * @return the program code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets the abstract test case that was refined to produce the concrete test case
     *
     * @return an abstract test case
     */
    public AbstractTCase getAbstractTCase() {
        return abstractTCase;
    }

    /**
     * Gets the ATCAL representation of the abstract test case that was refined to produce the concrete test case
     *
     * @return an ATCAL Z schema expression obtained from the abstract test case
     */
    public ZExprSchema getZExprSchema() {
        return zExprSchema;
    }

    /**
     * Gets the bijection map used to map the Z constants
     *
     * @return the bijection map
     */
    public Map<Long, ZExprConst> getBijectionMap() {
        return bijectionMap;
    }

    /**
     * Stub method kept for compatibility with older implementations.
     * TODO: remove this method
     *
     * @return
     */
    public boolean hasWarnings() {
        return false;
    }

    /**
     * Stub method kept for compatibility with older implementations.
     * TODO: remove this method
     *
     * @return
     */
    public String getWarnings() {
        return "";
    }

    /**
     * Stub method kept for compatibility with older implementations.
     * TODO: remove this method
     *
     * @return
     */
    public String getAbsLawName() {
        return "";
    }
}

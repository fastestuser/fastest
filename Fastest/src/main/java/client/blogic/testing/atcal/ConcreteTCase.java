package client.blogic.testing.atcal;

/**
 * Created by Cristian on 07/08/15.
 */

/**
 * This class represents an immutable refined test case.
 */
public class ConcreteTCase {

    private final String name;
    private final String language;
    private final String code;

    /**
     * Returns a new immutable instance of a refined test case
     * @param language  the programming language
     * @param code      the code of the program
     */
    public ConcreteTCase(String name, String language, String code) {
        this.name = name;
        this.language = language;
        this.code = code;
    }

    /**
     * Gets the name of the concrete test case.
     * @return  the name of the concrete test case
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the programming language of the concrete test case.
     * @return  the programming language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the program code of the concrete test case.
     * @return  the program code
     */
    public String getCode() {
        return code;
    }

    /**
     * Stub method kept for compatibility with older implementations.
     * TODO: remove this method
     * @return
     */
    public boolean hasWarnings(){
        return false;
    }

    /**
     * Stub method kept for compatibility with older implementations.
     * TODO: remove this method
     * @return
     */
    public String getWarnings() {
        return "";
    }

    /**
     * Stub method kept for compatibility with older implementations.
     * TODO: remove this method
     * @return
     */
    public String getAbsLawName(){
        return "";
    }
}

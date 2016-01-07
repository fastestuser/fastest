package common.z;

import common.z.czt.UniqueZLive;
import common.z.czt.visitors.CZTCloner;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.base.util.UnmarshalException;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.parser.util.ParseException;
import net.sourceforge.czt.session.FileSource;
import net.sourceforge.czt.util.Visitor;
import net.sourceforge.czt.z.ast.*;
import net.sourceforge.czt.z.impl.ZFactoryImpl;
import net.sourceforge.czt.z.util.Factory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * An implementation of the AbstractTCaseImpl.
 *
 * @author Pablo Rodriguez Monetti
 */
public class AbstractTCaseImpl implements AbstractTCase {

    private AxPara myAxPara;
    private String schName;
    private List<String> inclsNotIntegrated;
    private final Map<RefExpr, Expr> varExprMap;

    public AbstractTCaseImpl(AxPara axPara, String schName) {
        setMyAxPara(axPara);
        this.schName = schName;
        this.varExprMap = null;
    }


    /**
     * Creates instances of this class. The constructed test class will have the inclusion of
     * the schema whose name is given by the specified String and its predicate will consist
     * of the conjunction of the equalities taken from the specified Map.
     *
     * @param axPara
     * @param dadName
     * @param varExprMap
     */
    public AbstractTCaseImpl(AxPara axPara, String dadName, Map<RefExpr, Expr> varExprMap) {
        AxPara newAxPara = (AxPara) axPara.accept(new CZTCloner());

        ZFactory zFactory = new ZFactoryImpl();
        ZName zName = zFactory.createZName(dadName,
                zFactory.createZStrokeList(), "IncludedTClass");
        RefExpr refExpr = zFactory.createRefExpr(zName,
                zFactory.createZExprList(), false, false);
        ZDeclList zDeclList = zFactory.createZDeclList();
        zDeclList.add(0, zFactory.createInclDecl(refExpr));
        SpecUtils.setAxParaListOfDecl(newAxPara, zDeclList);
        schName = dadName + "_TCASE";
        SpecUtils.setAxParaName(newAxPara, schName);
        SpecUtils.setAxParaPred(newAxPara, SpecUtils.createAndPred(varExprMap));
        setMyAxPara(newAxPara);
        this.varExprMap = varExprMap;
    }

    private AbstractTCaseImpl(AxPara axPara, Map<RefExpr, Expr> varExprMap) {
        this.schName = SpecUtils.getAxParaName(axPara);
        this.myAxPara = axPara;
        this.varExprMap = varExprMap;
    }

    /**
     * Parse a latex file containing an abstract test case specification
     * FIXME: the method only works if the file contains a single schema, therefore it does not work if one or more variables are of schema types that require their own previous definition.
     *
     * @param fileURL the latex file to parse
     * @return an abstract test case
     */
    public static AbstractTCase fromFile(URL fileURL) {
        try {
            ZLive zLive = UniqueZLive.getInstance();
            Factory zFactory = zLive.getFactory();
            Spec spec = (Spec) ParseUtils.parse(new FileSource(fileURL.getFile()), zLive.getSectionManager());
            ZParaList o = (ZParaList) (spec.getSect().get(0).getChildren()[2]);
            AxPara axPara = (AxPara) (o.get(1));
            Pred p = SpecUtils.getAxParaPred(axPara);
            Map<RefExpr, Expr> translatedVars = SpecUtils.getAssignedValues(p).entrySet().stream().collect(
                    Collectors.toMap(entry -> zFactory.createRefExpr(zFactory.createZName(entry.getKey())), Map.Entry::getValue));
            return new AbstractTCaseImpl(axPara, translatedVars);
        } catch (ParseException | IOException | UnmarshalException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Verifies whether the specified AxPara's predicate has an equality for each explicitly
     * declared variable. With "explicitly declared variables" we refer to variables not
     * declared in an included schema.
     *
     * @param axPara
     * @return
     */
    public static boolean isAbstractTCase(AxPara axPara) {
        if (!SchemeImpl.isScheme(axPara))
            return false;
        return true;
    }

    public void setMyAxPara(AxPara axPara) {
        myAxPara = axPara;
    }

    public AxPara getMyAxPara() {
        return myAxPara;
    }

    public void setSchName(String schName) {
        this.schName = schName;
    }

    public String getSchName() {
        return schName;
    }

    public ZNameList getName() {
        return myAxPara.getName();
    }

    public Box getBox() {
        return myAxPara.getBox();
    }

    public NameList getNameList() {
        return myAxPara.getNameList();
    }

    public SchText getSchText() {
        return myAxPara.getSchText();
    }

    public ZNameList getZNameList() {
        return myAxPara.getZNameList();
    }

    public ZSchText getZSchText() {
        return myAxPara.getZSchText();
    }

    public void setBox(Box box) {
        myAxPara.setBox(box);
    }

    public void setNameList(NameList nameList) {
        myAxPara.setNameList(nameList);
    }

    public void setSchText(SchText schText) {
        myAxPara.setSchText(schText);
    }

    public <R> R accept(Visitor<R> v) {
        return myAxPara.accept(v);
    }

    public Term create(Object[] args) {
        return myAxPara.create(args);
    }

    public <T> T getAnn(Class<T> c) {
        return myAxPara.getAnn(c);
    }

    public List getAnns() {
        return myAxPara.getAnns();
    }

    public Object[] getChildren() {
        return myAxPara.getChildren();
    }

    @Override
    public AxPara clone() {
        return new AbstractTCaseImpl((AxPara) myAxPara.accept(new CZTCloner()), schName, varExprMap);
    }


    @Override
    public List<PreExpr> getInclPreds() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public void setInclPreds(List<PreExpr> preds) {
        // TODO Auto-generated method stub

    }


    @Override
    public void setInclsNotIntegrated(List<String> incls) {
        inclsNotIntegrated = incls;

    }

    @Override
    public Map<RefExpr, Expr> getVarExpMap() {
        return this.varExprMap;
    }

    @Override
    public String getInclsNotIntegrated() {
        if (inclsNotIntegrated == null || inclsNotIntegrated.isEmpty())
            return "";
        StringBuilder incls = new StringBuilder();
        for (String incl : inclsNotIntegrated)
            incls.append(incl + "; ");
        return incls.toString();
    }


}


package common.z.czt.visitors;

import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.SchExpr;
import net.sourceforge.czt.z.visitor.AxParaVisitor;
import net.sourceforge.czt.z.visitor.RefExprVisitor;
import net.sourceforge.czt.z.visitor.SchExprVisitor;
import net.sourceforge.czt.z.visitor.Expr2Visitor;
import client.blogic.management.Controller;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.ZSchText;
import net.sourceforge.czt.z.ast.DeclList;
import net.sourceforge.czt.z.ast.Decl;
import net.sourceforge.czt.z.ast.ZDeclList;
import net.sourceforge.czt.z.ast.ConstDecl;
import net.sourceforge.czt.z.ast.Expr2;
import common.z.SpecUtils;
import common.z.UtilSymbols;
import net.sourceforge.czt.z.ast.AndExpr;
import net.sourceforge.czt.z.ast.CompExpr;
import net.sourceforge.czt.z.ast.DecorExpr;
import net.sourceforge.czt.z.ast.InclDecl;
import net.sourceforge.czt.z.ast.NameList;
import net.sourceforge.czt.z.ast.VarDecl;
import net.sourceforge.czt.z.ast.ZFactory;
import net.sourceforge.czt.z.impl.ZFactoryImpl;
import net.sourceforge.czt.z.impl.ZNameListImpl;
import net.sourceforge.czt.z.visitor.CompExprVisitor;
import net.sourceforge.czt.z.visitor.DecorExprVisitor;

/**
 * This class was made to calculate the declaration part of the Valid Input 
 * Space of an operation. The declaration part is a list of declarations, an
 * instance of ZDeclList.
 * 
 * The list of predicates are calculated recursively, based on the Visitor design
 * pattern, unfolding all schemas. Diference whith DeclExtractor is that this one
 * does not check whether operation is selected or not.
 * @author 
 */
public class DeclsExtractorFull implements SchExprVisitor<ZDeclList>,
        Expr2Visitor<ZDeclList>,RefExprVisitor<ZDeclList>,
        AxParaVisitor<ZDeclList>, DecorExprVisitor<ZDeclList>,
        CompExprVisitor<ZDeclList>{

    // A reference to the list of paragraphs of the loaded specification
    private ZParaList zParaList;
    // A reference to the current instance of Controller, which is used to
    // determine if a given schema reference correspond or not to a schema 
    // selected as operation or as predicate. 
    //private Controller controller;

    public DeclsExtractorFull(ZParaList zParaList, Controller controller) {
        this.zParaList = zParaList;
        //this.controller = controller;
    }
    
    
    /**
     * Visits the specified instance of AxPara returning the list of declarations
     * associated to the VIS associated to the instance.
     * @param axPara the instance of AxPara for which the list of declarations
     * of its VIS will be calculated
     * @return the list of declarations associated to the VIS associated to the 
     * specified AxPara.
     */
    public ZDeclList visitAxPara(AxPara axPara) {
        Expr axParaExpr = null;
        ZDeclList newDeclList = null;
        ZSchText zSchText = axPara.getZSchText();
        DeclList declList = zSchText.getDeclList();
        if (declList instanceof ZDeclList) {
            for (int j = 0; j < ((ZDeclList) declList).size(); j++) {
                Decl decl = ((ZDeclList) declList).get(j);
                if (decl instanceof ConstDecl) {
                    ConstDecl constDecl = (ConstDecl) decl;
                    axParaExpr = constDecl.getExpr();
                    newDeclList = axParaExpr.accept(this);
                }
            }
        }
        return newDeclList;
    }
    
    
    /**
     * Visits the specified instance of SchExpr returning the list of declarations
     * associated to the VIS associated to the instance.
     * @param schExpr the instance of SchExpr for which the list of declarations
     * of its VIS will be calculated
     * @return the list of declarations associated to the VIS associated to the 
     * specified SchExpr.
     */
    public ZDeclList visitSchExpr(SchExpr schExpr) {
        ZSchText zSchText = schExpr.getZSchText();
        DeclList declList = zSchText.getDeclList();
        ZFactory zFactory = new ZFactoryImpl();
        ZDeclList newZDeclList = zFactory.createZDeclList();

        if (declList instanceof ZDeclList) {
            ZDeclList zDeclList = (ZDeclList) declList;
            for (int i = 0; i < zDeclList.size(); i++) {
                Decl decl = zDeclList.get(i);
                if (decl instanceof InclDecl) {
                    InclDecl inclDecl = (InclDecl) decl;
                    Expr inclExpr = inclDecl.getExpr();
                    String inclName = "";
//                    boolean deltaOrXi = false;
//                    boolean primedInclusion = false;
                    if (inclExpr instanceof RefExpr) {
                        inclName = ((RefExpr) inclExpr).getName().toString();
                        int firstCharCode = (int) inclName.charAt(0);

                        if (firstCharCode == 916 || firstCharCode == 926) {
                            // The schema is a Delta or a Xi
                            inclName = inclName.substring(1);
                            //deltaOrXi = true;
                        }
                    } else if (inclExpr instanceof DecorExpr) {
                        inclName = ((RefExpr) ((DecorExpr) inclExpr).getExpr()).getName().toString();
                        //primedInclusion = true;
                    }

                    //boolean isOp = FastestUtils.isLoadedOperation(controller, inclName);

	                // The included AxPara A is a schema
	                // which is not a selected operation
	                // nor a selected predicate, so it is
	                // needed to unfold the schema 
	                AxPara inclAxPara = SpecUtils.axParaSearch(inclName,
	                        zParaList);
	                ZDeclList inclZDeclList = inclAxPara.accept(this);
	                SpecUtils.insertZDeclList(newZDeclList, inclZDeclList,
	                        newZDeclList.size());

                } else if (decl instanceof VarDecl) {
                    // It is neccesary to clone the declaration
                    // because if it is changed (ie. when it has
                    // primed variables) then the declaration
                    // in the original schema will be changed too
                    VarDecl clonedVarDecl = (VarDecl) decl.accept(new CZTCloner());
                    NameList nameList = clonedVarDecl.getName();
                    // The primed variables are removed
                    // from the list of variables
                    if (nameList instanceof ZNameListImpl) {
                        ZNameListImpl zNameListImpl = (ZNameListImpl) nameList;
                        for (int k = 0; k < zNameListImpl.size(); k++) {
                            String varName = zNameListImpl.get(k).toString();
                            if (varName.endsWith("!")
                                    || varName.endsWith(UtilSymbols.primeSymbol())) {
                                zNameListImpl.remove(k);
                            }
                        }
                        // If some name remains in the 
                        // resulting clonedVarDecl (after removal of
                        // primed variables) then we add that
                        // clonedVarDecl to the new list of decls
                        if (zNameListImpl.size() != 0) {
                            SpecUtils.insertDecl(newZDeclList,
                                    clonedVarDecl, newZDeclList.size());
                        }

                    }
                }

            }
        }
        return newZDeclList;
    }

    
    /**
     * Visits the specified instance of Expr2 returning the list of declarations
     * associated to the VIS associated to the instance.
     * @param expr2 the instance of Expr2 for which the list of declarations
     * of its VIS will be calculated
     * @return the list of declarations associated to the VIS associated to the 
     * specified Expr2.
     */    
    public ZDeclList visitExpr2(Expr2 expr2) {
        // The list of declarations are appended
        ZDeclList leftDeclList = expr2.getLeftExpr().accept(this);
        ZDeclList rightDeclList = expr2.getRightExpr().accept(this);
        SpecUtils.insertZDeclList(leftDeclList, rightDeclList, leftDeclList.size());
        return leftDeclList;
    }

    
    /**
     * Visits the specified instance of RefExpr returning the list of declarations
     * associated to the VIS associated to the instance.
     * @param refExpr the instance of RefExpr for which the list of declarations
     * of its VIS will be calculated
     * @return the list of declarations associated to the VIS associated to the 
     * specified RefExpr.
     */    
    public ZDeclList visitRefExpr(RefExpr refExpr) {
        String refExprName = refExpr.getZName().getWord().toString();

        int firstCharCode = (int) refExprName.charAt(0);
        //boolean deltaOrXi = false;
        if (firstCharCode == 916 || firstCharCode == 926) {
            // The schema is a Delta or a Xi
            refExprName = refExprName.substring(1);
            //deltaOrXi = true;
        }

        //boolean isOp = FastestUtils.isLoadedOperation(controller, refExprName);

        ZFactory zFactory = new ZFactoryImpl();
        ZDeclList zDeclList = zFactory.createZDeclList();
        // The included AxPara A is a schema
         // which is not a selected operation
         // nor a selected predicate, so it is
         // needed to unfold the schema
        AxPara refAxPara = SpecUtils.axParaSearch(refExprName, zParaList);
        zDeclList = refAxPara.accept(this);
        return zDeclList;
    }

    /**
     * Visits the specified instance of DecorExpr returning the list of declarations
     * associated to the VIS associated to the instance.
     * @param decorExpr the instance of DecorExpr for which the list of declarations
     * of its VIS will be calculated
     * @return the list of declarations associated to the VIS associated to the 
     * specified DecorExpr.
     */
    public ZDeclList visitDecorExpr(DecorExpr decorExpr){
        // An empty list of declarations is returned because a DecorExpr 
        // represents a schema that is primed
        return (new ZFactoryImpl()).createZDeclList();
    }
    
    
    /**
     * Visits the specified instance of CompExpr returning the list of declarations
     * associated to the VIS associated to the instance.
     * @param compExpr the instance of CompExpr for which the list of declarations
     * of its VIS will be calculated
     * @return the list of declarations associated to the VIS associated to the 
     * specified CompExpr.
     */    
    public ZDeclList visitCompExpr(CompExpr compExpr){
        Expr leftExpr = compExpr.getLeftExpr();
        Expr rightExpr = compExpr.getRightExpr();        
        AndExpr andExpr = (new ZFactoryImpl()).createAndExpr();
        andExpr.setLeftExpr(leftExpr);
        andExpr.setRightExpr(rightExpr);
        return andExpr.accept(this);
    }    
}

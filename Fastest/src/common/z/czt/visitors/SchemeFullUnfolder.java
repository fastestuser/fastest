package common.z.czt.visitors;

import java.util.*;
import common.repository.AbstractRepository;
import common.repository.AbstractIterator;
import common.z.DeclDecoration;
import common.z.SpecUtils;
import common.z.UtilSymbols;
import common.z.czt.visitors.PrimeVarsMaker;
import common.z.czt.visitors.CZTCloner;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.util.Visitor;
import net.sourceforge.czt.z.ast.Box;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.ZSchText;
import net.sourceforge.czt.z.ast.DeclList;
import net.sourceforge.czt.z.ast.ZDeclList;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.AndExpr;
import net.sourceforge.czt.z.ast.OrExpr;
import net.sourceforge.czt.z.ast.DecorExpr;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.SchExpr;
import net.sourceforge.czt.z.ast.Decl;
import net.sourceforge.czt.z.ast.InclDecl;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ConstDecl;
import net.sourceforge.czt.z.ast.Para;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.ZSect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.impl.ZFactoryImpl;

/**
 * An instance of this class allow the unfolding of schemas included in other
 * schemas.
 * @author prodriguez
 */
public class SchemeFullUnfolder {


    static List<String> listOfUnfoldedAxParas;

    /* Devuelve la especificacion que surje de expandir los esquemas en la especificacion que se pasa como argumento
    No modifica la especificacion original.
     */
    public static Spec unfoldSpec(Spec spec) {
        Visitor<Term> cloneVisitor = new CZTCloner();
        Spec spec2 = (Spec) spec.accept(cloneVisitor);
        listOfUnfoldedAxParas = new ArrayList<String>();
        for (Sect sect : spec2.getSect()) {
            if (sect instanceof ZSect) {
                ParaList paraList = ((ZSect) sect).getParaList();
                if (paraList instanceof ZParaList) {
                    for (int i = 0; i < ((ZParaList) paraList).size(); i++) {
                        Para para = ((ZParaList) paraList).get(i);
                        if (para instanceof AxPara) {
                            unfoldAxPara((AxPara) para, (ZParaList) paraList);
                        }
                    }
                }
            }
        }
        return spec2;
    }


    /* Expande los esquemas que se incluyen en este AxPara
     */
    public static AxPara unfoldAxPara(AxPara axPara, ZParaList zParaList) {
        String axParaName = SpecUtils.getAxParaName(axPara);
        //System.out.println("El nombre del esquema: "+nombre);
        ZSchText zSchText = axPara.getZSchText();
        DeclList declList = zSchText.getDeclList();
        if (declList instanceof ZDeclList) {
            for (int j = 0; j < ((ZDeclList) declList).size(); j++) {
                Decl decl = ((ZDeclList) declList).get(j);
                if (decl instanceof ConstDecl) {
                    ConstDecl constDecl = (ConstDecl) decl;

                    constDecl.setExpr(unfoldExpr(constDecl.getExpr(), zParaList));
                    if (constDecl.getExpr() instanceof SchExpr) {
                        axPara.setBox(Box.SchBox);
                    }
                }
            }

        }
        listOfUnfoldedAxParas.add(axParaName);
        return axPara;
    }


    /* Devuelve la expresión que surge de expandir los esquemas que incluye,
    modificando la expresion original
     */
    private static Expr unfoldExpr(Expr expr, ZParaList zParaList) {
        Expr resultExpr = expr;
        if (expr instanceof SchExpr) {
            resultExpr = unfoldSchExpr((SchExpr) expr, zParaList);
        } else if (expr instanceof AndExpr) {
            resultExpr = unfoldAndExpr((AndExpr) expr, zParaList);
        } else if (expr instanceof OrExpr) {
            resultExpr = unfoldOrExpr((OrExpr) expr, zParaList);
        } else if (expr instanceof RefExpr) {
            resultExpr = unfoldRefExpr((RefExpr) expr, zParaList);

        }
        return resultExpr;
    }


    /* Devuelve la expresión que surge de expandir los esquemas que incluye,
    modificando la expresion original
     */
    private static SchExpr unfoldSchExpr(SchExpr schExpr, ZParaList zParaList) {

        ZSchText zSchText = schExpr.getZSchText();
        DeclList declList = zSchText.getDeclList();
        if (declList instanceof ZDeclList) {
            int declListSize = ((ZDeclList) declList).size();
            for (int j = 0; j < declListSize; j++) {
                Decl decl = ((ZDeclList) declList).get(j);
                if (decl instanceof InclDecl) {
                    Expr expr = ((InclDecl) decl).getExpr();
                    String nameToSearch = "";
                    DeclDecoration declDecoration = DeclDecoration.NOT_PRIMED;
                    boolean isXi = false;

                    if (expr instanceof RefExpr) {
                        String refExprName = ((RefExpr) expr).getName().toString();
                        int firstCharCode = (int) refExprName.charAt(0);
                        if (firstCharCode == 916) {
                            //El esquema a expandir es un delta
                            nameToSearch = refExprName.substring(1);
                            declDecoration = DeclDecoration.BOTH;
                            isXi = false;
                        } else if (firstCharCode == 926) {
                            //El esquema a expandir es un Xi
                            nameToSearch = refExprName.substring(1);
                            declDecoration = DeclDecoration.BOTH;
                            isXi = true;
                        } else {
                            //El esquema a expandir no está primado, no es un delta ni un Xi
                            nameToSearch = refExprName;
                            declDecoration = DeclDecoration.NOT_PRIMED;
                            isXi = false;
                        }
                    } else if (expr instanceof DecorExpr) {
                        //El esquema a expandir esta primado
                        //ZLive zLive = new ZLive();
                        //TextUI textUI = new TextUI(zLive, new PrintWriter(System.out, true));
                        //System.out.println(textUI.printTerm(expr, Markup.LATEX));
                        nameToSearch = ((RefExpr) ((DecorExpr) expr).getExpr()).getName().toString();
                        declDecoration = DeclDecoration.PRIMED;
                        isXi = false;

                    }

                    //Buscamos el esquema a expandir
                    AxPara axParaToIncl = SpecUtils.axParaSearch(nameToSearch, zParaList);
                    //System.out.println("Incluido: "+nameToSearch);
                    if (axParaToIncl == null) {
                        System.out.println("Schema no encontrado" + nameToSearch);
                    } else {

                        ZSchText zSchText2 = axParaToIncl.getZSchText();
                        DeclList declList2 = SpecUtils.getAxParaListOfDecl(axParaToIncl);
                        Pred pred = zSchText.getPred();
                        Pred pred2 = SpecUtils.getAxParaPred(axParaToIncl);

                        AbstractRepository<String> varNameRep = SpecUtils.getVarNames(axParaToIncl);
                        PrimeVarsMaker primeVisitor = new PrimeVarsMaker(varNameRep);


                        if (declList2 instanceof ZDeclList) {
                            ((ZDeclList) declList).remove(j);
                            int deltaSize = 0;
                            switch (declDecoration) {
                                case NOT_PRIMED:
                                    // El schema a expandir no está primado
								/*Insertamos las declaraciones de la ZDeclList declList2 en la posicion j de
                                    la ZDeclList declList y aumentamos deltaSize en el numero de declaraciones
                                    insertadas
                                     */
                                    deltaSize += SpecUtils.insertZDeclList((ZDeclList) declList,
                                            (ZDeclList) declList2, j);
                                    if (pred2 != null) {
                                        zSchText.setPred(SpecUtils.andPreds(pred, pred2));
                                    }
                                    break;
                                case PRIMED:
                                    // El schema a expandir está primado
								/*Insertamos las declaraciones de la ZDeclList declList2 en la posicion j de
                                    la ZDeclList declList (primandolas previamente) y aumentamos deltaSize en el
                                    numero de declaraciones insertadas
                                     */
                                    deltaSize += SpecUtils.insertZDeclList((ZDeclList) declList,
                                            (ZDeclList) declList2.accept(primeVisitor), j);
                                    if (pred2 != null) {
                                        zSchText.setPred(SpecUtils.andPreds(pred, (Pred) pred2.accept(primeVisitor)));
                                    }
                                    break;
                                case BOTH:
                                    //El esquema a expandir es un delta o un Xi, es decir,
                                    //incluye variables primadas y no primadas
								/*Insertamos las declaraciones de la ZDeclList declList2 en la posicion j de
                                    la ZDeclList declList  (primandolas previamente) y aumentamos deltaSize en el numero de declaraciones
                                    insertadas
                                     */

                                    deltaSize += SpecUtils.insertZDeclList((ZDeclList) declList,
                                            (ZDeclList) declList2.accept(primeVisitor), j);
                                    /*Insertamos las declaraciones de la ZDeclList declList2 en la posicion j de
                                    la ZDeclList declList y aumentamos deltaSize en el
                                    numero de declaraciones insertadas
                                     */
                                    deltaSize += SpecUtils.insertZDeclList((ZDeclList) declList,
                                            (ZDeclList) declList2, j);

                                    if (pred2 != null) {
                                        zSchText.setPred(SpecUtils.andPreds(SpecUtils.andPreds(pred, pred2),
                                                (Pred) pred2.accept(primeVisitor)));
                                    }
                                    break;
                            }

                            if (isXi) {
                                // El esquema a expandir es un Xi, por lo que se agregan la conjunción de las igualdades
                                // entre las variables del esquema a expandir y sus correspondientes variables primadas
                                Pred equalities = (new ZFactoryImpl()).createAndPred();
                                AbstractIterator<String> it = varNameRep.createIterator();
                                while (it.hasNext()) {
                                    zSchText.setPred(SpecUtils.andPreds(zSchText.getPred(), SpecUtils.createUnchangedPred(it.next())));
                                }
                            }
                            j = j + deltaSize - 1;
                            declListSize = declListSize + deltaSize - 1;
                        }
                    }
                }
            }
        }
        return schExpr;
    }

    /* Devuelve la expresion que surge de expandir los esquemas que incluye la AndExpr dada
    teniendo ademas la lista de todo los objetos Para de la especificacion. La expresion original NO
    resulta modificada.
     */
    private static Expr unfoldAndExpr(AndExpr andExpr, ZParaList zParaList) {
        Expr leftExpr = andExpr.getLeftExpr();
        Expr rightExpr = andExpr.getRightExpr();

        Expr unfoldedLeftExpr = unfoldExpr(leftExpr, zParaList);
        Expr unfoldedRightExpr = unfoldExpr(rightExpr, zParaList);

        if(unfoldedLeftExpr instanceof SchExpr &&
                unfoldedRightExpr instanceof SchExpr){
            return SpecUtils.andSchExprs((SchExpr) unfoldedLeftExpr,
                    (SchExpr) unfoldedRightExpr);
        }
        else{
            return andExpr;
        }

    }


    /* Devuelve la expresion que surge de expandir los esquemas que incluye la OrExpr dada
    teniendo ademas la lista de todo los objetos Para de la especificacion. La expresion original NO
    resulta modificada.
     */
    private static Expr unfoldOrExpr(OrExpr orExpr, ZParaList zParaList) {
        Expr leftExpr = orExpr.getLeftExpr();
        Expr rightExpr = orExpr.getRightExpr();

        Expr unfoldedLeftExpr = unfoldExpr(leftExpr, zParaList);
        Expr unfoldedRightExpr = unfoldExpr(rightExpr, zParaList);
        
        if(unfoldedLeftExpr instanceof SchExpr && 
                unfoldedRightExpr instanceof SchExpr){
            return SpecUtils.orSchExprs((SchExpr) unfoldedLeftExpr, 
                    (SchExpr) unfoldedRightExpr);
        }
        else{
            return orExpr;
        }
       
    }

    /* Devuelve la expresion que surge de expandir el esquema denotado por la RefExpr dada
    teniendo ademas la lista de todo los objetos Para de la especificacion. La expresion original NO
    resulta modificada.
     */
    private static Expr unfoldRefExpr(RefExpr refExpr, ZParaList zParaList) {


        String refExprName = refExpr.getZName().getWord().toString();

        boolean isExpandibleRef = true;
        if (refExprName.equals(UtilSymbols.integerSymbol())
                || refExprName.equals(UtilSymbols.naturalSymbol())
                || refExprName.equals("?")
                || refExpr.getZExprList().size() != 0) {
            return refExpr;
        }


        SchExpr schExprResult = null;
        String nameToSearch = "";
        DeclDecoration declDecoration = DeclDecoration.NOT_PRIMED;
        boolean isXi = false;
        int firstCharCode = (int) refExprName.charAt(0);
        if (firstCharCode == 916) {
            //El esquema a expandir es un delta
            nameToSearch = refExprName.substring(1);
            declDecoration = DeclDecoration.BOTH;
            isXi = false;
        } else if (firstCharCode == 926) {
            //El esquema a expandir es un Xi
            nameToSearch = refExprName.substring(1);
            declDecoration = DeclDecoration.BOTH;
            isXi = true;
        } else {
            //El esquema a expandir no está primado, no es un delta ni un Xi
            nameToSearch = refExprName;
            declDecoration = DeclDecoration.NOT_PRIMED;
            isXi = false;
        }


        AxPara axParaRef = SpecUtils.axParaSearch(nameToSearch, zParaList);


        if (axParaRef == null) {
            // If the right Expr is not a paragraph, then we return the RefExpr
            // unchanged
            return refExpr;
        }


       if(!listOfUnfoldedAxParas.contains(nameToSearch)){
            unfoldAxPara(axParaRef,zParaList);
       }



        CZTCloner cloneVisitor = new CZTCloner();

        SchExpr schExpr = SpecUtils.getAxParaSchExpr(axParaRef);

        if(schExpr == null){
            // If the right Expr is a paragraph but it is not an schema, then
            //we return the RefExpr unchanged
            return refExpr;
        }

        schExprResult = (SchExpr) schExpr.accept(cloneVisitor);

        ZSchText zSchText = schExprResult.getZSchText();
        DeclList declList = zSchText.getDeclList();
        Pred pred = zSchText.getPred();

        AbstractRepository<String> varNameRep = SpecUtils.getVarNames(axParaRef);
        PrimeVarsMaker primeVisitor = new PrimeVarsMaker(varNameRep);

        if (declList instanceof ZDeclList) {
            ZDeclList zDeclList = (ZDeclList) declList;
            switch (declDecoration) {
                case PRIMED:
                    zSchText.setDeclList((DeclList) zDeclList.accept(primeVisitor));
                    zSchText.setPred((Pred) pred.accept(primeVisitor));
                    break;
                case BOTH:
                    SpecUtils.insertZDeclList(zDeclList, (ZDeclList)
                            zDeclList.accept(primeVisitor), zDeclList.size());
		if(pred!=null)
                    zSchText.setPred(SpecUtils.andPreds(pred,
                            (Pred) pred.accept(primeVisitor)));
                    break;
            }

            if (isXi) {
                Pred equalities = (new ZFactoryImpl()).createAndPred();
                AbstractIterator<String> it = varNameRep.createIterator();
                while (it.hasNext()) {
                    zSchText.setPred(SpecUtils.andPreds(zSchText.getPred(), SpecUtils.createUnchangedPred(it.next())));
                }
            }
        }
        return schExprResult;
    }

	public static AxPara unFoldAxPara(AxPara axPara, ZParaList zParaList){
		ZSchText zSchText = axPara.getZSchText();
		DeclList declList = zSchText.getDeclList();
		if(declList instanceof ZDeclList){
			for(int j=0; j< ((ZDeclList)declList).size(); j++){
				Decl decl = ((ZDeclList)declList).get(j);
				if(decl instanceof ConstDecl){
					ConstDecl constDecl = (ConstDecl)decl;

					constDecl.setExpr(unfoldExpr(constDecl.getExpr(),zParaList));
					if(constDecl.getExpr() instanceof SchExpr)
						axPara.setBox(Box.SchBox);
				}
			}

		}
		return axPara;
	}

}

package client.presentation.commands;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.Para;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import common.z.czt.visitors.CZTReplacer;
import compserver.axdef.SynonymsChecker;
import client.blogic.management.Controller;
import client.presentation.ClientTextUI;

public class ReplaceAxDefCommand implements Command{
	
	private static Controller controller;
	private static ZLive zLive;
	
	public void run(ClientTextUI clientTextUI, String args) {

		controller = clientTextUI.getMyController();
		zLive = UniqueZLive.getInstance();
		
		//SpecInfo sInfo = new SpecInfo();
		//sInfo.setAxDefsValues(controller.getAxDefsValues());
		//sInfo.setFreeParaList(controller.getFreeParas());

		//Para cada schema box, hacemos un replace
		Spec spec = controller.getOriginalSpec();
		for (Sect sect : spec.getSect())
		{
			if (sect instanceof ZSect)
			{
				ZSect zSect = (ZSect)sect;
				ParaList paraList = zSect.getParaList();
				if (paraList instanceof ZParaList){
					ZParaList zParaList = (ZParaList) paraList;
					for(int i = 0; i < zParaList.size(); i++){
						Para para = zParaList.get(i);
						if(para instanceof AxPara)
						{    
							AxPara axPara  = (AxPara) para;
							String strBox  = (axPara.getBox()).name();
							if (strBox.equals("SchBox")){
								try{
									Pred pred = SpecUtils.getAxParaPred(axPara);
									pred = replaceAxDefsInPred(pred);
									SpecUtils.setAxParaPred(axPara, pred);
								}
								catch (Exception e) {
									System.out.println("Error while replacing an axiomatic definition.");
								}
							}
						}
					}
				}
			} 
		}
		System.out.println(SpecUtils.termToLatex(spec));



	}

	public static Pred replaceAxDefsInPred(Pred pred) throws IOException, CommandException{
		// ver de pasar AxPara en vez de tClass
		
		//Reemplazamos las definiciones axiomaticas de tipo "Synonyms" de tipo constante,
		//y aquellas que ya tienen un valor (mediante setaxdef)
		Map<RefExpr, Expr> axDefsValues = controller.getAxDefsValues();
		if (axDefsValues != null) {

			
			Set<Map.Entry<RefExpr, Expr>> set = axDefsValues.entrySet();
			Iterator<Map.Entry<RefExpr, Expr>> iterator = set.iterator();
			CZTReplacer replaceVisitor = new CZTReplacer();

			while (iterator.hasNext()) {
				Map.Entry<RefExpr, Expr> mapEntry = iterator.next();
				RefExpr refExpr = mapEntry.getKey();
				Expr expr = mapEntry.getValue();
				replaceVisitor.setOrigTerm(refExpr);
				replaceVisitor.setNewTerm(expr);
				pred = (Pred) pred.accept(replaceVisitor);
			}
		}
		
		//Reemplazamos las definiciones axiomaticas de tipo "Equivalences"
		SynonymsChecker synonymsChecker = new SynonymsChecker(pred);
		String strPred = synonymsChecker.replacedPred();
		strPred = strPred.replace("\n", "\\\\\n");
		pred = ParseUtils.parsePred(new StringSource(strPred),zLive.getCurrentSection(), zLive.getSectionManager());
		pred = SpecUtils.simplifyAndPred(pred);
		return pred;
	}
}
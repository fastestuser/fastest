package client.presentation.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.AndPred;
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
import common.z.TClass;
import common.z.TClassImpl;
import common.z.czt.UniqueZLive;
import compserver.axdef.AxDefUtils;
import compserver.axdef.ResultMatchAxDef;
import compserver.axdef.SynonymsChecker;
import compserver.prunning.SpecInfo;
import client.blogic.management.Controller;
import client.presentation.ClientTextUI;

public class ReplaceAxDefCommand implements Command{

	

	public void run(ClientTextUI clientTextUI, String args) {

		Controller controller = clientTextUI.getMyController();
		ZLive zLive = UniqueZLive.getInstance();
		
		SpecInfo sInfo = new SpecInfo();
		sInfo.setAxDefsValues(controller.getAxDefsValues());
		sInfo.setFreeParaList(controller.getFreeParas());

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
								TClassImpl tc = new TClassImpl(axPara,SpecUtils.getAxParaName(axPara));
								try{
									remplazarPred(tc,zLive);
								}
								catch (Exception e) {
									System.out.println("error en remlazo de pred");
								}
							}
						}
					}
				}
			} 
		}
		System.out.println(SpecUtils.termToLatex(spec));



	}

	private void remplazarPred(TClass tClass,ZLive zLive) throws IOException, CommandException{
		// ver de pasar AxPara en vez de tClass
		SynonymsChecker synonymsChecker = new SynonymsChecker(tClass);
		String pred1 = synonymsChecker.replacedPred();
		pred1 = pred1.replace("\n", "\\\\\n");
		Pred p = ParseUtils.parsePred(new StringSource(pred1),zLive.getCurrentSection(), zLive.getSectionManager());
		p = SpecUtils.simplifyAndPred(p);
		
		String pred2 = SpecUtils.termToLatex(p);
		
		SpecUtils.setAxParaPred(tClass.getMyAxPara(), p);
	}
	
	
}
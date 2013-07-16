package client.presentation.commands;

import java.util.ArrayList;
import java.util.List;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Para;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.TClassImpl;
import compserver.axdef.ResultMatchAxDef;
import compserver.axdef.SynonymsChecker;
import compserver.prunning.SpecInfo;
import client.blogic.management.Controller;
import client.presentation.ClientTextUI;

public class ReplaceAxDefCommand implements Command{

	public void run(ClientTextUI clientTextUI, String args) {

		Controller controller = clientTextUI.getMyController();
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
								ResultMatchAxDef r = pruneTree(tc,sInfo);
								r.getResult();
							}
						}
					}
				}
			} 
		}

	}

	private ResultMatchAxDef pruneTree(TClass tClass, SpecInfo specInfo){
		SynonymsChecker synonymsChecker = new SynonymsChecker(tClass);
		String tClassName = SpecUtils.getAxParaName(tClass);
		String synonymName = "";
		List<String> params = new ArrayList<String>();
		boolean result = false;

		//synonymsChecker.info = new HashMap<String,List<Map<String,String>>>();
		String pred = synonymsChecker.replacedPred();
		
		ResultMatchAxDef resultMatchAxDef = new ResultMatchAxDef(tClassName, synonymName, params, result);
		return resultMatchAxDef;
	}
}
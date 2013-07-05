package client.presentation.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.Para;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.Type;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import common.z.SpecUtils;
import common.z.TClass;
import common.z.TClassImpl;
import compserver.axdef.AxDefUtils;
import compserver.axdef.ResultMatchAxDef;
import compserver.axdef.SynonymsChecker;
import compserver.prunning.SpecInfo;
import compserver.prunning.Theorem;
import compserver.prunning.Variable;
import compserver.prunning.operators.OperatorAnalizer;
import compserver.prunning.operators.SpecialLine;
import compserver.prunning.typechecking.TypeChecker;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
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

		Map<String, List<Map<String,String>>> matches = synonymsChecker.findParameters();
		while(matches.size()>0 && !result){
			Set<Map.Entry<String, List<Map<String,String>>>> set = matches.entrySet();
			Iterator<Map.Entry<String, List<Map<String,String>>>> iterator = set.iterator();
			while(iterator.hasNext() && !result){
				Map.Entry<String, List<Map<String,String>>> mapEntry = iterator.next();
				synonymName = mapEntry.getKey();
				List<Map<String,String>> listMatches = mapEntry.getValue();
				for(int i=0;i<listMatches.size() && !result;i++){
					// Deberia ir tras el chequeo y el eval
					params.clear();
					result = true;
					Map<String, String> mapFR = listMatches.get(i);

					//We extract the real parameters in the correct order
					Theorem theSynonym = AxDefUtils.getSynonym(synonymName);
					List<Variable> formalParameters = theSynonym.getFormalParamList();
					for(int j=0;j<formalParameters.size();j++){
						Variable formalVar = formalParameters.get(j);
						String formalName = formalVar.getName();
						String realName = mapFR.get(formalName);
						//System.out.println("Formal: "+formalName);
						//System.out.println("Real: "+realName);
						params.add(realName);
					}
					TypeChecker typeChecker = new TypeChecker();
					result = typeChecker.checkParametersTypes(theSynonym, tClass, params);
					if(result){
						List<SpecialLine> specialLines = theSynonym.getSpecialLines();
						if(specialLines.size()>0){
							Map<String,Type> mapFormalReal = typeChecker.getMapFR();
							String pred = AxDefUtils.replaceParameters(synonymName, params,"SpecialPredicates", mapFormalReal);
							result = (new OperatorAnalizer()).analize(specialLines, pred, tClass, specInfo);
						}
					}
				}
			}
			if(!result)
				matches = synonymsChecker.findParameters();
		}
		ResultMatchAxDef resultMatchAxDef = new ResultMatchAxDef(tClassName, synonymName, params, result);
		return resultMatchAxDef;
	}




}



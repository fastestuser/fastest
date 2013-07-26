package client.presentation.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.FileSource;
import net.sourceforge.czt.session.Key;
import net.sourceforge.czt.session.SectionManager;
import net.sourceforge.czt.session.Source;
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
import common.z.czt.visitors.ParenthesisRemover;
import compserver.axdef.AxDefsChecker;
import client.blogic.management.Controller;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.SpecLoaded;
import client.presentation.ClientTextUI;

public class ReplaceAxDefCommand implements Command{

	private static Controller controller;
	private static ZLive zLive;

	public void run(ClientTextUI clientTextUI, String args) {

		controller = clientTextUI.getMyController();
		zLive = UniqueZLive.getInstance();

		Spec spec = loadSpecAgain(controller.getNomTexFileSpec());
		controller.setOriginalSpec(spec);
		EventAdmin eventAdmin = null;
		try {
			eventAdmin = EventAdmin.getInstance();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		SpecLoaded specLoaded = new SpecLoaded(spec);
		eventAdmin.announceEvent(specLoaded);
		//Para cada schema box, hacemos un replace
		//Spec spec = controller.getOriginalSpec();
		for (Sect sect : spec.getSect())
		{
			if (sect instanceof ZSect)
			{
				ZSect zSect = (ZSect)sect;
				ParaList paraList = zSect.getParaList();
				if (paraList instanceof ZParaList){
					ZParaList zParaList = (ZParaList) paraList;
					ParenthesisRemover cleaner = new ParenthesisRemover();
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
									axPara.accept(cleaner);
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
		//System.out.println(SpecUtils.termToLatex(spec));
	}

	public static Pred replaceAxDefsInPred(Pred pred) throws IOException, CommandException{
		//Reemplazamos las definiciones axiomaticas de tipo "Synonyms" de tipo constante,
		//y aquellas que ya tienen un valor (mediante setaxdef)
		pred = (Pred) replaceAxDefValues(pred);

		//Reemplazamos las definiciones axiomaticas de tipo "Equivalences"
		AxDefsChecker axDefsChecker = new AxDefsChecker(pred);
		String strPred = axDefsChecker.replacedPred();
		strPred = strPred.replace("\n", "\\\\\n");
		pred = ParseUtils.parsePred(new StringSource(strPred),zLive.getCurrentSection(), zLive.getSectionManager());
		pred = SpecUtils.simplifyAndPred(pred);
		return pred;
	}

	private static Term replaceAxDefValues(Term term){

		Map<RefExpr, Expr> axDefsValues = controller.getAxDefsValues();
		if (axDefsValues != null) {

			Set<Map.Entry<RefExpr, Expr>> set = axDefsValues.entrySet();
			Iterator<Map.Entry<RefExpr, Expr>> iterator = set.iterator();
			CZTReplacer replaceVisitor = new CZTReplacer();
			String strTerm = SpecUtils.termToLatex(term);

			while (iterator.hasNext()) {
				Map.Entry<RefExpr, Expr> mapEntry = iterator.next();
				RefExpr refExpr = mapEntry.getKey();

				String refExprPattern = "(\\W|^)" + refExpr.getZName() + "(\\W|$)";
				strTerm = SpecUtils.termToLatex(term);

				Pattern pattern = Pattern.compile(refExprPattern);
				Matcher matcher = pattern.matcher(strTerm);
				if (matcher.find()) { //Contiene la definicion axiomatica
					Term expr = mapEntry.getValue();
					expr = replaceAxDefValues(expr);

					replaceVisitor.setNewTerm(expr);
					replaceVisitor.setOrigTerm(refExpr);
					term =  term.accept(replaceVisitor);
					strTerm = SpecUtils.termToLatex(term);
				}
			}
			return term;
		}
		return null;
	}

	/**
	 * This method copies the content of the file, whose name is equals to the
	 * first specified string, into the file whose name is equals to the second
	 * specified string.
	 */
	private boolean copyFile(String originalFileName, String newFileName) {
		try {
			FileWriter writer = new FileWriter(newFileName);
			PrintWriter printer = new PrintWriter(writer);
			FileReader reader = new FileReader(originalFileName);
			BufferedReader in = new BufferedReader(reader);
			String line;

			while ((line = in.readLine()) != null) {
				printer.println(line);
			}
			printer.flush();

			printer.close();
			writer.close();

			in.close();
			reader.close();
			return true;

		} catch (FileNotFoundException e) {
			System.out.println("The file " + originalFileName + " could not be found.");
			return false;
		} catch (Exception e) {
			return false;
		}

	}

	private Spec loadSpecAgain(String nomTexFileSpec){
		File texFileToRead = null;
		Spec spec = null;
		try {
			// Inicializamos el Controller
			// The following is made in order to load the ZLive instance at
			// Fastest initiation
			//ZLive zLive = UniqueZLive.getInstance();
			UniqueZLive.getInstance();
			String texFileToReadName = "";
			File originalTexFile = null;
			originalTexFile = new File(nomTexFileSpec);
			texFileToReadName = "temp/" + originalTexFile.getName() + ".tmp";
			// A copy of the original file is made, in order to avoid the
			// access restriction from other programs
			copyFile(nomTexFileSpec, texFileToReadName);
			texFileToRead = new File(texFileToReadName);
			FileSource source = new FileSource(texFileToRead);
			SectionManager manager = new SectionManager();
			//SectionManager manager = zLive.getSectionManager();
			manager.put(new Key(texFileToReadName, Source.class), source);
			// The specification is loaded and set in the controller
			spec = (Spec) manager.get(new Key(texFileToReadName, Spec.class));
		}
		catch (Exception e){
			System.out.println("Cant loadAgain " + nomTexFileSpec );
		}
		return spec;
	}
}
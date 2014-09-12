package client.blogic.testing.refinement.tcrlrules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import client.blogic.testing.refinement.DescriptiveErrorListener;
import client.blogic.testing.refinement.FTCRLLexer;
import client.blogic.testing.refinement.FTCRLParser;
import client.blogic.testing.refinement.FTCRLParser.RefinementRuleContext;

public class TCRLFileParser {
	private static RefinementRuleContext makeRuleContext(String ruleString){
		ANTLRInputStream input = new ANTLRInputStream(ruleString); 
		FTCRLLexer lexer = new FTCRLLexer(input);
		DescriptiveErrorListener err = new DescriptiveErrorListener();
		lexer.removeErrorListeners();
		lexer.addErrorListener(err);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FTCRLParser parser = new FTCRLParser(tokens);
		parser.removeErrorListeners();
		parser.addErrorListener(err);
		RefinementRuleContext ruleContext = parser.refinementRule();
		if (err.hasErrors())
			return null;
		return ruleContext;
	}

	private static String unfoldPreamble(String preamble){
		RefinementRules.instance();
		String REGEX = "^(\\w*)\\.@PREAMBLE$";
		Pattern p = Pattern.compile(REGEX,Pattern.MULTILINE);
		Matcher m = p.matcher(preamble);
		String unpreambulo = new String();
		while(m.find()) {
			unpreambulo = RefinementRules.getRule(m.group(1)).getPreamble();
			preamble = m.replaceFirst(unfoldPreamble(unpreambulo));
			m = p.matcher(preamble);
		}
		return preamble;
	}
	//resuelve los preambles incluidos recursivamente 
	private static void resolvePreamble(){
		RefinementRules.instance();
		Iterator<String> it = RefinementRules.getRefRuleNames();
		String preamble = "";
		String ruleName = "";
		RefinementRule rule;
		while (it.hasNext()) {
			try{
				ruleName = it.next();
				rule = RefinementRules.getRule(ruleName);
				preamble = rule.getPreamble();
				preamble = unfoldPreamble(preamble);
				rule.setPreamble(preamble);
			} catch (Exception e) {
				System.out.println("Error when trying to resolve "+ruleName+" preamble.");
				System.out.println("Refinement rule "+ruleName+" not loaded.");
				//Revisar porque borramos esto
				//RefinementRules.deleteRule(ruleName);
				continue;
			}
		}
	}

	private static void resolveLawsReferences(){
		RefinementRules.instance();
		//if (RefinementRules.isEmpty()){
		//	System.out.println("Error when trying to resolve the rules.");
		//	System.out.println("Refinements rules not loaded.");
		//}
		Iterator<String> it = RefinementRules.getRefRuleNames();
		RefinementRuleContext ruleContext;
		ANTLRInputStream input;
		String ruleString;
		FTCRLLexer lexer;
		CommonTokenStream tokens;
		RefinementRule rule;
		String ruleName = "";
		while (it.hasNext()){
			try{
				ruleName = it.next();
				rule = RefinementRules.getRule(ruleName);
				ruleContext = rule.getTree();
				ruleString = ruleContext.accept(new FTCRLPreprocVisitor(ruleContext));
				input = new ANTLRInputStream(ruleString);
				lexer = new FTCRLLexer(input);
				tokens = new CommonTokenStream(lexer);
				ruleContext = new FTCRLParser(tokens).refinementRule();
				rule.setTree(ruleContext);
			} catch (Exception e) {
				System.out.println("Error when trying to resolve "+ruleName+" laws.");
				System.out.println("Refinement rule "+ruleName+" not loaded.");
				//Revisar porque borramos esto
				//RefinementRules.deleteRule(ruleName);
				continue;
			}
		}
	}

	/*Del archivo de reglas, llena las reglas*/
	public static void parse(File refRuleFile) throws Exception, IOException{
		try{
			FileInputStream refRuleFileStream = new FileInputStream(refRuleFile.getAbsolutePath());
			String refRulesString = new Scanner(refRuleFileStream,"UTF-8").useDelimiter("\\A").next();
			refRuleFileStream.close();

			RefinementRuleContext ruleContext;
			RefinementRule rule;
			RefinementRules.instance();
			String refRuleAux[],srefrule,section,preamble, uut, epilogue,ruleString,name,plcode = "",laws;
			String refRulesAux[] = refRulesString.split("@RRULE");
			
			
			if (refRulesAux.length < 2) 
				throw new Exception("missing @RRULE section.");

			
			int cantHijos = refRulesAux.length;
			for (int i = 1; i<cantHijos;i++){
				HashMap<String,String> hsections = new HashMap<String, String>();
				List<String> lsections = new LinkedList<String>();
				
				srefrule = refRulesAux[i];
				if (srefrule.contains("@PREAMBLE"))
					lsections.add("@PREAMBLE");
				if (srefrule.contains("@LAWS"))
					lsections.add("@LAWS");
				if (srefrule.contains("@PLCODE"))
					lsections.add("@PLCODE");
				if (srefrule.contains("@UUT"))
					lsections.add("@UUT");
				if (srefrule.contains("@EPILOGUE"))
					lsections.add("@EPILOGUE");
					
				hsections.put("@PREAMBLE", "");
				hsections.put("@LAWS", "");
				hsections.put("@PLCODE", "");
				hsections.put("@UUT", "");
				hsections.put("@EPILOGUE", "");
				Iterator<String> it = lsections.iterator();
				section = it.next();
				refRuleAux = srefrule.split(section,2);
				name = refRuleAux[0];
				String sant = section;
				while (it.hasNext()){
					section = it.next();
					refRuleAux = refRuleAux[1].split(section,2);
					hsections.put(sant,refRuleAux[0]);
					sant = section;
				}
				hsections.put(sant,refRuleAux[1]);
				
				preamble = hsections.get("@PREAMBLE");
				laws = hsections.get("@LAWS");
				plcode = hsections.get("@PLCODE");
				uut = hsections.get("@UUT");
				epilogue = hsections.get("@EPILOGUE");
				
				ruleString = "@RRULE"+name+"@PREAMBLE\n@LAWS"+laws+"@UUT"+uut;
				ruleContext = makeRuleContext(ruleString); //falla	indudablemente aca. 
				//habria qeu pasar todo esto a despues de refinement, pero antes camgiar la gramatica
				if(ruleContext != null){
					rule = new RefinementRule(ruleContext, preamble, epilogue, plcode);
					RefinementRules.addRule(ruleContext.name().getText(), rule);
				} else{
					System.out.println("Refinement rule "+name.trim()+" not loaded.");
				}

			}

			resolveLawsReferences();
			resolvePreamble();
		}

		catch (FileNotFoundException e){
			throw new IOException("File " + refRuleFile.getAbsolutePath() + " not found");
		}
		catch (IOException e){
			throw new IOException("Can't close " + refRuleFile.getAbsolutePath() + " file");
		}

	}

}

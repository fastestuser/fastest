package client.blogic.testing.refinement.tcrlrules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
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
		RefinementRules rules = RefinementRules.getInstance();
		String REGEX = "^(\\w*)\\.@PREAMBLE$";
		Pattern p = Pattern.compile(REGEX,Pattern.MULTILINE);
		Matcher m = p.matcher(preamble);
		String unpreambulo = new String();
		while(m.find()) {
			unpreambulo = rules.getRule(m.group(1)).getPreamble();
			preamble = m.replaceFirst(unfoldPreamble(unpreambulo));
			m = p.matcher(preamble);
		}
		return preamble;
	}
	//resuelve los preambles incluidos recursivamente 
	private static void resolvPreamble(){
		RefinementRules rules = RefinementRules.getInstance();
		Iterator<String> it = rules.getRefRuleNames();
		String preamble = "";
		String ruleName = "";
		RefinementRule rule;
		while (it.hasNext()) {
			try{
				ruleName = it.next();
				rule = rules.getRule(ruleName);
				preamble = rule.getPreamble();
				preamble = unfoldPreamble(preamble);
				rule.setPreamble(preamble);
			} catch (Exception e) {
				System.out.println("Error when trying to resolve "+ruleName+" preamble.");
				System.out.println("Refinement rule "+ruleName+" not loaded.");
				rules.deleteRule(ruleName);
				continue;
			}
		}
	}

	private static void resolveLawsReferences(){
		RefinementRules rules = RefinementRules.getInstance();
		Iterator<String> it = rules.getRefRuleNames();
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
				rule = rules.getRule(ruleName);
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
				rules.deleteRule(ruleName);
				continue;
			}
		}
	}

	public static void parse(File refRuleFile) throws Exception, IOException{
		try{
			FileInputStream refRuleFileStream = new FileInputStream(refRuleFile.getAbsolutePath());
			String refRulesString = new Scanner(refRuleFileStream,"UTF-8").useDelimiter("\\A").next();
			refRuleFileStream.close();

			RefinementRuleContext ruleContext;
			RefinementRule rule;
			RefinementRules rules = RefinementRules.getInstance();
			String refRuleAux[],preamble, uut, epilogue,ruleString,rrule,plcode = "",laws;
			String refRulesAux[] = refRulesString.split("@RRULE");
			if (refRulesAux.length < 2) 
				throw new Exception("missing @RRULE section.");

			int cantHijos = refRulesAux.length;
			for (int i = 1; i<cantHijos;i++){

				refRuleAux = refRulesAux[i].split("@PREAMBLE",2);
				rrule = refRuleAux[0];
				if (refRuleAux.length < 2) {
					System.out.println("Error: missing @PREAMBLE section.");
					System.out.println("Refinement rule "+rrule.substring(0, rrule.indexOf("\n")).trim()+" not loaded.");
					continue;
				}

				refRuleAux = refRuleAux[1].split("@LAWS",2);
				if (refRuleAux.length < 2){
					System.out.println("Error: missing @LAWS section.");
					System.out.println("Refinement rule "+rrule.trim()+" not loaded.");
					continue;
				}

				preamble = refRuleAux[0];

				refRuleAux = refRuleAux[1].split("@PLCODE",2);
				if (refRuleAux.length == 2){ //tiene plcode
					laws = refRuleAux[0];
					refRuleAux = refRuleAux[1].split("@UUT");
					if (refRuleAux.length < 2){
						System.out.println("Error: missing @UUT section.");
						System.out.println("Refinement rule "+rrule.trim()+" not loaded.");
						continue;
					}
					plcode = refRuleAux[0].substring(1);
				} else {
					refRuleAux = refRuleAux[0].split("@UUT");
					if (refRuleAux.length < 2) {
						System.out.println("Error: missing @UUT section.");
						System.out.println("Refinement rule "+rrule.trim()+" not loaded.");
						continue;
					}
					laws = refRuleAux[0];
					plcode = "";
				}

				refRuleAux = refRuleAux[1].split("@EPILOGUE",2);
				if (refRuleAux.length == 2) //tiene epilogue
					epilogue = refRuleAux[1];
				else 
					epilogue = "";

				uut = refRuleAux[0];
				ruleString = "@RRULE"+rrule+"@PREAMBLE\n@LAWS"+laws+"@UUT"+uut;

				//StringTokenizer tokenizer = new StringTokenizer(preamble, "\n");
				//int preambleSize = tokenizer.countTokens();
				ruleContext = makeRuleContext(ruleString);	

				if(ruleContext != null){
					rule = new RefinementRule(ruleContext, preamble, epilogue, plcode);
					rules.addRule(ruleContext.name().getText(), rule);
				} else{
					System.out.println("Refinement rule "+rrule.trim()+" not loaded.");
				}

			}

			resolveLawsReferences();
			resolvPreamble();
		}

		catch (FileNotFoundException e){
			throw new IOException("File " + refRuleFile.getAbsolutePath() + " not found");
		}
		catch (IOException e){
			throw new IOException("Can't close " + refRuleFile.getAbsolutePath() + " file");
		}

	}

}

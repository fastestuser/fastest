package client.blogic.testing.refinement.tcrlrules;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import client.blogic.testing.refinement.ExceptionErrorStrategy;
import client.blogic.testing.refinement.FTCRLLexer;
import client.blogic.testing.refinement.FTCRLParser;
import client.blogic.testing.refinement.FTCRLParser.RefinementRuleContext;

public class TCRLFileParser {
	private static RefinementRuleContext makeRuleContext(String ruleString){
		ANTLRInputStream input = new ANTLRInputStream(ruleString); 
		FTCRLLexer lexer = new FTCRLLexer(input); 
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		FTCRLParser parser = new FTCRLParser(tokens);
		parser.setErrorHandler(new ExceptionErrorStrategy());
		RefinementRuleContext ruleContext = parser.refinementRule();
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
		Iterator<RefinementRule> it = rules.getRefRuleIterator();
		String preamble;
		RefinementRule rule;
		while (it.hasNext()) {
			rule = it.next();
			preamble = rule.getPreamble();
			preamble = unfoldPreamble(preamble);
			rule.setPreamble(preamble);
		}
	}

	private static void resolveLawsReferences(){
		RefinementRules rules = RefinementRules.getInstance();
		Iterator<RefinementRule> it = rules.getRefRuleIterator();
		RefinementRuleContext ruleContext;
		ANTLRInputStream input;
		String ruleString;
		FTCRLLexer lexer;
		CommonTokenStream tokens;
		RefinementRule rule;
		while (it.hasNext()){
			rule = it.next();
			ruleContext = rule.getTree();
			ruleString = ruleContext.accept(new FTCRLPreprocVisitor(ruleContext));
			input = new ANTLRInputStream(ruleString);
			lexer = new FTCRLLexer(input);
			tokens = new CommonTokenStream(lexer);
			ruleContext = new FTCRLParser(tokens).refinementRule();
			rule.setTree(ruleContext);
		}
	}
	
	public static void parse(File refRuleFile) throws IOException{
		FileInputStream refRuleFileStream = new FileInputStream(refRuleFile.getAbsolutePath());
		String refRulesString = new Scanner(refRuleFileStream,"UTF-8").useDelimiter("\\A").next();
		refRuleFileStream.close();
		RefinementRuleContext ruleContext;
		RefinementRule rule;
		RefinementRules rules = RefinementRules.getInstance();
		String refRuleAux[],preamble, uut, epilogue,ruleString,rrule,plcode = "",laws;
		String refRulesAux[] = refRulesString.split("@RRULE");
		int cantHijos = refRulesAux.length;
		for (int i = 1; i<cantHijos;i++){

			refRuleAux = refRulesAux[i].split("@PREAMBLE",2);
			rrule = refRuleAux[0];

			refRuleAux = refRuleAux[1].split("@LAWS",2);
			preamble = refRuleAux[0];

			refRuleAux = refRuleAux[1].split("@PLCODE",2);
			if (refRuleAux.length == 2){ //tiene plcode
				laws = refRuleAux[0];
				refRuleAux = refRuleAux[1].split("@UUT");
				plcode = refRuleAux[0].substring(1);
			} else {
				refRuleAux = refRuleAux[0].split("@UUT");
				laws = refRuleAux[0];
				plcode = "";
			}

			refRuleAux = refRuleAux[1].split("@EPILOGUE",2);
			if (refRuleAux.length == 2){ //tiene epilogue
				epilogue = refRuleAux[1];
			} else {
				epilogue = "";
			}

			uut = refRuleAux[0];

			ruleString = "@RRULE"+rrule+"@PREAMBLE\n@LAWS"+laws+"@UUT"+uut;
			ruleContext = makeRuleContext(ruleString);	

			rule = new RefinementRule(ruleContext, preamble, epilogue, plcode);
			rules.addRule(ruleContext.name().getText(), rule);

		}
		resolveLawsReferences();
		resolvPreamble();
	}
		
}

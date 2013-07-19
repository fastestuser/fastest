package compserver.axdef;

import client.presentation.commands.ReplaceAxDefCommand;
import common.z.SpecUtils;
import common.regex.RegExUtils;
import common.z.czt.UniqueZLive;
import common.repository.AbstractIterator;
import compserver.prunning.Theorem;
import compserver.prunning.Variable;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.*;
import java.util.regex.Pattern; 
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.parser.circus.ParseUtils;
import net.sourceforge.czt.session.CommandException;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.Pred;

/**
 * Obtains all the information of the expressions in a test class that match with the
 * regular expression of an axiomatic definition
 */
public class SynonymsChecker
{

	private AbstractIterator<Theorem> synonymsIt;
	private String strPred;
	//private String originalPred;
	private String currentSynonym;
	//public Map<String,List<Map<String,String>>> info;

	/**
	 * Creates instaces of TheoremsChecker.
	 * @param tClass the test class under analysis
	 */
	public SynonymsChecker(Pred pred)
	{
		SynonymsControl synonymsControl = SynonymsControl.getInstance();
		synonymsIt = synonymsControl.createIterator();
		strPred = SpecUtils.termToLatex(pred);
		String[] parts = strPred.split("\n");
		String auxPred = "";
		for(int i=0;i<parts.length;i++){
			if(parts[i].endsWith(" \\\\"))
				parts[i] = parts[i].substring(0, parts[i].length() -3)+"\n";
			auxPred+=parts[i];
		}
		strPred = auxPred;
		//originalPred = auxPred;
		currentSynonym = "";
	}
	/**
	 * Returns a map with the theorem name which regular expression match with a test class's
	 * predicate as key and the asignation to the parametes of the theorem as value
	 * @param tClass the test class under analysis
	 * @throws CommandException 
	 * @throws IOException 
	 */
	public String replacedPred() throws IOException, CommandException{

		if(synonymsIt.hasNext()){
			Theorem theSynonym = synonymsIt.next();
			//String theoremName = theSynonym.getName();

			List<List<List<String>>> reservedWords = theSynonym.getReservedWords();
			boolean reservedsInPredicate = true; 
			// We check if the necessary operators are present in the predicate
			for(int x1=0;x1<reservedWords.size() && reservedsInPredicate;x1++){
				List<List<String>> alterna = reservedWords.get(x1);
				boolean someAlternative = false;
				for(int x2=0;x2<alterna.size() && !someAlternative;x2++){
					List<String> subList = alterna.get(x2);
					boolean thisAlternative = true;
					for(int x3=0;x3<subList.size() && thisAlternative;x3++){
						if(!strPred.contains(subList.get(x3)))
							thisAlternative = false;
					}
					if(thisAlternative)
						someAlternative = true;
				}
				if(!someAlternative)
					reservedsInPredicate = false;
			}

			// If the operators are present we do the analysis
			if(reservedsInPredicate){
				Map<String,String> mapFR = new HashMap<String,String>();
				List<Map<String,String>> matches = new ArrayList<Map<String,String>>();
				analyzePatterns(theSynonym, mapFR, matches, 0);
				return replacedPred() ;
			}
			else
				return replacedPred() ;
		}
		else
			return strPred ;
	}

	private List<Map<String,String>> analyzePatterns(Theorem theSynonym, Map<String,String> mapFR, List<Map<String,String>> matches, int startIndex) throws IOException, CommandException
	{
		if(currentSynonym!=theSynonym.getName()){
			//strPred = originalPred;
			currentSynonym = theSynonym.getName();
		}

		String finalStrPred;

		String[] partsPredicate = theSynonym.getPredicatesToMatch().split("\n");
		//strPred = originalPred;
		List<List<Pattern>> patterns = theSynonym.getRegEx();
		
		//Pattern with axdefs replaced (falta terminar)
		/*
		String strPred2 = theSynonym.getPredicatesToMatch();
		ZLive zLive = UniqueZLive.getInstance();
		strPred2 = strPred2.replace("\n", "\\\\\n");
		Pred finalPred2 = ParseUtils.parsePred(new StringSource(strPred2),zLive.getCurrentSection(), zLive.getSectionManager());
		finalPred2 = ReplaceAxDefCommand.replaceAxDefsInPred(finalPred2);
		strPred2 = SpecUtils.termToLatex(finalPred2);
		List<List<Pattern>> patterns = SynonymsLoader.createRegExpr(strPred2, theSynonym.getFormalParamList(), new ArrayList<Map<Integer,String>>());
		*/
		
		List<Map<Integer,String>> mapGroups = theSynonym.getVarRegExGroups();
		List<Pattern> auxPatterns = patterns.get(startIndex);
		Matcher matcher = auxPatterns.get(0).matcher(strPred);

		int groupCount = 0;


		Map<Integer,String> groups = mapGroups.get(startIndex);
		boolean match = false;
		boolean nonContradiction = false;
		for(int i=0;i<auxPatterns.size();i++){
			Pattern auxPattern = auxPatterns.get(i);
			String functionName = null;
			if (currentSynonym.startsWith("Synonym")){
				functionName = currentSynonym.split("_")[1];
			}
			if (functionName != null)
				strPred = ExpressionDelimiter.marcarPred(strPred, functionName, theSynonym.getFormalParamList().size());
			
			matcher = matcher.reset(strPred);
			matcher = matcher.usePattern(auxPattern);

			while(matcher.find()){

				finalStrPred = theSynonym.getDefinition();

				boolean contradiction = false;
				Map<String,String> mapFRCopy = new HashMap<String,String>();
				mapFRCopy.putAll(mapFR);
				match = true;
				for(int j=1;j<matcher.groupCount()+1 && !contradiction;j++){
					if(matcher.group(j)!=null && matcher.group(j)!=""){
						String captured = matcher.group(j);
						String formal = groups.get(j+groupCount).trim();
						if(captured.endsWith(" "))
							captured = captured.substring(0, captured.length()-1);
						else if(captured.endsWith(" ="))
							captured = captured.substring(0, captured.length()-2);

						if(captured.contains(",") && partsPredicate[startIndex].contains("\\se( "+formal+" )")){
							String auxNewVar = captured.substring(captured.lastIndexOf(",")+1).trim();
							strPred = strPred.replaceFirst(RegExUtils.addEscapeCharacters(captured), captured.substring(0, captured.lastIndexOf(",")-1));
							captured = auxNewVar;
							matcher.reset(strPred);
						}

						// If the formal parameter is present in the map we compared the captureds values
						if(mapFRCopy.containsKey(formal)){
							if(!mapFRCopy.get(formal).matches(RegExUtils.addEscapeCharacters("([(][ ])*"+captured+"([ ][)])*")) && !captured.matches(RegExUtils.addEscapeCharacters("([(][ ])*"+mapFRCopy.get(formal)+"([ ][)])*"))){
								contradiction = true;
							}
						}
						else{
							// If the formal parameter is not present in the map and the captured value is not present in the map we add this entry to the map
							if(!mapFRCopy.containsValue(captured)) {
								mapFRCopy.put(formal,captured);
							}
							else{
								// If the formal parameter is not present in the map and the captured value is present in the map we check if the corresponding formal parameter is a constant or a variable. The constants must be differents
								List<Variable> vars = theSynonym.getFormalParamList();
								boolean repeat = false;
								for(int k=0;k<vars.size() && !repeat;k++){
									Variable var = vars.get(k);
									String name = var.getName();
									String type = var.getType();
									if(name.equals(formal) && type.startsWith("\\const")){
										Set<String> keySet = mapFRCopy.keySet();
										List<String> keyList = new ArrayList<String>();
										keyList.addAll(keySet);
										for(int x=0;x<keyList.size() && !repeat;x++){
											String auxFormal = keyList.get(x);
											String auxCaptured = mapFRCopy.get(auxFormal);
											if(auxCaptured.equals(captured)){
												for(int y=0;y<vars.size() && !repeat;y++){
													Variable auxVar = vars.get(y);
													String auxName = auxVar.getName();
													String auxType = auxVar.getType();
													if(auxName.equals(auxFormal) && auxType.startsWith("\\const")){
														repeat = true;
													}
												}
											}
										}
									}
								}
								if(repeat)
									contradiction = true;
								else {
									mapFRCopy.put(formal,captured);
								}
							}
						}
					}
				}
				if(!contradiction){
					nonContradiction = true;
					if(startIndex+1<patterns.size()){
						List<Map<String,String>> auxList = analyzePatterns(theSynonym, mapFRCopy, matches, startIndex+1);
						if(auxList!=null)
							matches = auxList;
					}
					else{
						matches.add(mapFRCopy);

						//Chequear los tipos del map y si esta bien hacer lo que sigue:
						//Por cada variable en el map: finalPred = finalPred.replaceAll(formal, captured);
						//y despues

						//Hace falta chequear que tipe? o ya debe tipar si es que paso por loadspec
						/*boolean result = true;

						//We extract the real parameters in the correct order
						List<Variable> formalParameters = theSynonym.getFormalParamList();
						List<String> params = new ArrayList<String>();
						for(int j=0;j<formalParameters.size();j++){
							Variable formalVar = formalParameters.get(j);
							String formalName = formalVar.getName();
							String realName = mapFRCopy.get(formalName);
							//System.out.println("Formal: "+formalName);
							//System.out.println("Real: "+realName);
							params.add(realName);
						}
						TypeChecker typeChecker = new TypeChecker();
						result = typeChecker.checkParametersTypes(theSynonym, tClass, params);

						if (result) {*/
						Iterator<String> mapIt = mapFRCopy.keySet().iterator();
						while (mapIt.hasNext()) {
							String formal = mapIt.next();
							String formalPattern = "(\\W|^)" + formal + "(\\W|$)";
							finalStrPred = finalStrPred.replaceAll(formalPattern, "$1"+mapFRCopy.get(formal)+"$2");
						}

						ZLive zLive = UniqueZLive.getInstance();
						finalStrPred = finalStrPred.replace("\n", "\\\\\n");
						Pred finalPred = ParseUtils.parsePred(new StringSource(finalStrPred),zLive.getCurrentSection(), zLive.getSectionManager());
						finalPred = ReplaceAxDefCommand.replaceAxDefsInPred(finalPred);
						finalStrPred = SpecUtils.termToLatex(finalPred);

						String[] parts = finalStrPred.split("\n");
						String auxPred = "";
						for(int j=0;j<parts.length;j++){
							if(parts[j].endsWith(" \\\\"))
								parts[j] = parts[j].substring(0, parts[j].length() -3)+"\n";
							auxPred+=parts[j];
						}
						finalStrPred = auxPred;



						finalStrPred = finalStrPred.replace("\\", "\\\\");
						String originalPattern = auxPattern.pattern();
						//originalPattern = originalPattern.substring(1, originalPattern.length()-1);
						strPred = strPred.replaceFirst(originalPattern, finalStrPred);
						matcher = matcher.reset(strPred);
						//}
					}
				}
			}
			groupCount+=matcher.groupCount();
		}
		if(!match || !nonContradiction)
			return null;

		return matches;
	}
}
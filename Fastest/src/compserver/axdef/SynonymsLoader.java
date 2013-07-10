package compserver.axdef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.parser.z.ParseUtils;
import net.sourceforge.czt.session.StringSource;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.DeclList;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.ForallPred;
import net.sourceforge.czt.z.ast.MemPred;
import net.sourceforge.czt.z.ast.Para;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.SetExpr;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZDeclList;
import net.sourceforge.czt.z.ast.ZExprList;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;
import common.regex.RegExUtils;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import common.z.czt.visitors.AndPredClausesExtractor;
import compserver.prunning.Theorem;
import compserver.prunning.Variable;
import compserver.prunning.operators.Operator;

/**
 * Instances of this class have the functionality of parsing the axiomatic definitions
 */

public class SynonymsLoader {

	public static List<Variable> extractSynonymsParams(String line)
	{
		List<Variable> params = new ArrayList<Variable>();
		//String theoremName = line.substring(line.indexOf("@")+1, line.indexOf('~'));
		line = line.substring(line.indexOf("\\forall")+7, line.indexOf('@'));
		String types[] = line.split(";");
		String auxType;
		
		//if (theoremName != null) { //La agregamos como variable especial
		//	params.add(new Variable(theoremName, "generic"));
		//}
		
		for(int i=0;i<types.length;i++)
		{
			auxType = types[i];
			String parts[] = auxType.split(":",2);
			String varNames[] = parts[0].split(",");
			String type = parts[1].trim();
			for(int j=0;j<varNames.length;j++)
			{
				String name = varNames[j].trim();
				Variable var;
				if(name.startsWith("\\const")){
					name = name.substring(7);
					var = new Variable(name, "\\const "+type);
				}
				else
					var = new Variable(name, type);
				params.add(var);
			}
		}
		return params;
	}

	public static void loadSynonyms(Pred pred) {
		if (pred == null) {
			return;
		}
		AbstractRepository<Pred> predClauses = pred.accept(new AndPredClausesExtractor());
		AbstractIterator<Pred> predClausesIt = predClauses.createIterator();
		while (predClausesIt.hasNext()) {
			Pred auxPred = predClausesIt.next();
			if (auxPred instanceof ForallPred) { //Axiomatic definitions with forall (Synonyms)
				ForallPred forAllPred = (ForallPred) auxPred;


				//System.out.println("Cargandooooo " + SpecUtils.termToLatex(forAllPred));
				Theorem theorem = new Theorem();
				String synonym = SpecUtils.termToLatex(forAllPred);
				String theoremName = extractSynonymName(synonym).trim();
				ZDeclList zDeclList = extractTheoremDeclList(synonym);
				List<Variable> formalParamList = SynonymsLoader.extractSynonymsParams(synonym);
				String predicatesToMatch = SynonymsLoader.extractPredicates(synonym);
				List<List<List<String>>> reservedWords = extractReservedWords(predicatesToMatch);
				List<Map<Integer,String>> mapGroups = new ArrayList<Map<Integer,String>>();
				List<List<Pattern>> patterns = createRegExpr(predicatesToMatch, formalParamList, mapGroups);

				theorem.setFormalParamList(formalParamList);
				theorem.setPredicatesToMatch(predicatesToMatch);
				theorem.setReservedWords(reservedWords);
				theorem.setVarRegExGroups(mapGroups);
				theorem.setName(theoremName);
				theorem.setZDeclList(zDeclList);
				theorem.setRegEx(patterns);
				//theorem.setDefinition(auxDefinition);
				SynonymsControl.getInstance().addElement(theorem);
			}
		}
	}

	private static String extractSynonymName(String line) {
		int beginIndex = line.indexOf("@");
		int endIndex = line.indexOf('~');
		String SynonymName;
		if ((beginIndex != -1) && (endIndex != -1)) {
			SynonymName = line.substring(beginIndex+1, endIndex);
		}
		else {
			int random = (int)(Math.random()*1000000);
			SynonymName = "Synonym" + random;
		}
		return SynonymName;
	}

	private static String extractPredicates(String line) {
		String predicates = new String();
		predicates = line.substring(line.indexOf('@')+1, line.indexOf('='));
		return predicates;
	}

	private static List<List<List<String>>> extractReservedWords(String predicate)
	{
		List<List<List<String>>> reservedsList = new ArrayList<List<List<String>>>();
		String[] lines = predicate.split("\r\n|\r|\n");
		for(int i=0; i<lines.length;i++){
			String line = lines[i].trim();
			if(!line.contains("\\eval")){

				List<List<String>> alternatives = new ArrayList<List<String>>();

				String[] subLine = line.split(";");
				for(int x=0;x<subLine.length;x++){
					List<String> subList = new ArrayList<String>(); 
					Set<String> reservedSet = new HashSet<String>();
					String[] parts = subLine[x].split(" ");
					for(int j=0;j<parts.length;j++)
						// We analyze expressions that starts with a "\"
						if(parts[j].startsWith("\\")){
							// We check if the string is a Fastest's operator
							boolean special = false;
							boolean empty = false;
							if(parts[j].equals("\\{")){
								if(parts[j+1].equals("\\}")){
									empty = true;
									reservedSet.add(parts[j]+" "+parts[j+1]);
									j++;
								}
							} // We check if the string is the empty sequence
							else if(parts[j].equals("\\langle")){
								if(parts[j+1].equals("\\rangle")){
									empty = true;
									reservedSet.add(parts[j]+" "+parts[j+1]);
									j++;
								}
							}
							else if(!special && !parts[j].equals("\\}") && !parts[j].equals("\\rangle"))
								reservedSet.add(parts[j]);
						}
						else if(parts[j].matches("\\+|\\-|\\*|=|>|<"))
							reservedSet.add(parts[j]);

					subList.addAll(reservedSet);
					alternatives.add(subList);
				}
				reservedsList.add(alternatives);
			}
		}
		return reservedsList;
	}

	private static List<List<Pattern>> createRegExpr(String originalPred, List<Variable> vars, List<Map<Integer,String>> mapGroups)
	{
		List<List<Pattern>> patterns = new ArrayList<List<Pattern>>();
		String[] predLines = originalPred.split("\n");
		List<String> lines = new ArrayList<String>();
		for(int i=0;i<predLines.length;i++)
			lines.add(predLines[i]);

		for(int i=0;i<lines.size();i++){
			Map<Integer,String> groups = new HashMap<Integer,String>();
			String newPred = lines.get(i);
			for(int j=0;j<vars.size();j++){
				String name = vars.get(j).getName();
				Pattern regex = RegExUtils.createVarRegEx(name);
				Matcher matcher = regex.matcher(newPred);
				while(matcher.find()){
					String pattern = matcher.group();
					String newPattern = pattern.replaceAll(name, "([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))");
					newPred = newPred.replaceAll(pattern, newPattern);
				}
			}

			newPred = RegExUtils.addEscapeCharacters(newPred);
			String[] parts = newPred.split(";");
			String auxPred = "";
			for(int x=0;x<parts.length-1;x++){
				/*auxPred+="^[ ]*"+parts[x]+"[ ]*$|";*/auxPred+=parts[x].trim()+"|";
			}
			///*auxPred+="^(.*)"+parts[parts.length-1]+"(.*)$";*/auxPred+=parts[parts.length-1].trim();
			auxPred+="jacinto~([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))~([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))";
			if(auxPred.contains("~")){
			//	auxPred = auxPred.replace("~","(~?)");
			}
			if(auxPred.contains("(.*)~(.*)")){
				//auxPred = auxPred.replace("(.*)~(.*)","([^ (]+.*)~(.*[^ )]+)");

			}
			else if(auxPred.contains("(.+)~(.+)")){
				//auxPred = auxPred.replace("(.+)~(.+)","([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))~([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))");
			}
			else if(auxPred.contains("(.+)~.*")){
				//auxPred = auxPred.replace("(.+)~.*","([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))~(?:[^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))");
			}
			String[] auxPatterns = auxPred.split("\\|");
			String aux = lines.get(i);
			String[] partsAux = aux.split(";");
			int groupCount=0;
			List<Pattern> singlePattern = new ArrayList<Pattern>();
			for(int j=0;j<partsAux.length;j++){

				partsAux[j] = partsAux[j].replaceAll("\\\\sw\\( (.*) \\)", "$1");
				partsAux[j] = partsAux[j].replaceAll("\\\\se\\( (.*) \\)", "\\\\{ $1 \\\\}");

				auxPatterns[j] = auxPatterns[j].replace("\t","|");
				Pattern auxRegex = Pattern.compile(auxPatterns[j],Pattern.MULTILINE);
				Matcher auxMatcher = auxRegex.matcher(partsAux[j]);
				while(auxMatcher.find()){
					for(int x=1;x<auxMatcher.groupCount()+1;x++){
						if(auxMatcher.group(x)!=null && auxMatcher.group(x)!=""){
							groups.put(new Integer(x+groupCount), auxMatcher.group(x));
						}
					}
				}
				groupCount+=auxMatcher.groupCount();
				singlePattern.add(auxRegex);
			}

			mapGroups.add(groups);
			patterns.add(singlePattern);
		}
		return patterns;
	}
	
	private static ZDeclList extractTheoremDeclList(String line)
	{
		List<String> nonReserved = new ArrayList<String>();
		List<String> declarations = new ArrayList<String>();
		line = line.substring(line.indexOf("\\forall")+7, line.indexOf('@'));
		String types[] = line.split(";");
		String auxType;
		for(int i=0;i<types.length;i++)
		{
			auxType = types[i];
			String parts[] = auxType.split(":",2);
			String varNames[] = parts[0].split(",");
			String type = parts[1].trim();
			extractNonReservedWords(type, nonReserved);
			for(int j=0;j<varNames.length;j++)
			{
				String name = varNames[j].trim();
				if(name.startsWith("\\const")){
					name = name.substring(7);
					declarations.add(name+": "+"CONST"+type);
				}
				else
					declarations.add(name+": "+type);
			}
		}
		int random = (int)(Math.random()*1000000);
		String defTheorem = "\\begin{schema}{NAME"+random+"}[";	
		for(int i=0;i<nonReserved.size()-1;i++){
			defTheorem=defTheorem+nonReserved.get(i)+", ";
		}
		if(nonReserved.size()>0)
			defTheorem=defTheorem+nonReserved.get(nonReserved.size()-1)+"]";
		else
			defTheorem=defTheorem+"X]";
		for(int i=0;i<declarations.size()-1;i++){
			defTheorem=defTheorem+declarations.get(i)+" \\\\ ";
		}
		defTheorem=defTheorem+declarations.get(declarations.size()-1)+" \\end{schema}";

		Term parsedTerm = null;
		try{
			ZLive zLive = UniqueZLive.getInstance();
			parsedTerm = ParseUtils.parse(new StringSource(defTheorem), zLive.getSectionManager());
		}
		catch(Exception e){
			System.out.println("Exception");
			e.printStackTrace();
			System.out.println(defTheorem);
		}
		//System.out.println("Parseado:\n"+SpecUtils.termToLatex((Spec)parsedTerm));
		Spec spec = (Spec) parsedTerm;
		AxPara axPara = null;
		for (Sect sect : spec.getSect()) {
			if (sect instanceof ZSect) {
				ParaList paraList = ((ZSect) sect).getParaList();
				if (paraList instanceof ZParaList) {
					for(int i=0; i < ((ZParaList)paraList).size(); i++){
						Para para = ((ZParaList)paraList).get(i);
						if (para instanceof AxPara){
							axPara = (AxPara) para;
						}
					}
				}
			}
		}
		DeclList declList = SpecUtils.getAxParaListOfDecl(axPara);
		ZDeclList zDeclList = null;
		if(declList instanceof ZDeclList)
			zDeclList = (ZDeclList) declList;
		return zDeclList;
	}
	
	private static void extractNonReservedWords(String type, List<String> nonReserved)
	{
		String[] parts = type.split(" ");
		for(int i=0;i<parts.length;i++)
			if(!parts[i].startsWith("\\") && !nonReserved.contains(parts[i]))
				nonReserved.add(parts[i]);
	}

}

package compserver.axdef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.ForallPred;
import net.sourceforge.czt.z.ast.MemPred;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.ast.SetExpr;
import net.sourceforge.czt.z.ast.ZExprList;
import common.regex.RegExUtils;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.SpecUtils;
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
		//line = line.substring(line.lastIndexOf('{')+1,line.lastIndexOf('}'));
		line = line.substring(line.indexOf("\\forall")+7, line.indexOf('@'));
		String types[] = line.split(";");
		String auxType;
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
            	Theorem theorem = new Theorem();
            	
            	System.out.println("Cargandooooo " + SpecUtils.termToLatex(forAllPred));
            	String synonym = SpecUtils.termToLatex(forAllPred);
            	List<Variable> formalParamList = SynonymsLoader.extractSynonymsParams(synonym);
            	
            	//List<Map<Integer,String>> mapGroups = new ArrayList<Map<Integer,String>>();
        		//List<List<Pattern>> patterns = createRegExpr(auxPred, formalParamList, mapGroups);
            	
            	//theorem.setVarRegExGroups(mapGroups);
        		//theorem.setReservedWords(reservedWords);
        		//theorem.setDefinition(auxDefinition);
        		//theorem.setPredicatesToMatch(auxPredicate);
                //theorem.setName(theoremName);
                theorem.setFormalParamList(formalParamList);
        		//theorem.setZDeclList(zDeclList);
        		//theorem.setRegEx(patterns);
        		SynonymsControl.getInstance().addElement(theorem);
            }
        }
	}
	
	/*private List<List<Pattern>> createRegExpr(String originalPred, List<Variable> vars, List<Map<Integer,String>> mapGroups)
	{
		//List<Pattern> patterns = new ArrayList<Pattern>();
		List<List<Pattern>> patterns = new ArrayList<List<Pattern>>();
		String[] predLines = originalPred.split("\n");
		List<String> lines = new ArrayList<String>();
		for(int i=0;i<predLines.length;i++)
			lines.add(predLines[i]);

		for(int i=0;i<lines.size();i++){
			Map<Integer,String> groups = new HashMap<Integer,String>();
			String newPred = lines.get(i);
			//System.out.println("Predicado original:\n"+newPred);
			for(int j=0;j<vars.size();j++){
			String name = vars.get(j).getName();
			Pattern regex = RegExUtils.createVarRegEx(name);
			Matcher matcher = regex.matcher(newPred);
			while(matcher.find()){
				String pattern = matcher.group();
				String newPattern = pattern.replaceAll(name, "(.+)");
				newPred = newPred.replaceAll(pattern, newPattern);
			}
			}

			for(int x=0; x<operatorsList.size(); x++)
				if(newPred.indexOf(operatorsList.get(x))>-1){
					String operator = operatorsList.get(x);
					operator = operator.substring(1,2).toUpperCase()+operator.substring(2);
					try{
					Class operatorClass = Class.forName("compserver.prunning.operators." + operator + "Operator");
					Object object = operatorClass.newInstance();
					if (object instanceof Operator){
					Operator op = (Operator) object;
					//System.out.println("newPred antes: "+newPred);
					newPred = op.addSemantic(newPred);
					//System.out.println("newPred despues: "+newPred);
					}

					}
					catch(Exception e){
						System.out.println("Exception in ops");
					}
				}

			newPred = RegExUtils.addEscapeCharacters(newPred);
			//System.out.println("Despues newPred:\n"+newPred);
			String[] parts = newPred.split(";");
			String auxPred = "";
			for(int x=0;x<parts.length-1;x++){
				auxPred+="^[ ]*"+parts[x]+"[ ]*$|";
			}
			auxPred+="^[ ]*"+parts[parts.length-1]+"[ ]*$";
			if(auxPred.contains("(.*)~(.*)")){
				auxPred = auxPred.replace("(.*)~(.*)","([^ (]+.*)~(.*[^ )]+)");

			}
			else if(auxPred.contains("(.+)~(.+)")){
				//auxPred = auxPred.replace("(.+)~(.+)","([^ ]+)~([^ ]+)");
				auxPred = auxPred.replace("(.+)~(.+)","([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))~([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))");
				//"([^ ]+|(?:[(][^()]*[)])|(?:[(](?:[^ ]+|(?:[(][^()]*[)]))[)]))"

				//auxPred = auxPred.replace("(.+)~(.+)","([^ ]+)~([^ ]+)");
			}
			else if(auxPred.contains("(.+)~.*")){
				auxPred = auxPred.replace("(.+)~.*","([^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))~(?:[^ ]+\t(?:[(][^()]*[)])\t(?:[(](?:[^ ]+\t(?:[(][^()]*[)]))[)]))");
			}
			//System.out.println("El auxPred:\n"+auxPred);
			String[] auxPatterns = auxPred.split("\\|");
			//System.out.println("El tamaño es: "+auxPatterns.length);
			//Pattern regex = Pattern.compile(auxPred,Pattern.MULTILINE);
			//System.out.println("PAtron:\n"+regex);
			String aux = lines.get(i);
			//aux = aux.replaceAll("\\\\sw\\( (.*) \\)", "$1");
			//aux = aux.replaceAll("\\\\se\\( (.*) \\)", "\\\\{ $1 \\\\}");
			String[] partsAux = aux.split(";");
			int groupCount=0;
			List<Pattern> singlePattern = new ArrayList<Pattern>();
			for(int j=0;j<partsAux.length;j++){


			partsAux[j] = partsAux[j].replaceAll("\\\\sw\\( (.*) \\)", "$1");
			partsAux[j] = partsAux[j].replaceAll("\\\\se\\( (.*) \\)", "\\\\{ $1 \\\\}");



				auxPatterns[j] = auxPatterns[j].replace("\t","|");
				//System.out.println("El patron:\n"+auxPatterns[j]);
				Pattern auxRegex = Pattern.compile(auxPatterns[j],Pattern.MULTILINE);
				Matcher auxMatcher = auxRegex.matcher(partsAux[j]);
				while(auxMatcher.find()){
				for(int x=1;x<auxMatcher.groupCount()+1;x++){
					if(auxMatcher.group(x)!=null && auxMatcher.group(x)!=""){
						//System.out.println("Grupo "+(x+groupCount)+": "+auxMatcher.group(x));
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
	}*/
	
}

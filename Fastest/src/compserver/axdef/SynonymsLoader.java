package compserver.axdef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
				String predicatesToMatch = SynonymsLoader.extractPredicates(synonym);
				List<List<List<String>>> reservedWords = extractReservedWords(predicatesToMatch);
				
				//List<Map<Integer,String>> mapGroups = new ArrayList<Map<Integer,String>>();
				//List<List<Pattern>> patterns = createRegExpr(auxPred, formalParamList, mapGroups);

				theorem.setFormalParamList(formalParamList);
				theorem.setPredicatesToMatch(predicatesToMatch);
				theorem.setReservedWords(reservedWords);
				//theorem.setVarRegExGroups(mapGroups);
				//theorem.setDefinition(auxDefinition);
				theorem.setName("SynonymoDePrueba");
				//theorem.setZDeclList(zDeclList);
				//theorem.setRegEx(patterns);
				SynonymsControl.getInstance().addElement(theorem);
			}
		}
	}

	private static String extractPredicates(String line) {
		String predicates = new String();
		predicates = line.substring(line.indexOf('@')+1, line.indexOf('='));
		return predicates;
	}

	private static List<List<List<String>>> extractReservedWords(String predicate)
	{
		//List<String> reservado = new ArrayList<String>();
		//Set<String> reserved = new HashSet<String>();
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
							//for(int k=0; k<operatorsList.size() && !special; k++)
							//	if(parts[j].contains(operatorsList.get(k)))
							//		special =true;
							// We check if the string is the empty set
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
}

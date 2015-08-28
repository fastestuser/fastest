package client.blogic.testing.ttree.strategies.ftsdl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.strategies.ftsdl.Values.NodeValue;
import client.blogic.testing.ttree.strategies.ftsdl.Values.TClassNodeValue;
import client.blogic.testing.ttree.visitors.TClassNodeLeavesFinder;
import common.fastest.FastestUtils;
import common.repository.AbstractIterator;
import common.repository.AbstractRepository;
import common.z.SpecUtils;
import common.z.czt.visitors.AtomicPredExtractor;
import common.z.czt.visitors.FreeTypeVarsExtractor;
import common.z.czt.visitors.ISEExpressionExtractor;
import common.z.czt.visitors.NumVarsExtractor;
import net.sourceforge.czt.base.ast.Term;
import net.sourceforge.czt.util.Visitor;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.DeclList;

public final class FTSDLUtils {

	public static NodeValue getSPExpressions(List<NodeValue> args, Controller c)
	{	
		// TODO: eliminar casos que usen variables primadas o de salida.
		LinkedList<NodeValue> exps = new LinkedList<NodeValue>();

		// Get the SP expressions in the node.
		if ((args.size() == 1) && (args.get(0) instanceof TClassNodeValue))
		{
			AxPara axPara = ((TClassNodeValue) args.get(0)).getAxPara();
			
			List<String> usedExprs = new LinkedList<String>();

			Visitor<Map<Term, String>> searcher = new AtomicPredExtractor();
			Map<Term, String> expressions;
			expressions = axPara.accept(searcher);

			// Create a list with the expressions and operators that are used.
			Iterator<Term> expressionsIt = expressions.keySet().iterator();
			while (expressionsIt.hasNext())
			{
				Term exp = expressionsIt.next();
				String expString = SpecUtils.termToLatex(exp);

				//Avoid the repetition of expressions.
				if (!usedExprs.contains(SpecUtils.termToLatex(exp)))
				{
					usedExprs.add(expString);
					
					// Create a SPTerm with the expression and the operator.
					SPTerm sp = new SPTerm(expressions.get(exp), expString);
					exps.add(new NodeValue(sp));
				}
			}
			return new NodeValue(exps);
		}
		else
		{
			return new NodeValue(-1);
		}
	}
	
	public static NodeValue getNRVariables(List<NodeValue> args, Controller c)
	{
		//System.out.println("ENTER getNR");
		LinkedList<NodeValue> exps = new LinkedList<NodeValue>();

		// Get the NR expressions in the node.
		if ((args.size() == 1) && (args.get(0) instanceof TClassNodeValue))
		{
			TTreeNode node = ((TClassNodeValue)args.get(0)).getValue();

			DeclList declList = SpecUtils.getAxParaListOfDecl(node.getValue().getMyAxPara());
			Map<Term, String> numVars = declList.accept(new NumVarsExtractor());
			
			// Create a list with the variables found.
			Iterator<Term> numVarsIt = numVars.keySet().iterator();
			while (numVarsIt.hasNext())
			{
				Term numVar = numVarsIt.next();
				String numVarString = SpecUtils.termToLatex(numVar);
				String zType = numVars.get(numVar);

				// Create a NR with the var.
				NRTerm nr = new NRTerm(numVarString, zType);
				exps.add(new NodeValue(nr));
			}
			return new NodeValue(exps);
		}
		else
		{
			return new NodeValue(-1);
		}
	}
	
	public static NodeValue getFTVariables(List<NodeValue> args, Controller c)
	{
		LinkedList<NodeValue> exps = new LinkedList<NodeValue>();

		// Get the FT expressions in the node.
		if ((args.size() == 1) && (args.get(0) instanceof TClassNodeValue))
		{
			TTreeNode node = ((TClassNodeValue)args.get(0)).getValue();

			DeclList declList = SpecUtils.getAxParaListOfDecl(node.getValue().getMyAxPara());
			Map<Term, String> ftVars = declList.accept(new FreeTypeVarsExtractor(c));
			
			// Create a list with the variables found.
			Iterator<Term> ftVarsIt = ftVars.keySet().iterator();
			while (ftVarsIt.hasNext())
			{
				Term ftVar = ftVarsIt.next();
				String ftVarString = SpecUtils.termToLatex(ftVar);

				// Create a FT with the var.
				FTTerm ft = new FTTerm(ftVarString);
				exps.add(new NodeValue(ft));
			}
			return new NodeValue(exps);
		}
		else
		{
			return new NodeValue(-1);
		}
	}
	
	public static NodeValue getISEExpressions(List<NodeValue> args, Controller c)
	{	
		LinkedList<NodeValue> exps = new LinkedList<NodeValue>();

		// Get the SP expressions in the node.
		if ((args.size() == 1) && (args.get(0) instanceof TClassNodeValue))
		{
			AxPara axPara = ((TClassNodeValue) args.get(0)).getAxPara();
			
			List<String> usedExprs = new LinkedList<String>();

			Visitor<Map<Term, String>> searcher = new ISEExpressionExtractor();
			Map<Term, String> expressions = axPara.accept(searcher);

			// Create a list with the expressions and operators that are used.
			Iterator<Term> expressionsIt = expressions.keySet().iterator();
			while (expressionsIt.hasNext())
			{
				Term exp = expressionsIt.next();
				String expString = SpecUtils.termToLatex(exp);

				// Avoid the repetition of expressions.
				if (!usedExprs.contains(SpecUtils.termToLatex(exp)))
				{
					usedExprs.add(expString);
					
					// Create an ISETerm with the expression.
					ISETerm ise = new ISETerm(expString);
					exps.add(new NodeValue(ise));
				}
			}
			return new NodeValue(exps);
		}
		else
		{
			return new NodeValue(-1);
		}
	}
	
	public static NodeValue treeRoot(List<NodeValue> args, Controller c)
	{
		if ((args.size() == 1) && (args.get(0) instanceof TClassNodeValue))
		{
			TClassNode node = ((TClassNodeValue)args.get(0)).getValue();
			while(node.getDadNode() != null)
			{
				node = node.getDadNode();
			}

			return new TClassNodeValue(node, c);
		}
		return new NodeValue(-1);
	}

	public static NodeValue leaves(List<NodeValue> args, Controller c)
	{
		if ((args.size() == 1) && (args.get(0) instanceof TClassNodeValue))
		{
			TTreeNode n = ((TClassNodeValue)args.get(0)).getValue();
			List<NodeValue> l = new LinkedList<NodeValue>();

			Map<String, TClassNode> opTTreeMap = c.getOpTTreeMap();
			// OpName.
			String opName = FastestUtils.getOpAssociated(c, SpecUtils.getAxParaName(n.getValue().getMyAxPara()));

			TClassNode tClassRoot = opTTreeMap.get(opName);
			AbstractRepository<TClassNode> leaves = tClassRoot.acceptVisitor(new TClassNodeLeavesFinder());
			
			// Create a list with the leaves.
			AbstractIterator<TClassNode> it = leaves.createIterator();
			while (it.hasNext())
			{
				l.add(new TClassNodeValue(it.next(), c));
			}

			return new NodeValue(l);
		}
		return new NodeValue(-1);
	}

	// Returns the operator of a SPTerm
	public static NodeValue op(List<NodeValue> args, Controller c)
	{
		if ((args.size() == 1) && (args.get(0).getValue() instanceof SPTerm))
		{
			String op = ((SPTerm) args.get(0).getValue()).getOp();
			
			return new NodeValue(op);
		} 
		else 
		{
			return new NodeValue(-1);
		}
	}
	
	// Returns the ran of a NRTerm.
	public static NodeValue ran(List<NodeValue> args, Controller c)
	{
		if ((args.size() == 1) && (args.get(0).getValue() instanceof NRTerm))
		{
			String ran = ((NRTerm) args.get(0).getValue()).getRan();
			
			return new NodeValue(ran);
		} 
		else 
		{
			return new NodeValue(-1);
		}
	}

	public NodeValue in(NodeValue a, NodeValue b, Controller controller)
	{
		//TODO: Reordenar movinendo los diferentes casos a las diferentes clases XTerm.
		
		// If it's a SPTerm, check that the expression is in the node.
		// TODO: Falta hacer el caso de la precondicion? o se soluciona al usar la operacion de la especificacion?
		if (a.getValue() instanceof SPTerm)
		{
			String exp = ((SPTerm) a.getValue()).getExp();
			String schema = SpecUtils.termToLatex(((TClassNodeValue) b).getAxPara());
			
			return new NodeValue(schema.contains(exp));
		}
		
		// If it's a NRTerm, check that the variable is in the node.
		if (a.getValue() instanceof NRTerm)
		{
			String exp = ((NRTerm) a.getValue()).getExp();
			String schema = SpecUtils.termToLatex(((TClassNodeValue) b).getAxPara());
			NodeValue r = new NodeValue(schema.contains(exp));
			return r;
		}
		
		// If it's a FTTerm, check that the variable is in the node.
		if (a.getValue() instanceof FTTerm)
		{
			String exp = ((FTTerm) a.getValue()).getExp();
			String schema = SpecUtils.termToLatex(((TClassNodeValue) b).getAxPara());
			
			return new NodeValue(schema.contains(exp));
		}
		
		// If it's a ISETerm, check that the expression is in the node.
		if (a.getValue() instanceof ISETerm)
		{
			String exp = ((ISETerm) a.getValue()).getExp();
			String schema = SpecUtils.termToLatex(((TClassNodeValue) b).getAxPara());
			
			return new NodeValue(schema.contains(exp));
		}
		
		return new NodeValue(false);
	}
}
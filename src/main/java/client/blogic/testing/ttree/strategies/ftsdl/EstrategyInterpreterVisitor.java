package client.blogic.testing.ttree.strategies.ftsdl;

import java.lang.reflect.Method;
import java.util.*;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.TClassNode;
import client.blogic.testing.ttree.TTreeNode;
import client.blogic.testing.ttree.strategies.ftsdl.FTSDLParser.ExpressionContext;
import client.blogic.testing.ttree.strategies.ftsdl.FTSDLParser.StatementContext;
import client.blogic.testing.ttree.strategies.ftsdl.FTSDLParser.StrategyContext;
import client.blogic.testing.ttree.strategies.ftsdl.Values.NodeValue;
import client.blogic.testing.ttree.strategies.ftsdl.Values.TClassNodeValue;
import client.presentation.ClientTextUI;
import client.presentation.commands.AddTacticCommand;
import client.presentation.commands.GenAllTTCommand;
import client.presentation.commands.PruneTreeCommand;
import common.fastest.FastestUtils;
import java.util.Collection;
import common.z.SpecUtils;
import common.z.czt.visitors.SchemeUnfolder;
import net.sourceforge.czt.z.ast.AxPara;
import net.sourceforge.czt.z.ast.ParaList;
import net.sourceforge.czt.z.ast.Sect;
import net.sourceforge.czt.z.ast.Spec;
import net.sourceforge.czt.z.ast.ZParaList;
import net.sourceforge.czt.z.ast.ZSect;


public class EstrategyInterpreterVisitor extends FTSDLBaseVisitor<NodeValue>
{

	private TClassNodeValue OP = null;
	private String OPName = "";
	private int TI = 1;
	private int APPLIED = 0;
	private HashMap<String,StrategyContext> strategies = new HashMap<String, FTSDLParser.StrategyContext>();
	private HashMap<String,NodeValue> varsValues = new HashMap<String,NodeValue>();
	private ClientTextUI clientTextUI;

	public EstrategyInterpreterVisitor(HashMap<String,StrategyContext> strategies, String op, int ti, ClientTextUI clientTextUI)
	{
		this.OPName = op;
		this.TI = ti;
		this.strategies = strategies;
		this.clientTextUI = clientTextUI;
	}

	@Override
	public NodeValue visitStrategy(FTSDLParser.StrategyContext ctx)
	{
		return this.visitStatementBlock(ctx.statementBlock());
	}

	@Override
	public NodeValue visitStatement(FTSDLParser.StatementContext ctx)
	{
		if (ctx.getText().startsWith("exit"))
		{
			return new NodeValue(-1);
		}
		else
		{
			return this.visit(ctx.getChild(0));
		}
	}

	@Override
	public NodeValue visitStatementBlock(FTSDLParser.StatementBlockContext ctx)
	{
		Iterator<StatementContext> it = ctx.statement().iterator();
		NodeValue v = new NodeValue(0);

		boolean ended = false;
		while(it.hasNext() && (!ended))
		{
			v = this.visit(it.next());
			if (strategyEnded(v))
			{
				ended = true;
			}
		}

		return v;
	}

	@Override
	public NodeValue visitIfStatement(FTSDLParser.IfStatementContext ctx)
	{
		NodeValue exp = this.visit(ctx.expression());
		if (exp.isBoolean() && exp.asBoolean())
		{
			return this.visit(ctx.statementBlock(0));
		}
		else if (ctx.statementBlock().size() > 1)
		{
			return this.visit(ctx.statementBlock(1));
		}
		return null;
	}

	@Override
	public NodeValue visitForeachStatement(FTSDLParser.ForeachStatementContext ctx)
	{
		// We visit each element of the list that we find in "expression".
		// And in each iteration we store the value of "IDENTIFIER".
		NodeValue exp = this.visit(ctx.expression());
		List<NodeValue> expList = ((List<NodeValue>) exp.getValue());
		Iterator<NodeValue> expIt = expList.iterator();
		// Create the var.
		String itVarName = ctx.IDENTIFIER().getText();
		// The value.
		NodeValue v = new NodeValue(0);
		// And the var that indicates if the strategy should end.
		boolean ended = false;

		// Iterate the foreach.
		while ((expIt.hasNext()) && (!ended))
		{
			// Set the value of the var and we store it in varsValues.
			varsValues.put(itVarName, expIt.next());
			// Make the execution.
			v = this.visit(ctx.statementBlock());
			if (strategyEnded(v))
			{
				ended = true;
			}
		}

		// Before exiting we delete the var.
		varsValues.remove(itVarName);
		
		return v;
	}

	@Override
	public NodeValue visitExpression(FTSDLParser.ExpressionContext ctx)
	{
		// TI.
		if (ctx.getText().equals("TI"))
		{
			return new NodeValue(TI);
		}
		// OP.
		else if (ctx.getText().equals("OP"))
		{
			Controller controller = clientTextUI.getMyController();
			
			// The first time this is used, we search for the node.
			// If its an operation, we have to use the VIS, and if its a test class, we have to use that one.
			if (OP == null)
			{				
				boolean isOp = FastestUtils.isLoadedOperation(controller, OPName);
				
				if (isOp)
				{
					// Old part that uses the VIS of an operation.
					Map<String, TClassNode> opTTreeMap = controller.getOpTTreeMap();
	                TClassNode tClassRoot = opTTreeMap.get(OPName);
	                
	                if (tClassRoot == null)
	                {
	                    System.out.println("No test classes found for '" + OPName + "'.");
	                    return new NodeValue(-1);
	                }
	                else
	                {
	                	// Since this is an operation, we need to store the complete definition
	                	// to be used when searching for expressions to apply tactics.
	                	//OP = new TClassNodeValue(tClassRoot, controller);
	                	
	                	// Generate the unfolded AxPara.
	                	Spec spec = controller.getUnfoldedSpec();
						Collection<String> opNames = controller.getOpsToTestRep();
						Collection<String> schPredNames = controller.getSchemaPredicatesRep();
						spec = (Spec) spec.accept(new SchemeUnfolder(opNames,schPredNames));

						AxPara axPara = null;
						for (Sect sect : spec.getSect())
						{
							if (sect instanceof ZSect)
							{
								ParaList paraList = ((ZSect) sect).getParaList();
								if (paraList instanceof ZParaList)
								{
									axPara = SpecUtils.axParaSearch(OPName, (ZParaList) paraList);
								}
							}
						}
	                	
						OP = new TClassNodeValue(tClassRoot, controller, axPara);
	                }					
				}
				else
				{
					TTreeNode tClassNode = FastestUtils.getTTreeNode(controller, OPName);
					if (tClassNode == null)
					{
						System.out.println("'" + OPName + "' is not the name of an operation nor a test class.");
	                    return new NodeValue(-1);
					}
					else
					{
						OP = new TClassNodeValue((TClassNode) tClassNode, controller);
					}
				}
			}
			
			return OP;	

		// APPLIED.
		} 
		else if (ctx.getText().equals("APPLIED"))
		{
			return new NodeValue(APPLIED);
		}
		// Testing Operators.
		else if (ctx.TestingOP()!=null)
		{
			String op = ctx.TestingOP().getText();
			if (op.equals("=="))
			{
				NodeValue a = this.visit(ctx.expression(0));
				NodeValue b = this.visit(ctx.expression(1));
				return new NodeValue(a.asInteger() == b.asInteger());
			}
			if (op.equals(">"))
			{
				NodeValue a = this.visit(ctx.expression(0));
				NodeValue b = this.visit(ctx.expression(1));
				return new NodeValue(a.asInteger() > b.asInteger());
			}
			else if (op.equals("IN"))
			{
				NodeValue a = this.visit(ctx.expression(0));
				NodeValue b = this.visit(ctx.expression(1));
				return new FTSDLUtils().in(a,b,clientTextUI.getMyController());
			}

		}
		// Literal expression.
		else if (ctx.literalExpression() != null)
		{
			return this.visit(ctx.literalExpression());
		}
		// Function.
		else if (ctx.function() != null)
		{
			// Call the function with the arguments.
			// Function should be defined in FTSDUtils.
			String functionName = ctx.function().getText();
			
			// Visit and pass arguments.
			NodeValue args = new NodeValue(new LinkedList<NodeValue>());
			if (ctx.arglist()!=null)
			{
				args = new NodeValue(((List<NodeValue>) (this.visit(ctx.arglist())).getValue()));
			}
			
			// Invoke function.
			try
			{
				Class<?> c = Class.forName("client.blogic.testing.ttree.strategies.ftsdl.FTSDLUtils");
				Class[] paramTypes = new Class[2];
				paramTypes[0]=List.class;
				paramTypes[1]=Controller.class;
				Method method;
				method = c.getDeclaredMethod (functionName, paramTypes);
				return (NodeValue) method.invoke ("FTSDLUtils", ((List<NodeValue>)args.getValue()), clientTextUI.getMyController());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		// expression '.' expression.
		// TODO: Hay que mejorar este chequeo.
		else if ((ctx.expression().size()==2) && (ctx.getText().equals(ctx.expression(0).getText()+"."+ctx.expression(1).getText())))
		{
			// Like "function" but the name of the function is the second argument.
			// And the unique argument is the first one.
			String functionName = ctx.expression(1).getText();
			functionName = functionName.replaceAll("\\(\\)", "");
			
			// Visit and pass arguments.
			NodeValue arg = this.visit(ctx.expression(0));
			LinkedList<NodeValue> l = new LinkedList<NodeValue>();
			l.add(arg);
			NodeValue args = new NodeValue(l);
			
			// Invoke function.
			try 
			{
				Class<?> c = Class.forName("client.blogic.testing.ttree.strategies.ftsdl.FTSDLUtils");
				Class[] paramTypes = new Class[2];
				paramTypes[0]=List.class;
				paramTypes[1]=Controller.class;
				Method method;
				method = c.getDeclaredMethod (functionName, paramTypes);
				return (NodeValue) method.invoke ("FTSDLUtils", args.getValue(), clientTextUI.getMyController());
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return null;
		}
		// expression '-' expression.
		// TODO: Hay que mejorar este chequeo.
		else if ((ctx.expression().size()==2) && (ctx.getText().equals(ctx.expression(0).getText()+"-"+ctx.expression(1).getText())))
		{
			NodeValue a = this.visit(ctx.expression(0));
			NodeValue b = this.visit(ctx.expression(1));
			if (a.isInteger() && b.isInteger())
			{
				return new NodeValue(a.asInteger() - b.asInteger());
			}
			return null;
		}
		// expression '*' expression.
		// TODO: Hay que mejorar este chequeo.
		else if ((ctx.expression().size()==2) && (ctx.getText().equals(ctx.expression(0).getText()+"*"+ctx.expression(1).getText())))
		{
			NodeValue a = this.visit(ctx.expression(0));
			NodeValue b = this.visit(ctx.expression(1));
			if (a.isInteger() && b.isInteger())
			{
				return new NodeValue(a.asInteger() * b.asInteger());
			}
			return null;
		}
		// '(' expression ')'.
		// TODO: Hay que mejorar este chequeo.
		else if ((ctx.expression().size()==1) && (ctx.getText().equals("("+ctx.expression(0).getText()+")")))
		{
			return this.visit(ctx.expression(0));
		}

		// Generic case.
		return this.visit(ctx.getChild(0));
	}

	@Override
	public NodeValue visitArglist(FTSDLParser.ArglistContext ctx)
	{	
		LinkedList<NodeValue> l = new LinkedList<NodeValue>();
		
		Iterator<ExpressionContext> it = ctx.expression().iterator();
		while(it.hasNext())
		{
			l.add(this.visit(it.next()));
		}
		
		return new NodeValue(l);
	}
	
	@Override
	public NodeValue visitLiteralExpression(FTSDLParser.LiteralExpressionContext ctx)
	{
		if (ctx.INTEGER()!=null)
		{
			int i = Integer.parseInt(ctx.INTEGER().getText());
			return new NodeValue(i);
		} 
		else if (ctx.IDENTIFIER()!=null)
		{
			return varsValues.get(ctx.IDENTIFIER().getText());
		}
		
		return null;
	}

	@Override
	public NodeValue visitCommand(FTSDLParser.CommandContext ctx)
	{
		String command = ctx.getText();

		if (command.equals("genalltt"))
		{
			if (clientTextUI.getMyController().getftsdlPrint())
			{
				System.out.println("Command run: genalltt.");
			}
			
			GenAllTTCommand genalltt = new GenAllTTCommand();
			genalltt.run(clientTextUI, "");
		}
		else if (command.equals("prunett"))
		{
			if (clientTextUI.getMyController().getftsdlPrint())
			{
				System.out.println("Command run: prunett.");
			}
			
			PruneTreeCommand prunett = new PruneTreeCommand();
			prunett.run(clientTextUI, "");
		}
		else if (command.startsWith("addtactic"))
		{
			AddTacticCommand addtactic = new AddTacticCommand();
			String args = "";
			Iterator<ExpressionContext> it = ctx.expression().iterator();

			NodeValue v = this.visit(it.next());
			args += v.toString();
			args += " "+ctx.tactic().getText();
			while(it.hasNext())
			{
				v = this.visit(it.next());
				args += " "+v.toString();
			}
			
			addtactic.run(clientTextUI, args);
			
			if (clientTextUI.getMyController().getftsdlPrint())
			{
				System.out.println("Tactic addded: " + args);
			}
			
			APPLIED++;
		}
		else if (command.startsWith("applystrategy"))
		{
			Iterator<ExpressionContext> it = ctx.expression().iterator();
			String applyStrategyName = it.next().getText();
			NodeValue ti = this.visit(it.next());
			
			StrategyContext applyStrategyCtx = strategies.get(applyStrategyName);
			if (applyStrategyCtx!=null)
			{
				EstrategyInterpreterVisitor newVisitor = new EstrategyInterpreterVisitor(strategies, OPName, ti.asInteger(), clientTextUI);
				applyStrategyCtx.accept(newVisitor);

				// Actualize APPLIED.
				APPLIED += newVisitor.APPLIED;
				
				return new NodeValue(newVisitor.APPLIED);
			}
			else
			{
				System.out.println("Strategy "+applyStrategyName+" not defined.");
			}
			
			return new NodeValue(-1);
		}
		
		return null;
	}

	private boolean strategyEnded(NodeValue v)
	{
		if ((v != null) && v.isInteger() && v.asInteger() == -1)
		{
			return true;
		}
		
		return false;
	}
}

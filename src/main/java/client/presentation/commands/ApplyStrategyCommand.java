package client.presentation.commands;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import client.blogic.management.Controller;
import client.blogic.testing.ttree.strategies.ftsdl.EstrategyInterpreterVisitor;
import client.blogic.testing.ttree.strategies.ftsdl.EstrategyLoaderVisitor;
import client.blogic.testing.ttree.strategies.ftsdl.FTSDLLexer;
import client.blogic.testing.ttree.strategies.ftsdl.FTSDLParser;
import client.blogic.testing.ttree.strategies.ftsdl.FTSDLParser.StrategyContext;
import client.presentation.ClientTextUI;
import common.fastest.FastestUtils;

public class ApplyStrategyCommand implements Command
{
	/**
	 * Runs this command.
	 * @param clientTextUI
	 * @param args
	 */
	@Override
	public void run(ClientTextUI clientTextUI, String args)
	{
		PrintWriter output = clientTextUI.getOutput();
		try {
			// UnitToTestName is the name of an operation or the name of a previously
			// generated test class.
			String unitToTestName = "";
			
			// We make a little check of the parameters.
			if (args == null || "".equals(args)) 
			{
				output.println("Invalid parameters.  Try 'help'.");
				return;
			}

			String parts[] = args.split(" ", 0);
			if (parts.length < 2)
			{
				output.println("Invalid parameters.  Try 'help'.");
				return;
			}

			// We obtain the operation or test class name.
			unitToTestName = parts[1];
			Controller controller = clientTextUI.getMyController();

			// If it is an operation, the strategy will be applied to the VIS.
			// It it is a test class, it will be applied to that particular node.
			boolean isOp = FastestUtils.isLoadedOperation(controller, unitToTestName);
			if (!isOp)
			{
				String opName = FastestUtils.getOpAssociated(controller, unitToTestName);
				if (opName == null)
				{
					output.println("'" + unitToTestName + "' is not the name of a " + "loaded operation nor a test class.");
					return;
				}
			}

			// Determine if the strategy is a previously loaded strategy.
			String strategyName = parts[0];
			
			//TODO: Por ahora cargamos acá las estrategias desde el archivo estrategias.txt
			// Search the strategy and write it to a String.
			String fileName = "/conf/strategies.ftsdl";
			InputStream strategyInputStream = getClass().getResourceAsStream(fileName);
			String strategyString = new Scanner(strategyInputStream,"UTF-8").useDelimiter("\\A").next();
			
			// Parsing.
			ANTLRInputStream in = new ANTLRInputStream(strategyString);
			FTSDLLexer lexer = new FTSDLLexer(in);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			FTSDLParser parser = new FTSDLParser(tokens);
			ParseTree tree = parser.strategies();
			
			// Loading.
			EstrategyLoaderVisitor loader = new EstrategyLoaderVisitor();
			tree.accept(loader);
			HashMap<String, StrategyContext> strategies = loader.getStrategies();
			
			// Search the required strategy.
			StrategyContext strategy = strategies.get(strategyName);
			if (strategy==null)
			{
				System.out.println("Strategy "+strategyName+" not found in "+fileName+".");
				return;
			}
			// End loading.
			
			// Get testing intensity.
			int TI = 1;
			if (parts.length > 2)
			{
				TI = Integer.parseInt(parts[2]);
			}
			// Apply streategy.
			EstrategyInterpreterVisitor visitor = new EstrategyInterpreterVisitor(strategies, unitToTestName, TI, clientTextUI);
			strategy.accept(visitor);
			
		}
		catch (Exception e)
		{
			output.println("Error while trying to apply the strategy.");
		}
	}
}
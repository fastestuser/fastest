package client.presentation.commands;

import client.blogic.management.Controller;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.events.RunCTCFinished;
import client.blogic.management.ii.events.RunCTCRequested;
import client.blogic.testing.atcal.Abstraction;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.execution.Execution;
import client.presentation.ClientTextUI;
import com.google.common.collect.Maps;
import common.z.SpecUtils;
import common.z.czt.UniqueZLive;
import compserver.abstraction.capture.execution.CompilationInfo;
import net.sourceforge.czt.animation.eval.ZLive;
import net.sourceforge.czt.z.ast.Expr;
import net.sourceforge.czt.z.ast.Pred;
import net.sourceforge.czt.z.ast.RefExpr;
import net.sourceforge.czt.z.util.Factory;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class RunCTCCommand extends IIComponent implements Command {
    /**
     * Runs this command.
     *
     * @param clientTextUI
     * @param args
     */
    @Override
    public void run(ClientTextUI clientTextUI, String args) {
        try {
            Controller controller = clientTextUI.getMyController();
            // TODO: Support multiple test cases
            String parts[] = args.split("[ ]+", 2);
            String concreteTCaseName = parts[0];

            // look-up the concrete case by name
            ConcreteTCase concreteTCase = controller.getOpTCaseRefinedMap().get(concreteTCaseName);
            if (concreteTCase == null) {
                System.out.println(concreteTCaseName + " is not the name of a refined case");
                return;
            }

           // CompilationInfo compilationInfo = controller.getCompilationInfo();
            CompilationInfo compilationInfo = new CompilationInfo("", "", "", "", ".");
            if (compilationInfo == null) {
                System.out.println("The information of compilation has not been loaded.");
                System.out.println("You must set this information before try to run " + concreteTCaseName);
            }

            boolean someEventAnnounced = false;
            RunCTCRequested event = new RunCTCRequested(concreteTCase, compilationInfo, "");
            EventAdmin eventAdmin = EventAdmin.getInstance();
            eventAdmin.announceEvent(event);
            someEventAnnounced = true;

            if (someEventAnnounced)
                synchronized (clientTextUI) {
                    clientTextUI.wait();
                }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Manages an implicit invocation event with the result of concrete test case execution.
     * @param event
     * @throws IllegalArgumentException
     */
    public synchronized void manageEvent(Event_ event) throws IllegalArgumentException {
        if (event instanceof RunCTCFinished) {
            RunCTCFinished runCTCFinished = (RunCTCFinished)event;
            Execution execution = runCTCFinished.getExecution();

            // Parse the YAML output and abstract it back to a Z schema
            Yaml yaml = new Yaml();
            Map<String, Object> yamlData = (Map<String, Object>)yaml.load(execution.getYamlData());
            Abstraction abstraction = new Abstraction(runCTCFinished.getConcreteTCase());
            // Print the Z schema
            UniqueZLive.getInstance().printTerm(System.out, abstraction.toAxPara(yamlData));
        }
    }
}

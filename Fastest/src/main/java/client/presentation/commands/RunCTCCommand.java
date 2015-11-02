package client.presentation.commands;

import client.blogic.management.Controller;
import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.IIComponent;
import client.blogic.management.ii.events.Event_;
import client.blogic.management.ii.events.RunCTCFinished;
import client.blogic.management.ii.events.RunCTCRequested;
import client.blogic.testing.atcal.ConcreteTCase;
import client.blogic.testing.execution.Execution;
import client.presentation.ClientTextUI;
import compserver.abstraction.capture.execution.CompilationInfo;

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
            Execution execution = ((RunCTCFinished)event).getExecution();
            System.out.println(execution);

            // Parse the YAML output and abstract it back to a Z schema
            
        }
    }
}

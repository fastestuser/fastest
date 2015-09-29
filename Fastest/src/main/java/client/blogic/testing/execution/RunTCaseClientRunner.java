package client.blogic.testing.execution;

import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.RunCTCFinished;
import compserver.abstraction.capture.execution.CompilationInfo;

import java.io.File;

/**
 * Instances of this class has the responsibility of request, to a computation
 * server, for the running of a concrete case and abstract the output. Each request must
 * be done through a new instance of ServiceMediator, which is the only one that has the
 * knowledge about how the connection with the servers are implemented.
 */
public class RunTCaseClientRunner implements Runnable {

    /**
     * Creates new instances of TClassPruneClientRunner
     *
     * @param tClass
     */
    public RunTCaseClientRunner(String runCode, CompilationInfo compilationInfo) {
        this.compilationInfo = compilationInfo;
        this.runCode = runCode;
    }

    /**
     * Requests the running of a concrete test and the subsequent abstraction of
     * the output, either to the client itself or to a computation server.
     * After a response arrives, it announces a TCaseAbstracted event.
     */
    public void run() {
        // The code skips the server for now and runs the test locally.
        try {
            // Obtain the working directory
            String workingDirectory = compilationInfo.getWorkingDirectory();
            if (!workingDirectory.endsWith(File.separator))
                workingDirectory += File.separator;

            // Run the concrete test case
            Execution execution = Executor.execute(runCode, workingDirectory);

            // TODO: abstract the output


            EventAdmin eventAdmin = EventAdmin.getInstance();
            RunCTCFinished event = new RunCTCFinished(execution);
            eventAdmin.announceEvent(event);

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    private CompilationInfo compilationInfo;
    private String runCode;
}

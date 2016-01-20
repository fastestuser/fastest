package client.blogic.testing.execution;

import client.blogic.management.ii.EventAdmin;
import client.blogic.management.ii.events.RunCTCFinished;
import client.blogic.testing.atcal.ConcreteTCase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Instances of this class has the responsibility of request, to a computation
 * server, for the running of a concrete case and abstract the output. Each request must
 * be done through a new instance of ServiceMediator, which is the only one that has the
 * knowledge about how the connection with the servers are implemented.
 */
public class RunTCaseClientRunner implements Runnable {

    private final ExecutionCommandBuilder commandBuilder = new PerlCommandBuilder();  // TODO: do not hardcode perl here
    private final String workingDirectory;
    private final ConcreteTCase concreteTCase;

    /**
     * Creates new instances of the test case client runner
     *
     * @param concreteTCase   the concrete test case to run
     */
    public RunTCaseClientRunner(ConcreteTCase concreteTCase, String workingDirectory) {
        this.concreteTCase = concreteTCase;
        this.workingDirectory =
                workingDirectory.endsWith(File.separator) ? workingDirectory : workingDirectory + File.separator;
    }

    /**
     * Requests the execution of a concrete test and the subsequent abstraction of
     * the output, either to the client itself or to a computation server.
     * After a response arrives, it announces a TCaseAbstracted event.
     */
    public void run() {
        // TODO: The code skips the server for now and runs the test locally.
        try {
            // Write the test program code into a file
            String testFileName = commandBuilder.getTestFileName(concreteTCase.getName());
            File testProgramPath = new File(workingDirectory + testFileName);
            testProgramPath.getParentFile().mkdirs();
            PrintWriter printer = new PrintWriter(new FileWriter(testProgramPath));
            printer.println(concreteTCase.getCode());
            printer.flush();

            // Compile the test program if required
            if (commandBuilder.requiresCompilation()) {
                // TODO: add support for compilation here
            }

            // Get the test program's execution command and run it.
            String execCommand = commandBuilder.getExecCommand(testFileName);
            Execution execution = Executor.execute(execCommand, workingDirectory);

            RunCTCFinished event = new RunCTCFinished(concreteTCase, execution);
            EventAdmin eventAdmin = EventAdmin.getInstance();
            eventAdmin.announceEvent(event);

        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace(System.out);
        }
    }
}

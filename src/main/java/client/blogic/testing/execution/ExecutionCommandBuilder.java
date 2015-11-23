package client.blogic.testing.execution;

/**
 * Created by cristian on 01/10/15.
 */
public interface ExecutionCommandBuilder {
    String getTestFileName(String concreteTestName);
    boolean requiresCompilation();
    String getCompileCommand(String srcFileName);
    String getExecCommand(String programFileName);
}

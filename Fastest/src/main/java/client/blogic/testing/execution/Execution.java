package client.blogic.testing.execution;

/**
 * This class represents the output of a test case execution
 */
public class Execution {

    private final String yamlData;
    private final String stdOutput;
    private final String stdError;
    private final int exitCode;

    public Execution(String yamlData, String stdOutput, String stdError, int exitCode) {
        this.yamlData = yamlData;
        this.stdOutput = stdOutput;
        this.stdError = stdError;
        this.exitCode = exitCode;
    }

    public String getYamlData() {
        return yamlData;
    }

    public String getStdOutput() {
        return stdOutput;
    }

    public String getStdError() {
        return stdError;
    }

    public int getExitCode() {
        return exitCode;
    }

    @Override
    public String toString() {
        return "Execution{" +
                "yamlData=" + yamlData +
                ", stdOutput='" + stdOutput + '\'' +
                ", stdError='" + stdError + '\'' +
                ", exitCode=" + exitCode +
                '}';
    }
}

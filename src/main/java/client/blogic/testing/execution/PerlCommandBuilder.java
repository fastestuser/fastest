package client.blogic.testing.execution;

/**
 * Created by cristian on 01/10/15.
 */
public class PerlCommandBuilder implements ExecutionCommandBuilder {

    /* TODO: load this configuration from file */
    private final String perlBin = "/usr/bin/perl";

    @Override
    public boolean requiresCompilation() {
        return false;
    }

    @Override
    public String getCompileCommand(String srcFileName) {
        throw new RuntimeException("Perl does not support compilation.");
    }

    @Override
    public String getExecCommand(String programFileName) {
        return perlBin + " " + programFileName;
    }

    @Override
    public String getTestFileName(String concreteTestName) {
        return concreteTestName + ".pl";
    }
}

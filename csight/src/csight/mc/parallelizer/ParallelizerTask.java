package csight.mc.parallelizer;

import java.util.List;

/**
 * An MC Parallelizer task that contains a command to the Parallelizer, the
 * corresponding inputs, and the current refinement counter in CSightMain. The
 * START_K command should have inputs of size K = min{numParallel,
 * invsToCheck.size()}. The START_ONE command should have inputs of size = 1.
 * The STOP_ALL command should have corresponding input of null.
 */
public class ParallelizerTask {

    public enum ParallelizerCommands {
        START_K, START_ONE, STOP_ALL;
    }

    protected final ParallelizerCommands cmd;
    protected final List<ParallelizerInput> inputs;
    protected final int refinementCounter;

    public ParallelizerTask(ParallelizerCommands cmd,
            List<ParallelizerInput> inputs, int refinementCounter) {
        if (cmd.equals(ParallelizerCommands.START_K)) {
            assert (inputs.size() > 0);
        } else if (cmd.equals(ParallelizerCommands.START_ONE)) {
            assert (inputs.size() == 1);
        } else {
            assert (inputs == null);
        }

        this.cmd = cmd;
        this.inputs = inputs;
        this.refinementCounter = refinementCounter;
    }

}

package command;

import exceptions.NoMatchFoundException;
import progettose_gruppo09.Function;

/**
 * This class implements Command interface and modify the sequence of operations
 * that a function has to execute
 *
 * @author gruppo09
 */
public class ModifyFunctionCommand implements Command {

    private Function function;
    private String sequence;

    /**
     * Construct a new ModifyFunctionCommand object that operates on a
     * sequenceString to be modified
     *
     * @param f The function to be modified
     * @param text The new sequence to set in f
     */
    public ModifyFunctionCommand(Function f, String text) {
        this.function = f;
        this.sequence = text;
    }

    /**
     * Execute the setting of sequence into the sequenceStrinf of f
     *
     * @throws NoMatchFoundException
     */
    @Override
    public void execute() throws NoMatchFoundException {
        function.setSequenceString(sequence);
    }

}

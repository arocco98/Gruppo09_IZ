package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import java.util.ArrayList;
import progettose_gruppo09.Function;

/**
 * This class implements Command interface and execute the insertion of a
 * FunctionCommand checking if the name and the string passed as parameters in
 * the constructor are valid.
 *
 * @author gruppo09
 */
public class InsertFunctionCommand implements Command {

    private String name;
    private String sequence;
    private ArrayList<Function> functions;

    /**
     * The constructor of InsertFunctionCommand
     *
     * @param name The name of the new FunctionCommand.
     * @param sequence The sequence to check.
     * @param functions The FunctionCommand array that contains all the
     * previously created function command defined by the user.
     */
    public InsertFunctionCommand(String name, String sequence, ArrayList<Function> functions) {
        this.name = name.toLowerCase();
        this.sequence = sequence.trim();
        this.functions = functions;
    }

    /**
     * This method checks if the name of the new Function is not taken and
     * checks if the string passed as parameter contains only valid operation,
     * then add the new function to the available functions.
     *
     * @throws NoMatchFoundException When the string doesn't match any pattern.
     * @throws FunctionNameAlreadyExistsException When the function name already
     * exists.
     */
    @Override
    public void execute() throws NoMatchFoundException, FunctionNameAlreadyExistsException {
        // creating new function and generating its commands
        Function function = new Function(name);
        function.setSequenceString(sequence);

        // if no exceptions were thrown, add a new FunctionCommand to the functions array
        functions.add(function);
    }

}

package command;

import exceptions.StackSizeException;
import exceptions.VariablesNameException;
import java.util.Map.Entry;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Variables;
import progettose_gruppo09.VariablesStack;

/**
 * This class implements Command interface and executes the restore of a
 * Variables object by taking the last pushed element from the VariablesStack.
 *
 * @author gruppo09
 */
public class RestoreVariablesCommand implements Command {

    private Variables variables;
    private VariablesStack savedVariables;

    /**
     * Constructor of RestoreVariablesCommand
     *
     * @param variables The variables to modify.
     * @param savedVariables The stack containing all the saved Variables
     * object.
     */
    public RestoreVariablesCommand(Variables variables, VariablesStack savedVariables) {
        this.variables = variables;
        this.savedVariables = savedVariables;
    }

    /**
     * Execute the restore of the last pushed element and modify the Variables
     * object.
     *
     * @throws StackSizeException When the stack is empty.
     * @throws exceptions.VariablesNameException When the variable name is not
     * valid.
     */
    @Override
    public void execute() throws StackSizeException, VariablesNameException {
        //controlling that there is almost one element to restore
        if (savedVariables.isEmpty()) {
            throw new StackSizeException();
        }

        Variables poppedVariables = savedVariables.pop();

        //setting the current variables to the last value saved into the stack
        for (Entry<Character, Complex> entry : poppedVariables.getVariables().entrySet()) {
            variables.setVariable(entry.getKey(), entry.getValue());
        }
    }

}

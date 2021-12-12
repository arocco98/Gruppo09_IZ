package command;

import java.util.Map;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Variables;
import progettose_gruppo09.VariablesStack;

/**
 * This class implements Command interface and executes the push of a Variables
 * object into the stack
 *
 * @author gruppo09
 */
public class SaveVariablesCommand implements Command {

    private Variables variables;
    private VariablesStack savedVariables;

    /**
     * Constructor of SaveVariablesCommand.
     *
     * @param variables The variables to push into the stack.
     * @param savedVariables The stack of variables.
     */
    public SaveVariablesCommand(Variables variables, VariablesStack savedVariables) {
        this.variables = variables;
        this.savedVariables = savedVariables;
    }

    /**
     * Execute the push of the variables object into savedVariables stack.
     *
     * @throws Exception When an Exception is thrown.
     */
    @Override
    public void execute() throws Exception {
        Variables newVariables = new Variables();

        for (Map.Entry<Character, Complex> entry : variables.getVariables().entrySet()) {
            newVariables.setVariable(entry.getKey(), entry.getValue());
        }

        savedVariables.push(newVariables);
    }

    /**
     * Equals method, it checks if the object passed as parameter is equal to
     * the instance.
     *
     * @param obj The object to check if it is equal.
     * @return True if the objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        return true;
    }
}

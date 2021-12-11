package command;

import exceptions.StackSizeException;
import exceptions.VariablesNameException;
import progettose_gruppo09.*;

/**
 *
 * This class implements Command interface and execute the save in variable of
 * the element on top of the stack
 *
 * @author gruppo09
 */
public class InVariableCommand implements Command {

    private Character variable;
    private Stack stack;
    private Variables variables;

    /**
     * Construct a new InVariableCommand object that operates on a stack and
     * variables
     *
     * @param variable variable on which InVariableCommand operates
     * @param stack stack on which InVariableCommand operates
     * @param variables variables on which InVariableCommand operates
     */
    public InVariableCommand(Character variable, Stack stack, Variables variables) {
        this.variable = variable;
        this.stack = stack;
        this.variables = variables;
    }

    /**
     * Saves the thetop of the stack in the variable
     *
     * @throws VariablesNameException
     * @throws StackSizeException
     */
    @Override
    public void execute() throws VariablesNameException, StackSizeException {

        //check that the stack has at least one element so that division should be executed
        if (stack.size() >= 1) {
            //saving in the selected variable the value in the top of the stack
            //and removing it
            variables.setVariable(variable, stack.pop());
        } else {
            throw new StackSizeException();
        }
    }

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
        InVariableCommand other = (InVariableCommand) obj;

        if (!variable.equals(other.variable)) {
            return false;
        }
        return true;
    }
}

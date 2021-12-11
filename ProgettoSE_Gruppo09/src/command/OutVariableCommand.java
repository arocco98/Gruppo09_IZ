package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 *
 * This class implements Command interface and execute the save on the top of
 * the stack the element in the indicate variable
 *
 * @author gruppo09
 */
public class OutVariableCommand implements Command {

    private Stack stack;
    private Variables variables;
    private Character variable;

    /**
     * Construct a new InVariableCommand object that operates on a stack and
     * variables
     *
     * @param variable variable on which InVariableCommand operates
     * @param stack stack on which InVariableCommand operates
     * @param variables variables on which InVariableCommand operates
     */
    public OutVariableCommand(Stack stack, Variables variables, Character variable) {
        this.stack = stack;
        this.variables = variables;
        this.variable = variable;
    }

    /**
     * Pushes into the stack the value associated with a variable
     *
     * @throws VariablesNameException
     * @throws VariablesValueException
     */
    @Override
    public void execute() throws VariablesValueException, VariablesNameException {
        //check that the value associated with 'variable' is not null so that
        //the OutVariable operation should be executed
        if (variables.getVariable(variable) == null) {
            throw new VariablesValueException();
        }

        //pushing into the stack the value associated with 'variable'
        stack.push(variables.getVariable(variable));
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
        OutVariableCommand other = (OutVariableCommand) obj;

        if (!variable.equals(other.variable)) {
            return false;
        }
        return true;
    }
}

package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and takes the top element from the
 * stack and subtracts it to the value of the variable "x" (storing the result
 * of the addition into "x")
 *
 * @author grupo09
 */
public class SubVariableCommand implements Command {

    private Stack stack;
    private Variables variables;
    private Character x;

    /**
     * Construct a new SubVariableCommand object
     *
     * @param stack The stack from which to get the element
     * @param variables The list of variables SubVariableCommand operates on
     * @param x The variable in which subtraction is stored
     */
    public SubVariableCommand(Stack stack, Variables variables, Character x) {
        this.stack = stack;
        this.variables = variables;
        this.x = x;
    }

    /**
     * Execute the subtraction of the element in x and the top element of the
     * stack
     *
     * @throws exceptions.VariablesValueException
     * @throws exceptions.VariablesNameException
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws VariablesValueException, VariablesNameException, StackSizeException {

        if (stack.isEmpty()) {
            throw new StackSizeException();
        }

        if (variables.getVariable(x) == null) {
            throw new VariablesValueException();
        } else {
            variables.setVariable(x, ComplexOperations.complexSub(variables.getVariable(x), stack.peek()));
        }

    }

}

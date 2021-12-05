package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and takes the top element from the
 * stack and adds it to the value of the variable "x" (storing the result of the
 * addition into "x")
 *
 * @author grupo09
 */
public class SumVariableCommand implements Command {

    private Stack stack;
    private Variables variables;
    private Character x;

    /**
     * Construct a new SumVariableCommand object
     *
     * @param stack The stack from which to get the element
     * @param variables The list of variables SumVariableCommand operates on
     * @param x The variable in which sum is stored
     */
    public SumVariableCommand(Stack stack, Variables variables, Character x) {
        this.stack = stack;
        this.variables = variables;
        this.x = x;
    }

    /**
     * Execute the sum of the element in x and the top element of the stack
     *
     * @throws exceptions.VariablesValueException
     * @throws exceptions.VariablesNameException
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws VariablesValueException, VariablesNameException, StackSizeException {
        //check that the stack is not empty so that operation should be executed
        if (stack.isEmpty()) {
            throw new StackSizeException();
        }

        //check that the variable chosen is not null
        if (variables.getVariable(x) == null) {
            throw new VariablesValueException();
        } else {
            //inserts the result of the transaction into the variable chosen
            variables.setVariable(x, ComplexOperations.complexSum(variables.getVariable(x), stack.pop()));
        }

    }

}

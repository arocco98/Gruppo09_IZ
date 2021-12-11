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

    private ComplexStack stack;
    private Variables variables;
    private Character x;

    /**
     * Construct a new SubVariableCommand object
     *
     * @param stack The stack from which to get the element
     * @param variables The list of variables SubVariableCommand operates on
     * @param x The variable in which subtraction is stored
     */
    public SubVariableCommand(ComplexStack stack, Variables variables, Character x) {
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
        //check that the stack is not empty so that operation should be executed
        if (stack.isEmpty()) {
            throw new StackSizeException();
        }

        //check that the variable chosen is not null
        if (variables.getVariable(x) == null) {
            throw new VariablesValueException();
        } else {
            //inserts the result of the transaction into the variable chosen
            variables.setVariable(x, ComplexOperations.complexSub(variables.getVariable(x), stack.pop()));
        }

    }

    /**
     * Equals method, it checks if the object passed as parameter is equal to the instance.
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
        SubVariableCommand other = (SubVariableCommand) obj;

        if (!x.equals(other.x)) {
            return false;
        }
        return true;
    }
}

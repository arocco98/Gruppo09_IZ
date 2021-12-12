package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo_09
 */
public class ArgCommand implements Command {

    private ComplexStack stack;

    /**
     * Construct a new ArgCommand object that operates on a stack.
     *
     * @param stack The stack on which ArgCommand operates.
     */
    public ArgCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the arg operation on the first element of the stack.
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least one element so that
        //argument should be executed
        if (!stack.isEmpty()) {
            Complex c1 = stack.pop();

            //pushing into the stack the argument of c1 calling mod function
            stack.push(new Complex(ComplexOperations.arg(c1)));
        } else {
            throw new StackSizeException();
        }
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

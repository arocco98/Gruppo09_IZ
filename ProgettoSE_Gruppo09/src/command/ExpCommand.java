package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo09
 */
public class ExpCommand implements Command {

    private ComplexStack stack;

    /**
     * Construct a new ExpCommand object that operates on a stack.
     *
     * @param stack The stack on which ExpCommand operates.
     */
    public ExpCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the exp operation with the first element of the stack as
     * exponent.
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least one element so that
        //exponential should be executed
        if (stack.size() >= 1) {
            Complex c1 = stack.pop();

            //pushing into the stack the exponential of c1 calling exp function
            stack.push(ComplexOperations.exp(c1));
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

package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the inversion sign
 * operation of the first complex number in the stack.
 *
 * @author gruppo09
 */
public class InversionSignCommand implements Command {

    private ComplexStack stack;

    /**
     * Construct a new InversionSignCommand object that operates on a stack.
     *
     * @param stack The stack on which InversionSignCommand operates.
     */
    public InversionSignCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the inversion sign operation on the first stack element, if the
     * stack is empty a StackSizeException is thrown
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least one element so that
        //inversion sign should be executed
        if (stack.size() >= 1) {
            Complex complex = stack.pop();

            //pushing into the stack the value of c1 reversing the sign of real
            //part and imaginary part
            stack.push(new Complex(-complex.getReal(), -complex.getImaginary()));
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

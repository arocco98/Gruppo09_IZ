package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Stack;

/**
 * This class implements Command interface and execute the inversion sign
 * operation on the first complex number in the stack.
 *
 * @author gruppo09
 */
public class InversionSignCommand implements Command {

    private Stack stack;

    /**
     * Construct a new InversionSignCommand object that operates on a stack.
     *
     * @param stack The stack on which InversionSignCommand operates.
     */
    public InversionSignCommand(Stack stack) {
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

}

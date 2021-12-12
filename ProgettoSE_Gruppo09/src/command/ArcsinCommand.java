package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the arcsin operation on
 * the first element of the stack
 *
 * @author gruppo09
 */
public class ArcsinCommand implements Command {

    private ComplexStack stack;

    /**
     * Constructor of ArcsinCommand class.
     *
     * @param stack The stack from which take the element.
     */
    public ArcsinCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the arcsin operation on the first element of the stack.
     *
     * @throws Exception When an exception is thrown.
     */
    @Override
    public void execute() throws Exception {
        //check that the stack has at least one element so that
        //arc sine should be executed
        if (stack.isEmpty()) {
            throw new StackSizeException();
        }
        Complex complex = stack.pop();
        //pushing into the stack the value of the arc sine of complex
        stack.push(ComplexOperations.arcsin(complex));
    }

}

package command;

import exceptions.OperationDenied;
import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo_09
 */
public class TanCommand implements Command {

    private ComplexStack stack;

    public TanCommand(ComplexStack stack) {
        this.stack = stack;
    }

    @Override
    public void execute() throws StackSizeException, OperationDenied {
        //check that the stack has at least one element so that
        //tangent should be executed
        if (stack.size() >= 1) {
            Complex c1 = stack.pop();

            //pushing into the stack the tangent of c1 calling tan function
            stack.push(ComplexOperations.tan(c1));
        } else {
            throw new StackSizeException();
        }
    }

}

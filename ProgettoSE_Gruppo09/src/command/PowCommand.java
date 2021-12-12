package command;

import exceptions.ImaginaryException;
import exceptions.OperationDenied;
import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo_09
 */
public class PowCommand implements Command {

    private ComplexStack stack;

    public PowCommand(ComplexStack stack) {
        this.stack = stack;
    }

    @Override
    public void execute() throws StackSizeException, ImaginaryException, OperationDenied {
        //check that the stack has at least two elements so that
        //pow should be executed
        if (stack.size() >= 2) {
            Complex c2 = stack.pop();
            Complex c1 = stack.pop();

            if (c2.getImaginary() != 0) {
                throw new ImaginaryException();
            } else {
                stack.push(ComplexOperations.pow(c1, c2.getReal()));
            }

        } else {
            throw new StackSizeException();
        }
    }

}

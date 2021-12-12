package command;

import exceptions.OperationDenied;
import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the arc tangent of the
 * first complex number in the stack.
 *
 * @author gruppo09
 */
public class ArctanCommand implements Command {

    private ComplexStack stack;

    /**
     * Construct a new ArctanCommand object that operates on a stack.
     *
     * @param stack The stack on which InversionSignCommand operates.
     */
    public ArctanCommand(ComplexStack stack) {
        this.stack = stack;
    }

    @Override
    public void execute() throws StackSizeException, OperationDenied {
        //check that the stack has at least one element so that
        //arc tangent should be executed
        if (stack.size() >= 1) {
            Complex complex = stack.pop();

            //pushing into the stack the value of the arc tangent of complex
            stack.push(ComplexOperations.arctan(complex));
        } else {
            throw new StackSizeException();
        }
    }

}

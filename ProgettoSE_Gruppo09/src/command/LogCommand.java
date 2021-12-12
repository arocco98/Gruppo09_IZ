package command;

import exceptions.OperationDenied;
import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the natural log operation
 * on the first element of the stack.
 *
 * @author gruppo_09
 */
public class LogCommand implements Command {

    private ComplexStack stack;

    /**
     * Constructor of LogCommand class.
     *
     * @param stack The stack from which take the element.
     */
    public LogCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the natural log operation on the first element of the stack.
     *
     * @throws exceptions.StackSizeException
     * @throws exceptions.OperationDenied
     */
    @Override
    public void execute() throws StackSizeException, OperationDenied {
        //check that the stack has at least one element so that
        //logarithm should be executed
        if (!stack.isEmpty()) {
            Complex c1 = stack.pop();

            //pushing into the stack the logarithm of c1 calling log function
            stack.push(ComplexOperations.log(c1));
        } else {
            throw new StackSizeException();
        }
    }

}

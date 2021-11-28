package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and execute the division of two
 * complex numbers in a stack
 *
 * @author gruppo09
 */
public class DivCommand implements Command {

    private Stack stack;

    /**
     * Construct a new DivCommand object that operates on a stack
     *
     * @param stack The stack on which DivCommand operates
     */
    public DivCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the division of the last two complex numbers in the stack
     *
     * @throws exceptions.StackSizeException
     * @throws exceptions.OperationDenied
     */
    @Override
    public void execute() throws StackSizeException, OperationDenied {
        if (stack.size()>= 2) {
            Complex c2 = stack.pop();
            Complex c1 = stack.pop();

            if (c2.getImaginary() == 0 && c2.getReal() == 0) {
                throw new OperationDenied();
            } else {
                stack.push(ComplexOperations.complexDiv(c1, c2));
            }

        } else {
            throw new StackSizeException();
        }
    }

}

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

        //check that the stack has at least two elements so that
        //division should be executed
        if (stack.size() >= 2) {
            Complex c2 = stack.pop();
            Complex c1 = stack.pop();

            //check that the divider has a real part and an imaginary part other
            //than zero, otherwise the operation is not allowed and the last
            //operands taken from the stack are reinserted
            if (c2.getImaginary() == 0 && c2.getReal() == 0) {
                stack.push(c1);
                stack.push(c2);
                throw new OperationDenied();
            } else {
                stack.push(ComplexOperations.complexDiv(c1, c2));
            }

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

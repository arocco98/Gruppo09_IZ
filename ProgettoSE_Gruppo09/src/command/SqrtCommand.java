package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and execute the sqrt of one complex
 * numbers in a stack
 *
 * @author gruppo09
 */
public class SqrtCommand implements Command {

    private Stack stack;

    /**
     * Construct a new SqrtCommand object that operates on a stack
     *
     * @param stack The stack on which SqrtCommand operates
     */
    public SqrtCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the sqrt of the last one complex number in the stack
     *
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        if (stack.size() >= 1) {
            Complex c1 = stack.pop();

            //pushing into the stack the square root of c1 calling sqrt function
            stack.push(ComplexOperations.sqrt(c1));
        } else {
            throw new StackSizeException();
        }
    }

}

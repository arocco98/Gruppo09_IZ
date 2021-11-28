package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and execute the sum of two complex
 * numbers in a stack
 *
 * @author gruppo09
 */
public class SumCommand implements Command {

    private Stack stack;

    /**
     * Construct a new SumCommand object that operates on a stack
     *
     * @param stack The stack on which SumCommand operates
     */
    public SumCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the sum of the last two complex numbers in the stack
     *
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        if (stack.size() >= 2) {
            Complex c1 = stack.pop();
            Complex c2 = stack.pop();

            stack.push(ComplexOperations.complexSum(c1, c2));
        } else {
            throw new StackSizeException();
        }
    }

}

package command;

import exceptions.StackSizeException;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and allows you to swap the last two
 * element from the stack
 *
 * @author gruppo09
 */
public class SwapCommand implements Command {

    private ComplexStack stack;

    /**
     * Construct a new SwapCommand object that operates on a stack
     *
     * @param stack The stack on which SwapCommand operates
     */
    public SwapCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the swap of the last two elements on the stack
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least two elements so that
        //swap should be executed
        if (stack.size() >= 2) {
            Complex c1 = stack.pop();
            Complex c2 = stack.pop();

            //push the last two numbers taken in reverse order
            stack.push(c1);
            stack.push(c2);

        } else {
            throw new StackSizeException();
        }
    }

}

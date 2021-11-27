package command;

import exceptions.StackSizeException;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and pushes a copy of the last element
 * into the stack
 *
 * @author gruppo09
 */
public class DupCommand implements Command {

    private Stack stack;

    /**
     * Construct a new DupCommand object that operates on a stack
     *
     * @param stack The stack on which ClearCommand operates
     */
    public DupCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the push of a copy of the last element onto the stack
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        if (!stack.isEmpty()) {
            Complex c = stack.peek();
            stack.push(c);
        } else {
            throw new StackSizeException();
        }

    }

}

package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Stack;

/**
 * This class implements Command interface and removes the last element (i.e.
 * the top)
 *
 * @author gruppo09
 */
public class DropCommand implements Command {

    private Stack stack;

    /**
     * Construct a new DropCommand object that removes the last element in the
     * stack
     *
     * @param stack The stack on which DropCommand operates
     */
    public DropCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the removal of the last element of the stack.
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack is not empty so that drop function should be executed
        if (!stack.isEmpty()) {
            //taking the last element and removing it
            stack.pop();
        } else {
            throw new StackSizeException();
        }
    }
}

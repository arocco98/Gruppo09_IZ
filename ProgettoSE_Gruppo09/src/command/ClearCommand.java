package command;

import progettose_gruppo09.*;

/**
 * This class implements Command interface and allows you to remove all elements
 * from the stack
 *
 * @author gruppo09
 */
public class ClearCommand implements Command {

    private Stack stack;

    /**
     * Construct a new ClearCommand object that operates on a stack
     *
     * @param stack The stack on which ClearCommand operates
     */
    public ClearCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the clear on the stack by eliminating all elements present
     *
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {
        stack.removeAll(stack);
    }

}

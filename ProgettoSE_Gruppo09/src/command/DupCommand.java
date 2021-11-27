package command;

import progettose_gruppo09.*;

/**
 * This class implements Command interface and pushes a copy of the last element
 * onto the stack
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
     * Execute the push a copy of the last element onto the stack
     *
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {
        Complex c = stack.peek();
        stack.push(c);
    }

}

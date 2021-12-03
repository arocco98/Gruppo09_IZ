package command;

import exceptions.StackSizeException;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and pushes a copy of the second last
 * element
 *
 * @author gruppo09
 */
public class OverCommand implements Command {

    private Stack stack;

    /**
     * Construct a new OverCommand object that operates on a stack
     *
     * @param stack The stack on which OverCommand operates
     */
    public OverCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the push of a copy of the second last element
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws Exception {
        //check that the stack has at least two elements so that
        //over funcion should be executed
        if (stack.size() >= 2) {
            Complex top = stack.pop();
            Complex c = stack.peek();
            stack.push(top);
            stack.push(c);
        } else {
            throw new StackSizeException();
        }
    }

}

package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo_09
 */
public class CosCommand implements Command {

    private Stack stack;

    public CosCommand(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least one element so that
        //cosin should be executed
        if (stack.size() >= 1) {
            Complex c1 = stack.pop();

            //pushing into the stack the cosin of c1 calling cos function
            stack.push(ComplexOperations.cos(c1));
        } else {
            throw new StackSizeException();
        }
    }

}

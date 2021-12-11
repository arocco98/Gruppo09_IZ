package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo_09
 */
public class ArgCommand implements Command {

    private Stack stack;

    public ArgCommand(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least one element so that
        //argument should be executed
        if (stack.size() >= 1) {
            Complex c1 = stack.pop();

            //pushing into the stack the argument of c1 calling mod function
            stack.push(new Complex(ComplexOperations.arg(c1)));
        } else {
            throw new StackSizeException();
        }
    }

}

package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo_09
 */
public class ModCommand implements Command {

    private ComplexStack stack;

    public ModCommand(ComplexStack stack) {
        this.stack = stack;
    }

    @Override
    public void execute() throws Exception {
        //check that the stack has at least one element so that
        //module should be executed
        if (stack.size() >= 1) {
            Complex c1 = stack.pop();

            //pushing into the stack the module of c1 calling mod function
            stack.push(new Complex(ComplexOperations.mod(c1)));
        } else {
            throw new StackSizeException();
        }
    }

}

package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the sin operation on the
 * first element of the stack
 *
 * @author gruppo_09
 */
public class SinCommand implements Command {

    private ComplexStack stack;

    /**
     * Constructor of SinCommand class.
     *
     * @param stack The stack from which take the element.
     */
    public SinCommand(ComplexStack stack) {
        this.stack = stack;
    }

    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least one element so that
        //sin should be executed
        if (!stack.isEmpty()) {
            Complex c1 = stack.pop();

            //pushing into the stack the sin of c1 calling sin function
            stack.push(ComplexOperations.sin(c1));
        } else {
            throw new StackSizeException();
        }

    }

}

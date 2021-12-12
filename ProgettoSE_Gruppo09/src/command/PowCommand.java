package command;

import exceptions.ImaginaryException;
import exceptions.OperationDenied;
import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the pow operation on the
 * second last element of the stack with the top of the stack as exponent. It
 * must be a Complex having imaginary part equal to zero
 *
 * @author gruppo09
 */
public class PowCommand implements Command {

    private ComplexStack stack;

    /**
     * Constructor of PowCommand class.
     *
     * @param stack The stack from which take the element.
     */
    public PowCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the pow operation on the second last element of the stack with
     * the top of the stack as exponent.
     *
     * @throws exceptions.StackSizeException
     * @throws exceptions.ImaginaryException
     * @throws exceptions.OperationDenied
     */
    @Override
    public void execute() throws StackSizeException, ImaginaryException, OperationDenied {
        //check that the stack has at least two elements so that
        //pow should be executed
        if (stack.size() >= 2) {
            Complex c2 = stack.pop();
            Complex c1 = stack.pop();

            //controlling that c2 is a real number
            if (c2.getImaginary() != 0) {
                throw new ImaginaryException();
            } else {
                //pushing into the stack the value of the pow of c1 having the
                //real part of c2 as exponent 
                stack.push(ComplexOperations.pow(c1, c2.getReal()));
            }

        } else {
            throw new StackSizeException();
        }
    }

}

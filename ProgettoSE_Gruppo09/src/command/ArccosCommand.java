package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the arccos operation on
 * the first element of the stack
 *
 * @author gruppo09
 */
public class ArccosCommand implements Command {

    private ComplexStack stack;

    /**
     * Constructor of ArccosCommand class.
     *
     * @param stack The stack from which take the element.
     */
    public ArccosCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the arccos operation on the first element of the stack.
     *
     * @throws Exception When an exception is thrown.
     */
    @Override
    public void execute() throws Exception {
        //check that the stack has at least one element so that
        //arc cosine should be executed
        if (stack.isEmpty()) {
            throw new StackSizeException();
        }
        Complex complex = stack.pop();
        //pushing into the stack the value of the arc cosine of complex
        stack.push(ComplexOperations.arccos(complex));
    }

    /**
     * Equals method, it checks if the object passed as parameter is equal to
     * the instance.
     *
     * @param obj The object to check if it is equal.
     * @return True if the objects are equals, otherwise false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        return true;
    }
}

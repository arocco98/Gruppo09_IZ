package command;

import exceptions.StackSizeException;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and execute the mod operation on the
 * first element of the stack.
 *
 * @author gruppo_09
 */
public class ModCommand implements Command {

    private ComplexStack stack;

    /**
     * Constructor of ModCommand class.
     *
     * @param stack The stack from which take the element.
     */
    public ModCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the mod operation on the first element of the stack.
     *
     * @throws Exception When an exception is thrown.
     */
    @Override
    public void execute() throws Exception {
        //check that the stack has at least one element so that
        //module should be executed
        if (!stack.isEmpty()) {
            Complex c1 = stack.pop();

            //pushing into the stack the module of c1 calling mod function
            stack.push(new Complex(ComplexOperations.mod(c1)));
        } else {
            throw new StackSizeException();
        }
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

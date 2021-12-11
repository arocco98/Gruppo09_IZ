package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and execute the sqrt of one complex
 * numbers in a stack
 *
 * @author gruppo09
 */
public class SqrtCommand implements Command {

    private Stack stack;

    /**
     * Construct a new SqrtCommand object that operates on a stack
     *
     * @param stack The stack on which SqrtCommand operates
     */
    public SqrtCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the sqrt of the last one complex number in the stack
     *
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least one element so that
        //square root should be executed
        if (stack.size() >= 1) {
            Complex c1 = stack.pop();

            //pushing into the stack the square root of c1 calling sqrt function
            stack.push(ComplexOperations.sqrt(c1));
        } else {
            throw new StackSizeException();
        }
    }

    /**
     * Equals method, it checks if the object passed as parameter is equal to the instance.
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

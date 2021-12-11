package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and execute the sum of two complex
 * numbers in a stack
 *
 * @author gruppo09
 */
public class SumCommand implements Command {

    private Stack stack;

    /**
     * Construct a new SumCommand object that operates on a stack
     *
     * @param stack The stack on which SumCommand operates
     */
    public SumCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the sum of the last two complex numbers in the stack
     *
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least two elements so that
        //sum should be executed
        if (stack.size() >= 2) {
            Complex c1 = stack.pop();
            Complex c2 = stack.pop();

            //pushing into the stack the sum between c1 and c2 calling
            //complexSum function
            stack.push(ComplexOperations.complexSum(c1, c2));
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

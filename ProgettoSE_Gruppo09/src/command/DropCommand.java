package command;

import exceptions.StackSizeException;
import progettose_gruppo09.ComplexStack;

/**
 * This class implements Command interface and removes the last element (i.e.
 * the top)
 *
 * @author gruppo09
 */
public class DropCommand implements Command {

    private ComplexStack stack;

    /**
     * Construct a new DropCommand object that removes the last element in the
     * stack
     *
     * @param stack The stack on which DropCommand operates
     */
    public DropCommand(ComplexStack stack) {
        this.stack = stack;
    }

    /**
     * Execute the removal of the last element of the stack.
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack is not empty so that drop function should be executed
        if (!stack.isEmpty()) {
            //taking the last element and removing it
            stack.pop();
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

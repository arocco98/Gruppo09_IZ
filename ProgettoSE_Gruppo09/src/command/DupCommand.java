package command;

import exceptions.StackSizeException;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and pushes a copy of the last element
 * into the stack
 *
 * @author gruppo09
 */
public class DupCommand implements Command {

    private Stack stack;

    /**
     * Construct a new DupCommand object that operates on a stack
     *
     * @param stack The stack on which ClearCommand operates
     */
    public DupCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the push of a copy of the last element onto the stack
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack is not empty so that duplication should be executed
        if (!stack.isEmpty()) {
            //saving the value of the element to duplicate
            Complex c = stack.peek();
            //pushing a copy of the last element into the stack
            stack.push(c);
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

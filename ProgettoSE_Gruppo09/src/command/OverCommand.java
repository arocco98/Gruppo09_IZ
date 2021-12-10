package command;

import exceptions.StackSizeException;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and pushes a copy of the second last
 * element in the top of the stack
 *
 * @author gruppo09
 */
public class OverCommand implements Command {

    private Stack stack;

    /**
     * Construct a new OverCommand object that operates on a stack
     *
     * @param stack The stack on which OverCommand operates
     */
    public OverCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the push of a copy of the second last element
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws Exception {
        //check that the stack has at least two elements so that
        //over funcion should be executed
        if (stack.size() >= 2) {

            //saving the top element in a temporary variable and remove it from
            //the stack
            Complex top = stack.pop();

            //saving the value of the element to copy in the top of the stack 
            Complex c = stack.peek();

            //restoring the top element in the stack
            stack.push(top);
            //pushing the copy of second last element in the top of the stack
            stack.push(c);
        } else {
            throw new StackSizeException();
        }
    }

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

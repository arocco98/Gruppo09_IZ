package command;

import java.util.Objects;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and allows you to remove all elements
 * from the stack
 *
 * @author gruppo09
 */
public class ClearCommand implements Command {

    private Stack stack;

    /**
     * Construct a new ClearCommand object that operates on a stack
     *
     * @param stack The stack on which ClearCommand operates
     */
    public ClearCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the clear on the stack by eliminating all elements present
     *
     * @throws Exception
     */
    @Override
    public void execute() throws Exception {
        //using the method removeAll of ArrayList in order to empty the stack
        stack.removeAll(stack);
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

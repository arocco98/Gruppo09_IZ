package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and execute the subtraction of two
 * complex numbers in a stack
 *
 * @author gruppo09
 */
public class SubCommand implements Command {

    private Stack stack;

    /**
     * Construct a new SubCommand object that operates on a stack
     *
     * @param stack The stack on which SubCommand operates
     */
    public SubCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the sub of the last two complex numbers in the stack
     *
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least two elements so that
        //subtraction should be executed
        if (stack.size() >= 2) {
            Complex c2 = stack.pop();
            Complex c1 = stack.pop();

            stack.push(ComplexOperations.complexSub(c1, c2));
        } else {
            throw new StackSizeException();
        }
    }

}

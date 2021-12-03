package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and execute the product of two
 * complex numbers in a stack
 *
 * @author gruppo09
 */
public class ProdCommand implements Command {

    private Stack stack;

    /**
     * Construct a new ProdCommand object that operates on a stack
     *
     * @param stack The stack on which DivCommand operates
     */
    public ProdCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the product of the last two complex numbers in the stack
     *
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        //check that the stack has at least two elements so that
        //product should be executed
        if (stack.size() >= 2) {
            Complex c2 = stack.pop();
            Complex c1 = stack.pop();

            //pushing into the stack the product between c1 and c2 calling
            //complexProd function
            stack.push(ComplexOperations.complexProd(c1, c2));
        } else {
            throw new StackSizeException();
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        if (stack.getIndex() >= 1) {
            Complex c1 = stack.pop();

            stack.push(ComplexOperations.sqrt(c1));
        } else {
            throw new StackSizeException();
        }
    }

}

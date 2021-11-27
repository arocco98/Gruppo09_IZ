/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import exceptions.StackSizeException;
import progettose_gruppo09.*;

/**
 * This class implements Command interface and allows you to swap the last two element
 * from the stack
 *
 * @author gruppo09
 */
public class SwapCommand implements Command{
    
    private Stack stack;

    /**
     * Construct a new SwapCommand object that operates on a stack
     *
     * @param stack The stack on which ClearCommand operates
     */
    public SwapCommand(Stack stack) {
        this.stack = stack;
    }

    /**
     * Execute the swap of the last two elements on the stack 
     *
     * @throws StackSizeException
     */
    @Override
    public void execute() throws StackSizeException {
        if (stack.size() >= 2) {
            Complex c1 = stack.pop();
            Complex c2 = stack.pop();

            stack.push(c1);
            stack.push(c2);

        } else {
            throw new StackSizeException();
        }
    }
    
}

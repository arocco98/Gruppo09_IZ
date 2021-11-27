/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import exceptions.*;
import progettose_gruppo09.*;
/**
 *
 * @author gruppo09
 */
public class SubCommand implements Command{
    
    private Stack stack;
    
    /**
     * Construct a new SubCommand object that operates on a stack 
     * @param stack The stack on which SubCommand operates
     */
    public SubCommand(Stack stack){
        this.stack = stack;
    }

    /**
     * Execute the sub of the last two complex numbers in the stack
     * @throws exceptions.StackSizeException
     */
    @Override
    public void execute() throws StackSizeException{
        if(stack.getIndex() >= 2){
            Complex c1 = stack.pop();
            Complex c2 = stack.pop();

            stack.push(ComplexOperations.complexSub(c2, c1));
        } else {
            throw new StackSizeException();
        }
    }
    
}

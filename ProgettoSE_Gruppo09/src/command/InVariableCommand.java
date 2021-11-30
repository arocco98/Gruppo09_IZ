/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command;

import exceptions.StackSizeException;
import exceptions.VariablesNameException;
import progettose_gruppo09.*;

/**
 *
 * This class implements Command interface and execute the save in variable of the element on top of the stack
 * 
 * @author gruppo09
 */
public class InVariableCommand implements Command{
    
    private Character variable;
    private Stack stack;
    private Variables variables;

    /**
     * Construct a new InVariableCommand object that operates on a stack and variables
     * 
     * @param variable variable on which InVariableCommand operates
     * @param stack stack on which InVariableCommand operates
     * @param variables variables on which InVariableCommand operates
     */
    public InVariableCommand(Character variable, Stack stack, Variables variables) {
        this.variable = variable;
        this.stack = stack;
        this.variables = variables;
    }

    /**
     * saves the last element on the stack in the variable 
     * 
     * @throws VariablesNameException
     * @throws StackSizeException 
     */
    @Override
    public void execute() throws VariablesNameException, StackSizeException {
        if (stack.size() >= 1) {
            variables.setVariable(variable, stack.peek());
        } else {
            throw new StackSizeException();
        }
    }

}

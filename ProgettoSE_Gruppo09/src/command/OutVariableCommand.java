/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import exceptions.*;
import progettose_gruppo09.*;

/**
 *
 * This class implements Command interface and execute the save on the top of the stack the element in the indicate variable
 * 
 * @author gruppo09
 */
public class OutVariableCommand implements Command{

    private Stack stack;
    private Variables variables;
    private Character variable;

    /**
     * Construct a new InVariableCommand object that operates on a stack and variables
     * 
     * @param variable variable on which InVariableCommand operates
     * @param stack stack on which InVariableCommand operates
     * @param variables variables on which InVariableCommand operates
     */
    
    public OutVariableCommand(Stack stack, Variables variables, Character variable) {
        this.stack = stack;
        this.variables = variables;
        this.variable = variable;
    }

    /**
     * saves the last element on the stack in the variable 
     * 
     * @throws VariablesNameException
     * @throws VariablesValueException
     */
    
    @Override
    public void execute() throws VariablesValueException, VariablesNameException{
        if(variables.getVariable(variable)==null)
            throw new VariablesValueException();
        
        stack.push(variables.getVariable(variable));
    }

    
    
    
}

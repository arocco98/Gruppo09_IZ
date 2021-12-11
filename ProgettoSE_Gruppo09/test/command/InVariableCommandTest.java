/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package command;

import exceptions.StackSizeException;
import exceptions.VariablesNameException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class InVariableCommandTest {
    
    private ComplexStack stack;
    private Variables variables;
    private Character variable;
    private Character variable2;
    private Complex complex;
    
    
    @Before
    public void setUp() {
        stack = new ComplexStack();
        variables = new Variables();
        variable = 'a';
        variable2 = 'i';
        complex = new Complex(1.0, 0.1);
    }

    /**
     * Test of execute method, of class InVariableCommand.
     */
    @Test
    public void testExecute() throws VariablesNameException, StackSizeException {
        System.out.println("execute InVariableCommandTest");
        stack.push(complex);
        InVariableCommand instance = new InVariableCommand(variable, stack, variables);
        instance.execute();
        Complex result = variables.getVariable(variable);
        Complex expectedResult = complex;
        // expected equals
        assertEquals(expectedResult, result);
        
        stack.push(complex);
        InVariableCommand instance2 = new InVariableCommand(variable2, stack, variables);
        instance2.execute();
        result = variables.getVariable(variable2);
        expectedResult = complex;
        // expected equals
        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of testExecute method, of class InVariableCommand, when it throws an
     * VariablesException.
     */
    @Test(expected = VariablesNameException.class)
    public void testExecuteThrowsException1() throws VariablesNameException, StackSizeException {
        System.out.println("testExecute throws exception VariablesException");
        stack.push(complex);
        InVariableCommand instance = new InVariableCommand('A',stack, variables);
        instance.execute();
    }
    
    /**
     * Test of testExecute method, of class InVariableCommand, when it throws an
     * StackSizeException.
     * 
     * @throws VariablesNameException
     * @throws StackSizeException 
     */
    @Test(expected = StackSizeException.class)
    public void testExecuteThrowsException2() throws VariablesNameException, StackSizeException {
        System.out.println("testExecute throws exception StackSizeException");
        InVariableCommand instance = new InVariableCommand('a',stack, variables);
        instance.execute();
    }
    
}

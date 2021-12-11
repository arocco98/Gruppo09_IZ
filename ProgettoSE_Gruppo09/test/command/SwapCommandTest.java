/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package command;

import exceptions.StackSizeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class SwapCommandTest {
    
    private ComplexStack stack;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(1.5, 3.1);
    }

    /**
     * Test of execute method with a stack size smaller than 2, of class
     * SwapCommand.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Execute1");
        SwapCommand instance = new SwapCommand(stack);
        instance.execute();
    }
    /**
     * Test of execute method, of class SwapCommand.
     */
    @Test
    public void testExecute2() throws StackSizeException {
        stack.push(c1);
        stack.push(c2);
        System.out.println("execute2");
        SwapCommand instance = new SwapCommand(stack);
        instance.execute();
        assertEquals(c1, stack.pop());
        assertEquals(c2, stack.pop());
    }
    
}

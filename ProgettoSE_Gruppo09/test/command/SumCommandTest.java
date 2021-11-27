/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package command;

import exceptions.StackSizeException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class SumCommandTest {
    
    private Stack stack;
    private Complex c1;
    private Complex c2;    
            
    @Before
    public void setUp() {
        stack = new Stack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(1.5, 3.1);
    }

    /**
     * Test of execute method with a stack size smaller than 2, of class SumCommand.
     */
    @Test (expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Execute1");
        SumCommand instance = new SumCommand(stack);
        instance.execute();
    }
    
    /**
     * Test of execute method with a stack size greater than 2 or equal, of class SumCommand.
     */
    @Test 
    public void testExecute2() throws StackSizeException {
        System.out.println("Execute2");
        stack.push(c1);
        stack.push(c2);
        SumCommand instance = new SumCommand(stack);
        instance.execute();
        assertEquals(new Complex(13.5, 8), stack.peek());
    }
    
}

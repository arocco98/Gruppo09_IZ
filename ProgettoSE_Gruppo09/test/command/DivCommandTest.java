/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class DivCommandTest {
    
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
     * Test of execute method with a stack size smaller than 2, of class DivCommand.
     */
    @Test (expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Execute1");
        DivCommand instance = new DivCommand(stack);
        instance.execute();
    }
    
     /**
     * Test of execute method with a stack size greater than 2 or equal, of class DivCommand.
     */
    @Test 
    public void testExecute2() throws StackSizeException {
        System.out.println("Execute2");
        stack.push(c1);
        stack.push(c2);
        DivCommand instance = new DivCommand(stack);
        instance.execute();
        assertEquals(new Complex(2.8, -2.52), stack.peek());
    }
}

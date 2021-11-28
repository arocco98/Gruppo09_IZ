/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import exceptions.OperationDenied;
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
    private Complex c3;

    @Before
    public void setUp() {
        stack = new Stack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(1.5, 3.1);
        c3 = new Complex(0, 0);
    }

    /**
     * Test of execute method with a stack size smaller than 2, of class
     * DivCommand.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException, OperationDenied {
        System.out.println("Execute1");
        DivCommand instance = new DivCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method with a stack size greater than 2 or equal, of
     * class DivCommand.
     */
    @Test
    public void testExecute2() throws StackSizeException, OperationDenied {
        System.out.println("Execute2");
        stack.push(c1);
        stack.push(c2);
        DivCommand instance = new DivCommand(stack);
        instance.execute();
        assertEquals(new Complex(2.8, -2.52), stack.peek());
    }

    /**
     * Test of execute method with the divisor equal to zero for both the real
     * and imaginary part
     */
    @Test(expected = OperationDenied.class)
    public void testExecute3() throws StackSizeException, OperationDenied {
        System.out.println("Execute3");
        stack.push(c1);
        stack.push(c3);
        DivCommand instance = new DivCommand(stack);
        instance.execute();
    }

}

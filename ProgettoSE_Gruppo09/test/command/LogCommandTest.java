/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import exceptions.OperationDenied;
import exceptions.StackSizeException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexStack;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo_09
 */
public class LogCommandTest {

    private ComplexStack stack;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(0, 0);
    }

    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException, OperationDenied {
        System.out.println("Execute1");
        LogCommand instance = new LogCommand(stack);
        instance.execute();
    }

    @Test
    public void testExecute2() throws StackSizeException, OperationDenied {
        System.out.println("Execute2");
        stack.push(c1);
        LogCommand instance = new LogCommand(stack);
        instance.execute();
        assertEquals(new Complex(2.5620117, 0.3876696), stack.peek());
    }

    @Test(expected = OperationDenied.class)
    public void testExecute3() throws StackSizeException, OperationDenied {
        System.out.println("Execute3");
        stack.push(c2);
        LogCommand instance = new LogCommand(stack);
        instance.execute();
    }
}

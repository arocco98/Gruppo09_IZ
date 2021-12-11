/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

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
public class ExpCommandTest {

    private ComplexStack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
    }

    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Execute1");
        ExpCommand instance = new ExpCommand(stack);
        instance.execute();
    }

    @Test
    public void testExecute2() throws StackSizeException {
        System.out.println("Execute2");
        stack.push(c1);
        ExpCommand instance = new ExpCommand(stack);
        instance.execute();
        assertEquals(new Complex(30355.7817824, -159898.8700467), stack.peek());
    }

}

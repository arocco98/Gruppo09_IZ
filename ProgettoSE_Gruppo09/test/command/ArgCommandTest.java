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

/**
 *
 * @author gruppo_09
 */
public class ArgCommandTest {

    private ComplexStack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
    }

    /**
     * Test of execute method, of class ArgCommand, when it throws a
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Test of execute method, of class ArgCommand, when it throws a StackSizeException.");

        ArgCommand instance = new ArgCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method, of class ArgCommand.
     */
    @Test
    public void testExecute2() throws StackSizeException {
        System.out.println("Test of execute method, of class ArgCommand.");

        stack.push(c1);
        ArgCommand instance = new ArgCommand(stack);
        instance.execute();
        assertEquals(new Complex(0.3876696, 0.0), stack.peek());
    }

}

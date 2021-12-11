/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import exceptions.ImaginaryException;
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
public class PowCommandTest {

    private ComplexStack stack;
    private Complex c1;
    private Complex c2;
    private Complex c3;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(2, 12);
        c3 = new Complex(4, 0);
    }

    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException, ImaginaryException, OperationDenied {
        System.out.println("Execute1");
        PowCommand instance = new PowCommand(stack);
        instance.execute();
    }

    @Test
    public void testExecute2() throws StackSizeException, ImaginaryException, OperationDenied {
        System.out.println("Execute2");
        stack.push(c1);
        stack.push(c3);
        PowCommand instance = new PowCommand(stack);
        instance.execute();
        assertEquals(new Complex(567.8401, 28221.648), stack.peek());
    }

    @Test(expected = ImaginaryException.class)
    public void testExecute3() throws StackSizeException, ImaginaryException, OperationDenied {
        System.out.println("Execute3");
        stack.push(c1);
        stack.push(c2);
        PowCommand instance = new PowCommand(stack);
        instance.execute();
    }
}

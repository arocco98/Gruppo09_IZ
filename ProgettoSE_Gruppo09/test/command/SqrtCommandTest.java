/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package command;

import static org.junit.Assert.*;

import exceptions.StackSizeException;
import org.junit.Before;
import org.junit.Test;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class SqrtCommandTest {

    private ComplexStack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
    }

    /**
     * Test of execute method with a stack size smaller than 1, of class
     * SqrtCommand.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Execute1");
        SqrtCommand instance = new SqrtCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method with a stack size greater than 1 or equal, of
     * class SqrtCommand.
     *
     * @throws exceptions.StackSizeException
     */
    @Test
    public void testExecute2() throws StackSizeException {
        System.out.println("Execute2");
        stack.push(c1);
        SqrtCommand instance = new SqrtCommand(stack);
        instance.execute();
        assertEquals(new Complex(3.5328365, 0.6934938), stack.peek());
    }

}

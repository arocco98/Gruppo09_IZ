package command;

import exceptions.StackSizeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo09
 */
public class InversionSignCommandTest {

    private ComplexStack stack;

    @Before
    public void setUp() {
        stack = new ComplexStack();
    }

    /**
     * Test of execute method with an empty stack, it should throw a
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecuteThrowsException() throws Exception {
        System.out.println("Test of execute method with an empty stack, it should throw a StackSizeException.");

        InversionSignCommand instance = new InversionSignCommand(this.stack);
        instance.execute();
    }

    /**
     * Test of execute method, of class InversionSignCommand.
     */
    @Test
    public void testExecute() throws StackSizeException {
        System.out.println("Test of execute method, of class InversionSignCommand.");

        InversionSignCommand instance = new InversionSignCommand(this.stack);

        // real and imaginary part
        Complex insertedComplex = new Complex(4.0, -2.0);
        Complex expectedComplex = new Complex(-4.0, 2.0);
        stack.push(insertedComplex);

        instance.execute();
        assertEquals(expectedComplex, stack.peek());

        // only imaginary part
        insertedComplex = new Complex(0.0, 7.0);
        expectedComplex = new Complex(0.0, -7.0);
        stack.push(insertedComplex);
        instance.execute();
        assertEquals(expectedComplex, stack.peek());

        // only real part
        insertedComplex = new Complex(-8.0, 0.0);
        expectedComplex = new Complex(8, 0.0);
        stack.push(insertedComplex);
        instance.execute();
        assertEquals(expectedComplex, stack.peek());
    }

}

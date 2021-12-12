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
public class ExpCommandTest {

    private ComplexStack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
    }

    /**
     * Test of execute method, of class ExpCommand, when it throws
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Test of execute method, of class ExpCommand, when it throws StackSizeException.");

        ExpCommand instance = new ExpCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method, of class ExpCommand.
     */
    @Test
    public void testExecute2() throws StackSizeException {
        System.out.println("Test of execute method, of class ExpCommand.");

        stack.push(c1);
        ExpCommand instance = new ExpCommand(stack);
        instance.execute();
        assertEquals(new Complex(30355.7817824, -159898.8700467), stack.peek());
    }

}

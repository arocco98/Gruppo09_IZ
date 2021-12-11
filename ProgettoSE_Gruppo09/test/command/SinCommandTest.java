package command;

import exceptions.StackSizeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo09
 */
public class SinCommandTest {

    private Stack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new Stack();
        c1 = new Complex(12, 4.9);
    }

    /**
     * Test of execute method, of class SinCommand.
     */
    @Test
    public void testExecute() throws StackSizeException {
        System.out.println("Test Execute sin");
        stack.push(c1);
        SinCommand instance = new SinCommand(stack);
        instance.execute();
        assertEquals(new Complex(-36.0301273, 56.6573392), stack.peek());
    }

    /**
     * Test of execute method, of class SinCommand.
     *
     * @throws exceptions.StackSizeException
     */
    @Test(expected = StackSizeException.class)
    public void testExecute2() throws StackSizeException {
        System.out.println("Test Execute sin");
        SinCommand instance = new SinCommand(stack);
        instance.execute();
    }

}

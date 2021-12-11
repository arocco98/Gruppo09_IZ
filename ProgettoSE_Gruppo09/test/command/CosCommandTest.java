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
public class CosCommandTest {

    private Stack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new Stack();
        c1 = new Complex(12, 4.9);
    }

    /**
     * Test of execute method, of class CosCommand.
     */
    @Test
    public void testExecute() throws StackSizeException {
        System.out.println("Test Execute cos");
        stack.push(c1);
        CosCommand instance = new CosCommand(stack);
        instance.execute();
        assertEquals(new Complex(56.6636230, 36.0261317), stack.peek());
    }

    /**
     * Test of execute method, of class CosCommand.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute2() throws StackSizeException {
        System.out.println("Test Execute cos");
        CosCommand instance = new CosCommand(stack);
        instance.execute();
    }

}

package command;

import exceptions.StackSizeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class OverCommandTest {

    private Stack stack;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        stack = new Stack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(1.5, 3.1);
    }

    /**
     * Test of execute method, of class OverCommand, with an empty stack
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws Exception {
        System.out.println("execute");
        OverCommand instance = new OverCommand(stack);
        instance.execute();

    }

    /**
     * Test of execute method, of class OverCommand.
     */
    @Test
    public void testExecute2() throws Exception {
        System.out.println("execute");
        stack.push(c1);
        stack.push(c2);
        OverCommand instance = new OverCommand(stack);
        instance.execute();
        assertEquals(c1, stack.peek());
    }

}

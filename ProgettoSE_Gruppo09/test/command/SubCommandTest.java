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
public class SubCommandTest {

    private ComplexStack stack;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(1.5, 3.1);
    }

    /**
     * Test of execute method with a stack size smaller than 2, of class
     * SubCommand.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Execute1");
        SubCommand instance = new SubCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method with a stack size greater than 2 or equal, of
     * class SubCommand.
     *
     * @throws exceptions.StackSizeException
     */
    @Test
    public void testExecute2() throws StackSizeException {
        System.out.println("Execute2");
        stack.push(c1);
        stack.push(c2);
        SubCommand instance = new SubCommand(stack);
        instance.execute();
        Complex expected1 = new Complex(10.5, 1.8);
        assertEquals(expected1, stack.peek());
    }

}

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
public class ModCommandTest {

    private ComplexStack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
    }

    /**
     * Test of execute method, of class ModCommandTest, when it throws
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException, Exception {
        System.out.println("Test of execute method, of class ModCommandTest, when it throws StackSizeException.");
        ModCommand instance = new ModCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method, of class ModCommandTest.
     */
    @Test
    public void testExecute2() throws StackSizeException, Exception {
        System.out.println("Test of execute method, of class ModCommandTest.");
        stack.push(c1);
        ModCommand instance = new ModCommand(stack);
        instance.execute();
        assertEquals(new Complex(12.9618671, 0.0), stack.peek());
    }

}

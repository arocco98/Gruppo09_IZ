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
public class SumCommandTest {

    private ComplexStack stack;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(5.2, 4.9);
        c2 = new Complex(18.9, 3.1);
    }

    /**
     * Test of execute method with a stack size smaller than 2, of class
     * SumCommand.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException {
        System.out.println("Test of execute method with a stack size smaller than 2, of class SumCommand.");
        SumCommand instance = new SumCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method with a stack size greater than 2 or equal, of
     * class SumCommand.
     */
    @Test
    public void testExecute2() throws StackSizeException {
        System.out.println("Test of execute method with a stack size greater than 2 or equal, of class SumCommand.");
        stack.push(c1);
        stack.push(c2);
        SumCommand instance = new SumCommand(stack);
        instance.execute();
        assertEquals(new Complex(24.1, 8), stack.peek());
    }

}

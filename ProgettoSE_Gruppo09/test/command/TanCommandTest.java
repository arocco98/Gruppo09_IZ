package command;

import exceptions.OperationDenied;
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
public class TanCommandTest {

    private ComplexStack stack;
    private Complex c1;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
    }

    /**
     * Test of execute method, of class TanCommand.
     */
    @Test
    public void testExecute() throws StackSizeException, OperationDenied {
        System.out.println("Test Execute tan");
        stack.push(c1);
        TanCommand instance = new TanCommand(stack);
        instance.execute();
        assertEquals(new Complex(-1.004E-4, 0.9999530), stack.peek());
    }

    /**
     * Test of execute method, of class TanCommand.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute2() throws StackSizeException, OperationDenied {
        System.out.println("Test Execute tan");
        TanCommand instance = new TanCommand(stack);
        instance.execute();
    }

}

package command;

import exceptions.ImaginaryException;
import exceptions.OperationDenied;
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
public class PowCommandTest {

    private ComplexStack stack;
    private Complex c1;
    private Complex c2;
    private Complex c3;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(2, 12);
        c3 = new Complex(4, 0);
    }

    /**
     * Test of execute method, of class PowCommandTest.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws StackSizeException, ImaginaryException, OperationDenied {
        System.out.println("Test of execute method, of class PowCommandTest.");

        PowCommand instance = new PowCommand(stack);
        instance.execute();
    }

    /**
     * Test of execute method, of class PowCommandTest.
     */
    @Test
    public void testExecute2() throws StackSizeException, ImaginaryException, OperationDenied {
        System.out.println("Test of execute method, of class PowCommandTest.");

        stack.push(c1);
        stack.push(c3);
        PowCommand instance = new PowCommand(stack);
        instance.execute();
        assertEquals(new Complex(567.8401, 28221.648), stack.peek());
    }

    /**
     * Test of execute method, of class PowCommandTest, when it throws an
     * ImaginaryException.
     */
    @Test(expected = ImaginaryException.class)
    public void testExecute3() throws StackSizeException, ImaginaryException, OperationDenied {
        System.out.println("Test of execute method, of class PowCommandTest, when it throws an ImaginaryException.");

        stack.push(c1);
        stack.push(c2);
        PowCommand instance = new PowCommand(stack);
        instance.execute();
    }
}

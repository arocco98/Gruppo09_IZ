package command;

import exceptions.StackSizeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexOperations;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo09
 */
public class ArccosCommandTest {

    private ComplexStack stack;

    @Before
    public void setUp() {
        stack = new ComplexStack();
    }

    /**
     * Test of execute method, of class ArccosCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Test of execute method, of class ArccosCommand.");

        Complex insertedComplex = new Complex(1.23, 4.56);
        stack.add(insertedComplex);

        ArccosCommand instance = new ArccosCommand(stack);
        instance.execute();

        assertEquals(stack.peek(), ComplexOperations.arccos(insertedComplex));
    }

    /**
     * Test of execute method, of class ArccosCommand, when it throws a
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecuteWhenThrowsException() throws Exception {
        System.out.println("Test of execute method, of class ArccosCommand, when it throws a StackSizeException.");

        ArcsinCommand instance = new ArcsinCommand(stack);
        instance.execute();
    }

}

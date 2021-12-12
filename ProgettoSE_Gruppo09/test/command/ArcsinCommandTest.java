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
public class ArcsinCommandTest {

    private ComplexStack stack;

    @Before
    public void setUp() {
        stack = new ComplexStack();
    }

    /**
     * Test of execute method, of class ArcsinCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");

        Complex insertedComplex = new Complex(1.23, 4.56);
        stack.add(insertedComplex);

        ArcsinCommand instance = new ArcsinCommand(stack);
        instance.execute();

        assertEquals(stack.peek(), ComplexOperations.arcsin(insertedComplex));
    }

    /**
     * Test of execute method, of class ArcsinCommand, when it throws a StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecuteWhenThrowsException() throws Exception {
        System.out.println("execute");

        ArcsinCommand instance = new ArcsinCommand(stack);
        instance.execute();
    }

}

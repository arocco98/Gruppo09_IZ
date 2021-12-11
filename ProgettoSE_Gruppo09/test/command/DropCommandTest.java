package command;

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
public class DropCommandTest {

    private ComplexStack stack;

    @Before
    public void setUp() {
        stack = new ComplexStack();
    }

    /**
     * Test of execute method with an empty stack, it should throw a
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecuteThrowsException() throws StackSizeException {
        System.out.println("Execute with empty stack");
        DropCommand instance = new DropCommand(this.stack);
        instance.execute();
    }

    /**
     * Test of execute method, of class DropCommand.
     */
    @Test
    public void testExecute() throws StackSizeException {
        System.out.println("Execute with non-empty stack");

        DropCommand instance = new DropCommand(this.stack);

        // only one element in the stack
        Complex insertedComplex1 = new Complex(4.0, -2.0);
        stack.push(insertedComplex1);
        int tmpSize = stack.size();
        instance.execute();
        assertEquals(stack.size(), tmpSize - 1);

        // two elements in the stack
        Complex insertedComplex2 = new Complex(2.0, 4.0);
        stack.push(insertedComplex1);
        stack.push(insertedComplex2);
        tmpSize = stack.size();
        instance.execute();
        assertEquals(stack.size(), tmpSize - 1);
    }

}

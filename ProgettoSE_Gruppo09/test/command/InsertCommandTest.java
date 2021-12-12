package command;

import exceptions.NoMatchFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.ComplexStack;

/**
 *
 * @author gruppo09
 */
public class InsertCommandTest {

    ComplexStack stack;

    /**
     * Method for setting up all the used variables.
     */
    @Before
    public void setUp() {
        stack = new ComplexStack();
    }

    /**
     * Test of execute method, of class InsertCommand.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Test of execute method, of class InsertCommand.");

        // defining variables for testing
        InsertCommand instance = null;
        Complex complex = null;
        int size = 0;

        // checking first pattern: a+bj
        instance = new InsertCommand(stack, "1.23+4.56j");
        complex = new Complex(1.23, 4.56);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking second pattern: a+jb
        instance = new InsertCommand(stack, "1.23+j4.56");
        complex = new Complex(1.23, 4.56);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking third pattern: bj+a
        instance = new InsertCommand(stack, "1.2j-3.4");
        complex = new Complex(-3.4, 1.2);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking fourth pattern: jb+a
        instance = new InsertCommand(stack, "-j1.23+4.56");
        complex = new Complex(4.56, -1.23);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking fifth pattern: a
        instance = new InsertCommand(stack, "1.23");
        complex = new Complex(1.23, 0.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking sixth pattern: bj
        instance = new InsertCommand(stack, "-1.23j");
        complex = new Complex(0.0, -1.23);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking seventh pattern: jb
        instance = new InsertCommand(stack, "-j1.23");
        complex = new Complex(0.0, -1.23);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking eighth pattern: a+j
        instance = new InsertCommand(stack, "1.23-j");
        complex = new Complex(1.23, -1.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking ninth pattern: j+a
        instance = new InsertCommand(stack, "j+1.23");
        complex = new Complex(1.23, 1.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking tenth pattern: j
        instance = new InsertCommand(stack, "-j");
        complex = new Complex(0.0, -1.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());
    }

    /**
     * Test of execute method, of class InsertCommand,when it throws
     * NoMatchFoundException
     *
     * @throws NoMatchFoundException
     */
    @Test(expected = NoMatchFoundException.class)
    public void testExecuteThrowsException() throws NoMatchFoundException {
        System.out.println("Test of execute method, of class InsertCommand,when it throws NoMatchFoundException");

        InsertCommand instance = new InsertCommand(stack, "1.23+4.56a");
        instance.execute();
    }
}

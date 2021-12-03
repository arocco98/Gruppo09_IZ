package command;

import exceptions.NoMatchFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Stack;

/**
 *
 * @author gruppo09
 */
public class InsertCommandTest {

    Stack stack;

    /**
     * Method for setting up all the used variables.
     */
    @Before
    public void setUp() {
        stack = new Stack();
    }

    /**
     * Test of execute method, of class InsertCommand.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");

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

        // checking second pattern: bj+a
        instance = new InsertCommand(stack, "1.2j-3.4");
        complex = new Complex(-3.4, 1.2);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking third pattern: a
        instance = new InsertCommand(stack, "1.23");
        complex = new Complex(1.23, 0.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking fourth pattern: bj
        instance = new InsertCommand(stack, "-1.23j");
        complex = new Complex(0.0, -1.23);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking fifth pattern: a+j
        instance = new InsertCommand(stack, "1.23-j");
        complex = new Complex(1.23, -1.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking sixth pattern: j+a
        instance = new InsertCommand(stack, "j+1.23");
        complex = new Complex(1.23, 1.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());

        // checking seventh pattern: j
        instance = new InsertCommand(stack, "-j");
        complex = new Complex(0.0, -1.0);
        instance.execute();
        size++;
        // checking if the inserted element is correct
        assertEquals(complex, stack.peek());
        // checking if the element has been inserted correctly by analyzing the size of the stack
        assertEquals(size, stack.size());
    }

    @Test(expected = NoMatchFoundException.class)
    public void testExecuteThrowsException() throws NoMatchFoundException {
        System.out.println("Execute when throws NoMatchFoundException");

        InsertCommand instance = new InsertCommand(stack, "1.23+4.56a");
        instance.execute();
    }
}

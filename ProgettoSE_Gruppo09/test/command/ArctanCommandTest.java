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
public class ArctanCommandTest {

    private ComplexStack stack;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(-12, -4.9);
    }

    /**
     * Test of execute method, of class ArctanCommand.
     */
    @Test
    public void testExecute1() throws Exception {
        System.out.println("Test of execute method, of class ArctanCommand.");

        stack.push(c1);
        ArctanCommand instance = new ArctanCommand(stack);
        instance.execute();
        assertEquals(new Complex(1.4994329, 0.029025), stack.peek());

        stack.push(c2);
        instance.execute();
        assertEquals(new Complex(-1.4994329, -0.0290249), stack.peek());
    }

    /**
     * Test of execute method, of class ArctanCommand, when it throws a
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute2() throws Exception {
        System.out.println("Test of execute method, of class ArctanCommand when it launches a StackSizeException.");

        ArctanCommand instance = new ArctanCommand(stack);
        instance.execute();
    }

}

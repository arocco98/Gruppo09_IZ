package command;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class DupCommandTest {

    private ComplexStack stack;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        c1 = new Complex(12, 4.9);
        c2 = new Complex(1.5, 3.1);
        stack.push(c1);
        stack.push(c2);
    }

    /**
     * Test of execute method, of class DupCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Test of execute method, of class DupCommand.");

        DupCommand instance = new DupCommand(stack);
        instance.execute();
        assertEquals(c2, stack.peek());
    }

}

package command;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class ClearCommandTest {

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
     * Test of execute method, of class ClearCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        ClearCommand instance = new ClearCommand(stack);
        instance.execute();
        assertTrue(stack.isEmpty());
    }

}

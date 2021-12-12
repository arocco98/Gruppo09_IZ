package command;

import exceptions.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.*;

/**
 *
 * @author gruppo09
 */
public class SubVariableCommandTest {

    private ComplexStack stack;
    private Variables variables;
    private Character char1;
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() throws VariablesNameException {
        stack = new ComplexStack();
        variables = new Variables();
        char1 = 'f';
        c1 = new Complex(14.2, 1.6);
        c2 = new Complex(8.9, 2.5);
    }

    /**
     * Test of execute method, of class SubVariableCommand, whet it throws a
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws Exception {
        System.out.println("Test of execute method, of class SubVariableCommand, whet it throws a StackSizeException.");
        SubVariableCommand instance = new SubVariableCommand(stack, variables, char1);
        instance.execute();
    }

    /**
     * Test of execute method, of class SubVariableCommand, whet it throws a
     * VariablesValueException.
     */
    @Test(expected = VariablesValueException.class)
    public void testExecute2() throws Exception {
        System.out.println("Test of execute method, of class SubVariableCommand, whet it throws a VariablesValueException.");
        SubVariableCommand instance = new SubVariableCommand(stack, variables, char1);
        stack.push(c2);
        instance.execute();
    }

    /**
     * Test of execute method, of class SubVariableCommand.
     */
    @Test
    public void testExecute3() throws Exception {
        System.out.println("Test of execute method, of class SubVariableCommand.");
        SubVariableCommand instance = new SubVariableCommand(stack, variables, char1);
        variables.setVariable(char1, c1);
        stack.push(c2);
        instance.execute();
        assertEquals(new Complex(5.3, -0.9), variables.getVariable(char1));
    }

}

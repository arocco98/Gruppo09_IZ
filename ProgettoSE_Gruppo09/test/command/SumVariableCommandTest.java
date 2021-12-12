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
public class SumVariableCommandTest {

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
        c1 = new Complex(5.2, 2.6);
        c2 = new Complex(8.9, 2.5);
    }

    /**
     * Test of execute method, of class SumVariableCommand, whet it throws a
     * StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecute1() throws Exception {
        System.out.println("Test of execute method, of class SumVariableCommand, whet it throws a StackSizeException.");
        SumVariableCommand instance = new SumVariableCommand(stack, variables, char1);
        instance.execute();
    }

    /**
     * Test of execute method, of class SumVariableCommand, whet it throws a
     * VariablesValueException.
     */
    @Test(expected = VariablesValueException.class)
    public void testExecute2() throws Exception {
        System.out.println("Test of execute method, of class SumVariableCommand, whet it throws a VariablesValueException.");
        SumVariableCommand instance = new SumVariableCommand(stack, variables, char1);
        stack.push(c2);
        instance.execute();
    }

    /**
     * Test of execute method, of class SumVariableCommand.
     */
    @Test
    public void testExecute3() throws Exception {
        System.out.println("Test of execute method, of class SumVariableCommand.");
        SumVariableCommand instance = new SumVariableCommand(stack, variables, char1);
        variables.setVariable(char1, c1);
        stack.push(c2);
        instance.execute();
        assertEquals(new Complex(14.1, 5.1), variables.getVariable(char1));
    }
}

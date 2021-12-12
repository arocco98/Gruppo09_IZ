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
public class OutVariableCommandTest {

    private ComplexStack stack;
    private Variables variables;
    private Character variable;
    private Complex complex;

    @Before
    public void setUp() {
        stack = new ComplexStack();
        variables = new Variables();
        variable = 'a';
        complex = new Complex(1.0, 0.1);
    }

    /**
     * Test of execute method, of class OutVariableCommand.
     */
    @Test
    public void testExecute() throws VariablesNameException, VariablesValueException, StackSizeException {
        System.out.println("Test of execute method, of class OutVariableCommand.");

        variables.setVariable(variable, complex);
        OutVariableCommand instance = new OutVariableCommand(stack, variables, variable);
        instance.execute();
        Complex result = stack.peek();
        Complex expectedResult = complex;
        // expected equals
        assertEquals(expectedResult, result);
    }

    /**
     * Test of testExecute method, of class OutVariableCommand, when it throws a
     * VariablesNameException.
     */
    @Test(expected = VariablesNameException.class)
    public void testExecuteThrowsException1() throws VariablesNameException, StackSizeException, VariablesValueException {
        System.out.println("Test of testExecute method, of class OutVariableCommand, when it throws a VariablesNameException.");

        OutVariableCommand instance = new OutVariableCommand(stack, variables, 'A');
        instance.execute();
    }

    /**
     * Test of testExecute method, of class OutVariableCommand, when it throws a
     * VariablesValueException.
     */
    @Test(expected = VariablesValueException.class)
    public void testExecuteThrowsException2() throws VariablesNameException, StackSizeException, VariablesValueException {
        System.out.println("Test of testExecute method, of class OutVariableCommand, when it throws a VariablesValueException.");

        variables.setVariable(variable, null);
        OutVariableCommand instance = new OutVariableCommand(stack, variables, variable);
        instance.execute();
    }

}

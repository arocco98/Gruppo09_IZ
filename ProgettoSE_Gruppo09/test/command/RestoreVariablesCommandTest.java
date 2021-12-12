package command;

import exceptions.StackSizeException;
import exceptions.VariablesNameException;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Variables;
import progettose_gruppo09.VariablesStack;

/**
 *
 * @author gruppo09
 */
public class RestoreVariablesCommandTest {

    private Variables variables;
    private VariablesStack savedVariables;

    @Before
    public void setUp() throws VariablesNameException {
        variables = new Variables();
        variables.setVariable('a', new Complex(1.23, 4.56));
        variables.setVariable('b', new Complex(0.0, 4.56));
        variables.setVariable('c', new Complex(1.23, 0.0));
        variables.setVariable('d', new Complex(42.0, 77.7));
        variables.setVariable('e', new Complex(7.89, 10.11));

        savedVariables = new VariablesStack();
    }

    /**
     * Test of execute method, of class RestoreVariablesCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Test of execute method, of class RestoreVariablesCommand.");

        // first saving a set of variables
        SaveVariablesCommand saveVariablesCommand = new SaveVariablesCommand(variables, savedVariables);
        saveVariablesCommand.execute();

        // changing some variables
        variables.setVariable('a', new Complex(1.0, 2.0));
        variables.setVariable('c', new Complex(0.0, -1.0));
        variables.setVariable('e', new Complex(-2.0, 0.0));

        assertNotEquals(variables.getVariable('a'), savedVariables.get(0).getVariable('a'));
        assertNotEquals(variables.getVariable('c'), savedVariables.get(0).getVariable('c'));
        assertNotEquals(variables.getVariable('e'), savedVariables.get(0).getVariable('e'));

        // saving the instance of a saved variables
        Variables savedVariablesInstance = savedVariables.get(0);

        RestoreVariablesCommand instance = new RestoreVariablesCommand(variables, savedVariables);
        instance.execute();

        assertEquals(variables.getVariable('a'), savedVariablesInstance.getVariable('a'));
        assertEquals(variables.getVariable('c'), savedVariablesInstance.getVariable('c'));
        assertEquals(variables.getVariable('e'), savedVariablesInstance.getVariable('e'));
    }

    /**
     * Test of execute method, of class RestoreVariablesCommand, when it throws
     * a StackSizeException.
     */
    @Test(expected = StackSizeException.class)
    public void testExecuteWhenThrowsException() throws Exception {
        System.out.println("Test of execute method, of class RestoreVariablesCommand, when it throws a StackSizeException.");

        RestoreVariablesCommand instance = new RestoreVariablesCommand(variables, savedVariables);
        // the savedVariables array is empty, so we cannot restore a saved variables set
        instance.execute();
    }

}

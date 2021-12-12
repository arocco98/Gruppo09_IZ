package command;

import exceptions.VariablesNameException;
import java.util.Map.Entry;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Variables;
import progettose_gruppo09.VariablesStack;

/**
 *
 * @author gruppo09
 */
public class SaveVariablesCommandTest {

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
     * Test of execute method, of class SaveVariablesCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Test of execute method, of class SaveVariablesCommand.");

        SaveVariablesCommand instance = new SaveVariablesCommand(variables, savedVariables);

        assertEquals(savedVariables.size(), 0);
        instance.execute();
        assertEquals(savedVariables.size(), 1);

        // checking if all the values are equals
        for (Entry<Character, Complex> entry : variables.getVariables().entrySet()) {
            assertEquals(variables.getVariable(entry.getKey()), savedVariables.get(0).getVariable(entry.getKey()));
        }

    }

}

package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Function;

/**
 *
 * @author gruppo09
 */
public class ModifyFunctionCommandTest {

    Function fc1;

    @Before
    public void setUp() {
        try {
            fc1 = new Function("op1", "+ - * /");
        } catch (FunctionNameAlreadyExistsException ex) {
            System.out.println("Name already Exists Exception");
        } catch (NoMatchFoundException ex) {
            System.out.println("No Match Found Exception");
        }

    }

    /**
     * Test of execute method, of class ModifyFunctionCommand.
     */
    @Test
    public void testExecute1() throws Exception {
        System.out.println("Test of execute method, of class ModifyFunctionCommand.");

        String sequence = "+ - * / sqrt";
        ModifyFunctionCommand modifyFunctionCommand = new ModifyFunctionCommand(fc1, sequence);
        modifyFunctionCommand.execute();

        assertEquals(sequence, fc1.getSequenceString());
    }

    /**
     * Test of execute method, of class ModifyFunctionCommand, when it throws a
     * NoMatchFoundException.
     */
    @Test(expected = NoMatchFoundException.class)
    public void testExecute2() throws Exception {
        System.out.println("Test of execute method, of class ModifyFunctionCommand, when it throws a NoMatchFoundException.");

        String sequence = "+ - * / sqrtt";
        ModifyFunctionCommand modifyFunctionCommand = new ModifyFunctionCommand(fc1, sequence);
        modifyFunctionCommand.execute();
    }

}

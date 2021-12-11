package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Function;

/**
 *
 * @author gruppo09
 *
 */
public class DeleteFunctionCommandTest {

    Function fc1;
    Function fc2;
    Function fc3;
    ArrayList<Function> functions;

    @Before
    public void setUp() throws FunctionNameAlreadyExistsException, NoMatchFoundException {

        functions = new ArrayList<>();
        Function.setFunctions(this.functions);
        
        fc1 = new Function("op1", "+ - ");
        functions.add(fc1);

        fc2 = new Function("op2", "/ * op1");
        functions.add(fc2);

        fc3 = new Function("op3", "- +");

        functions.add(fc3);

    }

    /**
     * Test of execute method, of class DeleteFunctionCommand.
     */
    @Test
    public void testExecute1() throws Exception {
        System.out.println("Test of execute method, of class DeleteFunctionCommand.");

        Function selectedFunction = fc1;
        DeleteFunctionCommand deleteFunctionCommand = new DeleteFunctionCommand(selectedFunction, functions);
        deleteFunctionCommand.execute();

        assertEquals(2, functions.size());
        assertEquals(fc2, functions.get(0));
        assertEquals(fc3, functions.get(1));

    }

    /**
     * Test of execute method, of class DeleteFunctionCommand.
     */
    @Test
    public void testExecute2() throws Exception {
        System.out.println("Test of execute method, of class DeleteFunctionCommand, with function addiction.");

        Function selectedFunction = fc1;
        DeleteFunctionCommand deleteFunctionCommand = new DeleteFunctionCommand(selectedFunction, functions);
        deleteFunctionCommand.execute();

        assertEquals(2, functions.size());
        assertEquals(fc2, functions.get(0));
        assertEquals(fc3, functions.get(1));
        assertEquals(fc2.getSequenceString(), "/ * + -");

    }

}

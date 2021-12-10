package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import exceptions.VariablesNameException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Function;
import progettose_gruppo09.Stack;
import progettose_gruppo09.Variables;

/**
 *
 * @author gruppo09
 */
public class InsertFunctionCommandTest {

    private Stack stack = null;
    private Variables variables = null;
    private ArrayList<Function> functions = null;

    @Before
    public void setUp() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        // instantiating stack and variables attributes
        stack = new Stack();
        variables = new Variables();
        functions = new ArrayList<>();

        // populating stack and variables attributes
        stack.add(new Complex(1, 2));
        stack.add(new Complex(1, 0.0));
        stack.add(new Complex(0.0, 3));
        stack.add(new Complex(-1, 2));
        stack.add(new Complex(1, -2));

        try {
            variables.setVariable('a', new Complex(3, 4));
            variables.setVariable('i', new Complex(0.0, 4));
            variables.setVariable('z', new Complex(3, 0.0));
        } catch (VariablesNameException ex) {
        }
        
        Function.setStack(this.stack);
        Function.setVariables(this.variables);
        Function.setFunctions(this.functions);

    }

    /**
     * Test of execute method, of class InsertFunctionCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Execute");
        
        Function function1 = new Function("function1", "+ - drop");
        functions.add(function1);
        Function function2 = new Function("function2", "drop drop");
        functions.add(function2);
        
        Function function3 = new Function("function3", "* * <a");

        // adding a new FunctionCommand with valid name and sequence command string
        InsertFunctionCommand instance = new InsertFunctionCommand(function3.getName(), function3.getSequenceString(), functions);
        instance.execute();

        assertEquals(functions.size(), 3);

        assertEquals(functions.get(2), function3);
    }

    /**
     * Test of execute method, of class InsertFunctionCommand.
     */
    @Test(expected = FunctionNameAlreadyExistsException.class)
    public void testExecuteWhenThrowsFunctionNameAlreadyExistsException() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("Execute when it throws FunctionNameAlreadyExistsException");

        Function function1 = new Function("function1", "+ - drop");
        functions.add(function1);
        Function function2 = new Function("function2", "drop drop");
        functions.add(function2);
        // adding a new FunctionCommand with valid name and sequence command string
        InsertFunctionCommand instance = new InsertFunctionCommand("function2", "* * <a", functions);
        instance.execute();
    }

    /**
     * Test of execute method, of class InsertFunctionCommand.
     */
    @Test(expected = NoMatchFoundException.class)
    public void testExecuteWhenThrowsNoMatchFoundException() throws NoMatchFoundException, FunctionNameAlreadyExistsException {
        System.out.println("Execute when it throws NoMatchFoundException");

        Function function1 = new Function("function1", "+ - drop");
        functions.add(function1);
        Function function2 = new Function("function2", "drop drop");
        functions.add(function2);
        // adding a new FunctionCommand with valid name and sequence command string
        InsertFunctionCommand instance = new InsertFunctionCommand("function3", "sqrrt * <a", functions);
        instance.execute();
    }

}
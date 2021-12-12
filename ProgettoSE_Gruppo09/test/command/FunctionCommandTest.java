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
import progettose_gruppo09.ComplexStack;
import progettose_gruppo09.Variables;

/**
 *
 * @author gruppo09
 */
public class FunctionCommandTest {

    private ComplexStack stack = null;
    private Variables variables = null;
    private ArrayList<Function> functions;

    @Before
    public void setUp() {
        // instantiating stack and variables attributes
        stack = new ComplexStack();
        variables = new Variables();
        functions = new ArrayList<>();

        // populating stack and variables attributes
        stack.push(new Complex(1.23, 4.56));
        stack.push(new Complex(1.23, 0.0));
        stack.push(new Complex(0.0, 4.56));
        stack.push(new Complex(-1.23, 4.56));
        stack.push(new Complex(1.23, -4.56));

        try {
            variables.setVariable('a', new Complex(4.56, 7.89));
            variables.setVariable('i', new Complex(0.0, 7.89));
            variables.setVariable('z', new Complex(4.56, 0.0));
        } catch (VariablesNameException ex) {
        }

        Function.setStack(this.stack);
        Function.setVariables(this.variables);
        Function.setFunctions(this.functions);
    }

    /**
     * Test of execute method, of class FunctionCommand.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Test of execute method, of class FunctionCommand with only default operations");

        String name = "function";
        String sequenceString = "+ - dup dup >a";
        Function fc = new Function(name, sequenceString);
        functions.add(fc);
        FunctionCommand instance = new FunctionCommand(fc);
        instance.execute();

        assertEquals(stack.size(), 4);
        assertEquals(variables.getVariable('a'), new Complex(0.0, 4.56));
        assertEquals(stack.peek(), new Complex(0.0, 4.56));
    }

    /**
     * Test of execute method, of class FunctionCommand.
     */
    @Test
    public void testExecuteWithCreatedFunctionCommand() throws Exception {
        System.out.println("Test of execute method, of class FunctionCommand with a user-defined operation");

        Function function1 = new Function("function1", "+ - dup dup >a");
        functions.add(function1);

        // testing using a user-defined function in the string
        String name = "function2";
        String sequenceString = "drop <i function1 +";
        Function function2 = new Function(name, sequenceString);
        Function.setFunctions(functions);

        FunctionCommand instance = new FunctionCommand(function2);
        instance.execute();

        assertEquals(stack.size(), 3);
        assertEquals(stack.peek(), new Complex(2.46, -15.78));
    }

    /**
     * Test of execute method, of class FunctionCommand.
     */
    @Test(expected = Exception.class)
    public void testExecuteWhenThrowsException() throws Exception {
        System.out.println("Test of execute method, of class FunctionCommand when it throws an exception");

        FunctionCommand instance = null;
        String name = "function";
        String sequenceString = "+ - / * drop + +";

        instance = new FunctionCommand(new Function(name, sequenceString));
        instance.execute();
    }

    /**
     * Test of equals method, of class FunctionCommand.
     */
    @Test
    public void testEquals() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("Test of equals method, of class FunctionCommand.");

        FunctionCommand instance = new FunctionCommand(new Function("function", "+ - * /"));

        FunctionCommand function1 = new FunctionCommand(new Function("function1", "dup / drop"));
        FunctionCommand function2 = new FunctionCommand(new Function("function", "+ - * /"));

        assertTrue(instance.equals(instance));
        assertFalse(instance.equals(function1));
        assertTrue(instance.equals(function2));
    }

}

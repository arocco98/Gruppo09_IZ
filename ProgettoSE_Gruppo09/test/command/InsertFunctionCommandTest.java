package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import exceptions.VariablesNameException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettose_gruppo09.Complex;
import progettose_gruppo09.Stack;
import progettose_gruppo09.Variables;

/**
 *
 * @author gruppo09
 */
public class InsertFunctionCommandTest {

    private Stack stack = null;
    private Variables variables = null;
    private ArrayList<FunctionCommand> functionCommands = null;

    @Before
    public void setUp() {
        // instantiating stack and variables attributes
        stack = new Stack();
        variables = new Variables();

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

        ArrayList<Command> sequenceCommands1 = new ArrayList<>();
        sequenceCommands1.add(new SumCommand(stack));
        sequenceCommands1.add(new SubCommand(stack));
        sequenceCommands1.add(new DropCommand(stack));
        FunctionCommand functionCommand1 = new FunctionCommand("function1", "+ - drop", sequenceCommands1);

        ArrayList<Command> sequenceCommands2 = new ArrayList<>();
        sequenceCommands2.add(new DropCommand(stack));
        sequenceCommands2.add(new DropCommand(stack));
        FunctionCommand functionCommand2 = new FunctionCommand("function2", "drop drop", sequenceCommands2);

        functionCommands = new ArrayList<>();
        functionCommands.add(functionCommand1);
        functionCommands.add(functionCommand2);

    }

    /**
     * Test of execute method, of class InsertFunctionCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Execute");

        // adding a new FunctionCommand with valid name and sequence command string
        InsertFunctionCommand instance = new InsertFunctionCommand("function3", "* * <a", functionCommands, stack, variables);
        instance.execute();

        assertEquals(functionCommands.size(), 3);

        ArrayList<Command> sequenceCommands3 = new ArrayList<>();
        sequenceCommands3.add(new ProdCommand(stack));
        sequenceCommands3.add(new ProdCommand(stack));
        sequenceCommands3.add(new OutVariableCommand(stack, variables, 'a'));
        FunctionCommand functionCommand3 = new FunctionCommand("function3", "* * <a", sequenceCommands3);

        assertEquals(functionCommands.get(2), functionCommand3);
    }

    /**
     * Test of execute method, of class InsertFunctionCommand.
     */
    @Test(expected = FunctionNameAlreadyExistsException.class)
    public void testExecuteWhenThrowsFunctionNameAlreadyExistsException() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("Execute when it throws FunctionNameAlreadyExistsException");

        // adding a new FunctionCommand with valid name and sequence command string
        InsertFunctionCommand instance = new InsertFunctionCommand("function2", "* * <a", functionCommands, stack, variables);
        instance.execute();
    }

    /**
     * Test of execute method, of class InsertFunctionCommand.
     */
    @Test(expected = NoMatchFoundException.class)
    public void testExecuteWhenThrowsNoMatchFoundException() throws NoMatchFoundException, FunctionNameAlreadyExistsException {
        System.out.println("Execute when it throws NoMatchFoundException");

        // adding a new FunctionCommand with valid name and sequence command string
        InsertFunctionCommand instance = new InsertFunctionCommand("function3", "sqrrt * <a", functionCommands, stack, variables);
        instance.execute();
    }

}

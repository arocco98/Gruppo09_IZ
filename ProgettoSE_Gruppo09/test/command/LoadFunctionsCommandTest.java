package command;

import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import java.io.File;
import java.io.FileNotFoundException;
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
public class LoadFunctionsCommandTest {

    private ArrayList<FunctionCommand> functions;
    private ArrayList<FunctionCommand> functions2;
    private ArrayList<Command> sequenceCommands;
    private ArrayList<Command> sequenceCommands2;
    private Stack stack;
    private Complex n1;
    private Complex n2;
    private Complex n3;
    private Complex n4;
    private SumCommand sum;
    private SubCommand sub;
    private ProdCommand prod;
    private File file1;
    private Variables variables;

    public LoadFunctionsCommandTest() {
    }

    @Before
    public void setUp() {
        functions = new ArrayList<>();
        functions2 = new ArrayList<>();
        sequenceCommands = new ArrayList<>();
        sequenceCommands2 = new ArrayList<>();
        stack = new Stack();
        n1 = new Complex(1.0, 1.0);
        n2 = new Complex(2.0, 2.0);
        n3 = new Complex(1.0, 1.0);
        n4 = new Complex(1.0, 1.0);
        stack.push(n1);
        stack.push(n2);
        stack.push(n3);
        stack.push(n4);
        sum = new SumCommand(stack);
        sub = new SubCommand(stack);
        prod = new ProdCommand(stack);
        sequenceCommands.add(sum);
        sequenceCommands.add(sub);
        sequenceCommands.add(prod);
        sequenceCommands2.add(sub);
        sequenceCommands2.add(sum);
        sequenceCommands2.add(prod);
        variables = new Variables();
    }

    /**
     * Test of execute method, of class LoadFunctionsCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Load Test");

        file1 = new File("file1");
        FunctionCommand fun1 = new FunctionCommand("op1", "+ - *", sequenceCommands);
        FunctionCommand fun2 = new FunctionCommand("op2", "- + *", sequenceCommands2);
        functions.add(fun1);
        functions.add(fun2);

        SaveFunctionCommands insta = new SaveFunctionCommands(functions, file1);
        insta.execute();

        LoadFunctionsCommand instance = new LoadFunctionsCommand(functions2, stack, variables, file1);
        instance.execute();

        assertTrue(functions2.equals(functions));
    }

    /**
     * Test of execute method, of class LoadFunctionsCommand.
     */
    @Test
    public void testExecute2() throws Exception {
        System.out.println("Load Test2");

        file1 = new File("file1");
        FunctionCommand fun1 = new FunctionCommand("op1", "+ - *", sequenceCommands);
        FunctionCommand fun2 = new FunctionCommand("op2", "- op1 *", sequenceCommands2);
        functions.add(fun1);
        functions.add(fun2);

        SaveFunctionCommands insta = new SaveFunctionCommands(functions, file1);
        insta.execute();

        LoadFunctionsCommand instance = new LoadFunctionsCommand(functions2, stack, variables, file1);
        instance.execute();

        assertTrue(functions2.equals(functions));
    }

    /**
     * Test of execute method, of class LoadFunctionsCommand, that generate an
     * FileNotFoundException
     */
    @Test(expected = FileNotFoundException.class)
    public void testExecute3() throws Exception {
        System.out.println("Load Test 3");

        file1 = new File("file1");
        FunctionCommand fun1 = new FunctionCommand("op1", "+ - *", sequenceCommands);
        FunctionCommand fun2 = new FunctionCommand("op2", "- + *", sequenceCommands2);
        functions.add(fun1);
        functions.add(fun2);

        SaveFunctionCommands insta = new SaveFunctionCommands(functions, file1);
        insta.execute();

        LoadFunctionsCommand instance = new LoadFunctionsCommand(functions2, stack, variables, new File("file2"));
        instance.execute();

    }

    /**
     * Test of execute method, of class LoadFunctionsCommand, that generate an
     * NoMatchFoundException
     */
    @Test(expected = NoMatchFoundException.class)
    public void testExecute4() throws Exception {
        System.out.println("Load Test 4");

        file1 = new File("file1");
        FunctionCommand fun1 = new FunctionCommand("op1", "+ - *", sequenceCommands);
        FunctionCommand fun2 = new FunctionCommand("op2", "- op2 *", sequenceCommands2);
        functions.add(fun1);
        functions.add(fun2);

        SaveFunctionCommands insta = new SaveFunctionCommands(functions, file1);
        insta.execute();

        LoadFunctionsCommand instance = new LoadFunctionsCommand(functions2, stack, variables, file1);
        instance.execute();

    }

    /**
     * Test of execute method, of class LoadFunctionsCommand, that generate an
     * FunctionNameAlreadyExistsException
     */
    @Test(expected = FunctionNameAlreadyExistsException.class)
    public void testExecute5() throws Exception {
        System.out.println("Load Test 5");

        file1 = new File("file1");
        FunctionCommand fun1 = new FunctionCommand("op1", "+ - *", sequenceCommands);
        FunctionCommand fun2 = new FunctionCommand("op1", "- sqrt *", sequenceCommands2);
        functions.add(fun1);
        functions.add(fun2);

        SaveFunctionCommands insta = new SaveFunctionCommands(functions, file1);
        insta.execute();

        LoadFunctionsCommand instance = new LoadFunctionsCommand(functions2, stack, variables, file1);
        instance.execute();

    }

}

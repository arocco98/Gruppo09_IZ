package command;

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
public class FunctionCommandTest {

    private Stack stack = null;
    private Variables variables = null;

    @Before
    public void setUp() {
        // instantiating stack and variables attributes
        stack = new Stack();
        variables = new Variables();

        // populating stack and variables attributes
        stack.add(new Complex(1.23, 4.56));
        stack.add(new Complex(1.23, 0.0));
        stack.add(new Complex(0.0, 4.56));
        stack.add(new Complex(-1.23, 4.56));
        stack.add(new Complex(1.23, -4.56));

        try {
            variables.setVariable('a', new Complex(4.56, 7.89));
            variables.setVariable('i', new Complex(0.0, 7.89));
            variables.setVariable('z', new Complex(4.56, 0.0));
        } catch (VariablesNameException ex) {
        }
    }

    /**
     * Test of execute method, of class FunctionCommand.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("Execute with only default operations");

        FunctionCommand instance = null;
        String name = "function";
        String sequenceString = "+ - dup dup >a";

        ArrayList<Command> sequenceCommands = new ArrayList<>();
        sequenceCommands.add(new SumCommand(stack));
        sequenceCommands.add(new SubCommand(stack));
        sequenceCommands.add(new DupCommand(stack));
        sequenceCommands.add(new DupCommand(stack));
        sequenceCommands.add(new InVariableCommand('a', stack, variables));

        instance = new FunctionCommand(name, sequenceString, sequenceCommands);
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
        System.out.println("Execute with a user-defined operation");

        FunctionCommand instance = null;
        String name = "";
        String sequenceString = "";

        // testing using a user-defined function in the string
        name = "function2";
        sequenceString = "drop <i function1 +";

        ArrayList<Command> sequenceCommands1 = new ArrayList<>();
        sequenceCommands1.add(new SumCommand(stack));
        sequenceCommands1.add(new SubCommand(stack));
        sequenceCommands1.add(new DupCommand(stack));
        sequenceCommands1.add(new DupCommand(stack));
        sequenceCommands1.add(new InVariableCommand('a', stack, variables));

        FunctionCommand function1 = new FunctionCommand("function1", "+ - dup dup >a", sequenceCommands1);

        ArrayList<Command> sequenceCommands2 = new ArrayList<>();
        sequenceCommands2.add(new DropCommand(stack));
        sequenceCommands2.add(new OutVariableCommand(stack, variables, 'i'));
        sequenceCommands2.add(function1);
        sequenceCommands2.add(new SumCommand(stack));

        instance = new FunctionCommand(name, sequenceString, sequenceCommands2);
        instance.execute();

        assertEquals(stack.size(), 3);
        assertEquals(stack.peek(), new Complex(2.46, -15.78));
    }

    /**
     * Test of execute method, of class FunctionCommand.
     */
    @Test(expected = Exception.class)
    public void testExecuteWhenThrowsException() throws Exception {
        System.out.println("Execute test when it throws an exception");

        FunctionCommand instance = null;
        String name = "function";
        String sequenceString = "+ - / * drop + +";

        ArrayList<Command> sequenceCommands = new ArrayList<>();
        sequenceCommands.add(new SumCommand(stack));
        sequenceCommands.add(new SubCommand(stack));
        sequenceCommands.add(new DropCommand(stack));
        sequenceCommands.add(new SumCommand(stack));
        sequenceCommands.add(new SumCommand(stack));

        instance = new FunctionCommand(name, sequenceString, sequenceCommands);
        instance.execute();
    }

    /**
     * Test of getName method, of class FunctionCommand.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");

        FunctionCommand instance = new FunctionCommand("function", "", null);
        String expResult = "function";
        String result = instance.getName();

        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class FunctionCommand.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");

        String name = "function";
        String expResult = "function";
        FunctionCommand instance = new FunctionCommand(name, "", null);

        instance.setName(expResult);

        assertEquals(instance.getName(), expResult);
    }

    /**
     * Test of getSequenceString method, of class FunctionCommand.
     */
    @Test
    public void testGetSequenceString() {
        System.out.println("getSequenceString");

        String sequenceString = "+ - drop dup <a +b";
        String expResult = "+ - drop dup <a +b";
        FunctionCommand instance = new FunctionCommand("function", sequenceString, null);

        assertEquals(instance.getSequenceString(), expResult);
    }

    /**
     * Test of setSequenceString method, of class FunctionCommand.
     */
    @Test
    public void testSetSequenceString() {
        System.out.println("setSequenceString");

        String sequenceString = "* / over -b";
        FunctionCommand instance = new FunctionCommand("function", "+ - + -", null);

        assertNotEquals(instance.getSequenceString(), sequenceString);
        instance.setSequenceString(sequenceString);
        assertEquals(instance.getSequenceString(), sequenceString);
    }

    /**
     * Test of getSequenceCommands method, of class FunctionCommand.
     */
    @Test
    public void testGetSequenceCommands() {
        System.out.println("getSequenceCommands");

        ArrayList<Command> sequenceCommands = new ArrayList<>();
        sequenceCommands.add(new SumCommand(stack));
        sequenceCommands.add(new SubCommand(stack));
        sequenceCommands.add(new DropCommand(stack));
        sequenceCommands.add(new SumCommand(stack));
        sequenceCommands.add(new SumCommand(stack));

        FunctionCommand instance = new FunctionCommand("function", " + - drop + +", sequenceCommands);

        assertEquals(instance.getSequenceCommands(), sequenceCommands);
    }

    /**
     * Test of setSequenceCommands method, of class FunctionCommand.
     */
    @Test
    public void testSetSequenceCommands() {
        System.out.println("setSequenceCommands");

        // creating first array of commands
        ArrayList<Command> sequenceCommands1 = new ArrayList<>();
        sequenceCommands1.add(new SumCommand(stack));
        sequenceCommands1.add(new SubCommand(stack));
        sequenceCommands1.add(new DropCommand(stack));
        sequenceCommands1.add(new SumCommand(stack));
        sequenceCommands1.add(new SumCommand(stack));

        FunctionCommand instance = new FunctionCommand("function", "+ - drop + +", sequenceCommands1);

        // creating second array of commands
        ArrayList<Command> sequenceCommands2 = new ArrayList<>();
        sequenceCommands1.add(new DivCommand(stack));
        sequenceCommands1.add(new ProdCommand(stack));
        sequenceCommands1.add(new SumCommand(stack));

        assertNotEquals(instance.getSequenceCommands(), sequenceCommands2);

        instance.setSequenceCommands(sequenceCommands2);

        assertEquals(instance.getSequenceCommands(), sequenceCommands2);
    }

    /**
     * Test of toString method, of class FunctionCommand.
     */
    @Test
    public void testToString() {
        System.out.println("toString");

        FunctionCommand instance = new FunctionCommand("function", "+ - * /", null);
        String expString = "function: + - * /";

        assertEquals(instance.toString(), expString);
    }

    /**
     * Test of equals method, of class FunctionCommand.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        FunctionCommand instance = new FunctionCommand("function", "+ - * /", null);
        
        FunctionCommand function1 = new FunctionCommand("function1", "dup / drop", null);
        FunctionCommand function2 = new FunctionCommand("function", "+ - * /", null);

        assertTrue(instance.equals(instance));
        assertFalse(instance.equals(function1));
        assertTrue(instance.equals(function2));   
    }
    
}

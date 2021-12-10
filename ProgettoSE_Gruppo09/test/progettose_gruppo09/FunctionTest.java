package progettose_gruppo09;

import command.Command;
import command.DropCommand;
import command.OutVariableCommand;
import command.SubCommand;
import command.SumCommand;
import exceptions.FunctionNameAlreadyExistsException;
import exceptions.NoMatchFoundException;
import exceptions.VariablesNameException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class FunctionTest {

    private ArrayList<Function> functions = null;
    private Stack stack = null;
    private Variables variables = null;

    @Before
    public void setUp() {
        // instantiating functions, stack and variables attributes
        functions = new ArrayList<>();
        stack = new Stack();
        variables = new Variables();

        // setting static variables
        Function.setFunctions(functions);
        Function.setStack(stack);
        Function.setVariables(variables);
        
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
     * Test of generateCommands method, of class Function.
     */
    @Test
    public void testGenerateCommands() throws Exception {
        System.out.println("GenerateCommands");
        
        String sequenceString = "+ - <a drop";
        ArrayList<Command> expectedCommands = new ArrayList<>();
        Command command1 = new SumCommand(stack);
        Command command2 = new SubCommand(stack);
        Command command3 = new OutVariableCommand(stack, variables, 'a');
        Command command4 = new DropCommand(stack);
        expectedCommands.add(command1);
        expectedCommands.add(command2);
        expectedCommands.add(command3);
        expectedCommands.add(command4);
        
        Function instance = new Function("function");
        instance.generateCommands(sequenceString);
        
        ArrayList<Command> generatedCommands = instance.getSequenceCommands();
        assertTrue(generatedCommands.size() == expectedCommands.size());
        int size = generatedCommands.size();
        for(int i = 0; i < size-1; i++) {
            assertTrue(generatedCommands.get(i).equals(expectedCommands.get(i)));
        }
        
    }

    /**
     * Test of generateCommands method, of class Function.
     */
    @Test (expected = NoMatchFoundException.class)
    public void testGenerateCommandsWhenThrowsException() throws Exception {
        System.out.println("GenerateCommands when it throws a NoMatchFoundException");
        
        String sequenceString = "+ - <A drop";
        
        Function instance = new Function("function");
        instance.generateCommands(sequenceString); 
    }
    
    /**
     * Test of isAValidName method, of class Function.
     */
    @Test
    public void testIsAValidName() {
        System.out.println("isAValidName");
        String name = "";
        boolean expResult = false;
        boolean result = Function.isAValidName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Function.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Function instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSequenceString method, of class Function.
     */
    @Test
    public void testGetSequenceString() {
        System.out.println("getSequenceString");
        Function instance = null;
        String expResult = "";
        String result = instance.getSequenceString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSequenceString method, of class Function.
     */
    @Test
    public void testSetSequenceString() throws Exception {
        System.out.println("setSequenceString");
        String sequenceString = "+ - / *";
        Function instance = new Function("function", "+ -");
        assertNotEquals(instance.getSequenceString(), sequenceString);
        instance.setSequenceString(sequenceString);
        assertEquals(instance.getSequenceString(), sequenceString);
    }

    /**
     * Test of getSequenceCommands method, of class Function.
     * @throws exceptions.FunctionNameAlreadyExistsException
     * @throws exceptions.NoMatchFoundException
     */
    @Test
    public void testGetSequenceCommands() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("getSequenceCommands");
        Function instance = new Function("function", "+ - / *");
        ArrayList<Command> expResult = null;
        ArrayList<Command> result = instance.getSequenceCommands();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of toString method, of class Function.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Function instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Function.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Function instance = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

package progettose_gruppo09;

import command.Command;
import command.DivCommand;
import command.DropCommand;
import command.OutVariableCommand;
import command.ProdCommand;
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
    private ComplexStack stack = null;
    private Variables variables = null;

    @Before
    public void setUp() {
        // instantiating functions, stack and variables attributes
        functions = new ArrayList<>();
        stack = new ComplexStack();
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
        System.out.println("Test of generateCommands method, of class Function.");

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
        // checking if the just created array has the size we expect
        assertTrue(generatedCommands.size() == expectedCommands.size());
        // checking if all the elements of the arrays are equals to each other
        assertEquals(generatedCommands, expectedCommands);

    }

    /**
     * Test of generateCommands method, of class Function, when it throws a
     * NoMatchFoundException.
     */
    @Test(expected = NoMatchFoundException.class)
    public void testGenerateCommandsWhenThrowsException() throws Exception {
        System.out.println("Test of generateCommands method, of class Function, when it throws a NoMatchFoundException.");

        String sequenceString = "+ - notExistingFunction drop";

        Function instance = new Function("function");
        instance.generateCommands(sequenceString);
    }

    /**
     * Test of isAValidName method, of class Function.
     */
    @Test
    public void testIsAValidName() {
        System.out.println("Test of isAValidName method, of class Function.");

        // expected false because the name is empty
        String name = "";
        boolean expResult = false;
        boolean result = Function.isAValidName(name);
        assertEquals(expResult, result);

        // expected false because the name contains more than one word
        name = "two words";
        expResult = false;
        result = Function.isAValidName(name);
        assertEquals(expResult, result);

        // expected false because the name is a basic operation name
        name = "drop";
        expResult = false;
        result = Function.isAValidName(name);
        assertEquals(expResult, result);

        // expected false because the name is a basic operation name
        name = "<a";
        expResult = false;
        result = Function.isAValidName(name);
        assertEquals(expResult, result);

        // expected true because the name is a valid function name
        name = "function";
        expResult = true;
        result = Function.isAValidName(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Function.
     */
    @Test
    public void testGetName() throws FunctionNameAlreadyExistsException {
        System.out.println("Test of getName method, of class Function.");

        Function instance = new Function("function");
        String expResult = "function";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSequenceString method, of class Function.
     */
    @Test
    public void testGetSequenceString() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("Test of getSequenceString method, of class Function.");

        Function instance = new Function("function", "clear 3.14 + sqrt");
        String expResult = "clear 3.14 + sqrt";
        String result = instance.getSequenceString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSequenceString method, of class Function.
     */
    @Test
    public void testSetSequenceString() throws Exception {
        System.out.println("Test of setSequenceString method, of class Function.");

        String sequenceString = "+ - / *";
        Function instance = new Function("function", "+ -");
        // expected not equals because the instance has the operations "+ -"
        assertNotEquals(instance.getSequenceString(), sequenceString);
        instance.setSequenceString(sequenceString);
        // expected equals because now the function has the same operations as the sequenceStirng attribute
        assertEquals(instance.getSequenceString(), sequenceString);
    }

    /**
     * Test of getSequenceCommands method, of class Function.
     *
     * @throws exceptions.FunctionNameAlreadyExistsException
     * @throws exceptions.NoMatchFoundException
     */
    @Test
    public void testGetSequenceCommands() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("Test of getSequenceCommands method, of class Function.");

        Function instance = new Function("function", "+ - * /");
        ArrayList<Command> expResult = new ArrayList<>();
        expResult.add(new SumCommand(stack));
        expResult.add(new SubCommand(stack));
        expResult.add(new ProdCommand(stack));
        expResult.add(new DivCommand(stack));

        ArrayList<Command> result = instance.getSequenceCommands();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Function.
     */
    @Test
    public void testToString() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("Test of toString method, of class Function.");

        Function instance = new Function("function", "<i -b over dup");
        String expResult = "function";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Function.
     *
     * @throws exceptions.FunctionNameAlreadyExistsException
     * @throws exceptions.NoMatchFoundException
     */
    @Test
    public void testEquals() throws FunctionNameAlreadyExistsException, NoMatchFoundException {
        System.out.println("Test of equals method, of class Function.");

        Function instance = new Function("function1", "+ +z * drop");
        Function other = new Function("differentFunction", "clear 1.23+4.56j dup *");

        // expecting false because the other function has a different name
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);

        // expected true because we are comparing the same object
        expResult = true;
        result = instance.equals(instance);
        assertEquals(expResult, result);
    }

}

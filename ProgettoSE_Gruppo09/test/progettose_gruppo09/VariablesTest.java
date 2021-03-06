package progettose_gruppo09;

import exceptions.VariablesNameException;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class VariablesTest {

    /**
     * Test of getVariables method, of class Variables.
     */
    @Test
    public void testGetVariables() {
        System.out.println("Test of getVariables method, of class Variables.");
        // instantiating variables
        Variables instance = new Variables();
        HashMap<Character, Complex> expResult = new HashMap<>();
        for (char character = 'a'; character <= 'z'; character++) {
            expResult.put(character, null);
        }

        // populating variables
        try {
            instance.setVariable('i', new Complex(1.2, 3.4));
        } catch (VariablesNameException ex) {
        }

        HashMap<Character, Complex> result = instance.getVariables();
        // Expected not equals
        assertNotEquals(expResult, result);

        expResult.put('i', new Complex(1.2, 3.4));
        // expected equals 
        assertEquals(expResult, result);

        for (char character = 'a'; character <= 'z'; character++) {
            try {
                instance.setVariable(character, new Complex(1.2, 3.4));
                expResult.put(character, new Complex(1.2, 3.4));
            } catch (VariablesNameException ex) {
            }
        }

        result = instance.getVariables();
        // expected equals
        assertEquals(expResult, result);
    }

    /**
     * Test of getVariable method, of class Variables.
     */
    @Test
    public void testGetVariable() {
        System.out.println("Test of getVariable method, of class Variables.");

        Variables instance = new Variables();
        Complex expResult = null;
        Complex result = null;
        try {
            result = instance.getVariable('a');
        } catch (VariablesNameException ex) {
        }
        // expected null
        assertEquals(expResult, result);

        try {
            instance.setVariable('a', new Complex(1.2, 3.4));
            result = instance.getVariable('a');
        } catch (VariablesNameException ex) {
        }

        expResult = new Complex(1.2, 3.4);

        // expected equals
        assertEquals(expResult, result);
    }

    /**
     * Test of getVariable method, of class Variables, when it throws an
     * exception.
     */
    @Test(expected = VariablesNameException.class)
    public void testGetVariableThrowsException() throws VariablesNameException {
        System.out.println("Test of getVariable method, of class Variables, when it throws an exception.");

        Variables instance = new Variables();
        instance.getVariable('A');
    }

    /**
     * Test of setVariable method, of class Variables.
     */
    @Test
    public void testSetVariable() {
        System.out.println("Test of setVariable method, of class Variables.");

        Complex complex = null;
        Variables instance = new Variables();
        try {
            instance.setVariable('i', complex);
        } catch (VariablesNameException ex) {
        }

        Complex result = null;
        try {
            result = instance.getVariable('i');
        } catch (VariablesNameException ex) {
        }

        // expected equals
        assertEquals(result, complex);

        complex = new Complex(1.2, 3.4);
        try {
            instance.setVariable('i', complex);
            result = instance.getVariable('i');
        } catch (VariablesNameException ex) {
        }

        // expected equals
        assertEquals(result, complex);
    }

    /**
     * Test of setVariable method, of class Variables, when it throws an
     * exception.
     */
    @Test(expected = VariablesNameException.class)
    public void testSetVariableThrowsException() throws VariablesNameException {
        System.out.println("Test of setVariable method, of class Variables, when it throws an exception.");

        Variables instance = new Variables();
        instance.setVariable('A', new Complex(1.2, 3.4));
    }

    /**
     * Test of toString method, of class Variables.
     */
    @Test
    public void testToString() {
        System.out.println("Test of toString method, of class Variables.");

        Variables instance = new Variables();
        String expResult = "";
        for (char character = 'a'; character <= 'z'; character++) {
            expResult += character + ": " + "null\n";
        }
        String result = instance.toString();
        // expected equals
        assertEquals(expResult, result);

        Complex complex = new Complex(1.2, 3.4);
        try {
            instance.setVariable('a', complex);
        } catch (VariablesNameException ex) {
        }
        expResult = "a: " + complex + "\n";

        for (char character = 'b'; character <= 'z'; character++) {
            expResult += character + ": " + "null\n";
        }

        result = instance.toString();
        // expected equals
        assertEquals(expResult, result);
    }

}

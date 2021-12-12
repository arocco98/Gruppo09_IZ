package progettose_gruppo09;

import exceptions.VariablesNameException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class VariablesStackTest {

    private VariablesStack instance;
    private Variables variables1;
    private Variables variables2;
    private Variables variables3;
    private Complex c1;
    private Complex c2;
    private Complex c3;

    @Before
    public void setUp() throws VariablesNameException {
        instance = new VariablesStack();
        variables1 = new Variables();
        variables2 = new Variables();
        variables3 = new Variables();
        c1 = new Complex(1.23, 4.56);
        c2 = new Complex(1.23, 0.0);
        c3 = new Complex(0.0, 4.56);
        variables1.setVariable('a', c1);
        variables2.setVariable('b', c2);
        variables3.setVariable('c', c3);
    }

    /**
     * Test of push method, of class VariablesStack.
     */
    @Test
    public void testPush() {
        System.out.println("Test of push method, of class VariablesStack.");

        instance.push(variables1);
        instance.push(variables2);
        instance.push(variables3);
        assertEquals(variables1, instance.get(0));
        assertEquals(variables2, instance.get(1));
        assertEquals(variables3, instance.get(2));
    }

    /**
     * Test of pop method, of class VariablesStack.
     */
    @Test
    public void testPop() throws VariablesNameException {
        System.out.println("Test of pop method, of class VariablesStack.");

        Variables expResult = new Variables();
        expResult.setVariable('c', c3);
        instance.push(variables1);
        instance.push(variables2);
        instance.push(variables3);
        Variables result = instance.pop();
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class VariablesStack.
     */
    @Test
    public void testPeek() throws VariablesNameException {
        System.out.println("Test of peek method, of class VariablesStack.");

        Variables expResult = new Variables();
        expResult.setVariable('c', c3);
        instance.push(variables1);
        instance.push(variables2);
        instance.push(variables3);
        Variables result = instance.peek();
        assertEquals(expResult, result);
    }

}

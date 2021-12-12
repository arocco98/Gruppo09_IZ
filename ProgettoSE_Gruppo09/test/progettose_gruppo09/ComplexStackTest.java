package progettose_gruppo09;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class ComplexStackTest {

    private ComplexStack instance;

    @Before
    public void setUp() {
        instance = new ComplexStack();
    }

    /**
     * Test of Push method, of class ComplexStack.
     */
    @Test
    public void testPush() {
        System.out.println("Test of Push method, of class ComplexStack.");

        Complex a = new Complex(1.0, 2.0);
        instance.push(a);
        assertEquals(a, instance.get(instance.size() - 1));
    }

    /**
     * Test of Pop method, of class ComplexStack.
     */
    @Test
    public void testPop() {
        System.out.println("Test of Pop method, of class ComplexStack.");

        Complex expResult = null;
        Complex result = instance.pop();
        assertEquals(expResult, result);

        Complex a = new Complex(1.0, 2.0);
        instance.push(a);
        Complex expResult1 = a;
        Complex result1 = instance.pop();
        assertEquals(expResult1, result1);
    }

    /**
     * Test of Peek method, of class ComplexStack.
     */
    @Test
    public void testPeek() {
        System.out.println("Test of Peek method, of class ComplexStack.");

        Complex expResult = null;
        Complex result = instance.peek();
        assertEquals(expResult, result);

        Complex a = new Complex(1.0, 2.0);
        instance.push(a);
        Complex expResult1 = a;
        Complex result1 = instance.peek();
        assertEquals(expResult1, result1);
    }

    /**
     * Test of toString method, of class ComplexStack.
     */
    @Test
    public void testToString() {
        System.out.println("Test of toString method, of class ComplexStack.");

        Complex a = new Complex(2.0, 2.0);
        Complex b = new Complex(1.0, 2.0);
        instance.push(a);
        instance.push(b);
        String expResult = "1.0+2.0j" + "\n" + "2.0+2.0j" + "\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}

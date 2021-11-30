package progettose_gruppo09;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class StackTest {

    private Stack instance;

    @Before
    public void setUp() {
        instance = new Stack();
    }

    public StackTest() {
    }

    /**
     * Test of Push method, of class Stack.
     */
    @Test
    public void testPush() {
        System.out.println("Push");
        Complex a = new Complex(1.0, 2.0);
        instance.push(a);
        assertEquals(a, instance.get(instance.size() - 1));
    }

    /**
     * Test of Pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("Pop");
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
     * Test of Peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("Peek");
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
     * Test of toString method, of class Stack.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Complex a = new Complex(2.0, 2.0);
        Complex b = new Complex(1.0, 2.0);
        instance.push(a);
        instance.push(b);
        String expResult = "1.0+2.0j" + "\n" + "2.0+2.0j" + "\n";
        String result = instance.toString();
        System.out.println(result);
        assertEquals(expResult, result);
    }

}
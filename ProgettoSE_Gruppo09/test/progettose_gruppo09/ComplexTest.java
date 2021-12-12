package progettose_gruppo09;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class ComplexTest {

    private Complex c1;

    @Before
    public void setUp() {
        c1 = new Complex(1.2, 5.6);
    }

    /**
     * Test of Constructor method, of class Complex.
     */
    @Test
    public void testComplex() {
        System.out.println("Test of Constructor method, of class Complex.");

        Complex c2 = new Complex(7.4, 6.2);

        assertTrue(c2.getReal() == 7.4);
        assertTrue(c2.getImaginary() == 6.2);

        Complex c3 = new Complex(-2.8);

        assertTrue(c3.getReal() == -2.8);
        assertTrue(c3.getImaginary() == 0.0);
    }

    /**
     * Test of getReal method, of class Complex.
     */
    @Test
    public void testGetReal() {
        System.out.println("Test of getReal method, of class Complex.");

        double expResult = 1.2;
        assertEquals(expResult, c1.getReal(), 0.0);
    }

    /**
     * Test of setReal method, of class Complex.
     */
    @Test
    public void testSetReal() {
        System.out.println("Test of setReal method, of class Complex.");

        double real = 4.7;
        c1.setReal(real);
        assertEquals(real, c1.getReal(), 0.0);
    }

    /**
     * Test of getImaginary method, of class Complex.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("Test of getImaginary method, of class Complex.");

        double imaginary = 5.6;
        assertEquals(imaginary, c1.getImaginary(), 0.0);
    }

    /**
     * Test of setImaginary method, of class Complex.
     */
    @Test
    public void testSetImaginary() {
        System.out.println("Test of setImaginary method, of class Complex.");

        double imaginary = -5.40;
        c1.setImaginary(imaginary);
        assertEquals(imaginary, c1.getImaginary(), 0.0);
    }

    /**
     * Test of equals method, of class Complex.
     */
    @Test
    public void testEquals() {
        System.out.println("Test of equals method, of class Complex.");

        Object obj = null;
        boolean expResult1 = false;
        boolean result1 = c1.equals(obj);
        assertEquals(expResult1, result1);

        Complex c2 = new Complex(1.2, 5.6);
        boolean expResult2 = true;
        boolean result2 = c1.equals(c2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        System.out.println("Test of toString method, of class Complex.");

        String result = c1.toString();
        String expResult = "1.2+5.6j";
        assertEquals(expResult, result);
    }

}

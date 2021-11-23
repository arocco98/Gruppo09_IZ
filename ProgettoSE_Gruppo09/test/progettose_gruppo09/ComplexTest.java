/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
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
        double expResult = 1.2;
        assertEquals(expResult, c1.getReal(), 0.0);
    }
    
    /**
     * Test of setReal method, of class Complex.
     */
    @Test
    public void testSetReal() {
        double real = 4.7;
        c1.setReal(real);
        assertEquals(real, c1.getReal(), 0.0);
    }

    /**
     * Test of getImaginary method, of class Complex.
     */
    @Test
    public void testGetImaginary() {
        double expResult = 5.6;
        assertEquals(expResult, c1.getImaginary(), 0.0);        
    }

    /**
     * Test of setImaginary method, of class Complex.
     */
    @Test
    public void testSetImaginary() {
        double imaginary = -5.40;
        c1.setImaginary(imaginary);
         assertEquals(imaginary, c1.getImaginary(), 0.0);
    }

    /**
     * Test of equals method, of class Complex.
     */
    @Test
    public void testEquals() {
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
        String result = c1.toString();
        String expResult = "1.2+5.6j";
        assertEquals(expResult, result);
    }
    
}

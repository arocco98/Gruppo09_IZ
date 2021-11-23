/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package progettose_gruppo09;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class ComplexOperationsTest {

    @Test
    public void testComplexSum(){
        Complex a = new Complex(4.0, 2.0);
        Complex b = new Complex(3.0, 1.0);
        Complex expected = new Complex(7.0, 3.0);
        assertEquals(expected, ComplexOperations.complexSum(a, b));
    }  
    @Test
    public void testComplexProd(){

        Complex a = new Complex(4.0, 2.0);
        Complex b = new Complex(3.0, 1.0);
        Complex expected = new Complex(10.0, 10.0);
        assertEquals(expected, ComplexOperations.complexProd(a, b));

        Complex c = new Complex(0.0, 2.0);
        Complex d = new Complex(3.0, 1.0);
        Complex expected2 = new Complex(-2.0, 6.0);
        assertEquals(expected2, ComplexOperations.complexProd(c, d));

        Complex e = new Complex(4.0, 2.0);
        Complex f = new Complex(3.0, 0.0);
        Complex expected3 = new Complex(12.0, 6.0);
        assertEquals(expected3, ComplexOperations.complexProd(e, f));

        Complex g = new Complex(-4.0, 2.0);
        Complex h = new Complex(3.0, 7.0);
        Complex expected4 = new Complex(-26.0, -22.0);
        assertEquals(expected4, ComplexOperations.complexProd(g, h));

        Complex i = new Complex(4.0, 2.0);
        Complex l = new Complex(3.0, -3.0);
        Complex expected5 = new Complex(18.0, -6.0);
        assertEquals(expected5, ComplexOperations.complexProd(i, l));

        Complex m = new Complex(7.0, -2.0);
        Complex n = new Complex(-3.0, 4.0);
        Complex expected6 = new Complex(-13.0, 34.0);
        assertEquals(expected6, ComplexOperations.complexProd(m, n));

    } 

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

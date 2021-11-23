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
        Complex a = new Complex(4.1, 2.0);
        Complex b = new Complex(3.2, 1.0);
        Complex expected = new Complex(7.3, 3.0);
        assertEquals(expected, ComplexOperations.complexSum(a, b));
    }  

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

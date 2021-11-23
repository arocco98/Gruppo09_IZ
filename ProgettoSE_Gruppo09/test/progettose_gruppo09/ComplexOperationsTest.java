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
        
        //This case is used to test that the sum between two numbers with
        //real part and imaginary part equal and opposite sign gives zero 
        assertEquals(new Complex(0.0, 0.0), ComplexOperations.complexSum(new Complex(4.0, 2.0), new Complex(-4.0, -2.0)));
        
        //This case is used to test that the sum between two positive
        //numbers with imaginary part equal to zero 
        assertEquals(new Complex(15.0, 0.0), ComplexOperations.complexSum(new Complex(8.0, 0.0), new Complex(7.0, 0.0)));
        
        //This case is used to test that the sum between two positive 
        //numbers with real part equal to zero 
        assertEquals(new Complex(0.0, 20.0), ComplexOperations.complexSum(new Complex(0.0, 17.0), new Complex(0.0, 3.0)));
        
        //This case is used to test that the sum between two numbers with
        //imaginary part equal to zero and real part with opposite sign 
        assertEquals(new Complex(-19.0, 0.0), ComplexOperations.complexSum(new Complex(4.0, 0.0), new Complex(-23.0, 0.0)));
        
        //This case is used to test that the sum between two numbers with
        //real part equal to zero and imaginary part with opposite sign 
        assertEquals(new Complex(0.0, -16.0), ComplexOperations.complexSum(new Complex(0.0, -20.0), new Complex(0.0, 4.0)));
        
        //This case is used to test that the sum between two positive numbers with the first
        //having imaginary part equal to zero and the second having real part equal to zero
        assertEquals(new Complex(14.0, 35.0), ComplexOperations.complexSum(new Complex(14.0, 0.0), new Complex(0.0, 35.0)));
        
        //This case is used to test that the sum between two positive numbers with the first
        //having real part equal to zero and the second having imaginary part equal to zero 
        assertEquals(new Complex(32.0, 46.0), ComplexOperations.complexSum(new Complex(0.0, 46.0), new Complex(32.0, 0.0)));
        
        //This case is used to test that the sum between two negative numbers with the first
        //having imaginary part equal to zero and the second having real part equal to zero
        assertEquals(new Complex(-14.0, -35.0), ComplexOperations.complexSum(new Complex(-14.0, 0.0), new Complex(0.0, -35.0)));
        
        //This case is used to test that the sum between two negative numbers with the first
        //having real part equal to zero and the second having imaginary part equal to zero
        assertEquals(new Complex(-32.0, -46.0), ComplexOperations.complexSum(new Complex(0.0, -46.0), new Complex(-32.0, 0.0)));
        
        //This case is used to test that the sum between two positive numbers with
        //real part and imaginary part having decimal 
        assertEquals(new Complex(12.1, 7.8), ComplexOperations.complexSum(new Complex(11.6, 7.0), new Complex(0.5, 0.8)));
                
        //This case is used to test that the sum between a negative number and
        //a positive one with real part and imaginary part having decimal
        assertEquals(new Complex(-11.1, -6.2), ComplexOperations.complexSum(new Complex(-11.6, -7.0), new Complex(0.5, 0.8)));
    }  

    
}

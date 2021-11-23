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

    @Test
    public void testComplexSub(){
        
        double result = 0;
        double result2 = 0;
        
        //sub with positive real part ≠0 and immag part =0 
        Complex a = new Complex(4.0, 0.0);
        Complex b = new Complex(3.0, 0.0);
        Complex expected = new Complex(1.0, 0.0);
        assertEquals(expected, ComplexOperations.complexSub(a, b));
        
        //sub with real part =0 and positive immag part ≠0 
        Complex a1 = new Complex(0.0, 2.0);
        Complex b1 = new Complex(0.0, 1.0);
        Complex expected1 = new Complex(0.0, 1.0);
        assertEquals(expected1, ComplexOperations.complexSub(a1, b1));
        
        //sub with positive real part ≠0 and positive immag part ≠0 
        Complex a2 = new Complex(3.0, 7.0);
        Complex b2 = new Complex(1.0, 4.0);
        Complex expected2 = new Complex(2.0, 3.0);
        assertEquals(expected2, ComplexOperations.complexSub(a2, b2));
        
        //sub with real part =0 and positive immag part ≠0 but the result should be with negative immag part
        Complex a3 = new Complex(0.0, 4.0);
        Complex b3 = new Complex(0.0, 5.0);
        Complex expected3 = new Complex(0.0, -1.0);
        assertEquals(expected3, ComplexOperations.complexSub(a3, b3));
        
        //sub with real positive part ≠0 and immag part =0 but the result should be with negative real part
        Complex a4 = new Complex(3.0, 0.0);
        Complex b4 = new Complex(7.0, 0.0);
        Complex expected4 = new Complex(-4.0, 0.0);
        assertEquals(expected4, ComplexOperations.complexSub(a4, b4));
        
        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with negative real part and positive immag part
        Complex a5 = new Complex(3.0, 4.0);
        Complex b5 = new Complex(7.0, 2.0);
        Complex expected5 = new Complex(-4.0, 2.0);
        assertEquals(expected5, ComplexOperations.complexSub(a5, b5));
        
        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with positive real part and negative immag part
        Complex a6 = new Complex(10.0, 1.0);
        Complex b6 = new Complex(7.0, 8.0);
        Complex expected6 = new Complex(3.0, -7.0);
        assertEquals(expected6, ComplexOperations.complexSub(a6, b6));
        
        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with negative real part and negative immag part
        Complex a7 = new Complex(4.0, 1.0);
        Complex b7 = new Complex(7.0, 8.0);
        Complex expected7 = new Complex(-3.0, -7.0);
        assertEquals(expected7, ComplexOperations.complexSub(a7, b7));
        
        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with negative real part, with decimal part, and negative immag part
        Complex a8 = new Complex(4.1, 1.0);
        Complex b8 = new Complex(7.2, 8.0);
        result = 4.1 - 7.2;
        Complex expected8 = new Complex(result, -7.0);
        assertEquals(expected8.getReal(), ComplexOperations.complexSub(a8, b8).getReal(),0);
        
        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with positive real part, with decimal part, and positive immag part
        Complex a9 = new Complex(10.2, 8.0);
        Complex b9 = new Complex(7.1, 1.0);
        result = 10.2 - 7.1;
        Complex expected9 = new Complex(result, 7.0);
        assertEquals(expected9, ComplexOperations.complexSub(a9, b9));
        
        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with negative real part, with decimal part, and positive immag part, with decimal part
        Complex a10 = new Complex(4.1, 8.2);
        Complex b10 = new Complex(7.2, 1.1);
        result = 4.1 - 7.2;
        result2 = 8.2 - 1.1;
        Complex expected10 = new Complex(result, result2);
        assertEquals(expected10, ComplexOperations.complexSub(a10, b10));
        
        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with positive real part, with decimal part, and negative immag part, with decimal part
        Complex a11 = new Complex(10.2, 1.2);
        Complex b11 = new Complex(7.1, 7.1);
        result = 10.2 - 7.1;
        result2 = 1.2 - 7.1;
        Complex expected11 = new Complex(result, result2);
        assertEquals(expected11, ComplexOperations.complexSub(a11, b11));
    } 
    
    @Test
    public void testComplexDiv(){

        Complex a = new Complex(4.0, 2.0);
        Complex b = new Complex(3.0, 1.0);
        Complex expected = new Complex(1.4, 0.2);
        assertEquals(expected, ComplexOperations.complexDiv(a, b));

        Complex c = new Complex(0.0, 2.0);
        Complex d = new Complex(3.0, 1.0);
        Complex expected2 = new Complex(0.2, 0.6);
        assertEquals(expected2, ComplexOperations.complexDiv(c, d));

        Complex e = new Complex(4.0, 2.0);
        Complex f = new Complex(3.0, 0.0);
        Complex expected3 = new Complex(1.33, 0.66);
        assertEquals(expected3, ComplexOperations.complexDiv(e, f));

        Complex g = new Complex(-4.0, 2.0);
        Complex h = new Complex(3.0, 7.0);
        Complex expected4 = new Complex(0.03, -0.58);
        assertEquals(expected4, ComplexOperations.complexDiv(g, h));

        Complex i = new Complex(4.0, 2.0);
        Complex l = new Complex(3.0, -3.0);
        Complex expected5 = new Complex(0.33, 1.0);
        assertEquals(expected5, ComplexOperations.complexDiv(i, l));

        Complex m = new Complex(7.0, -2.0);
        Complex n = new Complex(-3.0, 4.0);
        Complex expected6 = new Complex(1.16, 1.36);
        assertEquals(expected6, ComplexOperations.complexDiv(m, n));

    } 
}

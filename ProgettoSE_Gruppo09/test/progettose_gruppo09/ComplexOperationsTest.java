package progettose_gruppo09;

import exceptions.OperationDenied;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo09
 */
public class ComplexOperationsTest {

    /**
     * Test of complexSum method, of class Complex.
     */
    @Test
    public void testComplexSum() {

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

    /**
     * Test of complexSub method, of class Complex.
     */
    @Test
    public void testComplexSub() {

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
        Complex expected8 = new Complex(-3.1, -7.0);
        assertEquals(expected8.getReal(), ComplexOperations.complexSub(a8, b8).getReal(), 0);

        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with positive real part, with decimal part, and positive immag part
        Complex a9 = new Complex(10.2, 8.0);
        Complex b9 = new Complex(7.1, 1.0);
        Complex expected9 = new Complex(3.1, 7.0);
        assertEquals(expected9, ComplexOperations.complexSub(a9, b9));

        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with negative real part, with decimal part, and positive immag part, with decimal part
        Complex a10 = new Complex(4.1, 8.2);
        Complex b10 = new Complex(7.2, 1.1);
        Complex expected10 = new Complex(-3.1, 7.1);
        assertEquals(expected10, ComplexOperations.complexSub(a10, b10));

        //sub with real positive part ≠0 and immag positive part ≠0 but the result should be with positive real part, with decimal part, and negative immag part, with decimal part
        Complex a11 = new Complex(10.2, 1.2);
        Complex b11 = new Complex(7.1, 7.1);
        Complex expected11 = new Complex(3.1, -5.9);
        assertEquals(expected11, ComplexOperations.complexSub(a11, b11));
    }

    /**
     * Test of complexProd method, of class Complex.
     */
    @Test
    public void testComplexProd() {

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

    /**
     * Test of complexDiv method, of class Complex.
     */
    @Test
    public void testComplexDiv() {

        assertEquals(new Complex(1.4, 0.2), ComplexOperations.complexDiv(new Complex(4.0, 2.0), new Complex(3.0, 1.0)));

        assertEquals(new Complex(0.2, 0.6), ComplexOperations.complexDiv(new Complex(0.0, 2.0), new Complex(3.0, 1.0)));

        assertEquals(new Complex(1.3333333, 0.6666667), ComplexOperations.complexDiv(new Complex(4.0, 2.0), new Complex(3.0, 0.0)));

        assertEquals(new Complex(0.0344828, 0.5862069), ComplexOperations.complexDiv(new Complex(-4.0, 2.0), new Complex(3.0, 7.0)));

        assertEquals(new Complex(0.3333333, 1.0), ComplexOperations.complexDiv(new Complex(4.0, 2.0), new Complex(3.0, -3.0)));

        assertEquals(new Complex(-1.16, -0.88), ComplexOperations.complexDiv(new Complex(7.0, -2.0), new Complex(-3.0, 4.0)));

    }

    /**
     * Test of sqrt method, of class Complex.
     */
    @Test
    public void testSqrt() {

        //sqrt of number with positive real part and positive immag. part
        assertEquals(new Complex(1.0986841, 0.4550899), ComplexOperations.sqrt(new Complex(1.0, 1.0)));

        //sqrt of number with negative real part and negative immag. part
        assertEquals(new Complex(0.4550899, -1.0986841), ComplexOperations.sqrt(new Complex(-1.0, -1.0)));

        //sqrt of number with negative real part and positive immag. part
        assertEquals(new Complex(0.4550899, 1.0986841), ComplexOperations.sqrt(new Complex(-1.0, 1.0)));

        //sqrt of number with positive real part and negative immag. part
        assertEquals(new Complex(1.0986841, -0.4550899), ComplexOperations.sqrt(new Complex(1.0, -1.0)));

        //sqrt of number,with decimal part, with positive real part and positive immag. part
        assertEquals(new Complex(1.6853046, 0.8603786), ComplexOperations.sqrt(new Complex(2.1, 2.9)));

        //sqrt of number,with decimal part, with negative real part and negative immag. part
        assertEquals(new Complex(0.8603787, -1.6853045), ComplexOperations.sqrt(new Complex(-2.1, -2.9)));

        //sqrt of number,with decimal part, with negative real part and positive immag. part
        assertEquals(new Complex(0.8603787, 1.6853045), ComplexOperations.sqrt(new Complex(-2.1, 2.9)));

        //sqrt of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(1.6853046, -0.8603786), ComplexOperations.sqrt(new Complex(2.1, -2.9)));

        //sqrt of number 0
        assertEquals(new Complex(0.0, 0.0), ComplexOperations.sqrt(new Complex(0.0, 0.0)));
    }

    /**
     * Test of mod method, of class Complex.
     */
    @Test
    public void testMod() {

        //mod of number with positive real part and positive immag. part
        assertEquals(1.4142136, ComplexOperations.mod(new Complex(1.0, 1.0)), 0);

        //mod of number with negative real part and negative immag. part
        assertEquals(1.4142136, ComplexOperations.mod(new Complex(-1.0, -1.0)), 0);

        //mod of number with negative real part and positive immag. part
        assertEquals(1.4142136, ComplexOperations.mod(new Complex(-1.0, 1.0)), 0);

        //mod of number with positive real part and negative immag. part
        assertEquals(1.4142136, ComplexOperations.mod(new Complex(1.0, -1.0)), 0);

        //mod of number,with decimal part, with positive real part and positive immag. part
        assertEquals(3.5805028, ComplexOperations.mod(new Complex(2.1, 2.9)), 0);

        //mod of number,with decimal part, with negative real part and negative immag. part
        assertEquals(3.5805028, ComplexOperations.mod(new Complex(-2.1, -2.9)), 0);

        //mod of number,with decimal part, with negative real part and positive immag. part
        assertEquals(3.5805028, ComplexOperations.mod(new Complex(-2.1, 2.9)), 0);

        //mod of number,with decimal part, with positive real part and negative immag. part
        assertEquals(3.5805028, ComplexOperations.mod(new Complex(2.1, -2.9)), 0);

        //mod of number 0
        assertEquals(0.0, ComplexOperations.mod(new Complex(0.0, 0.0)), 0);

    }

    /**
     * Test of arg method, of class Complex.
     */
    @Test
    public void testArg() {

        //arg of number with positive real part and positive immag. part
        assertEquals(0.7853982, ComplexOperations.arg(new Complex(1.0, 1.0)), 0);

        //arg of number with negative real part and negative immag. part
        assertEquals(-2.3561945, ComplexOperations.arg(new Complex(-1.0, -1.0)), 0);

        //arg of number with negative real part and positive immag. part
        assertEquals(2.3561945, ComplexOperations.arg(new Complex(-1.0, 1.0)), 0);

        //arg of number with positive real part and negative immag. part
        assertEquals(-0.7853982, ComplexOperations.arg(new Complex(1.0, -1.0)), 0);

        //arg of number,with decimal part, with positive real part and positive immag. part
        assertEquals(0.9440534, ComplexOperations.arg(new Complex(2.1, 2.9)), 0);

        //arg of number,with decimal part, with negative real part and negative immag. part
        assertEquals(-2.1975392, ComplexOperations.arg(new Complex(-2.1, -2.9)), 0);

        //arg of number,with decimal part, with negative real part and positive immag. part
        assertEquals(2.1975392, ComplexOperations.arg(new Complex(-2.1, 2.9)), 0);

        //arg of number,with decimal part, with positive real part and negative immag. part
        assertEquals(-0.9440534, ComplexOperations.arg(new Complex(2.1, -2.9)), 0);

        //arg of number 0
        assertEquals(0.0, ComplexOperations.arg(new Complex(0.0, 0.0)), 0);

    }

    /**
     * Test of exp method, of class Complex.
     */
    @Test
    public void testExp() {

        //exp of number with positive real part and positive immag. part
        assertEquals(new Complex(1.4686939, 2.2873553), ComplexOperations.exp(new Complex(1.0, 1.0)));

        //exp of number with negative real part and negative immag. part
        assertEquals(new Complex(0.1987661, -0.3095599), ComplexOperations.exp(new Complex(-1.0, -1.0)));

        //exp of number with negative real part and positive immag. part
        assertEquals(new Complex(0.1987661, 0.3095599), ComplexOperations.exp(new Complex(-1.0, 1.0)));

        //exp of number with positive real part and negative immag. part
        assertEquals(new Complex(1.4686939, -2.2873553), ComplexOperations.exp(new Complex(1.0, -1.0)));

        //exp of number,with decimal part, with positive real part and positive immag. part
        assertEquals(new Complex(-7.9290094, 1.9537507), ComplexOperations.exp(new Complex(2.1, 2.9)));

        //exp of number,with decimal part, with negative real part and negative immag. part
        assertEquals(new Complex(-0.1189001, -0.0292976), ComplexOperations.exp(new Complex(-2.1, -2.9)));

        //exp of number,with decimal part, with negative real part and positive immag. part
        assertEquals(new Complex(-0.1189001, 0.0292976), ComplexOperations.exp(new Complex(-2.1, 2.9)));

        //exp of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(-7.9290094, -1.9537507), ComplexOperations.exp(new Complex(2.1, -2.9)));

        //exp of number 0
        assertEquals(new Complex(1.0, 0.0), ComplexOperations.exp(new Complex(0.0, 0.0)));
    }

    /**
     * Test of log method, of class Complex.
     */
    @Test
    public void testLog() throws OperationDenied {

        //log of number with positive real part and positive immag. part
        assertEquals(new Complex(0.3465736, 0.7853982), ComplexOperations.log(new Complex(1.0, 1.0)));

        //log of number with negative real part and negative immag. part
        assertEquals(new Complex(0.3465736, -2.3561945), ComplexOperations.log(new Complex(-1.0, -1.0)));

        //log of number with negative real part and positive immag. part
        assertEquals(new Complex(0.3465736, 2.3561945), ComplexOperations.log(new Complex(-1.0, 1.0)));

        //log of number with positive real part and negative immag. part
        assertEquals(new Complex(0.3465736, -0.7853982), ComplexOperations.log(new Complex(1.0, -1.0)));

        //log of number,with decimal part, with positive real part and positive immag. part
        assertEquals(new Complex(1.2755032, 0.9440534), ComplexOperations.log(new Complex(2.1, 2.9)));

        //log of number,with decimal part, with negative real part and negative immag. part
        assertEquals(new Complex(1.2755032, -2.1975392), ComplexOperations.log(new Complex(-2.1, -2.9)));

        //log of number,with decimal part, with negative real part and positive immag. part
        assertEquals(new Complex(1.2755032, 2.1975392), ComplexOperations.log(new Complex(-2.1, 2.9)));

        //log of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(1.2755032, -0.9440534), ComplexOperations.log(new Complex(2.1, -2.9)));

    }

    @Test(expected = OperationDenied.class)
    public void testLog2() throws OperationDenied {

        ComplexOperations.log(new Complex(0.0, 0.0));

    }

    /**
     * Test of sin method, of class Complex.
     */
    @Test
    public void testSin() {

        //sin of number with positive real part and positive immag. part
        assertEquals(new Complex(1.2984576, 0.6349639), ComplexOperations.sin(new Complex(1.0, 1.0)));

        //sin of number with negative real part and negative immag. part
        assertEquals(new Complex(-1.2984576, -0.6349639), ComplexOperations.sin(new Complex(-1.0, -1.0)));

        //sin of number with negative real part and positive immag. part
        assertEquals(new Complex(-1.2984576, 0.6349639), ComplexOperations.sin(new Complex(-1.0, 1.0)));

        //sin of number with positive real part and negative immag. part
        assertEquals(new Complex(1.2984576, -0.6349639), ComplexOperations.sin(new Complex(1.0, -1.0)));

        //sin of number,with decimal part, with positive real part and positive immag. part
        assertEquals(new Complex(7.8677945, -4.5736841), ComplexOperations.sin(new Complex(2.1, 2.9)));

        //sin of number,with decimal part, with negative real part and negative immag. part
        assertEquals(new Complex(-7.8677945, 4.5736841), ComplexOperations.sin(new Complex(-2.1, -2.9)));

        //sin of number,with decimal part, with negative real part and positive immag. part
        assertEquals(new Complex(-7.8677945, -4.5736841), ComplexOperations.sin(new Complex(-2.1, 2.9)));

        //sin of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(7.8677945, 4.5736841), ComplexOperations.sin(new Complex(2.1, -2.9)));

        //sin of number 0
        assertEquals(new Complex(0.0, 0.0), ComplexOperations.sin(new Complex(0.0, 0.0)));

    }

    /**
     * Test of cos method, of class Complex.
     */
    @Test
    public void testCos() {

        //cos of number with positive real part and positive immag. part
        assertEquals(new Complex(0.8337300, -0.9888977), ComplexOperations.cos(new Complex(1.0, 1.0)));

        //cos of number with negative real part and negative immag. part
        assertEquals(new Complex(0.8337300, -0.9888977), ComplexOperations.cos(new Complex(-1.0, -1.0)));

        //cos of number with negative real part and positive immag. part
        assertEquals(new Complex(0.8337300, 0.9888977), ComplexOperations.cos(new Complex(-1.0, 1.0)));

        //cos of number with positive real part and negative immag. part
        assertEquals(new Complex(0.8337300, 0.9888977), ComplexOperations.cos(new Complex(1.0, -1.0)));

        //cos of number,with decimal part, with positive real part and positive immag. part
        assertEquals(new Complex(-4.6014624, -7.8202980), ComplexOperations.cos(new Complex(2.1, 2.9)));

        //cos of number,with decimal part, with negative real part and negative immag. part
        assertEquals(new Complex(-4.6014624, -7.8202980), ComplexOperations.cos(new Complex(-2.1, -2.9)));

        //cos of number,with decimal part, with negative real part and positive immag. part
        assertEquals(new Complex(-4.6014624, 7.8202980), ComplexOperations.cos(new Complex(-2.1, 2.9)));

        //cos of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(-4.6014624, 7.8202980), ComplexOperations.cos(new Complex(2.1, -2.9)));

        //cos of number 0
        assertEquals(new Complex(1.0, 0.0), ComplexOperations.cos(new Complex(0.0, 0.0)));

    }

    /**
     * Test of tan method, of class Complex.
     */
    @Test
    public void testTan() throws OperationDenied {

        //tan of number with positive real part and positive immag. part
        assertEquals(new Complex(0.2717526, 1.0839234), ComplexOperations.tan(new Complex(1.0, 1.0)));

        //tan of number with negative real part and negative immag. part
        assertEquals(new Complex(-0.2717526, -1.0839234), ComplexOperations.tan(new Complex(-1.0, -1.0)));

        //tan of number with negative real part and positive immag. part
        assertEquals(new Complex(-0.2717526, 1.0839234), ComplexOperations.tan(new Complex(-1.0, 1.0)));

        //tan of number with positive real part and negative immag. part
        assertEquals(new Complex(0.2717526, -1.0839234), ComplexOperations.tan(new Complex(1.0, -1.0)));

        //tan of number,with decimal part, with positive real part and positive immag. part
        assertEquals(new Complex(-0.0052932, 1.0029590), ComplexOperations.tan(new Complex(2.1, 2.9)));

        //tan of number,with decimal part, with negative real part and negative immag. part
        assertEquals(new Complex(0.0052932, -1.0029590), ComplexOperations.tan(new Complex(-2.1, -2.9)));

        //tan of number,with decimal part, with negative real part and positive immag. part
        assertEquals(new Complex(0.0052932, 1.0029590), ComplexOperations.tan(new Complex(-2.1, 2.9)));

        //tan of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(-0.0052932, -1.0029590), ComplexOperations.tan(new Complex(2.1, -2.9)));

    }

    /**
     * Test of arg method, of class Complex.
     */
    @Test
    public void testPow() throws OperationDenied {

        //positive pow of number with positive real part and positive immag. part
        assertEquals(new Complex(-2, 2), ComplexOperations.pow(new Complex(1.0, 1.0), 3.0));

        //positive pow of number with negative real part and negative immag. part
        assertEquals(new Complex(2, -2), ComplexOperations.pow(new Complex(-1.0, -1.0), 3.0));

        //positive pow of number with negative real part and positive immag. part
        assertEquals(new Complex(2, 2), ComplexOperations.pow(new Complex(-1.0, 1.0), 3.0));

        //positive pow of number with positive real part and negative immag. part
        assertEquals(new Complex(-2, -2), ComplexOperations.pow(new Complex(1.0, -1.0), 3.0));

        //negative pow of number,with decimal part, with positive real part and positive immag. part
        assertEquals(new Complex(-0.0207509, -0.0066341), ComplexOperations.pow(new Complex(2.1, 2.9), -3.0));

        //negative pow of number,with decimal part, with negative real part and negative immag. part
        assertEquals(new Complex(0.0207509, 0.0066341), ComplexOperations.pow(new Complex(-2.1, -2.9), -3.0));

        //negative pow of number,with decimal part, with negative real part and positive immag. part
        assertEquals(new Complex(0.0207509, -0.0066341), ComplexOperations.pow(new Complex(-2.1, 2.9), -3.0));

        //negative pow of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(-0.0207509, 0.0066341), ComplexOperations.pow(new Complex(2.1, -2.9), -3.0));

        //zero pow of number,with decimal part, with positive real part and negative immag. part
        assertEquals(new Complex(1, 1), ComplexOperations.pow(new Complex(2.1, -2.9), 0.0));

        //positive pow of number 0
        assertEquals(new Complex(0, 0), ComplexOperations.pow(new Complex(0.0, 0.0), 3.0));

    }

    /**
     * Test of arg method, of class Complex.
     */
    @Test(expected = OperationDenied.class)
    public void testPow2() throws OperationDenied {
        //negative pow of number 0
        ComplexOperations.pow(new Complex(0.0, 0.0), -3.0);
    }

}

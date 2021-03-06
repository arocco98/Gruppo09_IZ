package progettose_gruppo09;

import exceptions.OperationDenied;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class allows the use of the operations of addition, subtraction,
 * multiplication, division, square root and inversion of sign
 *
 * @author gruppo09
 */
public class ComplexOperations {

    /**
     * Execute the sum of two complex numbers
     *
     * @param a First operand of the sum between complex numbers, it must be a
     * complex number
     * @param b Second operand of the sum between complex numbers, it must be a
     * complex number
     * @return Complex number which is the sum between operand a and operand b
     */
    public static Complex complexSum(Complex a, Complex b) {

        double real = a.getReal() + b.getReal();
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = a.getImaginary() + b.getImaginary();
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);
    }

    /**
     * Execute the subtraction of two complex numbers
     *
     * @param a First operand of the subtraction between complex numbers, it
     * must be a complex number
     * @param b Second operand of the subtraction between complex numbers, it
     * must be a complex number
     * @return Complex number which is the subtraction between operand a and
     * operand b
     */
    public static Complex complexSub(Complex a, Complex b) {

        double real = a.getReal() - b.getReal();
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = a.getImaginary() - b.getImaginary();
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);

    }

    /**
     * Execute the product of two complex numbers
     *
     * @param a First operand of the product between complex numbers, it must be
     * a complex number
     * @param b Second operand of the product between complex numbers, it must
     * be a complex number
     * @return Complex number which is the product between operand a and operand
     * b
     */
    public static Complex complexProd(Complex a, Complex b) {

        double real = ((a.getReal() * b.getReal()) - (a.getImaginary() * b.getImaginary()));
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = ((a.getReal() * b.getImaginary()) + (a.getImaginary() * b.getReal()));
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);

    }

    /**
     * Execute the division of two complex numbers
     *
     * @param a First operand of the division between complex numbers, it must
     * be a complex number
     * @param b Second operand of the division between complex numbers, it must
     * be a complex number
     * @return Complex number which is the division between operand a and
     * operand b
     */
    public static Complex complexDiv(Complex a, Complex b) {

        double real = ((a.getReal() * b.getReal()) + (a.getImaginary() * b.getImaginary())) / ((b.getReal() * b.getReal()) + (b.getImaginary() * b.getImaginary()));
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = ((a.getImaginary() * b.getReal()) - (a.getReal() * b.getImaginary())) / ((b.getReal() * b.getReal()) + (b.getImaginary() * b.getImaginary()));
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);

    }

    /**
     * Modulus of a Complex number (the distance from the origin in polar
     * coordinates).
     *
     * @return |a| where 'a' is a Complex number.
     */
    public static double mod(Complex a) {
        double x = a.getReal();
        BigDecimal bdr = new BigDecimal(x).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double y = a.getImaginary();
        BigDecimal bdi = new BigDecimal(y).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        if (re != 0 || imm != 0) {
            double i = Math.sqrt(x * x + y * y);
            BigDecimal bd = new BigDecimal(i).setScale(7, RoundingMode.HALF_UP);
            return bd.doubleValue();
        } else {
            return 0d;
        }
    }

    /**
     * Argument of a Complex number (the angle in radians with the x-axis in
     * polar coordinates).
     *
     * @return arg(a) where 'a' is a Complex number.
     */
    public static double arg(Complex a) {
        double x = a.getReal();
        BigDecimal bdr = new BigDecimal(x).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double y = a.getImaginary();
        BigDecimal bdi = new BigDecimal(y).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        double i = Math.atan2(imm, re);

        BigDecimal bd = new BigDecimal(i).setScale(7, RoundingMode.HALF_UP);

        return bd.doubleValue();
    }

    /**
     * Complex square root. Computes the principal branch of the square root,
     * which is the value with 0 <= arg < pi.
     *
     * @return sqrt(a) where 'a' is a Complex number.
     */
    public static Complex sqrt(Complex a) {

        double r = Math.sqrt(mod(a));
        double theta = arg(a) / 2;

        double real = r * Math.cos(theta);
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = r * Math.sin(theta);
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);
    }

    /**
     * Complex exponential.
     *
     * @return exp(a) where 'a' is a Complex number.
     */
    public static Complex exp(Complex a) {

        double real = Math.exp(a.getReal()) * Math.cos(a.getImaginary());
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = Math.exp(a.getReal()) * Math.sin(a.getImaginary());
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);
    }

    /**
     * Principal branch of the Complex logarithm of a Complex number. The
     * principal branch is the branch with -pi < arg <= pi.
     *
     * @return log(a) where 'a' is a Complex number.
     */
    public static Complex log(Complex a) throws OperationDenied {
        if (mod(a) != 0.0) {
            double real = Math.log(mod(a));
            BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
            double re = bdr.doubleValue();

            double imaginary = arg(a);
            BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
            double imm = bdi.doubleValue();

            return new Complex(re, imm);
        } else {
            throw new OperationDenied();
        }
    }

    /**
     * Sine of this Complex number.
     *
     * @return sin(a) where 'a' is a Complex number.
     */
    public static Complex sin(Complex a) {
        double real = Math.cosh(a.getImaginary()) * Math.sin(a.getReal());
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = Math.sinh(a.getImaginary()) * Math.cos(a.getReal());
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);
    }

    /**
     * Cosine of this Complex number (doesn't change this Complex number).
     *
     * @return cos(a) where 'a' is a Complex number.
     */
    public static Complex cos(Complex a) {
        double real = Math.cosh(a.getImaginary()) * Math.cos(a.getReal());
        BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
        double re = bdr.doubleValue();

        double imaginary = -Math.sinh(a.getImaginary()) * Math.sin(a.getReal());
        BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
        double imm = bdi.doubleValue();

        return new Complex(re, imm);
    }

    /**
     * Tangent of this Complex number.
     *
     * @return tan(a) where 'a' is a Complex number.
     */
    public static Complex tan(Complex a) throws OperationDenied {
        Complex cos = cos(a);
        Complex sin = sin(a);

        if (mod(cos) != 0.0) {
            return complexDiv(sin(a), cos(a));
        } else {
            throw new OperationDenied();
        }
    }

    /**
     * Calculates the Complex to the passed power.
     *
     * @param z The input complex number.
     * @param power The power.
     * @return a Complex which is (z)^power.
     */
    public static Complex pow(Complex z, double power) throws OperationDenied {

        Complex output = new Complex(z.getReal(), z.getImaginary());
        double pot = power;

        if (power < 0) {
            pot = pot * -1;
        } else if (power == 0) {
            output = new Complex(1.0, 1.0);
        }

        if (z.equals(new Complex(0.0, 0.0)) && power < 0) {
            throw new OperationDenied();
        }

        for (int i = 1; i < pot; i++) {
            double real = output.getReal() * z.getReal() - output.getImaginary() * z.getImaginary();
            BigDecimal bdr = new BigDecimal(real).setScale(7, RoundingMode.HALF_UP);
            double re = bdr.doubleValue();

            double imaginary = output.getReal() * z.getImaginary() + output.getImaginary() * z.getReal();
            BigDecimal bdi = new BigDecimal(imaginary).setScale(7, RoundingMode.HALF_UP);
            double imm = bdi.doubleValue();

            output = new Complex(re, imm);
        }
        if (power < 0) {
            return complexDiv(new Complex(1.0, 0.0), output);
        }
        return output;
    }

    /**
     * This method calculates the arc sine of a Complex number
     *
     * @param complex The input Complex number to calculate arc sine
     * @return The arc sine of c
     */
    public static Complex arcsin(Complex complex) throws OperationDenied {

        Complex operand1 = new Complex(0.0, -1.0);
        Complex exponentialPart = ComplexOperations.exp(ComplexOperations.complexProd(new Complex(0.0, 0.5), new Complex(ComplexOperations.arg(ComplexOperations.complexSub(new Complex(1.0, 0.0), ComplexOperations.pow(complex, 2))), 0.0)));
        Complex modulusPart = ComplexOperations.sqrt(new Complex(ComplexOperations.mod(ComplexOperations.complexSub(new Complex(1.0, 0.0), ComplexOperations.pow(complex, 2))), 0.0));
        Complex izPart = ComplexOperations.complexProd(new Complex(0.0, 1.0), complex);
        Complex lnPart = ComplexOperations.log(ComplexOperations.complexSum(izPart, ComplexOperations.complexProd(modulusPart, exponentialPart)));

        Complex result = ComplexOperations.complexProd(operand1, lnPart);
        double realPart = result.getReal();
        double imaginaryPart = result.getImaginary();

        result.setReal(new BigDecimal(realPart).setScale(7, RoundingMode.HALF_UP).doubleValue());
        result.setImaginary(new BigDecimal(imaginaryPart).setScale(7, RoundingMode.HALF_UP).doubleValue());

        return result;
    }

    /**
     * This method calculates the arc cosine of a Complex number
     *
     * @param complex The input Complex number to calculate arc cosine
     * @return The arc cosine of c
     */
    public static Complex arccos(Complex complex) throws OperationDenied {
        Complex operand1 = new Complex(0.0, -1.0);
        Complex exponentialPart = ComplexOperations.exp(ComplexOperations.complexProd(new Complex(0.0, 0.5), new Complex(ComplexOperations.arg(ComplexOperations.complexSub(new Complex(1.0, 0.0), ComplexOperations.pow(complex, 2))), 0.0)));
        Complex modulusPart = ComplexOperations.sqrt(new Complex(ComplexOperations.mod(ComplexOperations.complexSub(new Complex(1.0, 0.0), ComplexOperations.pow(complex, 2))), 0.0));
        Complex iModulusPart = ComplexOperations.complexProd(new Complex(0.0, 1.0), modulusPart);
        Complex lnPart = ComplexOperations.log(ComplexOperations.complexSum(complex, ComplexOperations.complexProd(iModulusPart, exponentialPart)));

        Complex result = ComplexOperations.complexProd(operand1, lnPart);
        double realPart = result.getReal();
        double imaginaryPart = result.getImaginary();

        result.setReal(new BigDecimal(realPart).setScale(7, RoundingMode.HALF_UP).doubleValue());
        result.setImaginary(new BigDecimal(imaginaryPart).setScale(7, RoundingMode.HALF_UP).doubleValue());

        return result;
    }

    /**
     * This method calculates the arc tangent of a Complex number
     *
     * @param c the input Complex number to calculate arc tangent
     * @return the arc tangent of c
     */
    public static Complex arctan(Complex c) throws OperationDenied {
        Complex num = ComplexOperations.complexSub(new Complex(0.0, 1.0), c);
        Complex den = ComplexOperations.complexSum(new Complex(0.0, 1.0), c);
        Complex c1 = ComplexOperations.complexDiv(num, den);
        c1 = ComplexOperations.log(c1);
        c1 = complexProd(new Complex(0.0, -0.5), c1);

        double realPart = c1.getReal();
        double imaginaryPart = c1.getImaginary();

        c1.setReal(new BigDecimal(realPart).setScale(7, RoundingMode.HALF_UP).doubleValue());
        c1.setImaginary(new BigDecimal(imaginaryPart).setScale(7, RoundingMode.HALF_UP).doubleValue());
        return c1;
    }

}

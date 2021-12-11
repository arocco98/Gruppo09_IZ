package progettose_gruppo09;

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
     * Modulus of this Complex number (the distance from the origin in polar
     * coordinates).
     *
     * @return |z| where z is this Complex number.
     */
    public static double mod(Complex a) {
        double x = a.getReal();
        double y = a.getImaginary();
        if (x != 0 || y != 0) {
            return Math.sqrt(x * x + y * y);
        } else {
            return 0d;
        }
    }

    /**
     * Argument of this Complex number (the angle in radians with the x-axis in
     * polar coordinates).
     *
     * @return arg(z) where z is this Complex number.
     */
    public static double arg(Complex a) {
        double x = a.getReal();
        double y = a.getImaginary();

        return Math.atan2(y, x);
    }

    /**
     * Complex square root (doesn't change this complex number). Computes the
     * principal branch of the square root, which is the value with 0 <= arg <
     * pi.
     *
     * @return sqrt(z) where z is this Complex number.
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

}

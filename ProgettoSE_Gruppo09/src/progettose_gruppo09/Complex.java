package progettose_gruppo09;

/**
 *
 * @author gruppo09
 */
public class Complex {

    private double real;
    private double imaginary;

    /**
     * Construct a new Complex object
     */
    public Complex() {
    }

    /**
     * Construct a new Complex object having real as real part
     *
     * @param real the complex real part
     */
    public Complex(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }

    /**
     * Construct a new Complex object having real as real part and imaginary as
     * imaginary part
     *
     * @param real the complex real part
     * @param imaginary the complex imaginary part
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * This method is used to get the real part of a complex number
     *
     * @return the real part of the complex number
     */
    public double getReal() {
        return real;
    }

    /**
     * This method is used to set the real part of a complex number
     *
     * @param real the value you want to set as real part
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * This method is used to get the imaginary part of a complex number
     *
     * @return the imaginary part of the complex number
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * This method is used to get the imaginary part of a complex number
     *
     * @param imaginary the value you want to set as imaginary part
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    /**
     * This method is used to verify that a Complex object is equal to another
     * one
     *
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false
     * otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complex other = (Complex) obj;
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginary) != Double.doubleToLongBits(other.imaginary)) {
            return false;
        }
        return true;
    }

    /**
     * This method returns a string representation of the object
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        // real part and imaginary part is 0
        if (this.getReal() == 0.0 && this.getImaginary() == 0.0) {
            return "0";
        }

        // only imaginary part is 0
        if (this.getReal() != 0.0 && this.getImaginary() == 0.0) {
            return Double.toString(this.getReal());
        }

        // only real part is 0
        if (this.getReal() == 0.0 && this.getImaginary() != 0.0) {
            return Double.toString(this.getImaginary()) + "j";
        }

        if (this.getImaginary() > 0) {
            return Double.toString(this.getReal()) + "+" + Double.toString(this.getImaginary()) + "j";
        }

        return Double.toString(this.getReal()) + Double.toString(this.getImaginary()) + "j";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettose_gruppo09;

/**
 *
 * @author gruppo09
 */
public class Complex {
    
    private double real;
    private double imaginary;

    public Complex() {
    }
    
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }  

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

    @Override
    public String toString() {
        // real part and imaginary part is 0
        if(this.getReal() == 0.0 && this.getImaginary() == 0.0)
            return "0";
        
        // only imaginary part is 0
        if(this.getReal() != 0.0 && this.getImaginary() == 0.0)
            return Double.toString(this.getReal());
        
        // only real part is 0
        if(this.getReal() == 0.0 && this.getImaginary() != 0.0)
            return Double.toString(this.getImaginary()) + "j";
        
        if(this.getImaginary() > 0)
            return Double.toString(this.getReal()) + "+" + Double.toString(this.getImaginary()) + "j";
        
        return Double.toString(this.getReal()) + Double.toString(this.getImaginary()) + "j";
    }
}

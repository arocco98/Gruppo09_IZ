/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progettose_gruppo09;

/**
 *
 * @author gruppo09
 */
public class ComplexOperations {
    
    public ComplexOperations() {
    }
    
    public static Complex complexSum(Complex a, Complex b){
        
        return new Complex(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());

    }
    
    /**
     * 
     * @param a First operand of the subtraction between complex numbers, it must be a complex number
     * @param b Second operand of the subtraction between complex numbers, must be a complex number
     * @return Complex number which is the subtraction between operand a and operand b
     */
    public static Complex complexSub(Complex a, Complex b){
        
        return new Complex((a.getReal() - b.getReal()), a.getImaginary() - b.getImaginary());
        
    }
    
    public static Complex complexDiv(Complex a, Complex b){
        
        double real = (((a.getReal()*b.getReal())+(a.getImaginary()*b.getImaginary()))/((b.getReal()*b.getReal())+(b.getImaginary()*b.getImaginary())));
        double imaginary = (((a.getImaginary()*b.getReal())-(a.getReal()*b.getImaginary()))/((b.getReal()*b.getReal())+(b.getImaginary()*b.getImaginary())));
        return new Complex(real, imaginary);
        
    }
    
    public static Complex complexProd(Complex a, Complex b){
        
        double real = ((a.getReal()*b.getReal()) - (a.getImaginary()*b.getImaginary()));
        double imaginary = ((a.getReal()*b.getImaginary()) + (a.getImaginary()*b.getReal()));
        return new Complex(real, imaginary);

        
    }

}

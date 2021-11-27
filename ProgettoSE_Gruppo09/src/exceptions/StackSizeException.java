/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author memol
 */
public class StackSizeException extends Exception {

    /**
     * Creates a new instance of <code>StackSizeException</code> 
     */
    public StackSizeException() {
        System.err.println("Numero elementi non sufficiente");
    }

}

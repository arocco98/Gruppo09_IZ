/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author domenicopastore
 */
public class OperationDenied extends Exception {

    /**
     * Creates a new instance of <code>OperationDenied</code>
     */
    public OperationDenied() {
        System.err.println("Operazione non consentita");
    }

}

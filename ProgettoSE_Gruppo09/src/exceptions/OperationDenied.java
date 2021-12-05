package exceptions;

/**
 * This exception is called when an operation is not allowed when an operand
 * does not conform to the requirements
 *
 * @author gruppo09
 */
public class OperationDenied extends Exception {

    /**
     * Creates a new instance of <code>OperationDenied</code>
     */
    public OperationDenied() {
        System.err.println("Operazione non consentita");
    }

}

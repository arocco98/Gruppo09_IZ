package exceptions;

/**
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

package exceptions;

/**
 * This exception is called when the size of the stack not allow the execution
 * of an operation
 *
 * @author gruppo09
 */
public class StackSizeException extends Exception {

    /**
     * Creates a new instance of StackSizeException
     */
    public StackSizeException() {
        System.err.println("Numero elementi non sufficiente");
    }

}

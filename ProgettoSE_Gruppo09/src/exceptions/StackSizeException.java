package exceptions;

/**
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

package exceptions;

/**
 *
 * @author gruppo_09
 */
public class ImaginaryException extends Exception {

    /**
     * Creates a new instance of <code>ImaginaryException</code> without detail
     * message.
     */
    public ImaginaryException() {
        System.err.println("Insert a real number for use a pow function");
    }

}

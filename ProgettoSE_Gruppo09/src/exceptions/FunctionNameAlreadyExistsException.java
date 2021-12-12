package exceptions;

/**
 * This exception is called when the the user wants to add a new user-defined
 * function with a name that already exists or is uqual to a base operation
 *
 * @author gruppo09
 */
public class FunctionNameAlreadyExistsException extends Exception {

    /**
     * Creates a new instance of <code>FunctionNameAlreadyExistsException</code>
     * without detail message.
     */
    public FunctionNameAlreadyExistsException() {
        super();
    }
}

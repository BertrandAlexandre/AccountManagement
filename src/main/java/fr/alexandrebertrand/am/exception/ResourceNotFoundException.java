package fr.alexandrebertrand.am.exception;

/**
 * Exception thrown when a requested resource is not found.
 */
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6708413247236569688L;

    /**
     * Constructs an instance of <code>ResourceNotFoundException</code> .
     */
    public ResourceNotFoundException() {
    }

    /**
     * Constructs an instance of <code>ResourceNotFoundException</code> with an error message.
     *
     * @param msg Error message.
     */
    public ResourceNotFoundException(String msg) {
        super(msg);
    }

}

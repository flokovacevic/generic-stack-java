/**
 * Exception thrown when trying to pop or peek from an empty stack.
 *
 * @author Florian Kovacevic
 * @version 2026-02-22
 */
public class StackEmptyException extends Exception {

    /**
     * Creates a new StackEmptyException with a default message.
     */
    public StackEmptyException(){
        super("Stack is Empty - Nothing to read");
    }

    /**
     * Creates a new StackEmptyException with a custom message.
     *
     * @param message the detail message
     */
    public StackEmptyException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when trying to push an element onto a full stack.
 *
 * @author Florian Kovacevic
 * @version 2026-02-22
 */
public class StackFullException extends Exception {

    /**
     * Creates a new StackFullException with a default message.
     */
    public StackFullException(){
        super("Stack is Full - Cannot push any more elements");
    }

    /**
     * Creates a new StackFullException with a custom message.
     *
     * @param message the detail message
     */
    public StackFullException(String message) {
        super(message);
    }
}

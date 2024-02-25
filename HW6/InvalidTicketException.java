/**
 * @author Siwoo Park
 * @version 1.0
 */
public class InvalidTicketException extends Exception {
    /**
     * A constructor that takes in a String exception message.
     * @param message exception's message.
     */
    public InvalidTicketException(String message) {
        super(message);
    }

    /**
     * No-argument constructor has default message.
     */
    public InvalidTicketException() {
        super("Invalid ticket");
    }
}

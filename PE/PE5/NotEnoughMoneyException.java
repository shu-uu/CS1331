/**
 * @author Siwoo Park
 * @version 1.0
 */
public class NotEnoughMoneyException extends RuntimeException {
    /**
     * This exception should have the message.
     */
    public NotEnoughMoneyException() {
        super("Item not vended. Insufficient funds.");
    }
}
/**
 * @author Siwoo Park
 * @version 1.0
 */
public class OutOfStockException extends Exception {
    /**
     * This exception should have the message.
     * @param item out of stock item.
     */
    public OutOfStockException(String item) {
        super(item + " is not in stock.");
    }
}
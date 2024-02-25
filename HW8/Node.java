/**
 * @author Siwoo Park
 * @version 1
 * @param <T> the type of data stored in this node.
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructs a new Node with the specified data and next node.
     * @param data the data to be stored in this node.
     * @param next the next node in the linked list.
     */
    public Node(T data, Node<T> next) {
        setData(data);
        this.next = next;
    }

    /**
     * Constructs a new Node with the specified data and no next node.
     * @param data the data to be stored in this node.
     */
    public Node(T data) {
        this(data, null);
    }

    /**
     * @return the data stored in this node.
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data in this node.
     * @param data the data to be stored in this node.
     * @throws IllegalArgumentException if the data is null.
     */
    public void setData(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
    }

    /**
     * @return the next node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node in the linked list.
     * @param next the next node to be linked to this node.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
}

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Siwoo Park
 * @version 1
 * @param <T> the type of elements returned by this iterator.
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> next;

    /**
     * Constructs a LinkedListIterator using the provided LinkedList.
     * @param list the LinkedList to iterate over.
     * @throws IllegalArgumentException if the provided LinkedList is null.
     */
    public LinkedListIterator(LinkedList<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Head node cannot be null");
        }
        this.next = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements to iterate");
        }
        T data = next.getData();
        next = next.getNext();
        return data;
    }
}

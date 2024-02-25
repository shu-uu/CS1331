import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Siwoo Park
 * @version 1
 * @param <T> the type of elements held in this list.
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private int size;

    /**
     * Constructs an empty LinkedList.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Constructs a LinkedList containing the elements of the specified array.
     * @param data the array whose elements are to be placed into this list.
     * @throws IllegalArgumentException if input arraay or its elements are null.
     */
    public LinkedList(T[] data) {
        this();
        if (data == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        for (T datum : data) {
            if (datum == null) {
                throw new IllegalArgumentException("Array elements cannot be null");
            }
            add(datum);
        }
    }

    /**
     * @return the head node of the list.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * @return an array containing all elements in this list.
     */
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        int index = 0;
        for (Node<T> current = head; current != null; current = current.getNext()) {
            array[index++] = current.getData();
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
                String.format("===== LINKEDLIST %d =====\nisEmpty: %s\nsize: %d\nhead: %s\ndata: [",
                        hashCode(),
                        isEmpty(),
                        size(),
                        (head == null ? "null" : head.getData())));

        T[] data = toArray();
        if (data == null) {
            sb.append("TODO: Implement toArray method...");
        } else {
            for (int i = 0; i < data.length - 1; ++i) {
                sb.append(String.format("%s, ", data[i])); // append all but last value
            }
            if (data.length > 0) {
                sb.append(String.format("%s", data[data.length - 1])); // append last value
            }
        }
        sb.append("]\n============================");
        return sb.toString();
    }

    @Override
    public void add(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (head == null) {
            head = new Node<>(element);
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Node<>(element));
        }
        size++;
    }

    @Override
    public void add(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(new Node<>(element, current.getNext()));
        }
        size++;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public T remove(int index) throws NoSuchElementException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            return remove();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            T data = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            size--;
            return data;
        }
    }

    @Override
    public T remove(T element) throws IllegalArgumentException, NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found");
        }
        if (head.getData().equals(element)) {
            return remove();
        }
        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getData().equals(element)) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            throw new NoSuchElementException("Element not found");
        }
        T data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return data;
    }

    @Override
    public T set(int index, T element) throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        T oldData = current.getData();
        current.setData(element);
        return oldData;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public boolean contains(T element) throws IllegalArgumentException {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }
}
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Siwoo Park
 * @version 1
 * @param <T> type of elements in lineup.
 */
public class Lineup<T extends Comparable<T>> {
    private ArrayList<T> lineup;
    private boolean isAscending;

    /**
     * A constructor that takes in four generically typed elements.
     * 
     * @param first  ArrayList element.
     * @param second ArrayList element.
     * @param third  ArrayList element.
     * @param fourth ArrayList element.
     */
    public Lineup(T first, T second, T third, T fourth) {
        lineup = new ArrayList<>(4);
        if (first != null && second != null && third != null && fourth != null) {
            lineup.add(first);
            lineup.add(second);
            lineup.add(third);
            lineup.add(fourth);
        }
        isAscending = true;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < lineup.size(); i++) {
            str += lineup.get(i);
            if (i < lineup.size() - 1 || lineup.size() < 4) {
                str += " -> ";
            }
        }
        for (int i = lineup.size(); i < 4; i++) {
            str += "null";
            if (i < 3) {
                str += " -> ";
            }
        }
        return str;
    }

    /**
     * @param element to add.
     * @return true if the element was added successfully, false otherwise.
     */
    public boolean add(T element) {
        if (element == null || lineup.size() >= 4) {
            return false;
        }
        int insertIndex = -1;
        for (int i = 0; i < lineup.size(); i++) {
            T currentElement = lineup.get(i);
            int comparison = element.compareTo(currentElement);
            if (isAscending && comparison < 0 || !isAscending && comparison > 0) {
                insertIndex = i;
                break;
            }
        }
        if (insertIndex == -1) {
            lineup.add(element);
        } else {
            lineup.add(insertIndex, element);
        }
        return true;
    }

    /**
     * @param element to remove.
     * @return true if the element was removed successfully, false otherwise.
     */
    public boolean remove(T element) {
        if (element == null) {
            return false;
        }
        return lineup.remove(element);
    }

    /**
     * @param element to search.
     * @return true if the lineup contains the element, false otherwise.
     */
    public boolean contains(T element) {
        if (element == null) {
            return false;
        }
        return lineup.contains(element);
    }

    /**
     * @return size of the lineup.
     */
    public int size() {
        return lineup.size();
    }

    /**
     * Reverse the ordering of the lineup.
     */
    public void reverseLineup() {
        Collections.reverse(lineup);
        isAscending = !isAscending;
    }

    /**
     * @param args to be inputted.
     */
    public static void main(String[] args) {
        Lineup<Integer> lineup1 = new Lineup<>(1, 2, 3, 4);
        Lineup<String> lineup2 = new Lineup<>("a", "b", "c", "d");

        System.out.println("Lineup 1: " + lineup1);
        lineup1.add(5);
        System.out.println("After adding 5 to Lineup 1: " + lineup1);
        lineup1.remove(2);
        System.out.println("After removing 2 from Lineup 1: " + lineup1);
        System.out.println("Lineup 1 contains 3: " + lineup1.contains(3));
        System.out.println("Size of Lineup 1: " + lineup1.size());
        lineup1.reverseLineup();
        System.out.println("After reversing Lineup 1: " + lineup1);

        System.out.println("\nLineup 2: " + lineup2);
        lineup2.add("e");
        System.out.println("After adding 'e' to Lineup 2: " + lineup2);
        lineup2.remove("b");
        System.out.println("After removing 'b' from Lineup 2: " + lineup2);
        System.out.println("Lineup 2 contains 'c': " + lineup2.contains("c"));
        System.out.println("Size of Lineup 2: " + lineup2.size());
        lineup2.reverseLineup();
        System.out.println("After reversing Lineup 2: " + lineup2);
    }
}

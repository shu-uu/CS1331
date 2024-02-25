/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Restaurant {
    /**
     * Sorts an array of SushiRoll objects in ascending lexicographical order by
     * name using merge sort.
     * 
     * @param rolls the array of SushiRoll objects to sort
     * @return a sorted array of SushiRoll objects
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] rolls) {
        if (rolls.length <= 1) {
            return rolls;
        }
        int mid = rolls.length / 2;
        SushiRoll[] left = RecursionUtils.copyOfRange(rolls, 0, mid);
        SushiRoll[] right = RecursionUtils.copyOfRange(rolls, mid, rolls.length);
        left = mergeSortRolls(left);
        right = mergeSortRolls(right);

        return RecursionUtils.merge(left, right);
    }

    /**
     * Merges multiple sorted arrays of SushiRoll objects into a single sorted
     * array.
     * 
     * @param orders the 2D array of SushiRoll objects
     * @return a merged and sorted array of SushiRoll objects
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] orders) {
        if (orders.length == 0) {
            return new SushiRoll[0]; // Return an empty array if there are no orders
        }
        return mergeOrdersRecursive(orders, 0, orders.length - 1);
    }

    /**
     * Recursively merges sorted SushiRoll arrays.
     * 
     * @param orders 2D array of sorted SushiRolls.
     * @param start  Start index for recursion.
     * @param end    End index for recursion.
     * @return Merged and sorted SushiRoll array.
     */
    private static SushiRoll[] mergeOrdersRecursive(SushiRoll[][] orders, int start, int end) {
        if (start == end) {
            return orders[start];
        }
        int mid = (start + end) / 2;
        SushiRoll[] left = mergeOrdersRecursive(orders, start, mid);
        SushiRoll[] right = mergeOrdersRecursive(orders, mid + 1, end);

        return RecursionUtils.merge(left, right);
    }

    /**
     * Filters sushi rolls by the color of their plates.
     * 
     * @param rolls the array of SushiRoll objects
     * @param color the desired plate color
     * @return an array of SushiRoll objects with the specified plate color
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] rolls, Color color) {
        return platesOfColorRecursive(rolls, color, 0, 0);
    }

    /**
     * Helper method for platesOfColor. It recursively filters sushi rolls by plate
     * color.
     * 
     * @param rolls Array of SushiRoll objects.
     * @param color Desired plate Color to filter.
     * @param index Current index in recursion.
     * @param count Number of sushi rolls found that match the color.
     * @return Array of SushiRolls matching the specified color.
     */
    private static SushiRoll[] platesOfColorRecursive(SushiRoll[] rolls, Color color, int index, int count) {
        if (index == rolls.length) {
            return new SushiRoll[count];
        }

        if (rolls[index].getColor() == color) {
            SushiRoll[] filteredRolls = platesOfColorRecursive(rolls, color, index + 1, count + 1);
            filteredRolls[count] = rolls[index];
            return filteredRolls;
        } else {
            return platesOfColorRecursive(rolls, color, index + 1, count);
        }
    }

    /**
     * Calculates the total price of an array of SushiRoll objects.
     * 
     * @param rolls the array of SushiRoll objects
     * @return the total price of the sushi rolls
     */
    public static double totalPrice(SushiRoll[] rolls) {
        return totalPriceRecursive(rolls, 0);
    }

    /**
     * Recursively sums the prices of sushi rolls in the array.
     * 
     * @param rolls Array of SushiRoll objects.
     * @param index Current processing index for recursion.
     * @return Total price of sushi rolls up to the current index.
     */
    private static double totalPriceRecursive(SushiRoll[] rolls, int index) {
        if (index == rolls.length) {
            return 0;
        }

        return rolls[index].getColor().getPrice() + totalPriceRecursive(rolls, index + 1);
    }

    /**
     * Reverses the order of an array of SushiRoll objects in place.
     * 
     * @param rolls the array of SushiRoll objects to reverse
     */
    public static void flip(SushiRoll[] rolls) {
        flipRecursive(rolls, 0, rolls.length - 1);
    }

    /**
     * Recursively reverses the order of elements in a SushiRoll array in-place.
     * 
     * @param rolls Array of SushiRoll objects to be reversed.
     * @param start Starting index for the recursive reversal process.
     * @param end   Ending index for the recursive reversal process.
     */
    private static void flipRecursive(SushiRoll[] rolls, int start, int end) {
        if (start >= end) {
            return;
        }
        SushiRoll temp = rolls[start];
        rolls[start] = rolls[end];
        rolls[end] = temp;
        flipRecursive(rolls, start + 1, end - 1);
    }
}

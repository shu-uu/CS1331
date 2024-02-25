/**
 * @author Siwoo Park
 * @version 1.0
 */
public class GroceryShopping {
    public static void main(String[] args) {
        final double bananaCost = 3.99;
        final double applesCost = 1.25;
        final int numApples = 4;
        final double couponValue = 0.53;
        final double taxRate = 0.08;
        double orderTotal = 0.0;

        orderTotal += (bananaCost / 2);
        orderTotal += (applesCost * numApples);
        orderTotal -= (couponValue * 3);
        orderTotal *= (1 + taxRate);
        double orderTotalTrunc = ((int) (orderTotal * 100)) / 100.0;

        System.out.println("Your order total is $" + orderTotalTrunc + ".");

        int dollars = 10;
        dollars -= orderTotalTrunc;

        System.out.println("You have " + dollars + " dollar bills remaining.");
    }
}

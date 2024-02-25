/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Driver {
    public static void main(String[] args) {
        Food[] meal1 = TechDining.createMeal(3);
        Food[] meal2 = TechDining.createMeal(4);

        System.out.print("\n");
        System.out.println("Meal 1: " + printFood(meal1) + "  Cost: " + TechDining.mealCost(meal1) + "\n");
        System.out.println("Meal 2: " + printFood(meal2) + "  Cost: " + TechDining.mealCost(meal2) + "\n");

        Food[][] order1 = TechDining.createOrder(3);
        Food[][] order2 = TechDining.createOrder(4);

        System.out.println("Order 1:");
        for (Food[] meal : order1) {
            System.out.println(printFood(meal));
        }
        System.out.println("\nOrder 1 Cost: " + TechDining.orderCost(order1) + "\n\n");

        System.out.println("Order 2:");
        for (Food[] meal : order2) {
            System.out.println(printFood(meal));
        }
        System.out.println("\nOrder 2 Cost: " + TechDining.orderCost(order2) + "\n\n");
    }

    private static String printFood(Food[] foodArr) {
        String out = "[";
        for (Food food : foodArr) {
            out += String.format("%s, ", food);
        }
        if (foodArr.length > 0) {
            out = out.substring(0, out.length() - 2);
        }
        out += "]";
        return out;
    }
}

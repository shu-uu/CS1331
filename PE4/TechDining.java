import java.util.Random;

/**
 * @author Siwoo Park
 * @version 1.0
 */
public class TechDining {
    public static Food[] createMeal(int mealLength) {
        Random rand = new Random();
        Food[] foodArr = new Food[mealLength];
        Food[] food = Food.values();
        for (int i = 0; i < mealLength; ++i) {
            int foodIndex = rand.nextInt(food.length);
            foodArr[i] = food[foodIndex];
        }
        return foodArr;
    }

    public static Food[][] createOrder(int numMeals) {
        int mealSize = 0;
        Food[][] order = new Food[numMeals][];
        for (int i = 0; i < numMeals; ++i) {
            mealSize = numMeals - i;
            order[i] = createMeal(mealSize);
        }
        return order;
    }

    public static int mealCost(Food[] meal) {
        int mealCosts = 0;
        for (int i = 0; i < meal.length; ++i) {
            mealCosts += i * meal[i].ordinal();
        }
        return mealCosts;
    }

    public static int orderCost(Food[][] order) {
        int orderCosts = 0;
        for (Food[] meal : order) {
            orderCosts += mealCost(meal);
        }
        return orderCosts;
    }
}
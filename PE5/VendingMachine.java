import java.util.ArrayList;
/**
 * @author Siwoo Park
 * @version 1.0
 */
public class VendingMachine {
    private ArrayList<String> stock;
    private int cost;

    /**
     * A 2-arg constructor that initializes the vending machine with stock and cost.
     * @param stock list of items in stock.
     * @param cost cost per item in cents.
     */
    public VendingMachine(ArrayList<String> stock, int cost) {
        this.stock = new ArrayList<>(stock);
        this.cost = cost;
    }

    /**
     * Checks if the items in the order are in stock.
     * @param order items to check.
     * @throws OutOfStockException if any item is not found in stock.
     */
    public void checkStock(ArrayList<String> order) throws OutOfStockException {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        for (String item : order) {
            if (!stock.contains(item)) {
                throw new OutOfStockException(item);
            }
        }
        System.out.println("All items are in stock!");
    }

    /**
     * Attempts to purchase an item from the vending machine.
     * @param item item to buy.
     * @param money money provided.
     * @throws OutOfStockException if the item is not in stock.
     * @throws NotEnoughMoneyException if there is not enough money to buy the item.
     */
    public void buyItem(String item, int money) throws OutOfStockException, NotEnoughMoneyException {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        if (!stock.contains(item)) {
            throw new OutOfStockException(item);
        }
        if (money < cost) {
            throw new NotEnoughMoneyException();
        }
        stock.remove(item);
        System.out.println(item + " successfully vended!");
    }

    /**
     * Determines which favorite items are available in the vending machine.
     * @param favoriteItems The list of favorite items.
     * @return An ArrayList of available favorite items.
     */
    public ArrayList<String> availableFavorites(ArrayList<String> favoriteItems) {
        if (favoriteItems == null) {
            throw new IllegalArgumentException("Favorite items cannot be null.");
        }
        ArrayList<String> available = new ArrayList<>();
        for (String item : favoriteItems) {
            if (stock.contains(item)) {
                available.add(item);
            }
        }
        return available;
    }

    /**
     * The main method to simulate a vending machine operation.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        ArrayList<String> vendingItems = new ArrayList<>();
        vendingItems.add("Lays");
        vendingItems.add("Sprite");
        vendingItems.add("M&M");
        vendingItems.add("Monster");
        vendingItems.add("Gum");
        ArrayList<String> favorites = new ArrayList<>();
        favorites.add("M&M");
        favorites.add("Gum");
        favorites.add("Water");
        VendingMachine machine = new VendingMachine(vendingItems, 150);
        try {
            machine.checkStock(vendingItems);
            machine.buyItem("Lays", 300);
            machine.buyItem("Sprite", 110);
            machine.buyItem("Water", 300);
            machine.buyItem("Monster", 70);
            ArrayList<String> availableFavorites = machine.availableFavorites(favorites);
            for (String item : availableFavorites) {
                System.out.println(item);
            }
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Took a trip to the vending machine!");
        }
    }
}

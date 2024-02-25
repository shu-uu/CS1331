import java.util.ArrayList;
/**
 * @author Siwoo Park
 * @version 1.0
 */

public class Olivia {
    private static double budget;
    private static ArrayList<Media> cart = new ArrayList<>();
    private static boolean canUseConsole;

    /**
     * Add media to store.
     * @param media Media that represents item.
     * @param store blockbuster that represents store.
     * @return true if budget, genre, name, rating, and remove, add, false otherwise.
     */
    public static boolean addToCart(Media media, Blockbuster store) {
        if (media == null || store == null) {
            return false;
        }
        if (media.getRentalPrice() > budget) {
            return false;
        }
        Media mediaFromStore = store.findMedia(media);
        if (mediaFromStore == null) {
            return false;
        }
        if (mediaFromStore instanceof VideoGame
                && ((VideoGame) mediaFromStore).needsConsole()
                && !canUseConsole) {
            return false;
        }
        Media matchingMedia = store.findMedia(media);
        if (matchingMedia == null) {
            return false;
        }
        cart.add(mediaFromStore);
        store.removeMedia(mediaFromStore);
        budget -= mediaFromStore.getRentalPrice();
        return true;
    }

    /**
     * Olivia change her mind about renting the passed in media item, and remove.
     * @param media Media that represents item.
     * @param store blockbuster that represents store.
     */
    public static void changeMind(Media media, Blockbuster store) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(media)) {
                store.addMedia(cart.get(i));
                cart.remove(i);
                budget += media.getRentalPrice();
            }
        }
    }
}

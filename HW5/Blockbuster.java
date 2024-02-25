import java.util.ArrayList;

/**
 * @author Siwoo Park
 * @version 1.0
 */

public class Blockbuster {
    private ArrayList<Media> inventory;

    /**
     * A no-argument constructor.
     */
    public Blockbuster() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Takes in a non-null media item and adds it to the end.
     * @param media String representation of a Media.
     */
    public void addMedia(Media media) {
        inventory.add(media);
    }

    /**
     * Method takes valid media item and removes the first occurrence.
     * @param media String representation of a Media.
     * @return currentMedia or null depending if statement.
     */
    public Media removeMedia(Media media) {
        for (int i = 0; i < inventory.size(); i++) {
            Media currentMedia = inventory.get(i);
            if (currentMedia.equals(media)) {
                inventory.remove(i);
                return currentMedia;
            }
        }
        return null;
    }

    /**
     * Sorts the store’s inventory in ascending order.
     */
    public void sortMedia() {
        for (int i = 0; i < inventory.size() - 1; i++) {
            for (int j = 0; j < inventory.size() - 1 - i; j++) {
                if (inventory.get(j).compareTo(inventory.get(j + 1)) > 0) {
                    Media temp = inventory.get(j);
                    inventory.set(j, inventory.get(j + 1));
                    inventory.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Takes in a valid media item and finds.
     * @param media String representation of a Media.
     * @return currMedia if media item is found, return null otherwise.
     */
    public Media findMedia(Media media) {
        sortMedia();
        int low = 0;
        int high = inventory.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Media currMedia = inventory.get(mid);
            if (currMedia.compareTo(media) == 0) {
                return currMedia;
            } else if (currMedia.compareTo(media) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        for (Media item : inventory) {
            if (item.equals(media)) {
                return item;
            }
        }
        return null;
    }

    /**
     * @return the most popular movie based on audience rating.
     */
    public Movie getMostPopularMovie() {
        int highestRating = -1;
        Movie mostPopular = null;
        for (Media media : inventory) {
            if (media instanceof Movie) {
                Movie movie = (Movie) media;
                if (movie.getRating() > highestRating
                        || (movie.getRating() == highestRating
                                && movie.getName().compareTo(mostPopular.getName()) < 0)) {
                    highestRating = movie.getRating();
                    mostPopular = movie;
                }
            }
        }
        return mostPopular;
    }
}

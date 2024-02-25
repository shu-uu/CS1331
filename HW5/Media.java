/**
 * @author Siwoo Park
 * @version 1.0
 */

public abstract class Media implements Comparable<Media> {
    private Genre genre;
    private String name;
    private int rating;
    private double rentalPrice;

    /**
     * A constructor that takes in genre, name, rating, rentalPrice.
     * @param genre       the genre of the media item.
     * @param name        the name of the media item.
     * @param rating      the customer rating of the media item.
     * @param rentalPrice the price in dollars to rent the media item.
     */
    public Media(Genre genre, String name, int rating, double rentalPrice) {
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.rentalPrice = rentalPrice;
    }

    /**
     * A constructor that takes in genre, name, rating, and set rentalPrice to 7.
     * @param genre  the genre of the media item.
     * @param name   the name of the media item.
     * @param rating the customer rating of the media item.
     */
    public Media(Genre genre, String name, int rating) {
        this(genre, name, rating, 7.0);
    }

    @Override
    public String toString() {
        return String.format("Genre: %s, Name: %s, Rating: %d, Rental Price: $%.2f",
                genre, name, rating, rentalPrice);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        Media other = (Media) obj;
        return genre.equals(other.genre) && name.equals(other.name)
                && rating == other.rating && rentalPrice == other.rentalPrice;
    }

    @Override
    public int compareTo(Media other) {
        int genreCompare = genre.compareTo(other.genre);
        if (genreCompare != 0) {
            return genreCompare;
        }
        int nameCompare = name.compareTo(other.name);
        if (nameCompare != 0) {
            return nameCompare;
        }
        return Integer.compare(rating, other.rating);
    }

    /**
     * Getter for name.
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for rating.
     * @return rating.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Getter for rentalPrice.
     * @return rentalPrice.
     */
    public double getRentalPrice() {
        return rentalPrice;
    }
}
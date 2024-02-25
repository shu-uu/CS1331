/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Movie extends Media {
    private int runtime;

    /**
     * Constructor that takes in genre, name, rating, rentalPrice, and runtime.
     * @param genre       the genre of the media item.
     * @param name        the name of the media item.
     * @param rating      the customer rating of the media item.
     * @param rentalPrice the price in dollars to rent the media item.
     * @param runtime     the runtime of the movie in minutes.
     */
    public Movie(Genre genre, String name, int rating, double rentalPrice, int runtime) {
        super(genre, name, rating, rentalPrice);
        this.runtime = runtime;
    }

    /**
     * Constructor takes in genre, name, rating and sets rentalPrice 5.
     * @param genre  the genre of the media item.
     * @param name   the name of the media item.
     * @param rating the customer rating of the media item.
     */
    public Movie(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 111);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Runtime: %d", runtime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Movie movie = (Movie) o;
        return runtime == movie.runtime;
    }
}

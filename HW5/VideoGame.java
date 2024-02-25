/**
 * @author Siwoo Park
 * @version 1.0
 */
public class VideoGame extends Media {
    private int maxPlayers;
    private boolean needsConsole;

    /**
     * Constructor takes genre, name, rating, rentalPrice, maxPlayers, and needsConsole.
     * @param genre        the genre of the media item.
     * @param name         the name of the media item.
     * @param rating       the customer rating of the media item.
     * @param rentalPrice  the price in dollars to rent the media item.
     * @param maxPlayers   the maximum number of players that can play the game at
     *                     once.
     * @param needsConsole whether the video game needs a gaming console to play.
     */
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needsConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needsConsole;
    }

    /**
     * Constructor takes genre, name, rating, sets rentalPrice 5, maxPlayers 2,
     * needsConsole false.
     * @param genre  the genre of the media item.
     * @param name   the name of the media item.
     * @param rating the customer rating of the media item.
     */
    public VideoGame(Genre genre, String name, int rating) {
        this(genre, name, rating, 5.0, 2, false);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Players: %d, %s need console",
                maxPlayers, needsConsole ? "does" : "does not");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(this.getClass().equals(obj.getClass()))) {
            return false;
        }
        VideoGame otherGame = (VideoGame) obj;
        return super.equals(obj) && maxPlayers == otherGame.maxPlayers
                && needsConsole == otherGame.needsConsole;
    }

    /**
     * Getter for needsConsole.
     * @return needsConsole.
     */
    public boolean needsConsole() {
        return needsConsole;
    }
}
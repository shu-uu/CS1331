/**
 * @author Siwoo Park
 * @version 1.0
 */
public abstract class SportsGame {
    private String venue;
    private String startTime;
    private String startDate;
    private int score1;
    private int score2;
    private int seatsLeft;
    /**
     * @param venue the location of the sports game.
     * @param startTime the time that the game began.
     * @param startDate the date that the game happens.
     * @param score1 the score of the first team.
     * @param score2 the score of the second team.
     * @param seatsLeft the number of remaining seats for viewing the game.
     * @throws IllegalArgumentException if the passed in value for league is blank or null.
     */
    public SportsGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft) {
        if (venue == null || venue.isBlank()) {
            throw new IllegalArgumentException("Venue is blank or null");
        }
        if (startTime == null || startTime.isBlank()) {
            throw new IllegalArgumentException("startTime is blank or null");
        }
        if (startDate == null || startDate.isBlank()) {
            throw new IllegalArgumentException("startDate is blank or null");
        }
        if (score1 < 0) {
            throw new IllegalArgumentException("score1 is negative");
        }
        if (score2 < 0) {
            throw new IllegalArgumentException("score2 is negative");
        }
        if (seatsLeft < 0) {
            throw new IllegalArgumentException("seatsLegt is negative");
        }
        this.venue = venue.trim();
        this.startTime = startTime.trim();
        this.startDate = startDate.trim();
        this.score1 = score1;
        this.score2 = score2;
        this.seatsLeft = seatsLeft;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%d,%d,%d",
            venue, startTime, startDate, score1, score2, seatsLeft);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            SportsGame sg = (SportsGame) obj;
            return venue.equals(sg.venue)
                && startTime.equals(sg.startTime)
                && startDate.equals(sg.startDate)
                && score1 == sg.score1
                && score2 == sg.score2
                && seatsLeft == sg.seatsLeft;
        }
        return false;
    }

    /**
     * Getter for seatsLeft.
     * @return seatsLeft.
     */
    public int getSeatsLeft() {
        return seatsLeft;
    }
}
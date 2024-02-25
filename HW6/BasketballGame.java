/**
 * @author Siwoo Park
 * @version 1.0
 */
public class BasketballGame extends SportsGame {
    private String league;
    /**
     * @param venue     the location of the sports game.
     * @param startTime the time that the game began.
     * @param startDate the date that the game happens.
     * @param score1    the score of the first team.
     * @param score2    the score of the second team.
     * @param seatsLeft the number of remaining seats for viewing the game.
     * @param league    the name of the league that the basketball teams are a part of.
     * @throws IllegalArgumentException if the passed in value for league is blank
     *                                  or null.
     */
    public BasketballGame(String venue, String startTime, String startDate, int score1, int score2, int seatsLeft,
            String league) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (league == null || league.isBlank()) {
            throw new IllegalArgumentException("league is blank or null");
        }
        this.league = league.trim();
    }

    @Override
    public String toString() {
        return String.format("BasketballGame,%s,%s", super.toString(), league);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            BasketballGame bg = (BasketballGame) obj;
            return super.equals(bg) && league.equals(bg.league);
        }
        return false;
    }
}

/**
 * @author Siwoo Park
 * @version 1.0
 */
public class FootballGame extends SportsGame {
    private String performer;
    /**
     * @param venue the location of the sports game.
     * @param startTime the time that the game began.
     * @param startDate the date that the game happens.
     * @param score1 the score of the first team.
     * @param score2 the score of the second team.
     * @param seatsLeft the number of remaining seats for viewing the game.
     * @param performer the name of the league that the basketball teams are a part of.
     * @throws IllegalArgumentException if the passed in value for league is blank or null.
     */
    public FootballGame(String venue, String startTime, String startDate,
        int score1, int score2,  int seatsLeft, String performer) {
        super(venue, startTime, startDate, score1, score2, seatsLeft);
        if (performer == null || performer.isBlank()) {
            throw new IllegalArgumentException("performer is blank or null");
        }
        this.performer = performer.trim();
    }

    @Override
    public String toString() {
        return String.format("FootballGame,%s,%s", super.toString(), performer);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            FootballGame fg = (FootballGame) obj;
            return super.equals(fg) && performer.equals(fg.performer);
        }
        return false;
    }
}

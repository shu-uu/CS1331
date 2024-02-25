
/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Driver {
    /**
     * @param args a command line argument it is a collection of variables in the string format.
     */
    public static void main(String[] args) {
        TrickOrTreater[] team1 = {
            new Ghost(),
            new Ghost("ghose1", 5, 3),
            new Witch(),
            new Witch("witch1", 9, 4, "Heew"),
            new Ghost("ghost2", 7, 2)
        };

        TrickOrTreater[] team2 = {
            new Witch(),
            new Ghost("ghost3", 6, 5),
            new Witch("witch2", 11, 2, "Heehee"),
            new Ghost(),
            new Witch("witch3", 8, 6, "Heeheehee")
        };

        HalloweenNight night = new HalloweenNight(team1, team2);
        System.out.println(night);
        night.compareTeams();
        night.battle(50);
    }
}
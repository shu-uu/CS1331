/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Ghost extends TrickOrTreater {
    private int robberiesConducted = 0;

    /**
     * A constructor that takes in name, age, and numCandy.
     * 
     * @param name     the trick-or-treater’s name.
     * @param age      the trick-or-treater’s age, in years.
     * @param numCandy a count of the number of pieces of candy.
     */
    public Ghost(String name, int age, int numCandy) {
        super(name, age, numCandy);
    }

    /**
     * A no-argument constructor.
     */
    public Ghost() {
        this("Casper the Unfriendly Ghost", 12, 0);
    }

    @Override
    public void trickOrTreat() {
        System.out.println("Boo! Trick or treat!");
        gainCandy(2);
    }

    /**
     * Ensure that robberiesConducted maintains an accurate value.
     * 
     * @param target to be robbed.
     */
    public void rob(TrickOrTreater target) {
        if (target instanceof Robbable) {
            int candyTaken = ((Robbable) target).beRobbed();
            if (candyTaken > 0) {
                robberiesConducted++;
                gainCandy(candyTaken);
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "/" + robberiesConducted;
    }

    @Override
    public int compareTo(TrickOrTreater t) {
        int compare = super.compareTo(t);
        if (compare == 0 && t instanceof Ghost) {
            return robberiesConducted - ((Ghost) t).robberiesConducted;
        }
        return compare;
    }
}

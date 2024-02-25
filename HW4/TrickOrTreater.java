/**
 * @author Siwoo Park
 * @version 1.0
 */
public abstract class TrickOrTreater implements Comparable<TrickOrTreater> {
    private String name;
    private int age;
    private int numCandy;

    /**
     * A constructor that takes in name, age, and numCandy.
     * 
     * @param name     the trick-or-treater’s name.
     * @param age      the trick-or-treater’s age, in years.
     * @param numCandy a count of the number of pieces of candy.
     */
    public TrickOrTreater(String name, int age, int numCandy) {
        this.name = (name == null || name.trim().isEmpty() || name.length() == 0) ? "Charlie Brown" : name;
        this.age = (age < 0 || age > 12) ? 8 : age;
        this.numCandy = (numCandy < 0) ? 0 : numCandy;
    }

    /**
     * This method should be declared, but not implemented in this class.
     */
    public abstract void trickOrTreat();

    /**
     * Add amount of candy to the trick-or-treater’s candy basket.
     * 
     * @param gained the amount of candy to gain.
     */
    protected void gainCandy(int gained) {
        if (gained > 0) {
            numCandy += gained;
        }
    }

    /**
     * For any positive input, deduct as much of that amount.
     * 
     * @param lost the amount of candy to lose.
     * @return the amount of candy that was successfully deducted.
     */
    protected int loseCandy(int lost) {
        if (lost < 0) {
            return 0;
        }
        int candyLost = Math.min(lost, numCandy);
        numCandy -= candyLost;
        return candyLost;
    }

    /**
     * Getter for numCamny.
     * 
     * @return numCandy.
     */
    public int getNumCandy() {
        return numCandy;
    }

    @Override
    public String toString() {
        return name + "/" + age + "/" + numCandy;
    }

    @Override
    public int compareTo(TrickOrTreater t) {
        if (numCandy != t.numCandy) {
            return numCandy - t.numCandy;
        }
        return age - t.age;
    }
}

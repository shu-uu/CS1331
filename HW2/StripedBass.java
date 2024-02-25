/**
 * This class defines a StripedBass object.
 * It is a subclass of Fish.
 * 
 * @author Siwoo Park
 * @version 1.0
 */
public class StripedBass extends Fish {
    private int stripeCount;
    private boolean isSaltwater;
    private Catfish bestFriend;

    /**
     * A constructor that takes in name, length, weight,
     * stripeCount, isSaltwater, andbestFriend.
     * 
     * @param name        the name of this fish.
     * @param length      the end-to-end length of this fish in inches.
     * @param weight      the weight of this fish in ounces.
     * @param stripeCount the count of all stripes on this striped bass.
     * @param isSaltwater whether this striped bass resides in a saltwater body.
     * @param bestFriend  a catfish who is the best friend of this striped bass.
     */
    public StripedBass(String name, Double length, Double weight,
            int stripeCount, boolean isSaltwater, Catfish bestFriend) {
        super(name, length, weight);
        this.stripeCount = (stripeCount > 0) ? stripeCount : 25;
        this.isSaltwater = isSaltwater;
        this.bestFriend = (bestFriend != null) ? new Catfish(bestFriend) : null;
    }

    /**
     * A constructor that takes in no parameters.
     */
    public StripedBass() {
        this("Striper", 30.0, 320.0, 14, false, null);
    }

    /**
     * A copy constructor that deep copies all necessary instance fields.
     * 
     * @param s StripedBass object that is to be read.
     */
    public StripedBass(StripedBass s) {
        super(s);
        stripeCount = s.stripeCount;
        isSaltwater = s.isSaltwater;
        bestFriend = (s.bestFriend != null) ? new Catfish(s.bestFriend) : null;
    }

    /**
     * The striped bass moves to the opposite kind of water body
     * if and only if it does not have a best friend.
     */
    public void migrate() {
        if (bestFriend == null) {
            isSaltwater = !isSaltwater;
        }
    }

    @Override
    public String toString() {
        String bestFriendDesc = (bestFriend != null) ? "a best friend named " + bestFriend.name : "no best friend";
        return super.toString() + String.format(" I’m a %s striped bass with %d stripes. I have %s.",
                (isSaltwater ? "saltwater" : "freshwater"), stripeCount, bestFriendDesc);
    }
}

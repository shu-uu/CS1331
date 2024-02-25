/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Witch extends TrickOrTreater implements Robbable {
    private String signatureCackle;

    /**
     * A constructor that takes in name, age, numCandy, and signatureCackle.
     * 
     * @param name            the trick-or-treater’s name.
     * @param age             the trick-or-treater’s age, in years.
     * @param numCandy        a count of the number of pieces of candy.
     * @param signatureCackle a witch’s signature cackle.
     */
    public Witch(String name, int age, int numCandy, String signatureCackle) {
        super(name, age, numCandy);
        this.signatureCackle = (signatureCackle == null || signatureCackle.trim().isEmpty()
                || signatureCackle.length() == 0) ? "Bwahaha" : signatureCackle;
    }

    /**
     * A no-argument constructor.
     */
    public Witch() {
        this("Maleficent", 7, 0, "Bwahaha");
    }

    @Override
    public void trickOrTreat() {
        System.out.println(signatureCackle + "! I'll get you my pretty!");
        gainCandy(3);
    }

    @Override
    public int compareTo(TrickOrTreater o) {
        int compare = super.compareTo(o);
        if (compare == 0 && o.getClass().equals(Witch.class)) {
            return signatureCackle.length() - ((Witch) o).signatureCackle.length();
        }
        return compare;
    }

    @Override
    public int beRobbed() {
        int candyTaken = Math.min(getNumCandy(), 6);
        loseCandy(candyTaken);
        return candyTaken;
    }
}

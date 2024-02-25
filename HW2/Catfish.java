/**
 * This class defines a Catfish object.
 * It is a subclass of Fish.
 * @author Siwoo Park
 * @version 1.0
 */
public class Catfish extends Fish {
    private Double whiskerLength;

    /**
     * A constructor that takes in name, length, weight, and whiskerLength.
     * @param name          the name of this fish.
     * @param length        the end-to-end length of this fish in inches.
     * @param weight        the weight of this fish in ounces.
     * @param whiskerLength the length of this catfish’s longest whisker in inches.
     */
    public Catfish(String name, Double length, Double weight, Double whiskerLength) {
        super(name, length, weight);
        setWhiskerLength(whiskerLength);
    }

    /**
     * A constructor that takes in no parameters.
     */
    public Catfish() {
        super("Bubba", 52.0, 720.0);
        whiskerLength = 5.0;
    }

    /**
     * A copy constructor that deep copies all necessary instance fields.
     * @param c Catfish object that is to be read.
     */
    public Catfish(Catfish c) {
        super(c);
        whiskerLength = c.whiskerLength;
    }

    /**
     * @return a boolean reflecting if this catfish is shaggy.
     */
    public boolean isShaggy() {
        if (whiskerLength == null || super.length == null) {
            return false;
        }
        return whiskerLength > super.length;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" I’m a catfish whose longest whisker is %.2f inches, so I %s shaggy.",
        whiskerLength, (isShaggy() ? "am" : "am not"));
    }

    /**
     * Setter for whiskerLength.
     * @param whiskerLength the length of this catfish’s longest whisker in inches.
     */
    public void setWhiskerLength(Double whiskerLength) {
        if (whiskerLength == null || whiskerLength.isNaN() || whiskerLength.isInfinite() || whiskerLength <= 0) {
            this.whiskerLength = 8.0;
        } else {
            this.whiskerLength = whiskerLength;
        }
    }
}

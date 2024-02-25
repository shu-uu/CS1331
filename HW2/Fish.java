/**
 * This class defines a Fish object.
 * @author Siwoo Park
 * @version 1.0
 */
public class Fish {
    protected final String name;
    protected Double length;
    protected Double weight;
    private static int totalFish = 0;

    /**
     * A constructor that takes in name, length, and weight.
     * @param name   the name of this fish.
     * @param length the end-to-end length of this fish in inches.
     * @param weight the weight of this fish in ounces.
     */
    public Fish(String name, Double length, Double weight) {
        if (name == null || name.trim().isEmpty() || name.length() == 0) {
            this.name = "Nemo";
        } else {
            this.name = name;
        }

        if (length == null || length.isNaN() || length.isInfinite() || length <= 0) {
            this.length = 8.0;
        } else {
            this.length = length;
        }

        if (weight == null || weight.isNaN() || weight.isInfinite() || weight <= 0) {
            this.weight = 2.0;
        } else {
            this.weight = weight;
        }
        totalFish += 1;
    }

    /**
     * A constructor that takes in no parameters.
     */
    public Fish() {
        this("Nemo", 5.0, 12.0);
    }

    /**
     * A copy constructor that deep copies all necessary instance fields.
     * @param f Fish object that is to be read.
     */
    public Fish(Fish f) {
        this(f.name, f.length, f.weight);
    }    

    /**
     * @return the end-to-end length of this fish as a String.
     */
    public String formatLength() {
        int feet = (int) (length / 12);
        double inches = length % 12;

        return String.format("%d ft %.2f in", feet, inches);
    }

    /**
     * @return the weight of this fish as a String.
     */
    public String formatWeight() {
        int pounds = (int) (weight / 16);
        double ounces = weight % 16;

        if (pounds == 1) {
            return String.format("%d lb %.2f oz", pounds, ounces);
        } else {
            return String.format("%d lbs %.2f oz", pounds, ounces);
        }
    }

    @Override
    public String toString() {
        return String.format("I'm a talking fish named " + name
                + ". My length is " + formatLength() + " in and my weight is " + formatWeight() + ".");
    }
}
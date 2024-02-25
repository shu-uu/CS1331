import java.util.Random;

/**
 * This class defines a FlyingFish object and should be a subclass of Fish.
 * 
 * @author Siwoo Park
 * @version 1.0
 */
public class FlyingFish extends Fish {
    private int flightTime;

    /**
     * A constructor that takes in name, length, weight, and flightTime.
     * 
     * @param name       the name of this fish.
     * @param length     the end-to-end length of this fish in inches.
     * @param weight     the weight of this fish in ounces.
     * @param flightTime the amount of time a flying fish can stay in the air in
     *                   seconds
     */
    public FlyingFish(String name, Double length, Double weight, int flightTime) {
        super(name, length, weight);
        this.flightTime = (flightTime > 0) ? flightTime : 30;
    }

    /**
     * A constructor that takes in no parameters.
     */
    public FlyingFish() {
        super("Gilbert", 12.0, 24.0);
        flightTime = 36;
    }

    /**
     * A copy constructor that deep copies all necessary instance fields.
     * 
     * @param f FlyingFish object that is to be read.
     */
    public FlyingFish(FlyingFish f) {
        super(f);
        flightTime = f.flightTime;
    }

    /**
     * @return this flying fish’s power.
     */
    public double calculatePower() {
        return super.weight * flightTime;
    }

    /**
     * Prints a message followed by a newline in the format.
     */
    public void fly() {
        Random rand = new Random();
        double randomNum = rand.nextDouble() * (flightTime - 1) + 1;
        System.out.printf("Woohoo! %s flew for %.2f seconds.%n", name, randomNum);
    }

    @Override
    public String toString() {
        return super.toString()
                + String.format(" I'm a flying fish, and my flight time record is %d seconds, so my power is %.2f.",
                        flightTime, calculatePower());
    }
}
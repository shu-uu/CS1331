/**
 * RollerCoaster class represents a regular roller coaster in your amusement
 * park.
 * 
 * @author Siwoo Park
 * @version 1.0
 */
public class RollerCoaster extends Ride {
    private double rate;
    private double photoFees;
    private int maxNumRuns;

    /**
     * A constructor takes in id, runsSinceInspection, passengers, rate, photoFees,
     * and maxNumRuns.
     * 
     * @param id                  a String representing the identifier for the ride.
     * @param runsSinceInspection int represents the number of times the ride has
     *                            run since last inspection.
     * @param passengers          an array of Strings representing the passengers
     *                            aboard the ride.
     * @param rate                a double representing the price of one run.
     * @param photoFees           a double representing the total fees to purchase
     *                            the mandatory photo package.
     * @param maxNumRuns          an int representing the total number of times that
     *                            the ride.
     */
    public RollerCoaster(String id, int runsSinceInspection, String[] passengers,
            double rate, double photoFees, int maxNumRuns) {
        super(id, runsSinceInspection, passengers);
        this.rate = rate;
        this.photoFees = photoFees;
        this.maxNumRuns = maxNumRuns;
    }

    /**
     * A constructor that takes in id, runsSinceInspection, maxNumRuns, and defaults
     * passengers.
     * 
     * @param id                  a String representing the identifier for the ride.
     * @param runsSinceInspection an int representing the number of times the ride
     *                            has run since the last inspection.
     * @param maxNumRuns          an int representing the total number of times that
     *                            the ride.
     */
    public RollerCoaster(String id, int runsSinceInspection, int maxNumRuns) {
        this(id, runsSinceInspection, new String[4], 10, 15, maxNumRuns);
    }

    /**
     * A constructor that takes in id.
     * 
     * @param id a String representing the identifier for the ride.
     */
    public RollerCoaster(String id) {
        this(id, 0, 200);
    }

    /**
     * @param numberOfRuns an int number of run.
     * @return whether the RollerCoaster can run that many times before needing an
     *         inspection.
     */
    public boolean canRun(int numberOfRuns) {
        return numberOfRuns >= 0 && super.runsSinceInspection + numberOfRuns <= maxNumRuns;
    }

    /**
     * @param components an array of String that represent different components of
     *                   the ride.
     * @return true if the ride passes inspection, otherwise false.
     */
    public boolean inspectRide(String[] components) {
        boolean tracksClear = false;
        boolean brakesOk = false;
        for (String component : components) {
            if (component.toUpperCase().equals("Tracks Clear".toUpperCase())) {
                tracksClear = true;
            }
            if (component.toUpperCase().equals("Brakes Ok".toUpperCase())) {
                brakesOk = true;
            }
        }
        if (tracksClear && brakesOk) {
            super.runsSinceInspection = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param numberOfRuns an int number of stops.
     * @return the double cost for the RollerCoaster to run that many times.
     */
    public double costPerPassenger(int numberOfRuns) {
        return numberOfRuns * rate + photoFees;
    }

    /**
     * Count the numver of empty seats.
     * 
     * @return empty set count.
     */
    private int countEmptySeats() {
        int count = 0;
        for (String passenger : super.passengers) {
            if (passenger == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param numberOfStops an int number of stops.
     * @param newPassengers an array of Strings with new passenger names.
     * @return true if all customers can fit on the RollerCoaster.
     *         And the RollerCoaster can travel the given number of runs, false
     *         otherwise.
     */
    public boolean addPassengers(int numberOfStops, String[] newPassengers) {
        if (numberOfStops < 0 || countEmptySeats() < newPassengers.length || !canRun(numberOfStops)) {
            return false;
        }

        for (String newPassenger : newPassengers) {
            for (int i = 0; i < super.passengers.length; i++) {
                if (super.passengers[i] == null) {
                    super.passengers[i] = newPassenger;
                    earnings += rate * numberOfStops;
                    break;
                }
            }
        }

        // Add photo fees only once per passenger, not per ride
        earnings += photoFees * newPassengers.length;

        super.runsSinceInspection += numberOfStops;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        RollerCoaster other = (RollerCoaster) obj;
        return Double.compare(other.rate, rate) == 0
                && Double.compare(other.photoFees, photoFees) == 0
                && other.maxNumRuns == maxNumRuns;
    }

    @Override
    public String toString() {
        return "Roller Coaster " + super.id + " has run " + super.runsSinceInspection +
                " times and has earned $" + String.format("%.2f", earnings) +
                ". It can only run " + (maxNumRuns - super.runsSinceInspection) +
                " more times. It costs $" + String.format("%.2f", rate) +
                " per ride and there is a one-time photo fee of $" + String.format("%.2f", photoFees) + ".";
    }

}

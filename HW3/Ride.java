/**
 * Ride class represents any amusement park ride.
 * 
 * @author Siwoo Park
 * @version 1.0
 */
public abstract class Ride {
    protected final String id;
    protected double earnings;
    protected int runsSinceInspection;
    protected String[] passengers;

    /**
     * A constructor takes id, runsSinceInspection, passengers.
     * 
     * @param id                  a String representing the identifier for the ride.
     * @param runsSinceInspection int represents the number of times the ride has
     *                            run since last inspection.
     * @param passengers          an array of Strings representing the passengers
     *                            aboard the ride.
     */
    public Ride(String id, int runsSinceInspection, String[] passengers) {
        this.id = id;
        this.runsSinceInspection = runsSinceInspection;
        this.passengers = new String[passengers.length];
        for (int i = 0; i < passengers.length; i++) {
            this.passengers[i] = passengers[i];
        }
    }

    /**
     * A constructor that takes in id, runsSinceInspection, passengers.
     * 
     * @param id         a String representing the identifier for the ride.
     * @param passengers an array of Strings representing the passengers aboard the
     *                   ride.
     */
    public Ride(String id, String[] passengers) {
        this(id, 0, passengers);
    }

    /**
     * Represents whether the ride can run that many times before it must be
     * inspected.
     * 
     * @param numberOfRuns an int number of run.
     * @return a boolean that represents whether the ride can run that many times
     *         before it must be inspected.
     */
    public abstract boolean canRun(int numberOfRuns);

    /**
     * Resets runsSinceInspection.
     * 
     * @param components an array of Strings that represent different components of
     *                   the ride.
     * @return if the ride passes inspection and returns true, otherwise false.
     */
    public abstract boolean inspectRide(String[] components);

    /**
     * @param numberOfStops an int number of stops.
     * @return a double cost for the passenger.
     */
    public abstract double costPerPassenger(int numberOfStops);

    /**
     * @param numberOfStops an int number of stops.
     * @param newPassengers an array of Strings with passenger names.
     * @return true if all passengers can fit to ride, the ride can travel the given
     *         number of stops, otherwise false.
     */
    public abstract boolean addPassengers(int numberOfStops, String[] newPassengers);

    /**
     * @return a list of passengers, one per line, as a String.
     */
    public String getPassengerList() {
        String str;
        if (passengers == null) {
            str = String.format("Passenger List for " + id);
        } else {
            str = String.format("Passenger List for " + id + ":");
        }

        for (String passenger : passengers) {
            if (passenger != null) {
                str += "\n";
                str += passenger;
            }
        }
        return str;
    }

    /**
     * Takes in an int number of stops and increases earnings accordingly.
     * 
     * @param numberOfStops an int number of stops.
     */
    public final void chargePassenger(int numberOfStops) {
        double cost = costPerPassenger(numberOfStops);
        for (String passenger : passengers) {
            if (passenger != null) {
                earnings += cost;
            }
        }
    }

    /**
     * Removes the first occurrence of a passenger from the ride.
     *
     * @param name the name of the passenger
     * @return true if the passenger was found and removed, false otherwise
     */
    public boolean removePassenger(String name) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].toUpperCase().equals(name.toUpperCase())) {
                passengers[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj.getClass().equals(this.getClass()))) {
            return false;
        }
        Ride ride = (Ride) obj;
        return id.equals(ride.id) && runsSinceInspection == ride.runsSinceInspection;
    }

    @Override
    public String toString() {
        return String.format("%s has run %d times and has earned $%.2f.", id, runsSinceInspection, earnings);
    }
}

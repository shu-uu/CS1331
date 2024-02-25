/**
 * Trolley class representing a regular trolley in your transport network.
 * 
 * @author Siwoo Park
 * @version 1.0
 */
public class Trolley extends Ride {
    private String[] stations;
    private int currentStation;

    /**
     * A constructor that takes in id, runsSinceInspection, stations,
     * currentStation.
     * 
     * @param id                  a String representing the identifier for the ride.
     * @param runsSinceInspection an int representing the number of times the ride
     *                            has run since the last inspection.
     * @param stations            String array represents the general areas of
     *                            Trolley routes.
     * @param currentStation      an int representing an index to an element in the
     *                            stations array.
     */
    public Trolley(String id, int runsSinceInspection, String[] stations, int currentStation) {
        super(id, runsSinceInspection, new String[20]);
        this.stations = new String[stations.length];
        for (int i = 0; i < stations.length; i++) {
            this.stations[i] = stations[i];
        }
        this.currentStation = currentStation;
    }

    /**
     * A constructor that takes in id, stations, currentStation.
     * 
     * @param id             a String representing the identifier for the ride.
     * @param stations       String array represents the general areas of Trolley
     *                       routes.
     * @param currentStation an int representing an index to an element in the
     *                       stations array.
     */
    public Trolley(String id, String[] stations, int currentStation) {
        this(id, 0, stations, currentStation);
    }

    /**
     * @param numberOfRuns an int number of run.
     * @return whether the trolley can run that many loops.
     */
    public boolean canRun(int numberOfRuns) {
        return numberOfRuns >= 0;
    }

    /**
     * @param components an array of String that represent different components of
     *                   the ride.
     * @return true if the ride passes inspection, otherwise false.
     */
    public boolean inspectRide(String[] components) {
        boolean gasTankNotEmpy = false;
        boolean brakesOk = false;
        for (String component : components) {
            if (component.toUpperCase().equals(("Gas Tank Not Empty".toUpperCase()))) {
                gasTankNotEmpy = true;
            }
            if (component.toUpperCase().equals(("Brakes Ok".toUpperCase()))) {
                brakesOk = true;
            }
        }
        if (gasTankNotEmpy && brakesOk) {
            super.runsSinceInspection = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param numberOfStops an int number of stops.
     * @return the double cost for the passenger to travel that number of stops.
     */
    public double costPerPassenger(int numberOfStops) {
        int numLoops = stations.length;
        double costPerLoop = numberOfStops * 3.0 / numLoops;
        return costPerLoop;
    }

    /**
     * @param numberOfStops an int number of stops.
     * @param passengers    an array of Strings with passenger names.
     * @return true if the trolley can travel the given number of loops, otherwise
     *         false.
     */
    public boolean addPassengers(int numberOfStops, String[] newPassengers) {
        if (!canRun(numberOfStops)) {
            return false;
        }

        for (String newPassenger : newPassengers) {
            boolean added = false;
            for (int i = 0; i < super.passengers.length; i++) {
                if (super.passengers[i] == null) {
                    super.passengers[i] = newPassenger;
                    earnings += costPerPassenger(numberOfStops); // Charge each passenger once
                    added = true;
                    break;
                }
            }
            if (!added) {
                // Stop adding passengers if there are no more empty seats
                break;
            }
        }

        moveTrolley(numberOfStops);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Trolley other = (Trolley) obj;
        if (currentStation != other.currentStation) {
            return false;
        }
        if (stations.length != other.stations.length) {
            return false;
        }
        for (int i = 0; i < stations.length; i++) {
            if (!stations[i].equalsIgnoreCase(other.stations[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Takes in the number of stations to advance and returns nothing.
     * 
     * @param numStations an int number of stations.
     */
    public void moveTrolley(int numStations) {
        int numLoops = stations.length;
        int totalStations = numStations + currentStation;
        int loopsCompleted = totalStations / numLoops;
        super.runsSinceInspection = super.runsSinceInspection + loopsCompleted;
        currentStation = totalStations % numLoops;
    }

    @Override
    public String toString() {
        String nextStation = stations[(currentStation + 1) % stations.length];
        return String.format("Trolley %s has driven %d loops and has earned $%.2f."
                + " This trolley is at %s. Next up is %s.",
                super.id, super.runsSinceInspection, super.earnings, stations[currentStation], nextStation);
    }
}

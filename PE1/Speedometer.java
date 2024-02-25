/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Speedometer {
    // Siwoo Park, I like to sing when I feel bad.
    public static void main(String[] args) {
        int kilometers = 50;
        double kmPerMile = 1.60934;
        double hours = 0.54;
        String name = "Siwoo";
        double miles = kilometers / kmPerMile;
        double milesTrunc = ((int) (miles * 1000)) / 1000.0;
        double speed = ((int) ((milesTrunc / hours) * 100)) / 100.0;

        System.out.println(name + " drove at a speed of " + speed
                + " mph for " + milesTrunc + " miles!");
    }
}

/**
 * Driver class will be used to test your code.
 * @author Siwoo Park
 * @version 1.0
 */
public class Driver {
    /**
     * Use this class's main method to test my code.
     * @param args a command line argument it is a collection of variables in the string format.
     */
    public static void main(String[] args) {
        RollerCoaster rollerCoaster1 = new RollerCoaster("Superman", 30, 100);
        RollerCoaster rollerCoaster2 = new RollerCoaster("RollerCoaster2", 15, 3);

        rollerCoaster1.addPassengers(3, new String[]{"P0", "P1", "P2", "P3"});

        System.out.println(rollerCoaster1);
        System.out.println(rollerCoaster2);
        System.out.println("");

        System.out.println("RollerCoaster1 and RollerCoaster2 are equal: " + rollerCoaster1.equals(rollerCoaster2));

        Trolley trolley1 = new Trolley("Tech Gold Route 321", 21,
            new String[]{"Scheller", "Klaus", "CRC", "Student Center"}, 2);
        Trolley trolley2 = new Trolley("Tech Gold Route 321", 21,
            new String[]{"Scheller", "Klaus", "CRC", "Student Center"}, 2);

        trolley1.addPassengers(10, new String[]{"S0", "S1", "S2", "S3", "S4", "S5", "S6"});

        System.out.println(trolley1);
        System.out.println(trolley2);
        System.out.println("");

        System.out.println("Trolley1 and Trolley2 are equal: " + trolley1.equals(trolley2));
    }
}
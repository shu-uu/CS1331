/**
 * This class is a test driver.
 * @author Siwoo Park
 * @version 1.0
 */
public class Aquarium {
    /**
     * Use this class's main method to test my code.
     * @param args a command line argument it is a collection of variables in the string format.
     */
    public static void main(String[] args) {

        Fish fish1 = new Fish("Ex Fish", 25.015, 16.015);
        Fish fish2 = new Fish();
        Fish fish3 = new Fish(fish1);

        Catfish catfish1 = new Catfish("catfish1", 42.3, 600.2, 3.0);
        Catfish catfish2 = new Catfish();
        Catfish catfish3 = new Catfish(catfish1);

        FlyingFish flyingFish1 = new FlyingFish("", 5.2, 1.9, 40);
        FlyingFish flyingFish2 = new FlyingFish();
        FlyingFish flyingFish3 = new FlyingFish(flyingFish1);

        StripedBass stripedBass1 = new StripedBass("stripedBass1", 6.4, 24.5, 4, false, catfish1);
        StripedBass stripedBass2 = new StripedBass();
        StripedBass stripedBass3 = new StripedBass(stripedBass1);

        System.out.println("Ex Fish");
        System.out.println(fish1);
        System.out.println("Ex Fish formatLength: " + fish1.formatLength());
        System.out.println("Ex Fish formatWeight: " + fish1.formatWeight());
        System.out.println("\n");

        System.out.println("Fish2");
        System.out.println(fish2);
        System.out.println("Fish2 formatLength: " + fish2.formatLength());
        System.out.println("Fish2 formatWeight: " + fish2.formatWeight());
        System.out.println("\n");

        System.out.println("Fish3");
        System.out.println(fish3);
        System.out.println("Fish3 formatLength: " + fish3.formatLength());
        System.out.println("Fish3 formatWeight: " + fish3.formatWeight());
        System.out.println("\n");

        System.out.println("Catfish1");
        System.out.println(catfish1);
        System.out.println("\n");
        System.out.println("Catfish2");
        System.out.println(catfish2);
        System.out.println("\n");
        System.out.println("Catfish3");
        System.out.println(catfish3);
        System.out.println("\n");

        System.out.println("FlyingFish1");
        System.out.println(flyingFish1);
        System.out.println("FlyingFish1 calculatePower: " + flyingFish1.calculatePower());
        flyingFish1.fly();
        System.out.println("\n");
        System.out.println("FlyingFish2");
        System.out.println(flyingFish2);
        System.out.println("FlyingFish2 calculatePower: " + flyingFish2.calculatePower());
        flyingFish2.fly();
        System.out.println("\n");
        System.out.println("FlyingFish3");
        System.out.println(flyingFish3);
        System.out.println("FlyingFish3 calculatePower: " + flyingFish3.calculatePower());
        flyingFish3.fly();
        System.out.println("\n");

        System.out.println("StripedBass1");
        System.out.println(stripedBass1);
        stripedBass1.migrate();
        System.out.println("\n");
        System.out.println("StripedBass2");
        System.out.println(stripedBass2);
        stripedBass2.migrate();
        System.out.println("\n");
        System.out.println("StripedBass3");
        System.out.println(stripedBass3);
        stripedBass3.migrate();
        System.out.println("\n");
    }
}
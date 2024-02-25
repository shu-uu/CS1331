/**
 * @author Siwoo Park
 * @version 1.0
 */
public class HalloweenNight {
    private TrickOrTreater[] cryptKickerFive = new TrickOrTreater[5];
    private TrickOrTreater[] ghoulGang = new TrickOrTreater[5];

    /**
     * A constructor that takes in arrays for cryptKickerFive and ghoulGang.
     * 
     * @param cryptKickerFive array of length 5.
     * @param ghoulGang       array of length 5.
     */
    public HalloweenNight(TrickOrTreater[] cryptKickerFive, TrickOrTreater[] ghoulGang) {
        for (int i = 0; i < 5; i++) {
            this.cryptKickerFive[i] = cryptKickerFive[i];
            this.ghoulGang[i] = ghoulGang[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("cryptKickerFive: ");
        for (int i = 0; i < cryptKickerFive.length; i++) {
            result.append(cryptKickerFive[i]);
            if (i < cryptKickerFive.length - 1) {
                result.append(", ");
            }
        }
        result.append(" versus ghoulGang: ");
        for (int i = 0; i < ghoulGang.length; i++) {
            result.append(ghoulGang[i]);
            if (i < ghoulGang.length - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

    /**
     * Trick-or-treaters in each group could be off to a head start.
     */
    public void compareTeams() {
        int cryptWins = 0, ghoulWins = 0;
        for (int i = 0; i < cryptKickerFive.length; i++) {
            if (cryptKickerFive[i].compareTo(ghoulGang[i]) > 0) {
                cryptWins += 1;
            } else if (cryptKickerFive[i].compareTo(ghoulGang[i]) < 0) {
                ghoulWins += 1;
            }
        }
        if (cryptWins > ghoulWins) {
            System.out.println("cryptKickerFive is favored.");
        } else if (ghoulWins > cryptWins) {
            System.out.println("ghoulGang is favored.");
        } else {
            System.out.println("Neither team is favored.");
        }
    }

    /**
     * A team’s total candy count must be at least this amount to win.
     * 
     * @param threshold the winning candy threshold.
     */
    public void battle(int threshold) {
        if (threshold <= 0) {
            threshold = 60;
        }
        for (int i = 0; i < cryptKickerFive.length; i++) {
            cryptKickerFive[i].trickOrTreat();
            if (cryptKickerFive[i] instanceof Ghost) {
                ((Ghost) cryptKickerFive[i]).rob(ghoulGang[i]);
            }
        }
        for (int i = 0; i < ghoulGang.length; i++) {
            ghoulGang[i].trickOrTreat();
            if (ghoulGang[i] instanceof Ghost) {
                ((Ghost) ghoulGang[i]).rob(cryptKickerFive[i]);
            }
        }
        int cryptCandy = 0, ghoulCandy = 0;
        for (int i = 0; i < cryptKickerFive.length; i++) {
            cryptCandy += cryptKickerFive[i].getNumCandy();
            ghoulCandy += ghoulGang[i].getNumCandy();
        }
        if (cryptCandy < threshold && ghoulCandy < threshold) {
            for (int i = 0; i < cryptKickerFive.length; i++) {
                cryptKickerFive[i].trickOrTreat();
                if (cryptKickerFive[i] instanceof Ghost) {
                    ((Ghost) cryptKickerFive[i]).rob(ghoulGang[i]);
                }
            }
            for (int i = 0; i < ghoulGang.length; i++) {
                ghoulGang[i].trickOrTreat();
                if (ghoulGang[i] instanceof Ghost) {
                    ((Ghost) ghoulGang[i]).rob(cryptKickerFive[i]);
                }
            }
            cryptCandy = 0;
            ghoulCandy = 0;
            for (int i = 0; i < cryptKickerFive.length; i++) {
                cryptCandy += cryptKickerFive[i].getNumCandy();
                ghoulCandy += ghoulGang[i].getNumCandy();
            }
        }
        if (cryptCandy >= threshold && ghoulCandy < threshold) {
            System.out.println("cryptKickerFive won!");
        } else if (ghoulCandy >= threshold && cryptCandy < threshold) {
            System.out.println("ghoulGang won!");
        } else {
            System.out.println("It is a tie!");
        }
    }
}

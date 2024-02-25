import java.util.Random;
import java.util.Scanner;

/**
 * @author Siwoo Park
 * @version 1.0
 */
public class PokemonBattle {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String myPokemon = "";
        String rivalPokemon = "";
        double rivPokeHealth = (double) (rand.nextInt(20) + 40);

        System.out.print("Enter your Pokemon's nickname: ");
        myPokemon = scan.nextLine();
        myPokemon = myPokemon.trim();

        System.out.print("Enter your rival Pokemon's nickname: ");
        rivalPokemon = scan.nextLine();
        rivalPokemon = rivalPokemon.trim();

        System.out.printf("Your rival has chosen %s to fight, which has %.2f health.%n", rivalPokemon, rivPokeHealth);

        int ranInt = 0;
        double ranDoub = 0;
        double totDam = 0;
        int turns = 0;

        do {
            AttackType attack = AttackType.values()[rand.nextInt(3)];
            if (attack == AttackType.SCRATCH) {
                ranInt = rand.nextInt(3) + 1;
                ranDoub = Math.round((rand.nextDouble() * 5.0 + 1.0) * 100.0) / 100.0;
                totDam = Math.round((ranInt * ranDoub) * 100.0) / 100.0;
            } else if (attack == AttackType.SURF) {
                totDam = Math.round((rand.nextDouble() * 9 + 2.0) * 100.0) / 100.0;
            } else {
                totDam = Math.round((rand.nextDouble() * 2 + 7.0) * 100.0) / 100.0;
            }
            rivPokeHealth = Math.max(rivPokeHealth - totDam, 0);
            System.out.printf("%s used %s and did %.2f damage. Your rival has %.2f health remaining.%n",
                    myPokemon, attack, totDam, rivPokeHealth);
            turns += 1;
        } while (rivPokeHealth > 0);
        System.out.println(rivalPokemon + " fainted after " + turns + " turns!");

        double prize = Math.round((-1200.0 * rand.nextDouble() + 2400.0) * 100.0) / 100.0;

        System.out.printf("You have earned $%.2f!%n", prize);

        scan.close();
    }
}
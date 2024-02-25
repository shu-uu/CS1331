/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Driver {

    public static void main(String[] args) {

        Roster team = new Roster();

        System.out.println("\n");

        Player player1 = new Player();
        Player player2 = new Player("Son", 90, new Position[] { Position.FORWARD }, 95);
        Player player3 = new Player("Kim", 80, new Position[] { Position.DEFENDER, Position.MIDFIELDER }, 85);

        System.out.println("\n");
        team.signPlayer(0, player1);
        team.signPlayer(1, player2);
        team.signPlayer(2, player3);

        System.out.println("\n" + team + "\n");

        team.transferPlayer(1);

        System.out.println("\n" + team + "\n");

        team.showBestPlayers(80);
        System.out.println();

        team.trainAllPlayers();
        System.out.println();

        System.out.println("\n" + team + "\n");
    }
}

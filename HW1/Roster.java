import java.util.Random;

/**
 * @author Siwoo Park
 * @version 1.0
 */
public class Roster {
    private Player[] players;
    private int size;

    public Roster(Player[] playersArr) {
        int sizes = 0;
        for (Player p : playersArr) {
            if (p != null) {
                sizes++;
            }
        }
        this.players = playersArr;
        this.size = sizes;
    }

    public Roster() {
        this.players = new Player[4];
        this.size = 0;
    }

    public Player signPlayer(int index, Player player) {
        if (index >= 0 && index < players.length && player != null) {
            Player oldPlayer = players[index];
            if (oldPlayer == null) {
                System.out.println("Signed: " + player);
                size += 1;
            } else {
                System.out.println("Replaced: " + oldPlayer);
            }
            players[index] = player;
            return oldPlayer;
        }
        System.out.println("Cannot add a player to this spot on the roster.");
        return null;
    }

    public Player transferPlayer(int index) {
        if (index >= 0 && index < players.length && players[index] != null) {
            Player transferred = players[index];
            System.out.println("Transferred: " + transferred);
            players[index] = null;
            size -= 1;
            return transferred;
        }
        System.out.println("There was no player to transfer!");
        return null;
    }

    public void showBestPlayers(int skillRating) {
        boolean found = false;
        for (Player p : players) {
            if (p != null && p.getSkillRating() > skillRating) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No players found above the given skill rating.");
        }
    }

    public void trainAllPlayers() {
        Random rand = new Random();
        boolean trained = false;
        for (Player p : players) {
            if (p != null) {
                int oldRating = p.getSkillRating();
                p.setSkillRating(oldRating + rand.nextInt(10) + 1);
                System.out.println("Trained to " + p.getSkillRating() + ": " + p);
                trained = true;
            }
        }
        if (!trained) {
            System.out.println("There were no players to train.");
        }
    }

    public void play(int index, Position position) {
        if (index < 0 || index >= players.length || players[index] == null) {
            System.out.println("Cannot play the player in this spot.");
            return;
        }
        Player player = players[index];
        boolean isPreferred = false;
        for (Position pos : player.getPreferredPosition()) {
            if (pos == position) {
                isPreferred = true;
                break;
            }
        }
        if (isPreferred) {
            int lossStamina = new Random().nextInt(5) + 1;
            player.setStamina(Math.max(0, player.getStamina() - lossStamina));
            System.out.println("Played: " + player);
        } else if (player.canPlayAs(position)) {
            int lossStamina2 = new Random().nextInt(6) + 5;
            player.setStamina(Math.max(0, player.getStamina() - lossStamina2));
            System.out.println("Played: " + player);
        } else {
            System.out.println("This player cannot be played in position " + position + ".");
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "The team has no players!";
        }
        String str1 = String.format("There are %d players on Java FC.\n", size);
        String str2 = "";
        for (Player p : players) {
            if (p != null) {
                str2 += p + "\n";
            }
        }
        return str1 + str2.trim();
    }
}
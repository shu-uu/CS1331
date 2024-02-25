import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Siwoo Park
 * @version 1
 */
public class Driver {
    /**
     * @param args to be inputted.
     * @throws InvalidTicketException if ticket is invalid.
     * @throws IOException input or output operation is failed or interpreted.
     */
    public static void main(String[] args) throws InvalidTicketException, IOException {
        BasketballGame game1 = new BasketballGame("McCamish Pavilion", "19:30", "11-07-2022",
            93, 63, 6192, "Atlantic Coast Conference");
        BasketballGame game2 = new BasketballGame("McCamish Pavilion", "19:30", "11-07-2022",
            93, 63, 6192, "Atlantic Coast Conference");
        FootballGame game3 = new FootballGame("Bobby Dodd Stadium", "16:00", "10-08-2022",
            23, 20, 17267, "Buzz");
        FootballGame game4 = new FootballGame("Bobby Dodd Stadium", "16:00", "10-08-2022",
            23, 20, 17267, "Buzz");
        ArrayList<SportsGame> gameList = new ArrayList<>();
        gameList.add(game1);
        gameList.add(game2);
        gameList.add(game3);
        gameList.add(game4);
        Tickets.purchaseTickets("TestTickets.csv", gameList);
        Tickets.retrieveGames("TestTickets.csv");
    }
}
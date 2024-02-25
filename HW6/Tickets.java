import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * @author Siwoo Park
 * @version 1.0
 */

public class Tickets {
    /**
     * @param file the path name of the file to read from.
     * @return arrayList of SportsGame objects.
     * @throws FileNotFoundException if file is not found.
     * @throws InvalidTicketException if file is invalid.
     */
    public static ArrayList<SportsGame> retrieveGames(String file)
        throws FileNotFoundException, InvalidTicketException {
        if (file == null || file.isBlank()) {
            throw new FileNotFoundException("file contains null or is a blank, enter the valid file");
        }
        File f = new File(file);
        if (!f.isFile()) {
            throw new FileNotFoundException("Please give a file directory that exists.");
        }
        if (!f.exists()) {
            throw new FileNotFoundException("File path is not valid.");
        }
        ArrayList<SportsGame> arrList = new ArrayList<SportsGame>();
        Scanner scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String info = scan.nextLine();
            arrList.add(processInfo(info));
        }
        scan.close();
        return arrList;
    }

    /**
     * Private helper method to process lines from the CSV to a baskeball or football game.
     * @param line the line of info to process.
     * @return SportsGame the sports game object that is returned.
     * @throws InvalidTicketException if file is invalid.
     */
    private static SportsGame processInfo(String line) throws InvalidTicketException {
        String[] arr = line.split(",");
        SportsGame sg;
        if (arr[0].equals("BasketballGame")) {
            sg = new BasketballGame(arr[1], arr[2], arr[3], (int) Integer.parseInt(arr[4]),
            (int) Integer.parseInt(arr[5]), (int) Integer.parseInt(arr[6]), arr[7]);
        } else if (arr[0].equals("FootballGame")) {
            sg = new FootballGame(arr[1], arr[2], arr[3], (int) Integer.parseInt(arr[4]),
            (int) Integer.parseInt(arr[5]), (int) Integer.parseInt(arr[6]), arr[7]);
        } else {
            throw new InvalidTicketException("Please use BasketballGame or FootballGame.");
        }
        return sg;
    }

    /**
     * Purchases the tickets and adds them to the ticket file.
     * @param file String of the pathanme of the file to read from.
     * @param arrList the arrayList of sports games to purchase.
     * @throws IOException input or output operation is failed or interpreted.
     * @throws InvalidTicketException if ticket is invalid.
     */
    public static void purchaseTickets(String file, ArrayList<SportsGame> arrList)
            throws IOException, InvalidTicketException {
        if (file == null || file.isBlank()) {
            throw new IllegalArgumentException("No null or blank file name.");
        }
        File f = new File(file);
        if (!f.isFile() || !f.exists()) {
            f.createNewFile();
            PrintWriter printwrite = new PrintWriter(f);
            for (int i = 0; i < arrList.size(); i++) {
                if (arrList.get(i).getSeatsLeft() != 0) {
                    printwrite.println(arrList.get(i).toString());
                }
            }
            printwrite.close();
        } else {
            ArrayList<SportsGame> finalGameList = new ArrayList<>();
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                finalGameList.add(processInfo(reader.nextLine()));
            }
            reader.close();
            for (int i = 0; i < arrList.size(); i++) {
                if (arrList.get(i).getSeatsLeft() > 0) {
                    finalGameList.add(arrList.get(i));
                }
            }
            PrintWriter printwrite = new PrintWriter(f);
            for (int i = 0; i < finalGameList.size(); i++) {
                printwrite.println(finalGameList.get(i).toString());
            }
            printwrite.close();
        }
    }

    /**
     * Finds the line number of a given game in a file and returns the list of lines as an ArrayList.
     * @param file String represents the pathanme of the file to read from.
     * @param sportgame the sportsgame to find.
     * @return ArrayList an arraylist of Integer objects that have the numbers of the games retrieved.
     * @throws FileNotFoundException if file is not found.
     * @throws InvalidTicketException if ticket is invalid.
     */
    public static ArrayList<Integer> findTickets(String file,
        SportsGame sportgame) throws FileNotFoundException, InvalidTicketException {
        if (file == null || file.isBlank()) {
            throw new FileNotFoundException("No null or blank file name.");
        }
        File f = new File(file);
        if (!f.isFile() || !f.exists()) {
            throw new FileNotFoundException("No file exists.");
        }
        Scanner scan = new Scanner(f);
        int i = 0;
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            SportsGame sportgame2 = processInfo(line);
            if (sportgame.equals(sportgame2)) {
                arrList.add(Integer.valueOf(i));
            }
            i += 1;
        }
        if (arrList.isEmpty()) {
            throw new InvalidTicketException("This ticket was not found.");
        }
        scan.close();
        return arrList;
    }

    /**
     * Attends every instance of a game and removes the ticket from the file.
     * @param file String of the pathanme of the file to read from.
     * @param sportgame the sports game to attend.
     * @throws FileNotFoundException if file is not found.
     * @throws IOException input or output operation is failed or interpreted.
     * @throws InvalidTicketException if ticket is invalid.
     */
    public static void attendGame(String file, SportsGame sportgame)
            throws FileNotFoundException, IOException, InvalidTicketException {
        if (file == null || file.isBlank()) {
            throw new FileNotFoundException("No null or blank file name.");
        }
        File f = new File(file);
        if (!f.isFile() || !f.exists()) {
            throw new FileNotFoundException("No file exists.");
        }
        ArrayList<Integer> findTicket = findTickets(file, sportgame);
        File test = new File("TestTickets.csv");
        test.createNewFile();
        PrintWriter printwrite = new PrintWriter(test);
        Scanner scan = new Scanner(f);
        Integer i = Integer.valueOf(0);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (!findTicket.contains(i)) {
                if (!line.isBlank()) {
                    SportsGame sport2 = processInfo(line);
                    printwrite.println(sport2.toString());
                }
            }
            i += 1;
        }
        scan.close();
        f.delete();
        printwrite.close();
        test.renameTo(f);
    }
}
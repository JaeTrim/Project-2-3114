import java.io.File;
import java.util.Scanner;

/**
 * FileReader Class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-19-09
 */

public class FileReader {

    private SeminarDB world;

    /**
     * Constructor for FileReader
     * 
     * @param size
     *            of world
     * @param file
     *            for name of file
     * @throws Exception
     */
    public FileReader(int size, String file) throws Exception {
        world = new SeminarDB(size, file);
        readFile(file);
    }


    /**
     * Reads the input file
     * 
     * @param name
     *            of file
     * @throws Exception
     */
    public void readFile(String name) throws Exception {
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String currLine = scanner.nextLine();
            currLine = currLine.trim();
            if (currLine.contains("insert")) {
                String[] insertLine = currLine.split("\\s+");
                int id = Integer.parseInt(insertLine[1]);
                String title = scanner.nextLine().trim();
                String date = scanner.next().trim();
                int length = Integer.parseInt(scanner.next());
                short xCoord = Short.parseShort(scanner.next());
                short yCoord = Short.parseShort(scanner.next());
                int cost = Integer.parseInt(scanner.next());
                scanner.nextLine();
                String keywordLine = scanner.nextLine().trim();
                String[] keywords = keywordLine.split("\\s+");
                String description = scanner.nextLine();
                String formatDesc = description.trim();
                Seminar sem = new Seminar(id, title, date, length, xCoord,
                    yCoord, cost, keywords, formatDesc);
                world.insert(sem);

            }
            else if (currLine.contains("search")) {
                String[] searchLine = currLine.split("\\s+");
                if (searchLine[1].equals("location")) {
                    int x = Integer.parseInt(searchLine[2]);
                    int y = Integer.parseInt(searchLine[3]);
                    int radius = Integer.parseInt(searchLine[4]);
                    world.searchLocation(x, y, radius);
                }
                else if (searchLine[1].equals("keyword")) {
                    String word = searchLine[2];
                    world.searchKeyword(word);
                }
                else if (searchLine[1].equals("ID")) {
                    int id = Integer.parseInt(searchLine[2]);
                    world.searchID(id);
                }
                else if (searchLine[1].equals("date")) {
                    String dateTime1 = searchLine[2];
                    String dateTime2 = searchLine[3];
                    world.searchDate(dateTime1, dateTime2);
                }
                else  {
                    int low = Integer.parseInt(searchLine[2]);
                    int high = Integer.parseInt(searchLine[3]);
                    world.searchCost(low, high);
                }
            }
            else if (currLine.contains("print")) {
                String[] printLine = currLine.split("\\s+");
                String printCommand = printLine[1];
                world.print(printCommand);

            }
            else if (currLine.contains("delete")) {
                String[] deleteLine = currLine.split("\\s+");
                int id = Integer.parseInt(deleteLine[1]);
                world.delete(id);

            }
        }
        scanner.close();

    }
}

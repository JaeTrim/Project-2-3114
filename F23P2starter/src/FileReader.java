import java.io.File;
import java.util.Scanner;

/**
 * FileReader Class
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 2023-19-09
 */

public class FileReader {
    
    /**
     * Constructor for FileReader
     * @param size of world
     * @param file for name of file
     * @throws Exception
     */
    public FileReader(int size, String file) throws Exception{
        SeminarDB world = new SeminarDB(size, file);
        readFile(file);
    }

    /**
     * Reads the input file
     * @param name of file
     * @throws Exception
     */
    public void readFile(String name) throws Exception {
        File file = new File(name);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String currLine = scanner.nextLine();
            currLine = currLine.trim();
            if (currLine.contains("insert")){
                String[] insertLine = currLine.split("\\s+");
                if (insertLine.length == 2){
                    char[] charArray = insertLine[1].toCharArray();
                    boolean found = false;
                    for (int i = 0; i < charArray.length; i++) {
                        if (!Character.isDigit(charArray[i])) {
                            found = true;
                        }
                    }
                    if (found == false){
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
                        Seminar sem = new Seminar(id, title, date, length,
                            xCoord, yCoord, cost, keywords, formatDesc);
                    }
                    else {
                        scanner.nextLine();
                        scanner.nextLine();
                        scanner.nextLine();
                        scanner.nextLine();
                    }
                }
                else {
                    scanner.nextLine();
                    scanner.nextLine();
                    scanner.nextLine();
                    scanner.nextLine();
                }
            }
            else if (currLine.contains("search")) {
                String[] searchLine = currLine.split("\\s+");
                if (searchLine[1] == "location"){
                    int x = Integer.parseInt(searchLine[2]);
                    int y = Integer.parseInt(searchLine[3]);
                    int radius = Integer.parseInt(searchLine[4]);
                }
                else if (searchLine[1] == "keyword"){
                    String word = searchLine[2];
                }
                else if (searchLine[1] == "ID" && searchLine[1] != null){
                    int id = Integer.parseInt(searchLine[2]);
                }
                else if (searchLine[1] == "cost"){
                    int low = Integer.parseInt(searchLine[2]);
                    int high = Integer.parseInt(searchLine[3]);
                }
                else if (searchLine[1] == "date"){
                    int dateTime1 = Integer.parseInt(searchLine[2]);
                    int dateTime2 = Integer.parseInt(searchLine[3]);
                }

            }
            else if (currLine.contains("print")) {
                String[] printLine = currLine.split("\\s+");
                String print = printLine[1];

            }
            else if (currLine.contains("delete")) {
                String[] deleteLine = currLine.split("\\s+");
                int id = Integer.parseInt(deleteLine[1]);
                

            }
        }
        scanner.close();
        
    }
}

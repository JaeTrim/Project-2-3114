import student.TestCase;

public class SeminarDBTest extends TestCase {

    private BST keywords;
    private SeminarDB world;

    public void setUp() {
        keywords = new BST();
        world = new SeminarDB(128, "P2Sample_input.txt");
    }


    public void testPrint() {
        world.print("keyword");
        String out = "Keyword Tree:\r\n" + "This tree is empty";
        assertFuzzyEquals(systemOut().getHistory(), out);

        world.print("cost");
        out = "Keyword Tree:\r\n" + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty";
        assertFuzzyEquals(systemOut().getHistory(), out);

        world.print("date");
        out = "Keyword Tree:\r\n" + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty";
        assertFuzzyEquals(systemOut().getHistory(), out);

        world.delete(1);
        out = "Keyword Tree:\r\n" + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\r\n"
            + "Delete FAILED -- There is no record with ID 1";
        assertFuzzyEquals(systemOut().getHistory(), out);

        short x = -1;
        short y = 1;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");

        world.insert(sem);
        out = "Keyword Tree:\r\n" + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\r\n"
            + "Delete FAILED -- There is no record with ID 1\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 1";
        assertFuzzyEquals(systemOut().getHistory(), out);

        x = 1;
        y = -1;
        Seminar sem2 = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        world.insert(sem2);
        out = "Keyword Tree:\r\n" + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\r\n"
            + "Delete FAILED -- There is no record with ID 1\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 1\r\n"
            + "Insert FAILED - Bad x, y coordinates: 1, -1";
        assertFuzzyEquals(systemOut().getHistory(), out);

        x = 150;
        y = 10;
        Seminar sem3 = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        world.insert(sem3);
        out = "Keyword Tree:\r\n" + "This tree is empty\r\n" + "Cost Tree:\r\n"
            + "This tree is empty\r\n" + "Date Tree:\r\n"
            + "This tree is empty\r\n"
            + "Delete FAILED -- There is no record with ID 1\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 1\r\n"
            + "Insert FAILED - Bad x, y coordinates: 1, -1\r\n"
            + "Insert FAILED - Bad x, y coordinates: 150, 10";
        assertFuzzyEquals(systemOut().getHistory(), out);

        x = 10;
        y = 150;
        Seminar sem4 = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        world.insert(sem4);
        out = "Keyword Tree:\r\n"
            + "This tree is empty\r\n"
            + "Cost Tree:\r\n"
            + "This tree is empty\r\n"
            + "Date Tree:\r\n"
            + "This tree is empty\r\n"
            + "Delete FAILED -- There is no record with ID 1\r\n"
            + "Insert FAILED - Bad x, y coordinates: -1, 1\r\n"
            + "Insert FAILED - Bad x, y coordinates: 1, -1\r\n"
            + "Insert FAILED - Bad x, y coordinates: 150, 10\r\n"
            + "Insert FAILED - Bad x, y coordinates: 10, 150";
        assertFuzzyEquals(systemOut().getHistory(), out);

        
    }
}

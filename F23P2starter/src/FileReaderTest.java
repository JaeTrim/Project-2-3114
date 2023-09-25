import student.TestCase;

/**
 * Test class for FileReader 
 */
public class FileReaderTest extends TestCase{
    
    /*
     * SetUp Constructor
     */
    public void setUp() throws Exception {
        int worldSize = 64;
        String file = "P2Sample_input.txt";
        new FileReader(worldSize, file);
    }

}

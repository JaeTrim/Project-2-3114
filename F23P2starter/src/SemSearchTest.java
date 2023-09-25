import java.io.FileNotFoundException;
import student.TestCase;

/**
 * @author {Your Name Here}
 * @version {Put Something Here}
 */
public class SemSearchTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }


    /**
     * Get code coverage of the class declaration.
     * @throws Exception 
     */
    public void testMInitx() throws Exception
    {
        SemSearch sem = new SemSearch();
        assertNotNull(sem);
        boolean thrown = false;
        try {
            SemSearch.main(null);
        }
        catch (Exception e) {
            Exception nullExc = new Exception("No Args");
            assertEquals(e.toString(), nullExc.toString());
            thrown = true;
        }
        assertTrue(thrown);
       
    }
    
    /**
     * 
     * Creates test method to test if memory and has are powers of two
     * 
     * @throws Exception
     */
    public void testPowerOfTwo() throws Exception {
        assertEquals(SemSearch.powerOfTwo(2), true);
        assertEquals(SemSearch.powerOfTwo(3), false);
    }
    
    /**
     * Test no exception
     * 
     * @throws Exception
     */
    public void testFileNotFound() throws Exception {
        String[] args = new String[] {"2", "testname"};
        boolean thrown = false;
        try {
            SemSearch.main(args);
        }
        catch (FileNotFoundException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    
    /**
     * Test Power of Two Exception
     * @throws Exception
     */
    public void testPowerOfTwoException() throws Exception {
        String[] args = new String[] {"12", "testname"};
        boolean thrown = false;
        try {
            SemSearch.main(args);
        }
        catch (Exception e) {
            Exception temp = new Exception("World Size Not A Power of 2");
            thrown = true;      
            assertEquals(e.toString(), temp.toString());
        }
        assertTrue(thrown);        
    }

}


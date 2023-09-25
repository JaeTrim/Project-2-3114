/**
 * 
 */
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import student.TestCase;

/**
 * 
 */
public class BSTTest extends TestCase {
    
    private BST<Integer, String> bst;
    
    public void setUp() {
        bst = new BST<>();
        bst.insert(new KVPair<>(5, "Five"));
        bst.insert(new KVPair<>(3, "Three"));
        bst.insert(new KVPair<>(7, "Seven"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(4, "Four"));
    }
    
    public void testInsert() {
        assertEquals("Five", bst.findValue(5));
        assertEquals("Three", bst.findValue(3));
        assertEquals("Seven", bst.findValue(7));
        assertEquals("Two", bst.findValue(2));
        assertEquals("Four", bst.findValue(4));
    }
    
    public void testFind() {
        assertEquals("Five", bst.find(5).value());
        assertEquals("Three", bst.find(3).value());
        assertNull(bst.find(6));
    }
    
    public void testRemove() {
        assertEquals("Five", bst.remove(5).value());
        assertNull(bst.find(5));
        assertNull(bst.remove(5));
        assertEquals("Seven", bst.remove(7).value());
        assertNull(bst.find(7));
    }
    
    public void testSize() {
        assertEquals(5, bst.size());
        bst.remove(5);
        assertEquals(4, bst.size());
    }
    
    public void testClear() {
        bst.clear();
        assertNull(bst.getRoot());
        assertEquals(0, bst.size());
    }
    
    public void testPrint() {
        // Redirect console output to check printed keys
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        bst.print();

        String expectedOutput = "null\n7\nnull\n5\nnull\n4\nnull\n3\nnull\n2\nnull\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    
    
    
    
    
    

}

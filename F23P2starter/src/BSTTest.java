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
        assertEquals(5, bst.size());
        assertEquals("Five", bst.find(5).value());
        assertEquals("Two", bst.find(2).value());
        assertEquals("Seven", bst.find(7).value());
    }
    
    public void testFind() {
        assertEquals("Five", bst.find(5).value());
        assertEquals("Three", bst.find(3).value());
        assertNull(bst.find(8)); // Key not present in the BST
    }
    
    public void testRemove() {
        assertNotNull(bst.find(5));
        bst.remove(5, "Five");
        assertNull(bst.find(5));
        assertEquals(4, bst.size());
        
        assertNotNull(bst.find(3));
        bst.remove(3, "Three");
        assertNull(bst.find(3));
        assertEquals(3, bst.size());
        
        assertNull(bst.remove(8, "Eight")); // Removing a non-existent key
        assertEquals(3, bst.size()); // Size remains the same
        
        bst = new BST<>();
        bst.insert(new KVPair<>(5, "Five"));
        
    }
    
    public void testRangeSearch() {
        SearchResult result = new SearchResult();
        bst.rangeSearch(bst.getRoot(), 2, 4, result);
        assertEquals("Two\nThree\nFour\n", result.getOutput());
        assertEquals(7, result.getNodesVisited());
    }
    
    public void testFindValue() {
        assertEquals("Five", bst.findValue(5, "Five").value().value());
        assertNull(bst.findValue(5, "WrongValue")); // Value mismatch
        assertNull(bst.findValue(8, "Eight")); // Key not present in the BST
    }
    
//    public void testRemoveSpecific() {
//        assertNotNull(bst.find(5));
//        bst.remove(5, "Five");
//        assertNull(bst.find(5));
//        assertEquals(4, bst.size());
//    }
//    
    
}

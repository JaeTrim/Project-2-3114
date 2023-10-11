
import student.TestCase;

/**
 * Test Class for BST
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */
public class BSTTest extends TestCase {

    private BST<Integer, String> bst;

    /**
     * setUp Constructor
     */
    public void setUp() {
        bst = new BST<>();
        bst.insert(new KVPair<>(1, "One"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(3, "Three"));
        bst.insert(new KVPair<>(4, "Four"));
        bst.insert(new KVPair<>(5, "Five"));
    }


    /**
     * Test Size
     */
    public void testSize() {
        bst = new BST<>();
        assertEquals(0, bst.size());

        bst.insert(new KVPair<>(1, "One"));
        assertEquals(1, bst.size());

        bst.insert(new KVPair<>(2, "Two"));
        assertEquals(2, bst.size());

        bst.remove(1, "One");
        assertEquals(1, bst.size());
    }


    /**
     * Test getRoot
     */
    public void testGetRoot() {
        bst = new BST<>();
        assertNull(bst.getRoot());

        bst.insert(new KVPair<>(1, "One"));
        assertNotNull(bst.getRoot());

        assertEquals(1, (int)bst.getRoot().value().key());

        bst.remove(1, "One");
        assertNull(bst.getRoot());
    }


    /**
     * Test Insert
     */
    public void testInsertOneNode() {
        bst = new BST<>();
        bst.insert(new KVPair<>(1, "One"));
        assertNotNull(bst.getRoot());
        assertEquals(1, (int)bst.getRoot().value().key());
        assertNull(bst.getRoot().left());
        assertNull(bst.getRoot().right());
        assertEquals(1, bst.size());
    }


    /**
     * Test Harder
     */
    public void testInsertMultipleNodes() {
        bst = new BST<>();
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(1, "One"));
        bst.insert(new KVPair<>(3, "Three"));

        assertNotNull(bst.getRoot());
        assertEquals(2, (int)bst.getRoot().value().key());
        assertNotNull(bst.getRoot().left());
        assertNotNull(bst.getRoot().right());
        assertEquals(1, (int)bst.getRoot().left().value().key());
        assertEquals(3, (int)bst.getRoot().right().value().key());
        assertEquals(3, bst.size());
    }


    /**
     * Test Valid Range
     */
    public void testValidRange() {
        SearchResult result = new SearchResult();
        bst.rangeSearch(bst.getRoot(), 2, 4, result);

        assertEquals(7, result.getNodesVisited());
    }


    /**
     * Test Empty Range
     */
    public void testEmptyRange() {
        SearchResult result = new SearchResult();
        bst.rangeSearch(bst.getRoot(), 6, 7, result);

        assertEquals(6, result.getNodesVisited());
    }


    /**
     * Test Harder
     */
    public void testRangeSingleNode() {
        BST<Integer, String> nodeBST = new BST<>();
        nodeBST.insert(new KVPair<>(1, "One"));

        SearchResult result = new SearchResult();
        nodeBST.rangeSearch(nodeBST.getRoot(), 1, 2, result);

        assertEquals(3, result.getNodesVisited());
    }


    /**
     * Test Harder
     */
    public void testFindSameVal() {
        BSTNode<KVPair<Integer, String>> result = bst.findValue(2, "Two");
        assertNotNull(result);
        assertEquals(2, (int)result.value().key());
        assertEquals("Two", result.value().value());
    }


    /**
     * Test Harder
     */
    public void testFindVal() {
        BSTNode<KVPair<Integer, String>> result = bst.findValue(2,
            "AnotherValue");
        assertNull(result);
    }


    /**
     * Test Harder
     */
    public void testFindValueWithNonExistingKey() {

        BSTNode<KVPair<Integer, String>> result = bst.findValue(6, "Six");
        assertNull(result);
    }


    /**
     * Test Harder
     */
    public void testFindValueSingleNode() {
        BST<Integer, String> nodeBST = new BST<>();
        nodeBST.insert(new KVPair<>(1, "One"));
        BSTNode<KVPair<Integer, String>> result = nodeBST.findValue(1, "One");
        assertNotNull(result);
        assertEquals(1, (int)result.value().key());
        assertEquals("One", result.value().value());
    }


    /**
     * Test Remove
     */
    public void testRemove() {
        KVPair<Integer, String> removed = bst.remove(3, "Three");

        assertNotNull(removed);
        assertEquals(3, (int)removed.key());
        assertEquals("Three", removed.value());
        assertNull(bst.find(3));
        assertEquals(4, bst.size());

        KVPair<Integer, String> newPair = bst.remove(1, null);
        assertNull(bst.find(3));
        assertEquals("One", newPair.value());

    }


    /**
     * Test Remove
     */
    public void testRemove2() {
        KVPair<Integer, String> removed = bst.remove(6, "Six");
        assertNull(removed);
        assertEquals(5, bst.size());

    }


    /**
     * Test Remove
     */
    public void testRemove3() {
        KVPair<Integer, String> removed = bst.remove(2, "Two");
        assertNotNull(removed);
        assertEquals(2, (int)removed.key());
        assertEquals("Two", removed.value());
        assertNull(bst.find(2));
        assertEquals(4, bst.size());
    }


    /**
     * Test Remove
     */
    public void testRemove4() {
        KVPair<Integer, String> removed = bst.remove(4, "Four");
        assertNotNull(removed);
        assertEquals(4, (int)removed.key());
        assertEquals("Four", removed.value());
        assertNull(bst.find(4));
        assertEquals(4, bst.size());
    }


    /**
     * Test Remove
     */
    public void testRemove5() {
        bst.insert(new KVPair<>(1, "One"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(3, "Three"));
        assertEquals("One", bst.remove(1, "One").value());
        bst.remove(1, "One");
        assertNull(bst.find(1));
        assertNull(bst.find(20));
        bst.remove(3, "Three");
        bst.print();
        String out = "null\r\n" + "5\r\n" + "null\r\n" + "4\r\n" + "null\r\n"
            + "3\r\n" + "null\r\n" + "2\r\n" + "null\r\n" + "2\r\n" + "null";
        assertFuzzyEquals(systemOut().getHistory(), out);

    }


    /**
     * Test Remove
     */
    public void testRemoveSecondIfStatement() {
        bst = new BST<>();
        bst.insert(new KVPair<>(5, "Five"));
        bst.insert(new KVPair<>(3, "Three"));
        bst.insert(new KVPair<>(7, "Seven"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(4, "Four"));
        bst.insert(new KVPair<>(1, "One"));
        KVPair<Integer, String> removedNode = bst.remove(1, "DifferentValue");
        removedNode = new KVPair<>(1, "One");
        assertNotNull(bst.find(1));
    }


    /**
     * Test Remove
     */
    public void testRemoveRightChildNull() {
        bst = new BST<>();
        bst.insert(new KVPair<>(5, "Five"));
        bst.insert(new KVPair<>(3, "Three"));
        bst.insert(new KVPair<>(7, "Seven"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(4, "Four"));

        BSTNode<KVPair<Integer, String>> removedNode = bst.getRoot();
        bst.remove(5, "Five");
        bst.print();

        assertNotNull(removedNode);
        assertEquals("Four", removedNode.value().value());

        assertNull(bst.find(5));
        assertNotNull(removedNode.left());
        assertEquals(removedNode.right().value(), bst.getRoot().right()
            .value());
    }


    /**
     * Test Print
     */
    public void testPrint() {
        bst.insert(new KVPair<>(1, "One"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(3, "Three"));
        bst.insert(new KVPair<>(4, "Four"));
        bst.insert(new KVPair<>(5, "Five"));
        bst.print();
        String output = "null\r\n" + "5\r\n" + "null\r\n" + "5\r\n" + "null\r\n"
            + "4\r\n" + "null\r\n" + "4\r\n" + "null\r\n" + "3\r\n" + "null\r\n"
            + "3\r\n" + "null\r\n" + "2\r\n" + "null\r\n" + "2\r\n" + "null\r\n"
            + "1\r\n" + "null\r\n" + "1\r\n" + "null";
        assertFuzzyEquals(systemOut().getHistory(), output);
    }


    /**
     * Test Print
     */
    public void testPrint2() {
        bst = new BST<>();
        bst.print();
        assertFuzzyEquals(systemOut().getHistory(), "null");
        bst.insert(new KVPair<>(1, "One"));
        bst.print();
        assertFuzzyEquals(systemOut().getHistory(), "null\r\n" + "  null\r\n"
            + "1\r\n" + "  null");
        bst.insert(new KVPair<>(2, "Two"));
        bst.print();
        assertFuzzyEquals(systemOut().getHistory(), "null\r\n" + "  null\r\n"
            + "1\r\n" + "  null\r\n" + "    null\r\n" + "  2\r\n"
            + "    null\r\n" + "1\r\n" + "  null");

        systemOut().clearHistory();
        bst = new BST<>();
        bst.insert(new KVPair<>(5, "five"));
        bst.print();

        assertFuzzyEquals(systemOut().getHistory(), "  null\r\n" + "5\r\n"
            + "  null");

        bst = new BST<>();
        bst.insert(new KVPair<>(5, "five"));
        bst.insert(new KVPair<>(3, "three"));
        bst.insert(new KVPair<>(7, "seven"));

    }


    /**
     * Test Harder
     */
    public void testFindValue() {
        bst = new BST<>();
        bst.insert(new KVPair<>(5, "five"));
        bst.insert(new KVPair<>(3, "three"));
        bst.insert(new KVPair<>(7, "seven"));
        bst.insert(new KVPair<>(2, "two"));
        bst.insert(new KVPair<>(4, "four"));
        BSTNode<KVPair<Integer, String>> result1 = bst.findValue(3, "three");
        assertNotNull(result1);
        assertEquals(3, (int)result1.value().key());
        assertEquals("three", result1.value().value());
        BSTNode<KVPair<Integer, String>> result2 = bst.findValue(5, "Seven");
        assertNull(result2);
        BSTNode<KVPair<Integer, String>> result3 = bst.findValue(7, null);
        assertNull(result3);
        BSTNode<KVPair<Integer, String>> result4 = bst.findValue(6, "six");
        assertNull(result4);
    }


    /**
     * Test Harder
     */
    public void testHarder() {
        assertNull(bst.findValue(10, "1"));
        bst.insert(new KVPair<>(5, "A"));
        bst.insert(new KVPair<>(10, "B"));
        assertNull(bst.findValue(15, "C"));
        assertNotNull(bst.findValue(10, "B"));
        assertNotNull(bst.findValue(5, "A"));
        bst.insert(new KVPair<>(10, "D"));
        assertNull(bst.findValue(10, "B2"));
        assertNotNull(bst.findValue(10, "D"));
        assertNull(bst.findValue(15, "D"));
        bst.print();
        assertFuzzyEquals(systemOut().getHistory(), "            null\r\n"
            + "          10\r\n" + "              null\r\n"
            + "            10\r\n" + "              null\r\n" + "        5\r\n"
            + "            null\r\n" + "          5\r\n"
            + "            null\r\n" + "      4\r\n" + "        null\r\n"
            + "    3\r\n" + "      null\r\n" + "  2\r\n" + "    null\r\n"
            + "1\r\n" + "  null");

        bst = new BST<>();
        bst.insert(new KVPair<>(10, "A"));
        assertNotNull(bst.findValue(10, "A"));
        bst = new BST<>();
        bst.insert(new KVPair<>(10, "A"));
        assertNotNull(bst.findValue(10, "A"));
        bst = new BST<>();
        assertNull(bst.remove(10, "value"));
        bst.insert(new KVPair<>(10, "A"));
        assertNotNull(bst.remove(10, "A"));
        assertNull(bst.getRoot());
        bst.insert(new KVPair<>(10, "A"));
        assertNull(bst.remove(5, "B"));
        bst.insert(new KVPair<>(5, "B"));
        bst.insert(new KVPair<>(15, "C"));
        assertNotNull(bst.remove(10, "A"));
        assertNull(bst.find(10));
        assertNotNull(bst.find(5));
        assertNotNull(bst.find(15));
        bst.insert(new KVPair<>(7, "D"));
        assertNotNull(bst.remove(5, "B"));
        assertNull(bst.find(5));
        assertNotNull(bst.find(7));
        bst.insert(new KVPair<>(20, "E"));
        assertNull(bst.find(10));
        assertNotNull(bst.find(7));
        assertNotNull(bst.find(15));
        assertNotNull(bst.find(20));
        bst.insert(new KVPair<>(10, "A"));
        bst.insert(new KVPair<>(15, "C"));
        bst.insert(new KVPair<>(10, "E"));
        assertNotNull(bst.remove(10, "A"));
        bst.remove(10, "E");
        assertNull(bst.find(10));
        assertNotNull(bst.find(15));
        System.out.println("Break");
        systemOut().clearHistory();
        bst.print();
        String out = "    null\r\n" + "  20\r\n" + "    null\r\n" + "15\r\n"
            + "      null\r\n" + "    15\r\n" + "      null\r\n" + "  7\r\n"
            + "    null";
        assertFuzzyEquals(systemOut().getHistory(), out);
        bst = new BST<>();
        bst.insert(new KVPair<>(10, "apple"));

        // Insert nodes on the left side
        bst.insert(new KVPair<>(5, "banana"));
        bst.insert(new KVPair<>(3, "cherry"));
        bst.insert(new KVPair<>(7, "date"));
        assertNull(bst.getRoot().right());
        bst.remove(10, "apple");
        BSTNode<KVPair<Integer, String>> root = bst.getRoot();
        assertEquals(root.value().value(), "banana");

        System.out.println("Break");
        systemOut().clearHistory();
        bst.print();
        out = "    null\r\n" + "  7\r\n" + "    null\r\n" + "5\r\n"
            + "    null\r\n" + "  3\r\n" + "    null";
        assertFuzzyEquals(systemOut().getHistory(), out);
    }


    /**
     * Test Harder
     */
    public void testPrintTree() {

        bst = new BST<>();
        assertFuzzyEquals(systemOut().getHistory(), "");
        bst.insert(new KVPair<>(10, "apple"));

        bst.print();
    }


    /**
     * Test Harder
     */
    public void testRemoveHarder() {
        bst = new BST<>();
        bst.insert(new KVPair<>(10, "A"));
        assertTrue(bst.getRoot().value().compareTo(5) > 0);
        assertEquals(bst.getRoot().left(), null);
        assertTrue(bst.getRoot().value().compareTo(12) < 0);
        assertTrue(bst.getRoot().value().compareTo(10) == 0);
        bst.insert(new KVPair<>(5, "banana"));
        bst.insert(new KVPair<>(3, "cherry"));
        bst.insert(new KVPair<>(7, "date"));
        bst.remove(10, "apple");
        bst.print();
        String out = "  null\r\n" + "10\r\n" + "      null\r\n" + "    7\r\n"
            + "      null\r\n" + "  5\r\n" + "      null\r\n" + "    3\r\n"
            + "      null";
        assertFuzzyEquals(systemOut().getHistory(), out);
    }

}

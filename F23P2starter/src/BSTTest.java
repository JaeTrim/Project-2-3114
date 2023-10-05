
import student.TestCase;

public class BSTTest extends TestCase {

    private BST<Integer, String> bst;

    public void setUp() {
        bst = new BST<>();
        bst.insert(new KVPair<>(1, "One"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(3, "Three"));
        bst.insert(new KVPair<>(4, "Four"));
        bst.insert(new KVPair<>(5, "Five"));
    }


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


    public void testGetRoot() {
        bst = new BST<>();
        assertNull(bst.getRoot());

        bst.insert(new KVPair<>(1, "One"));
        assertNotNull(bst.getRoot());

        assertEquals(1, (int)bst.getRoot().value().key());

        bst.remove(1, "One");
        assertNull(bst.getRoot());
    }


    public void testInsertOneNode() {
        bst = new BST<>();
        bst.insert(new KVPair<>(1, "One"));
        assertNotNull(bst.getRoot());
        assertEquals(1, (int)bst.getRoot().value().key());
        assertNull(bst.getRoot().left());
        assertNull(bst.getRoot().right());
        assertEquals(1, bst.size());
    }


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


    public void testValidRange() {
        SearchResult result = new SearchResult();
        bst.rangeSearch(bst.getRoot(), 2, 4, result);

        assertEquals(7, result.getNodesVisited());
    }


    public void testEmptyRange() {
        SearchResult result = new SearchResult();
        bst.rangeSearch(bst.getRoot(), 6, 7, result);

        assertEquals(6, result.getNodesVisited());
    }


    public void testRangeSingleNode() {
        BST<Integer, String> nodeBST = new BST<>();
        nodeBST.insert(new KVPair<>(1, "One"));

        SearchResult result = new SearchResult();
        nodeBST.rangeSearch(nodeBST.getRoot(), 1, 2, result);

        assertEquals(3, result.getNodesVisited());
    }


    public void testFindSameVal() {
        BSTNode<KVPair<Integer, String>> result = bst.findValue(2, "Two");
        assertNotNull(result);
        assertEquals(2, (int)result.value().key());
        assertEquals("Two", result.value().value());
    }


    public void testFindVal() {
        BSTNode<KVPair<Integer, String>> result = bst.findValue(2,
            "AnotherValue");
        assertNull(result);
    }


    public void testFindValueWithNonExistingKey() {

        BSTNode<KVPair<Integer, String>> result = bst.findValue(6, "Six");
        assertNull(result);
    }


    public void testFindValueSingleNode() {
        BST<Integer, String> nodeBST = new BST<>();
        nodeBST.insert(new KVPair<>(1, "One"));
        BSTNode<KVPair<Integer, String>> result = nodeBST.findValue(1, "One");
        assertNotNull(result);
        assertEquals(1, (int)result.value().key());
        assertEquals("One", result.value().value());
    }


    public void testRemove() {
        KVPair<Integer, String> removed = bst.remove(3, "Three");

        assertNotNull(removed);
        assertEquals(3, (int)removed.key());
        assertEquals("Three", removed.value());
        assertNull(bst.find(3));
        assertEquals(4, bst.size());
    }


    public void testRemove2() {
        KVPair<Integer, String> removed = bst.remove(6, "Six");
        assertNull(removed);
        assertEquals(5, bst.size());
    }


    public void testRemove3() {
        KVPair<Integer, String> removed = bst.remove(2, "Two");
        assertNotNull(removed);
        assertEquals(2, (int)removed.key());
        assertEquals("Two", removed.value());
        assertNull(bst.find(2));
        assertEquals(4, bst.size());
    }


    public void testRemove4() {
        KVPair<Integer, String> removed = bst.remove(4, "Four");
        assertNotNull(removed);
        assertEquals(4, (int)removed.key());
        assertEquals("Four", removed.value());
        assertNull(bst.find(4));
        assertEquals(4, bst.size());
    }


    public void testRemove5() {
        bst.insert(new KVPair<>(1, "One"));
        bst.insert(new KVPair<>(2, "Two"));
        bst.insert(new KVPair<>(3, "Three"));
        assertEquals("One", bst.remove(1, "One").theVal);
        bst.remove(1, "One");
        assertNull(bst.find(1));
        assertNull(bst.find(20));
        bst.remove(3, "Three");
        bst.print();
        String out = "null\r\n" + "5\r\n" + "null\r\n" + "4\r\n" + "null\r\n"
            + "3\r\n" + "null\r\n" + "2\r\n" + "null\r\n" + "2\r\n" + "null";
        assertFuzzyEquals(systemOut().getHistory(), out);

    }


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

}

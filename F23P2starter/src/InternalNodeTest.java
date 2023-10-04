import student.TestCase;

public class InternalNodeTest extends TestCase {

    private InternalNode internalNode;
    private LeafNode node;

    public void setUp() {
        internalNode = new InternalNode();
        node = new LeafNode();
    }
    
    public void testBasics() {
        assertEquals(internalNode.left(), null);
        assertEquals(internalNode.right(), null);
        internalNode.setLeft(node);
        assertEquals(internalNode.left(), node);
        internalNode.setRight(node);
        assertEquals(internalNode.right(), node);
        assertEquals(internalNode.getLevel(), 0);
        internalNode.setLevel(1);
        assertEquals(internalNode.getLevel(), 1);
    }
    
    public void testCoords() {
        internalNode.setXEnd(10);
        internalNode.setXStart(0);
        internalNode.setYEnd(20);
        internalNode.setYStart(5);
        assertEquals(internalNode.getXEnd(), 10);
        assertEquals(internalNode.getYEnd(), 20);
        assertEquals(internalNode.getYStart(), 5);
        assertEquals(internalNode.getXStart(), 0);
    }
}

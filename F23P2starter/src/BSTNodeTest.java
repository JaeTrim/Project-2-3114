import student.TestCase;

public class BSTNodeTest extends TestCase {

    private BSTNode<String> node;
    
    public void setUp() {
        node = new BSTNode<>("40");
    }
    
    public void testValue() {
        assertEquals("40", node.value());
        node.setValue("50");
        assertEquals("50", node.value());
    }
    
    public void testLeft() {
        assertNull(node.left());

        BSTNode<String> leftNode = new BSTNode<>("20");
        node.setLeft(leftNode);
        assertEquals(leftNode, node.left());
    }
    
    public void testRight() {
        assertNull(node.right());

        BSTNode<String> rightNode = new BSTNode<>("50");
        node.setRight(rightNode);
        assertEquals(rightNode, node.right());
    }
    
    public void testIsLeaf() {
        assertTrue(node.isLeaf());

        BSTNode<String> leftNode = new BSTNode<>("20");
        node.setLeft(leftNode);
        assertTrue(!node.isLeaf());

        BSTNode<String> rightNode = new BSTNode<>("50");
        node.setRight(rightNode);
        assertTrue(!node.isLeaf());
    }
}

import student.TestCase;

/**
 * Test class for BSTNode
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */
public class BSTNodeTest extends TestCase {

    private BSTNode<String> node;

    /**
     * setUp Constructor
     */
    public void setUp() {
        node = new BSTNode<>("40");
    }


    /**
     * Test For Node Class Value
     */
    public void testValue() {
        assertEquals("40", node.value());
        node.setValue("50");
        assertEquals("50", node.value());
    }


    /**
     * Test For Node Class Left
     */
    public void testLeft() {
        assertNull(node.left());

        BSTNode<String> leftNode = new BSTNode<>("20");
        node.setLeft(leftNode);
        assertEquals(leftNode, node.left());
    }


    /**
     * Test For Node Class Right
     */
    public void testRight() {
        assertNull(node.right());

        BSTNode<String> rightNode = new BSTNode<>("50");
        node.setRight(rightNode);
        assertEquals(rightNode, node.right());
    }
}

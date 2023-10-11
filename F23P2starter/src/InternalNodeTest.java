import student.TestCase;

/**
 * InternalNodeTest
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */
public class InternalNodeTest extends TestCase {

    private InternalNode internalNode;
    private LeafNode node;
    private LeafNode flyNode;

    /**
     * setUp Constructor
     */
    public void setUp() {
        flyNode = new LeafNode();
        internalNode = new InternalNode(flyNode);
        node = new LeafNode();
    }


    /**
     * Test Basics
     */
    public void testBasics() {
        assertEquals(internalNode.left(), flyNode);
        assertEquals(internalNode.right(), flyNode);
        internalNode.setLeft(node);
        assertEquals(internalNode.left(), node);
        internalNode.setRight(node);
        assertEquals(internalNode.right(), node);

        LeafNode temp = new LeafNode();

        short x = 100;
        short y = 100;
        Seminar semTemp = new Seminar(3, "", "", 0, x, y, 0, new String[] {
            "" }, "");
        DLList<Seminar> list = new DLList<Seminar>();
        list.add(semTemp);
        temp.setList(list);
        assertEquals(temp.value(), list);
        systemOut().clearHistory();
        temp.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "Leaf with 1 objects: 3\n");
    }


    /**
     * Test Insert
     */
    public void testInsertDecision0Right() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode result = rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        InternalNode left = (InternalNode)result;
        assertEquals(rootNode.left(), left.left());
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 1\n  E\n");

    }


    /**
     * Test Insert
     */
    public void testInsertDecision0Right2() {
        InternalNode rootNode = new InternalNode(flyNode);
        InternalNode temp = new InternalNode(new LeafNode());
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode result = rootNode.insert(sem, temp, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        InternalNode left = (InternalNode)result;
        assertEquals(rootNode.left(), left.left());
        assertEquals(rootNode.right(), flyNode);
        System.out.println("1111111111111111111111111111");
        systemOut().clearHistory();
        rootNode.print(0);
        assertFuzzyEquals(systemOut().getHistory(), "I\r\n"
            + "  Leaf with 1 objects: 1\r\n" + "  Leaf with 1 objects: 1");
        System.out.println("1111111111111111111111111111");

    }


    /**
     * Test Insert
     */
    public void testInsertDecision0Left() {
        InternalNode rootNode = new InternalNode(flyNode);

        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode result = rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        InternalNode left = (InternalNode)result;
        assertEquals(rootNode.left(), left.left());
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 1\n  E\n");
    }


    /**
     * Test Insert
     */
    public void testInsertDecision0Left2() {
        InternalNode rootNode = new InternalNode(flyNode);
        InternalNode temp = new InternalNode(new LeafNode());
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode result = rootNode.insert(sem, temp, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        InternalNode left = (InternalNode)result;
        assertEquals(rootNode.left(), left.left());
        assertEquals(rootNode.right(), flyNode);
        System.out.println("1111111111111111111111111111");
        systemOut().clearHistory();
        rootNode.print(0);
        assertFuzzyEquals(systemOut().getHistory(), "I\r\n"
            + "  Leaf with 1 objects: 1\r\n" + "  Leaf with 1 objects: 1");
        System.out.println("1111111111111111111111111111");
    }


    /**
     * Test Insert
     */
    public void testInsertDecision1Right() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 1;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode result = rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        InternalNode left = (InternalNode)result;
        assertEquals(rootNode.left(), left.left());
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 1\n  E\n");
    }


    /**
     * Test Insert
     */
    public void testInsertDecision1Left() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 1;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode result = rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        InternalNode left = (InternalNode)result;
        assertEquals(rootNode.left(), left.left());
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 1\n  E\n");
    }


    /**
     * Test Insert
     */
    public void testInsertDecision0() {
        short x = 10;
        short y = 10;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        InternalNode node1 = new InternalNode(flyNode);
        node1.insert(temp, flyNode, x, y, 128, 128, 0);
        LeafNode leftLeaf = (LeafNode)node1.left();
        assertEquals(node1.left(), leftLeaf);
        assertEquals(node1.right(), flyNode);
        x = 100;
        y = 100;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node1 = new InternalNode(flyNode);
        node1.insert(temp2, flyNode, 0, 0, 128, 128, 0);
        LeafNode rightLeaf = (LeafNode)node1.right();
        assertEquals(node1.left(), flyNode);
        assertEquals(node1.right(), rightLeaf);
        x = 100;
        y = 100;
        Seminar temp3 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node1 = new InternalNode(flyNode);
        node1.insert(temp3, flyNode, 0, 0, 64, 64, 0);
        LeafNode rightLeaf2 = (LeafNode)node1.right();
        assertEquals(node1.left(), flyNode);
        assertEquals(node1.right(), rightLeaf2);
        systemOut().clearHistory();
        node1.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  Leaf with 1 objects: 3\n");
    }


    /**
     * Test Insert
     */
    public void testDecision1() {
        short x = 10;
        short y = 200;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        InternalNode node1 = new InternalNode(flyNode);
        node1.insert(temp, flyNode, x, y, 128, 128, 1);
        node1.print(0);
        LeafNode leaf = (LeafNode)node1.right();
        assertEquals(node1.left(), flyNode);
        assertEquals(node1.right(), leaf);
        x = 100;
        y = 100;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node1 = new InternalNode(flyNode);
        node1.insert(temp2, flyNode, 0, 0, 128, 128, 1);
        LeafNode rightLeaf = (LeafNode)node1.right();
        assertEquals(node1.left(), flyNode);
        assertEquals(node1.right(), rightLeaf);
        x = 100;
        y = 10;
        Seminar temp3 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node1 = new InternalNode(flyNode);
        node1.insert(temp3, flyNode, 0, 0, 64, 128, 1);
        LeafNode leaf2 = (LeafNode)node1.right();
        assertEquals(node1.right(), leaf2);
        assertEquals(node1.right(), flyNode);
        systemOut().clearHistory();
        node1.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 3\n  E\n");
    }


    /**
     * Test Insert
     */
    public void testBinTreeInsert() {
        short x = 100;
        short y = 100;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinTree tree = new BinTree(128);
        tree.insert(temp);
        assertTrue(tree.getRoot() instanceof LeafNode);
        x = 50;
        y = 50;
        Seminar temp2 = new Seminar(4, "", "", 0, x, y, 0, new String[] { "" },
            "");
        tree.insert(temp2);
        assertTrue(tree.getRoot() instanceof InternalNode);
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history,
            "I\n  Leaf with 1 objects: 4\n  Leaf with 1 objects: 3\n");
    }


    /**
     * Test Insert
     */
    public void testInsertIntoLeftSubtree() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 10;
        short y = 10;
        int xEnd = 20;
        int yEnd = 20;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        assertTrue(rootNode.left() instanceof LeafNode);
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 1\n  E\n");
    }


    /**
     * Test Insert
     */
    public void testInsertIntoRightSubtree() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 90;
        short y = 90;
        int xEnd = 100;
        int yEnd = 100;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        assertTrue(rootNode.right() instanceof LeafNode);
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 1\n  E\n");
    }


    /**
     * Test Delete
     */
    public void testDelete() {
        System.out.println("DELETE");
        BinTree tree = new BinTree(128);
        short x = 10;
        short y = 10;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        LeafNode fly = (LeafNode)tree.getRoot();
        fly.insert(temp, flyNode, 0, 0, 0, 0, 0);
        fly.delete(temp, y, x, y, x, y, flyNode);
        assertEquals(tree.getRoot(), fly);
        tree.insert(temp);
        x = 85;
        y = 85;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        tree.insert(temp2);
        InternalNode newRoot = (InternalNode)tree.getRoot();
        newRoot.delete(temp2, 0, 0, 0, 10, 10, fly);
        assertEquals(newRoot.right(), fly);
        assertTrue(newRoot.left() instanceof LeafNode);
        tree.insert(temp2);
        newRoot.delete(temp, 0, 0, 0, 85, 85, fly);
        assertEquals(newRoot.left(), fly);
        assertTrue(newRoot.right() instanceof LeafNode);
        tree.insert(temp);
        newRoot.delete(temp2, 1, 0, 0, 10, 10, fly);
        assertEquals(newRoot.right(), fly);
        assertTrue(newRoot.left() instanceof LeafNode);
        tree.insert(temp2);
        newRoot.delete(temp, 1, 0, 0, 85, 85, fly);
        assertEquals(newRoot.left(), fly);
        assertTrue(newRoot.right() instanceof LeafNode);
        tree.print();
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  Leaf with 1 objects: 3\n");
    }


    /**
     * Test Delete
     */
    public void testDelete2() {
        InternalNode rootNode = new InternalNode(flyNode);
        BinNode leftChild = flyNode;
        BinNode rightChild = new LeafNode();
        rootNode.setLeft(leftChild);
        rootNode.setRight(rightChild);
        short x = 15;
        short y = 15;
        int xEnd = 25;
        int yEnd = 25;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, rightChild);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), rightChild);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  E\n");
    }


    /**
     * Test Delete
     */
    public void testDelete3() {
        InternalNode rootNode = new InternalNode(flyNode);
        BinNode leftChild = flyNode;
        BinNode rightChild = new LeafNode();
        rootNode.setLeft(leftChild);
        rootNode.setRight(rightChild);
        short x = 15;
        short y = 15;
        int xEnd = 25;
        int yEnd = 25;
        int level = 1;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, rightChild);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), rightChild);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  E\n");
    }


    /**
     * Test Delete
     */
    public void testDeleteLeftRightFly() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 15;
        short y = 15;
        int xEnd = 25;
        int yEnd = 25;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, flyNode);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  E\n");
    }


    /**
     * Test Delete
     */
    public void testDeleteLeftRightFly1() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 15;
        short y = 15;
        int xEnd = 25;
        int yEnd = 25;
        int level = 1;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, flyNode);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), flyNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  E\n");
    }


    /**
     * Test Delete
     */
    public void testDeleteLeftRightInternal() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 15;
        short y = 15;
        int xEnd = 25;
        int yEnd = 25;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode leftNode = new InternalNode(flyNode);
        BinNode rightNode = new InternalNode(flyNode);
        rootNode.setLeft(leftNode);
        rootNode.setRight(rightNode);
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, rootNode);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), rightNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  I\n    E\n    E\n");
    }


    /**
     * Test Delete
     */
    public void testDeleteLeftRightInternal1() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 15;
        short y = 15;
        int xEnd = 25;
        int yEnd = 25;
        int level = 1;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode leftNode = new InternalNode(flyNode);
        BinNode rightNode = new InternalNode(flyNode);
        rootNode.setLeft(leftNode);
        rootNode.setRight(rightNode);
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, rootNode);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), rightNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  I\n    E\n    E\n");
    }


    /**
     * Test Delete
     */
    public void testDeleteWhenSemYGreaterThanSplit() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 15;
        short y = 30;
        int xEnd = 25;
        int yEnd = 40;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode leftNode = new LeafNode();
        BinNode rightNode = new LeafNode();
        rootNode.setLeft(leftNode);
        rootNode.setRight(rightNode);
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, rightNode);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), rightNode);
        assertTrue(rootNode.left() instanceof LeafNode);
        assertTrue(rootNode.right() instanceof LeafNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  E\n");
    }


    /**
     * Test Delete
     */
    public void testDeleteWhenSemYGreaterThanSplit1() {
        InternalNode rootNode = new InternalNode(flyNode);
        short x = 15;
        short y = 30;
        int xEnd = 25;
        int yEnd = 40;
        int level = 1;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode leftNode = new LeafNode();
        BinNode rightNode = new LeafNode();
        rootNode.setLeft(leftNode);
        rootNode.setRight(rightNode);
        rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.delete(sem, level, x, y, xEnd, yEnd, flyNode);
        assertEquals(result, rightNode);
        assertEquals(rootNode.left(), flyNode);
        assertEquals(rootNode.right(), rightNode);
        assertTrue(rootNode.left() instanceof LeafNode);
        assertTrue(rootNode.right() instanceof LeafNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  E\n  E\n");
    }


    /**
     * Test Print
     */
    public void testPrint() {
        short x = 100;
        short y = 100;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinTree tree = new BinTree(128);
        tree.insert(temp);
        tree.insert(temp2);
        LeafNode root = (LeafNode)tree.getRoot();
        root.print(0);
        String out = "Leaf with 2 objects: 3 3 ";
        assertFuzzyEquals(systemOut().getHistory(), out);
    }


    /**
     * Test More
     */
    public void testInsertIntoNonEmptyNode() {
        Seminar seminar = new Seminar();
        BinNode resultNode = internalNode.insert(seminar, internalNode, 0, 0,
            100, 100, 0);
        assertTrue(resultNode instanceof InternalNode);
        LeafNode leftSubtree = new LeafNode();
        LeafNode rightSubtree = new LeafNode();
        InternalNode nonEmptyNode = new InternalNode(internalNode);
        nonEmptyNode.setLeft(leftSubtree);
        nonEmptyNode.setRight(rightSubtree);
        seminar = new Seminar();
        resultNode = nonEmptyNode.insert(seminar, internalNode, 0, 0, 100, 100,
            0);
        assertTrue(resultNode instanceof InternalNode);
    }


    /**
     * Test More
     */
    public void testRight() {
        InternalNode node1 = new InternalNode(internalNode);
        Seminar seminar = new Seminar();
        BinNode resultNode = node1.insert(seminar, internalNode, 50, 0, 100,
            100, 0);
        assertTrue(resultNode instanceof InternalNode);
        node1 = new InternalNode(internalNode);
        seminar = new Seminar();
        resultNode = node1.insert(seminar, internalNode, 0, 0, 50, 100, 0);
        assertTrue(resultNode instanceof InternalNode);
        node1 = new InternalNode(internalNode);
        seminar = new Seminar();
        resultNode = node1.insert(seminar, internalNode, 0, 0, 100, 100, 0);
        assertTrue(resultNode instanceof InternalNode);
        node1 = new InternalNode(internalNode);
        seminar = new Seminar();
        resultNode = node1.insert(seminar, internalNode, 0, 0, 100, 100, 1);
        assertTrue(resultNode instanceof InternalNode);
        node1 = new InternalNode(internalNode);
        seminar = new Seminar();
        resultNode = node1.insert(seminar, internalNode, 0, 0, 100, 100, 2);
        assertTrue(resultNode instanceof InternalNode);
        seminar = new Seminar();
        resultNode = internalNode.insert(seminar, internalNode, 0, 0, 100, 100,
            0);
        Seminar seminar1 = new Seminar();
        Seminar seminar2 = new Seminar();
        internalNode.insert(seminar1, internalNode, 0, 0, 100, 100, 0);
        internalNode.insert(seminar2, internalNode, 0, 0, 100, 100, 0);
        seminar = new Seminar();
        resultNode = internalNode.insert(seminar, internalNode, 0, 0, 100, 100,
            0);
        resultNode = internalNode.insert(seminar, internalNode, 0, 0, 100, 100,
            0);
        short x = 100;
        short y = 10;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        resultNode = internalNode.insert(temp, internalNode, 1, 1, 128, 128, 1);
        resultNode.print(1);
        assertFuzzyEquals(systemOut().getHistory(), "  I\r\n" + "    I\r\n"
            + "      Leaf with 10 objects: 0 0 0 0 0 0 0 0 0 0\r\n"
            + "      Leaf with 1 objects: 3\r\n"
            + "    Leaf with 10 objects: 0 0 0 0 0 0 0 0 0 0");

    }


    /**
     * Test Split
     */
    public void testSplit() {
        BinTree tree = new BinTree(128);
        Seminar temp = new Seminar(1, "", "", 0, (short)10, (short)10, 0,
            new String[] { "" }, "");
        Seminar temp2 = new Seminar(2, "", "", 0, (short)64, (short)64, 0,
            new String[] { "" }, "");
        tree.insert(temp);
        tree.insert(temp2);
        System.out.println("test");
        tree.print();
        InternalNode root = (InternalNode)tree.getRoot();
        root.insert(temp, flyNode, 0, 0, 128, 128, 0);
        assertEquals(root.getSplit(0, 128, 0), 63);
        root.insert(temp, flyNode, 0, 0, 128, 128, 1);
        assertEquals(root.getSplit(1, 128, 0), 63);
        root.delete(temp2, 0, 0, 128, 128, 0, flyNode);
        assertEquals(root.getSplit(1, 64, 0), 31);
        root.delete(temp, 0, 0, 128, 128, 0, flyNode);

    }


    /**
     * Test More
     */
    public void testDeleteHarder() {
        BinTree tree = new BinTree(128);
        InternalNode root = new InternalNode(flyNode);
        Seminar temp = new Seminar(1, "", "", 0, (short)10, (short)10, 0,
            new String[] { "" }, "");
        Seminar temp2 = new Seminar(2, "", "", 0, (short)84, (short)84, 0,
            new String[] { "" }, "");
        tree.insert(temp);
        tree.insert(temp2);
        root = (InternalNode)tree.getRoot();

        System.out.println(root.getSplit(0, 128, 10));
        BinNode right = root.delete(temp2, 0, 0, 0, 128, 128, flyNode);
        assertEquals(root.right(), flyNode);
        assertTrue(root.left() instanceof LeafNode);
        assertEquals(root.left(), right);

        BinNode left = root.delete(temp, 0, 0, 0, 128, 128, flyNode);
        assertEquals(root.right(), flyNode);
        assertEquals(root.left(), left);

        root.insert(temp, flyNode, 0, 0, 128, 128, 0);
        root.insert(temp2, flyNode, 0, 0, 128, 128, 0);

        assertEquals(root.search(128, 128, 64, 0, 0, 128, 128, 0, 0), 1);
        assertEquals(root.search(128, 128, 1, 0, 0, 128, 128, 0, 0), 1);
        assertEquals(root.search(128, 128, 64, 0, 0, 128, 128, 1, 0), 1);
        assertEquals(root.search(128, 128, 1, 0, 0, 128, 128, 1, 0), 1);
        assertEquals(root.search(128, 128, 120, 0, 0, 128, 128, 0, 0), 2);
        assertEquals(root.search(128, 128, 120, 23, 34, 128, 128, 0, 0), 2);
        assertEquals(root.search(128, 128, 120, 0, 0, 128, 128, 1, 0), 2);
        assertEquals(root.search(128, 128, 120, 23, 34, 128, 128, 1, 0), 2);
        assertEquals(root.search(128, 128, 65, 0, 0, 128, 128, 0, 0), 2);
        assertEquals(root.search(128, 128, 65, 23, 34, 128, 128, 0, 0), 2);
        assertEquals(root.search(128, 128, 0, 0, 0, 128, 128, 0, 0), 1);
        assertEquals(root.search(128, 128, 0, 23, 34, 128, 128, 0, 0), 1);
        assertEquals(root.search(128, 128, 0, 0, 0, 128, 128, 1, 1), 2);
        assertEquals(root.search(128, 128, 0, 23, 34, 128, 128, 1, 1), 2);
        assertEquals(root.search(128, 128, 128, 0, 0, 128, 128, 1, 0), 2);
        assertEquals(left.search(128, 128, 128, 0, 0, 128, 128, 1, 0), 0);

        assertEquals(root.getSplit(0, 0, 0), -1);
        assertEquals(root.getSplit(1, 0, 0), -1);
        assertEquals(root.getSplit(0, 12123, 223), 6172);
        assertEquals(root.getSplit(0, 0, 223), 112);
        assertEquals(root.delete(temp2, 0, 0, 0, 0, 0, flyNode), root.left());
        assertTrue(root.left() instanceof LeafNode);
        root.insert(temp2, flyNode, 0, 0, 0, 0, 0);
        right = (LeafNode)root.right();
        assertEquals(root.delete(temp, 0, 0, 0, 0, 0, flyNode), root);
        root.print(0);
        assertEquals(root.right(), right);
        assertEquals(root.delete(temp2, 1, 0, 0, 0, 0, flyNode), root.left());
        assertTrue(root.left() instanceof LeafNode);
        root.insert(temp2, flyNode, 0, 0, 0, 0, 0);
        right = (LeafNode)root.right();
        assertEquals(root.delete(temp, 1, 0, 0, 0, 0, flyNode), root);
        root.print(0);
        assertEquals(root.right(), right);
        assertEquals(root.delete(temp, 1, 0, 0, 0, 0, flyNode), root);
        root.left().delete(temp, 0, 0, 0, 0, 0, flyNode);
        assertTrue(root.right() instanceof LeafNode);

        root.right().delete(temp, 0, 0, 0, 0, 0, flyNode);
        root.left().insert(temp2, left, 0, 0, 0, 0, 0);

        root.print(0);

    }


    /**
     * Test More
     */
    public void testInternalNodeMore() {
        BinNode fly = new LeafNode();
        InternalNode node1 = new InternalNode(fly);

        Seminar seminar = new Seminar();

        BinNode result = node1.insert(seminar, fly, 0, 0, 10, 10, 0);

        assertEquals(node1, result);
        assertNotNull(node1.left());
        assertNotNull(node1.right());

        BinNode leftNode = new LeafNode();
        BinNode rightNode = new LeafNode();
        node1 = new InternalNode(leftNode);
        node1.setRight(rightNode);

        seminar = new Seminar();
        result = node1.insert(seminar, new LeafNode(), 0, 0, 10, 10, 2);
        InternalNode res = (InternalNode)result;

        assertEquals(node1, res);

        assertNotNull(res.left());
        assertNotNull(res.right());

        leftNode = new LeafNode();
        rightNode = new LeafNode();
        node1 = new InternalNode(leftNode);
        node1.setRight(rightNode);

        seminar = new Seminar();

        result = node1.insert(seminar, new LeafNode(), 0, 0, 10, 10, 3);
        res = (InternalNode)result;

        assertEquals(node1, res);

        assertNotNull(res.left());
        assertNotNull(res.right());

    }

}

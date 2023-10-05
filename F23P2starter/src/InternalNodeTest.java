import student.TestCase;

public class InternalNodeTest extends TestCase {

    private InternalNode internalNode;
    private LeafNode node;
    private LeafNode flyNode;

    public void setUp() {
        flyNode = new LeafNode();
        internalNode = new InternalNode(flyNode);
        node = new LeafNode();
    }


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

    }


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
    }


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
    }


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
    }


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
    }


    public void testInsertDecision0() {
        short x = 10;
        short y = 10;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        InternalNode node = new InternalNode(flyNode);
        node.insert(temp, flyNode, x, y, 128, 128, 0);
        LeafNode leftLeaf = (LeafNode)node.left();
        assertEquals(node.left(), leftLeaf);
        assertEquals(node.right(), flyNode);
        x = 100;
        y = 100;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node = new InternalNode(flyNode);
        node.insert(temp2, flyNode, 0, 0, 128, 128, 0);
        LeafNode rightLeaf = (LeafNode)node.right();
        assertEquals(node.left(), flyNode);
        assertEquals(node.right(), rightLeaf);
        x = 100;
        y = 100;
        Seminar temp3 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node = new InternalNode(flyNode);
        node.insert(temp3, flyNode, 0, 0, 64, 64, 0);
        LeafNode rightLeaf2 = (LeafNode)node.right();
        assertEquals(node.left(), flyNode);
        assertEquals(node.right(), rightLeaf2);
    }


    public void testDecision1() {
        short x = 10;
        short y = 200;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        InternalNode node = new InternalNode(flyNode);
        node.insert(temp, flyNode, x, y, 128, 128, 1);
        node.print();
        LeafNode leaf = (LeafNode)node.right();
        assertEquals(node.left(), flyNode);
        assertEquals(node.right(), leaf);
        x = 100;
        y = 100;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node = new InternalNode(flyNode);
        node.insert(temp2, flyNode, 0, 0, 128, 128, 1);
        LeafNode rightLeaf = (LeafNode)node.right();
        assertEquals(node.left(), flyNode);
        assertEquals(node.right(), rightLeaf);
        x = 100;
        y = 10;
        Seminar temp3 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        node = new InternalNode(flyNode);
        node.insert(temp3, flyNode, 0, 0, 64, 128, 1);
        LeafNode leaf2 = (LeafNode)node.right();
        assertEquals(node.right(), leaf2);
        assertEquals(node.right(), flyNode);
    }


    public void testBinTreeInsert() {
        short x = 100;
        short y = 100;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinTree tree = new BinTree(128);
        tree.insert(temp);
        assertTrue(tree.getRoot() instanceof LeafNode);
        tree.insert(temp);
        assertTrue(tree.getRoot() instanceof LeafNode);
        LeafNode leaf = (LeafNode)tree.getRoot();
        x = 50;
        y = 50;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        leaf.insert(temp2, flyNode, x, y, x, y, 1);
        tree.insert(temp2);
        assertTrue(tree.getRoot() instanceof InternalNode);

    }


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
    }


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

    }


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
    }


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
    }


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
    }


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
    }


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
    }


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
    }


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
    }


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
    }


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
    }


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
        root.print();
        String out = "Leaf with 2 objects: 3 3 ";
        assertFuzzyEquals(systemOut().getHistory(), out);

    }
}

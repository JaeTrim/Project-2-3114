import student.TestCase;

public class BinNodeTest extends TestCase {

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
        assertEquals(temp.left(), null);
        assertEquals(temp.right(), null);

        short x = 100;
        short y = 100;
        Seminar semTemp = new Seminar(3, "", "", 0, x, y, 0, new String[] {
            "" }, "");
        DLList<Seminar> list = new DLList<Seminar>();
        list.add(semTemp);
        temp.setList(list);
        assertEquals(temp.value(), list);

    }


    public void testInsert() {
        BinTree tree = new BinTree(128);
        BinNode node = tree.getRoot();
        short x = 10;
        short y = 10;
        short x1 = 85;
        short y1 = 85;
        short x2 = 100;
        short y2 = 100;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        Seminar sem2 = new Seminar(2, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        Seminar sem3 = new Seminar(3, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        LeafNode flyweight = new LeafNode();
        tree.insert(sem);
        tree.print();
        String output = "leaf with 1 objects 1";
        assertFuzzyEquals(systemOut().getHistory(), output);
        tree.insert(sem2);
        tree.print();
        output = "Leaf with 1 objects: 1\r\n" + "I\r\n"
            + "Leaf with 1 objects: 1\r\n" + "Leaf with 1 objects: 2";
        assertFuzzyEquals(systemOut().getHistory(), output);
        tree = new BinTree(128);
        tree.insert(sem);
        tree.insert(sem2);
        tree.insert(sem3);
        tree.print();
        output = "Leaf with 1 objects: 1\r\n" + "I\r\n"
            + "Leaf with 1 objects: 1\r\n" + "Leaf with 1 objects: 2\r\n"
            + "I\r\n" + "Leaf with 1 objects: 1\r\n" + "I\r\n" + "E\r\n"
            + "I\r\n" + "Leaf with 1 objects: 2\r\n" + "Leaf with 1 objects: 3";
        assertFuzzyEquals(systemOut().getHistory(), output);

        // start real test
        System.out.println("START");

        tree = new BinTree(128);
        LeafNode fly = (LeafNode)tree.getRoot();
        tree.insert(sem);
        // root is leaf
        node = tree.getRoot();

        tree.insert(sem2);
        InternalNode iNode = (InternalNode)tree.getRoot();
        tree.insert(sem3);
        InternalNode nextINode = (InternalNode)iNode.right();
        tree.print();
        assertEquals(nextINode.left(), fly);

        InternalNode nextNextINode = (InternalNode)nextINode.right();
        assertEquals(nextINode.right(), nextNextINode);

        LeafNode leaf = (LeafNode)nextNextINode.left();
        LeafNode leaf2 = (LeafNode)nextNextINode.right();

        assertEquals(nextNextINode.left(), leaf);
        assertEquals(nextNextINode.right(), leaf2);

        LeafNode fly2 = (LeafNode)nextINode.left();
        assertEquals(nextINode.left(), fly2);

        System.out.println("Break");
        tree.print();

        short x4 = 129;
        short y4 = 129;
        Seminar sem4 = new Seminar(3, "", "", 0, x4, y4, 0, new String[] { "" },
            "");

        System.out.println("\nBreak");
        tree.print();

        tree = new BinTree(128);
        tree.insert(sem3);
        tree.insert(sem2);
        System.out.println("\nBreak");
        tree.print();
        tree.insert(sem);

        short x6 = 11;
        short y6 = 11;
        Seminar sem6 = new Seminar(3, "", "", 0, x6, y6, 0, new String[] { "" },
            "");

        short x7 = 0;
        short y7 = 0;
        Seminar sem7 = new Seminar(3, "", "", 0, x7, y7, 0, new String[] { "" },
            "");

        tree = new BinTree(128);
        tree.insert(sem);
        tree.insert(sem6);

        System.out.println("\nBreak");
        tree.print();

        tree.insert(sem2);

        tree.insert(sem3);

        tree = new BinTree(128);
        tree.insert(sem4);
// tree.insert(sem);

        tree.insert(sem7);
        InternalNode test = (InternalNode)tree.getRoot();
        LeafNode next = (LeafNode)test.right();

        System.out.println("\nBreak");
        tree.print();

        tree = new BinTree(128);

        x = 100;
        y = 100;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        System.out.println("NEW START");
        InternalNode in = new InternalNode(flyNode);
        in.insert(temp, flyNode, x, y, 50, 50, 1);
        in.insert(temp, flyNode, x, y, 50, 50, 0);
    }


    public void testInsertDecision0() {
        System.out.println("BEGIN");
        short x = 10;
        short y = 10;
        Seminar temp = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        InternalNode node = new InternalNode(flyNode);

        node.insert(temp, flyNode, x, y, 128, 128, 0);

        LeafNode leftLeaf = (LeafNode)node.left();

        assertEquals(node.left(), leftLeaf);
        assertEquals(node.right(), flyNode);
        ///
        ///

        System.out.println("SEP");
        x = 100;
        y = 100;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");

        node = new InternalNode(flyNode);
        node.insert(temp2, flyNode, 0, 0, 128, 128, 0);

        LeafNode rightLeaf = (LeafNode)node.right();
        assertEquals(node.left(), flyNode);
        assertEquals(node.right(), rightLeaf);

        ///
        ///
        System.out.println("SEP");
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
        System.out.println("BEGIN");
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

        ///
        System.out.println("SEP");
        x = 100;
        y = 100;
        Seminar temp2 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");

        node = new InternalNode(flyNode);
        node.insert(temp2, flyNode, 0, 0, 128, 128, 1);

        LeafNode rightLeaf = (LeafNode)node.right();
        assertEquals(node.left(), flyNode);
        assertEquals(node.right(), rightLeaf);
        ///
        System.out.println("SEP");
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
        LeafNode fly = (LeafNode)tree.getRoot();
        tree.insert(temp);
        assertTrue(tree.getRoot() instanceof LeafNode);
        
        tree.insert(temp);
        assertTrue(tree.getRoot() instanceof LeafNode);
        
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

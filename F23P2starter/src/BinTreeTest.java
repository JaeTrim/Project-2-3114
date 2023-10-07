import student.TestCase;

public class BinTreeTest extends TestCase {

    private BinTree tree;
    private LeafNode flyNode;
    private BinNode root;

    public void setUp() {
        tree = new BinTree(128);
        flyNode = new LeafNode();
        root = flyNode;
    }


    public void testInsertEmpty() {
        short x = 10;
        short y = 20;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        tree.insert(sem);
        BinNode root = tree.getRoot();
        assertTrue(root instanceof LeafNode);
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "Leaf with 1 objects: 1\n");
    }


    public void testInsertAndDelete() {
        short x1 = 10;
        short y1 = 20;
        Seminar sem1 = new Seminar(1, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        short x2 = 30;
        short y2 = 40;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        short x3 = 50;
        short y3 = 60;
        Seminar sem3 = new Seminar(3, "", "", 0, x3, y3, 0, new String[] { "" },
            "");
        tree.insert(sem1);
        tree.insert(sem2);
        tree.insert(sem3);
        BinNode root = tree.getRoot();
        assertTrue(root instanceof InternalNode);
        tree.delete(sem2);
        tree.delete(sem1);
        tree.delete(sem3);
        root = tree.getRoot();
        assertTrue(root instanceof LeafNode);
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "E\n");
    }
    
    public void testInsertAndDelete2() {
        BinTree nTree = new BinTree(256);
        short x1 = 130;
        short y1 = 120;
        Seminar sem1 = new Seminar(1, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        short x2 = 90;
        short y2 = 200;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        short x3 = 30;
        short y3 = 154;
        Seminar sem3 = new Seminar(3, "", "", 0, x3, y3, 0, new String[] { "" },
            "");
        nTree.insert(sem1);
        nTree.insert(sem2);
        nTree.insert(sem3);
        BinNode root = nTree.getRoot();
        assertTrue(root instanceof InternalNode);
        nTree.delete(sem2);
        nTree.delete(sem1);
        nTree.delete(sem3);
        root = nTree.getRoot();
        assertTrue(root instanceof LeafNode);
        systemOut().clearHistory();
        nTree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "E\n");
    }



    public void testInsertOtherCase() {
        short x1 = 10;
        short y1 = 20;
        Seminar sem1 = new Seminar(1, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        short x2 = 30;
        short y2 = 40;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        tree.insert(sem1);
        tree.insert(sem2);
        BinNode root = tree.getRoot();
        assertTrue(root instanceof InternalNode);
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  I\n    I\n      I\n        Leaf with 1 objects: 1\n        Leaf with 1 objects: 2\n      E\n    E\n  E\n");
    }
    
    public void testInsertDuplicate() {
        short x = 40;
        short y = 60;
        Seminar sem1 = new Seminar(1, "Seminar 1", "Description 1", 0, x, y, 0, new String[] { "" }, "");
        Seminar sem2 = new Seminar(2, "Seminar 2", "Description 2", 0, x, y, 0, new String[] { "" }, "");
        tree.insert(sem1);
        tree.insert(sem2);
        BinNode root = tree.getRoot();
        assertTrue(root instanceof LeafNode);
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "Leaf with 2 objects: 1 2\n");
    }
    
    public void testInsertSeminarSplitting() {
        Seminar seminar1 = new Seminar(1, "Seminar 1", "2023-10-10", 60, (short) 70, (short) 70, 100, new String[]{"keyword1"}, "Description 1");
        Seminar seminar2 = new Seminar(2, "Seminar 2", "2023-10-11", 90, (short) 60, (short) 60, 150, new String[]{"keyword2"}, "Description 2");

        tree.insert(seminar1);
        tree.insert(seminar2);

        BinNode root = tree.getRoot();
        assertTrue(root instanceof InternalNode);

        InternalNode internalNode = (InternalNode) root;
        assertTrue(internalNode.left() instanceof LeafNode);
        assertTrue(internalNode.right() instanceof LeafNode);

        LeafNode leftLeaf = (LeafNode) internalNode.left();
        LeafNode rightLeaf = (LeafNode) internalNode.right();

        assertEquals(1, leftLeaf.value().size());
        assertEquals(seminar2, leftLeaf.value().get(0));

        assertEquals(1, rightLeaf.value().size());
        assertEquals(seminar1, rightLeaf.value().get(0));
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 2\n  Leaf with 1 objects: 1\n");
    }


    public void testDelete() {
        short x1 = 10;
        short y1 = 20;
        Seminar sem1 = new Seminar(1, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        short x2 = 30;
        short y2 = 40;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        tree.insert(sem1);
        tree.insert(sem2);
        tree.delete(sem1);
        BinNode root = tree.getRoot();
        assertTrue(root instanceof LeafNode);
        systemOut().clearHistory();
        tree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "Leaf with 1 objects: 2\n");
    }
    


    public void testPrint() {
        short x1 = 10;
        short y1 = 20;
        Seminar sem1 = new Seminar(1, "Seminar 1", "Description 1", 0, x1, y1,
            0, new String[] { "" }, "");
        short x2 = 30;
        short y2 = 40;
        Seminar sem2 = new Seminar(2, "Seminar 2", "Description 2", 0, x2, y2,
            0, new String[] { "" }, "");
        short x3 = 50;
        short y3 = 60;
        Seminar sem3 = new Seminar(3, "Seminar 3", "Description 3", 0, x3, y3,
            0, new String[] { "" }, "");
        tree.insert(sem1);
        tree.insert(sem2);
        tree.insert(sem3);
        systemOut().clearHistory();
        tree.print();
        String out = "I\r\n" + "I\r\n" + "I\r\n" + "I\r\n"
            + "Leaf with 1 objects: 1 \r\n" + "Leaf with 1 objects: 2 \r\n"
            + "Leaf with 1 objects: 3 \r\n" + "E\r\n" + "E";
        assertFuzzyEquals(systemOut().getHistory(), out);
    }
}

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
        assertTrue(root instanceof InternalNode);
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
        tree.print();
        String out = "I\r\n" + "I\r\n" + "I\r\n" + "I\r\n"
            + "Leaf with 1 objects: 1 \r\n" + "Leaf with 1 objects: 2 \r\n"
            + "Leaf with 1 objects: 3 \r\n" + "E\r\n" + "E";
        assertFuzzyEquals(systemOut().getHistory(), out);
    }
}

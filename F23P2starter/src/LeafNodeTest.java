import student.TestCase;

public class LeafNodeTest extends TestCase {

    private BinNode flyNode;
    private BinNode rootNode;

    public void setUp() {
        flyNode = new LeafNode();
        rootNode = new InternalNode(flyNode);
    }


    public void testEmptyInsert() {
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 0;
        Seminar sem = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        BinNode result = rootNode.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        assertNotSame(result, flyNode);
        assertTrue(result instanceof InternalNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 1 objects: 1\n  E\n");
    }


    public void testInsertSameXY() {
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 0;
        Seminar sem1 = new Seminar(1, "", "", 0, x, y, 0, new String[] { "" },
            "");
        Seminar sem2 = new Seminar(2, "", "", 0, x, y, 0, new String[] { "" },
            "");
        rootNode.insert(sem1, flyNode, x, y, xEnd, yEnd, level);
        BinNode result = rootNode.insert(sem2, flyNode, x, y, xEnd, yEnd,
            level);
        assertEquals(result, rootNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  Leaf with 2 objects: 1 2\n  E\n");
    }


    public void testInsertLevel0() {
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 0;
        Seminar sem1 = new Seminar(1, "", "", 0, (short)(x - 5), y, 0,
            new String[] { "" }, "");
        Seminar sem2 = new Seminar(2, "", "", 0, (short)(x + 5), y, 0,
            new String[] { "" }, "");
        BinNode result = rootNode.insert(sem1, flyNode, x, y, xEnd, yEnd,
            level);
        assertEquals(result, rootNode);
        assertTrue(result instanceof InternalNode);
        InternalNode internalNode = (InternalNode)result;
        assertTrue(internalNode.right() instanceof LeafNode);
        result = rootNode.insert(sem2, flyNode, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        assertTrue(result instanceof InternalNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  I\n    I\n      Leaf with 1 objects: 1\n      Leaf with 1 objects: 2\n    E\n  E\n");
    }


    public void testInsertLevel1() {
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 1;
        Seminar sem1 = new Seminar(1, "", "", 0, x, (short)(y - 5), 0,
            new String[] { "" }, "");
        Seminar sem2 = new Seminar(2, "", "", 0, x, (short)(y + 5), 0,
            new String[] { "" }, "");
        BinNode result = rootNode.insert(sem1, flyNode, x, y, xEnd, yEnd,
            level);
        assertEquals(result, rootNode);
        assertTrue(result instanceof InternalNode);
        InternalNode internalNode = (InternalNode)result;
        assertTrue(internalNode.right() instanceof LeafNode);
        result = rootNode.insert(sem2, flyNode, x, y, xEnd, yEnd, level);
        assertEquals(result, rootNode);
        assertTrue(result instanceof InternalNode);
        systemOut().clearHistory();
        rootNode.print(0);
        String history = systemOut().getHistory();
        assertEquals(history, "I\n  I\n    I\n      Leaf with 1 objects: 1\n      Leaf with 1 objects: 2\n    E\n  E\n");

    }
}

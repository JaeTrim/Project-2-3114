import student.TestCase;

/**
 * LeafNode Test Class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */
public class LeafNodeTest extends TestCase {

    private BinNode flyNode;
    private BinNode rootNode;

    /**
     * setUp Constructor
     */
    public void setUp() {
        flyNode = new LeafNode();
        rootNode = new InternalNode(flyNode);
    }


    /**
     * Test Insert Empty
     */
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


    /**
     * Test Insert With Same XY
     */
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


    /**
     * Test Insert Level 0
     */
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
        assertEquals(history,
            "I\n  I\n    I\n      Leaf with 1 objects: 1\n      "
            + "Leaf with 1 objects: 2\n    E\n  E\n");
    }


    /**
     * Test Insert Level 1
     */
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
        assertEquals(history,
            "I\n  I\n    I\n      Leaf with 1 objects: 1\n      "
            + "Leaf with 1 objects: 2\n    E\n  E\n");

    }


    /**
     * Test Delete Branches
     */
    public void testDeleteBranches() {
        LeafNode leafNode = new LeafNode();

        Seminar seminar1 = new Seminar(1, "", "", (short)0, (short)10,
            (short)20, (short)0, new String[] { "" }, "");
        Seminar seminar2 = new Seminar(2, "", "", (short)0, (short)5, (short)15,
            (short)0, new String[] { "" }, "");

        leafNode.insert(seminar1, flyNode, 10, 20, 100, 100, 0);
        leafNode.insert(seminar2, flyNode, 10, 20, 100, 100, 0);

        BinNode result = leafNode.delete(seminar2, 0, 10, 20, 100, 100,
            flyNode);
        assertEquals(1, leafNode.value().size());
        assertNotNull(result);
    }


    /**
     * Test Ascending Order
     */
    public void testAscending() {
        LeafNode leaf = new LeafNode();
        short x = 10;
        short y = 20;
        int xEnd = 30;
        int yEnd = 40;
        int level = 1;
        Seminar sem1 = new Seminar(1, "", "", 0, x, (y), 0, new String[] { "" },
            "");
        Seminar sem2 = new Seminar(2, "", "", 0, x, y, 0, new String[] { "" },
            "");
        Seminar sem3 = new Seminar(3, "", "", 0, x, y, 0, new String[] { "" },
            "");
        leaf.insert(sem1, flyNode, x, y, xEnd, yEnd, level);
        leaf.insert(sem2, flyNode, x, y, xEnd, yEnd, level);
        leaf.insert(sem3, flyNode, x, y, xEnd, yEnd, level);

        DLList<Seminar> sortedSeminars = leaf.value();
        assertEquals(3, sortedSeminars.size());
        assertEquals(1, sortedSeminars.get(0).id());
        assertEquals(2, sortedSeminars.get(1).id());
        assertEquals(3, sortedSeminars.get(2).id());
    }


    /**
     * Test Split
     */
    public void testSplitX1() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)10, (short)10, 0,
            new String[] { "" }, "");
        first.insert(sem1, flyNode, 0, 0, 256, 256, 0);
        assertEquals(first.getSplit(0, 256, 0), 127);
        assertEquals(first.value().get(0).x(), 10);
        assertEquals(sem1.x(), 10);

    }


    /**
     * Test Split
     */
    public void testSplitX2() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)11, (short)11, 0,
            new String[] { "" }, "");
        first.insert(sem1, flyNode, 11, 11, 256, 256, 0);
        assertEquals(first.getSplit(0, 256, 11), 133);
        assertEquals(first.value().get(0).x(), 11);
        assertEquals(sem1.x(), 11);

    }


    /**
     * Test Split
     */
    public void testSplitY1() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)10, (short)10, 0,
            new String[] { "" }, "");
        first.insert(sem1, flyNode, 0, 0, 256, 256, 1);
        assertEquals(first.getSplit(0, 256, 0), 127);
        assertEquals(first.value().get(0).y(), 10);
        assertEquals(sem1.y(), 10);

    }


    /**
     * Test Split
     */
    public void testSplitY2() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)11, (short)11, 0,
            new String[] { "" }, "");
        first.insert(sem1, flyNode, 11, 11, 256, 256, 1);
        assertEquals(first.getSplit(0, 256, 11), 133);
        assertEquals(first.value().get(0).y(), 11);
        assertEquals(sem1.y(), 11);

    }


    /**
     * Test Split
     */
    public void testXSplit3() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)222, (short)222, 0,
            new String[] { "" }, "");
        Seminar sem2 = new Seminar(2, "", "", 0, (short)206, (short)206, 0,
            new String[] { "" }, "");
        first.insert(sem1, flyNode, 155, 155, 256, 256, 0);
        assertEquals(first.getSplit(0, 256, 155), 205);
        assertEquals(first.value().get(0).x(), 222);
        tree.insert(sem1);
        tree.insert(sem2);
        tree.print();
        String out = "I\r\n" + "  Leaf with 1 objects: 1\r\n" + "  I\r\n"
            + "    Leaf with 1 objects: 1\r\n" + "    I\r\n"
            + "      Leaf with 1 objects: 1\r\n" + "      I\r\n"
            + "        Leaf with 1 objects: 1\r\n" + "        I\r\n"
            + "          I\r\n" + "            I\r\n"
            + "              Leaf with 1 objects: 2\r\n"
            + "              Leaf with 1 objects: 1\r\n"
            + "            Leaf with 1 objects: 1\r\n"
            + "          Leaf with 1 objects: 1";
        assertFuzzyEquals(systemOut().getHistory(), out);

    }


    /**
     * Test Split
     */
    public void testYSplit3() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)205, (short)205, 0,
            new String[] { "" }, "");
        Seminar sem2 = new Seminar(2, "", "", 0, (short)205, (short)205, 0,
            new String[] { "" }, "");
        first.insert(sem1, flyNode, 155, 155, 256, 256, 1);
        assertEquals(first.getSplit(0, 256, 155), 205);
        assertEquals(first.value().get(0).y(), 205);
        tree.insert(sem1);
        tree.insert(sem2);
        tree.print();
        String out = "Leaf with 2 objects: 1 2";
        assertFuzzyEquals(systemOut().getHistory(), out);
        assertEquals(first.value().get(0), sem1);
        first.delete(sem2, 1, 205, 205, 256, 256, flyNode);
        first.delete(sem1, 1, 205, 205, 256, 256, flyNode);

    }


    /**
     * Test Split
     */
    public void testSplit() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        int decision = 0;
        int end = 10;
        int coor = 2;
        assertEquals(5, first.getSplit(decision, end, coor));
        decision = 0;
        end = 11;
        coor = 2;
        assertEquals(6, first.getSplit(decision, end, coor));
        decision = 0;
        end = 5;
        coor = 5;
        assertEquals(4, first.getSplit(decision, end, coor));
        decision = 0;
        end = 5;
        coor = 7;
        assertEquals(5, first.getSplit(decision, end, coor));
        decision = 0;
        end = 1000000;
        coor = 250000;
        assertEquals(624999, first.getSplit(decision, end, coor));
    }


    /**
     * Test Sort List
     */
    public void testSortList() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        DLList<Seminar> seminars = new DLList<Seminar>();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)205, (short)205, 0,
            new String[] { "" }, "");
        seminars.add(sem1);
        first.setList(seminars);
        first.sortListAscending();
        assertEquals(seminars.get(0).id(), 1);
        seminars = new DLList<Seminar>();
        sem1 = new Seminar(2, "", "", 0, (short)205, (short)205, 0,
            new String[] { "" }, "");
        seminars.add(sem1);
        Seminar sem2 = new Seminar(1, "", "", 0, (short)205, (short)205, 0,
            new String[] { "" }, "");
        seminars.add(sem2);
        first.setList(seminars);
        first.sortListAscending();
        assertEquals(seminars.get(0).id(), 1);
        assertEquals(seminars.get(1).id(), 2);

    }


    /**
     * Test Delete More
     */
    public void testDeleteMore() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        Seminar sem1 = new Seminar(1, "", "", 0, (short)200, (short)200, 0,
            new String[] { "" }, "");
        first.insert(sem1, flyNode, 200, 200, 256, 256, 0);
        Seminar sem2 = new Seminar(2, "", "", 0, (short)200, (short)200, 0,
            new String[] { "" }, "");
        first.insert(sem2, flyNode, 200, 200, 256, 256, 0);
        assertEquals(first.value().get(0).x(), sem1.x());
        first.delete(sem2, 0, 200, 200, 256, 256, flyNode);
        assertEquals(first.value().size(), 1);
        first.insert(sem2, flyNode, 200, 200, 256, 256, 0);
        assertEquals(first.value().get(0).x(), sem2.x());
        first.delete(sem1, 0, 200, 200, 256, 256, flyNode);
        assertEquals(first.value().size(), 1);

    }


    /**
     * Test Split
     */
    public void testSameSideSplitX() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        DLList<Seminar> seminars = new DLList<Seminar>();
        Seminar sem1 = new Seminar(2, "", "", 0, (short)205, (short)205, 0,
            new String[] { "" }, "");
        seminars.add(sem1);
        first.insert(sem1, flyNode, 0, 0, 128, 128, 0);
        int split = 63;
        int xOrY = 0;
        // both greater than split
        assertTrue(first.sameSideSplit(split, 205, seminars, xOrY));
        seminars.remove(0);
        sem1 = new Seminar(2, "", "", 0, (short)5, (short)5, 0, new String[] {
            "" }, "");
        seminars.add(sem1);
        // both less than split
        assertTrue(first.sameSideSplit(split, 5, seminars, xOrY));
        seminars.remove(0);
        sem1 = new Seminar(2, "", "", 0, (short)63, (short)63, 0, new String[] {
            "" }, "");
        seminars.add(sem1);
        // equal to split
        assertTrue(first.sameSideSplit(split, 63, seminars, xOrY));

    }


    /**
     * Test Split
     */
    public void testSameSideSplitY() {
        BinTree tree = new BinTree(256);
        LeafNode first = (LeafNode)tree.getRoot();
        DLList<Seminar> seminars = new DLList<Seminar>();
        Seminar sem1 = new Seminar(2, "", "", 0, (short)205, (short)205, 0,
            new String[] { "" }, "");
        seminars.add(sem1);
        first.insert(sem1, flyNode, 0, 0, 128, 128, 0);
        int split = 63;
        int xOrY = 1;
        // both greater than split
        assertTrue(first.sameSideSplit(split, 205, seminars, xOrY));
        seminars.remove(0);
        sem1 = new Seminar(2, "", "", 0, (short)5, (short)5, 0, new String[] {
            "" }, "");
        seminars.add(sem1);
        // both less than split
        assertTrue(first.sameSideSplit(split, 5, seminars, xOrY));
        seminars.remove(0);
        sem1 = new Seminar(2, "", "", 0, (short)0, (short)63, 0, new String[] {
            "" }, "");
        seminars.add(sem1);
        // equal to split
        assertTrue(first.sameSideSplit(split, 63, seminars, xOrY));
        seminars.remove(0);
        sem1 = new Seminar(2, "", "", 0, (short)0, (short)220, 0, new String[] {
            "" }, "");
        seminars.add(sem1);
        assertFalse(first.sameSideSplit(split, 63, seminars, xOrY));
        seminars.remove(0);

        DLList<Seminar> sems = new DLList<Seminar>();
        sem1 = new Seminar(2, "", "", 0, (short)5, (short)10, 0, new String[] {
            "" }, "");
        sems.add(sem1);
        assertTrue(first.sameSideSplit(4, 7, sems, 0));
        assertFalse(first.sameSideSplit(4, 3, sems, 0));
        assertFalse(first.sameSideSplit(4, 3, sems, 0));
        assertTrue(first.sameSideSplit(4, 7, sems, 0));
        assertTrue(first.sameSideSplit(9, 12, sems, 1));
        assertFalse(first.sameSideSplit(9, 8, sems, 1));
        assertFalse(first.sameSideSplit(9, 8, sems, 1));
        assertTrue(first.sameSideSplit(9, 12, sems, 1));
        assertTrue(first.sameSideSplit(5, 5, sems, 0));
        assertTrue(first.sameSideSplit(10, 10, sems, 1));
        assertTrue(first.sameSideSplit(1, 10, sems, 1));
        assertTrue(first.sameSideSplit(15, 12, sems, 1));

        sems.remove(0);
        sem1 = new Seminar(2, "", "", 0, (short)-5, (short)-10, 0,
            new String[] { "" }, "");
        sems.add(sem1);
        assertTrue(first.sameSideSplit(5, -7, sems, 0));
        assertTrue(first.sameSideSplit(5, -7, sems, 1));
        assertFalse(first.sameSideSplit(-5, -3, sems, 0));
        assertFalse(first.sameSideSplit(-10, -3, sems, 1));
        first.print(0);
        first.delete(sem1, -5, -10, 128, 128, 128, flyNode);
        first.print(0);
        first.insert(sem1, flyNode, 0, 0, 128, 128, 0);
        first.insert(sem1, flyNode, 0, 0, 128, 128, 0);
        Seminar sem2 = new Seminar(123123, "", "", 0, (short)5, (short)10, 0,
            new String[] { "" }, "");
        sems = new DLList<Seminar>();
        sems.add(sem2);
        first.setList(sems);
        first.delete(sem1, 5, 10, 128, 128, 128, flyNode);

        LeafNode test = new LeafNode();
        Seminar sem = new Seminar(1, "", "", 0, (short)10, (short)20, 0,
            new String[] {}, "");
        test.setValue(sem);

        BinNode result = test.delete(sem, 0, 10, 20, 0, 0, flyNode);

        assertTrue(result instanceof LeafNode);
        assertEquals(0, test.value().size());

        test = new LeafNode();
        Seminar test1 = new Seminar(1, "", "", 0, (short)10, (short)20, 0,
            new String[] {}, "");
        Seminar test2 = new Seminar(2, "", "", 0, (short)5, (short)15, 0,
            new String[] {}, "");
        test.setValue(test1);

        result = test.delete(test2, 0, 5, 15, 0, 0, flyNode);

        assertTrue(result instanceof LeafNode);
        assertEquals(1, test.value().size());

        test = new LeafNode();
        test1 = new Seminar(1, "", "", 0, (short)10, (short)20, 0,
            new String[] {}, "");

        boolean t = false;
        try {
            result = test.delete(sem, 0, 10, 20, 0, 0, flyNode);
        }
        catch (IndexOutOfBoundsException e) {
            t = true;
        }
        assertTrue(t);

        test = new LeafNode();
        Seminar existingSeminar = new Seminar(1, "", "", 0, (short)10,
            (short)20, 0, new String[] {}, "");
        test.setValue(existingSeminar);
        assertTrue(test.sameSideSplit(split, 10, sems, 1));
        assertTrue(test.sameSideSplit(split, 0, sems, 1));
        assertFalse(test.sameSideSplit(split, 110, sems, 1));

    }

}

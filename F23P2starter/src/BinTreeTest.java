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
        short x2 = 1;
        short y2 = 1;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        short x3 = 43;
        short y3 = 177;
        Seminar sem3 = new Seminar(3, "", "", 0, x3, y3, 0, new String[] { "" },
            "");
        short x4 = 240;
        short y4 = 28;
        Seminar sem4 = new Seminar(4, "", "", 0, x4, y4, 0, new String[] { "" },
            "");
        short x5 = 19;
        short y5 = 255;
        Seminar sem5 = new Seminar(5, "", "", 0, x5, y5, 0, new String[] { "" },
            "");
        short x6 = 20;
        short y6 = 255;
        Seminar sem6 = new Seminar(9, "", "", 0, x6, y6, 0, new String[] { "" },
            "");
        short x7 = 20;
        short y7 = 255;
        Seminar sem7 = new Seminar(8, "", "", 0, x7, y7, 0, new String[] { "" },
            "");
        short x8 = 20;
        short y8 = 255;
        Seminar sem8 = new Seminar(7, "", "", 0, x8, y8, 0, new String[] { "" },
            "");
        nTree.insert(sem1);
        nTree.insert(sem2);
        nTree.insert(sem3);
        nTree.insert(sem4);
        nTree.insert(sem5);
        nTree.insert(sem6);
        nTree.insert(sem7);
        nTree.insert(sem8);
        systemOut().clearHistory();
        nTree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    Leaf with 1 objects: 2\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        Leaf with 1 objects: 3\r\n"
            + "        I\r\n"
            + "          I\r\n"
            + "            E\r\n"
            + "            I\r\n"
            + "              E\r\n"
            + "              I\r\n"
            + "                E\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    E\r\n"
            + "                    I\r\n"
            + "                      Leaf with 1 objects: 5\r\n"
            + "                      Leaf with 3 objects: 7 8 9\r\n"
            + "                  E\r\n"
            + "          E\r\n"
            + "      E\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      Leaf with 1 objects: 1\r\n"
            + "      Leaf with 1 objects: 4\r\n"
            + "    E\r\n"
            + "");
        systemOut().clearHistory();
        nTree.search(x1, y1, 3);
        nTree.search(x6, y6, 0);
        nTree.search(x1, y1, 2000);
        nTree.search(x5, y5, 35);
        nTree.search(x3, y3, 128);
        nTree.search(x6, y6, 0);
        history = systemOut().getHistory();
        assertEquals(history, "Seminars within 3 units of 130, 120:\r\n"
            + "Found a record with key value 1 at 130, 120\r\n"
            + "6 nodes visited in this search\r\n"
            + "Seminars within 0 units of 20, 255:\r\n"
            + "Found a record with key value 7 at 20, 255\r\n"
            + "Found a record with key value 8 at 20, 255\r\n"
            + "Found a record with key value 9 at 20, 255\r\n"
            + "12 nodes visited in this search\r\n"
            + "Seminars within 2000 units of 130, 120:\r\n"
            + "Found a record with key value 2 at 1, 1\r\n"
            + "Found a record with key value 3 at 43, 177\r\n"
            + "Found a record with key value 5 at 19, 255\r\n"
            + "Found a record with key value 7 at 20, 255\r\n"
            + "Found a record with key value 8 at 20, 255\r\n"
            + "Found a record with key value 9 at 20, 255\r\n"
            + "Found a record with key value 1 at 130, 120\r\n"
            + "Found a record with key value 4 at 240, 28\r\n"
            + "27 nodes visited in this search\r\n"
            + "Seminars within 35 units of 19, 255:\r\n"
            + "Found a record with key value 5 at 19, 255\r\n"
            + "Found a record with key value 7 at 20, 255\r\n"
            + "Found a record with key value 8 at 20, 255\r\n"
            + "Found a record with key value 9 at 20, 255\r\n"
            + "19 nodes visited in this search\r\n"
            + "Seminars within 128 units of 43, 177:\r\n"
            + "Found a record with key value 3 at 43, 177\r\n"
            + "Found a record with key value 5 at 19, 255\r\n"
            + "Found a record with key value 7 at 20, 255\r\n"
            + "Found a record with key value 8 at 20, 255\r\n"
            + "Found a record with key value 9 at 20, 255\r\n"
            + "Found a record with key value 1 at 130, 120\r\n"
            + "26 nodes visited in this search\r\n"
            + "Seminars within 0 units of 20, 255:\r\n"
            + "Found a record with key value 7 at 20, 255\r\n"
            + "Found a record with key value 8 at 20, 255\r\n"
            + "Found a record with key value 9 at 20, 255\r\n"
            + "12 nodes visited in this search\r\n"
            + "");
        nTree.delete(sem2);
        nTree.delete(sem1);
        nTree.delete(sem3);
        nTree.delete(sem8);
        nTree.delete(sem7);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    E\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        E\r\n"
            + "        I\r\n"
            + "          I\r\n"
            + "            E\r\n"
            + "            I\r\n"
            + "              E\r\n"
            + "              I\r\n"
            + "                E\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    E\r\n"
            + "                    I\r\n"
            + "                      Leaf with 1 objects: 5\r\n"
            + "                      Leaf with 1 objects: 9\r\n"
            + "                  E\r\n"
            + "          E\r\n"
            + "      E\r\n"
            + "  Leaf with 1 objects: 4\r\n"
            + "");
        nTree.delete(sem6);
        nTree.delete(sem5);
        nTree.delete(sem4);
        root = nTree.getRoot();
        assertTrue(root instanceof LeafNode);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "E\n");
        short x10 = 127;
        short y10 = 127;
        Seminar sem10 = new Seminar(10, "", "", 0, x10, y10, 0, new String[] { "" },
            "");
        short x11 = 127;
        short y11 = 128;
        Seminar sem11 = new Seminar(11, "", "", 0, x11, y11, 0, new String[] { "" },
            "");
        short x12 = 128;
        short y12 = 127;
        Seminar sem12 = new Seminar(12, "", "", 0, x12, y12, 0, new String[] { "" },
            "");
        short x13 = 128;
        short y13 = 128;
        Seminar sem13 = new Seminar(13, "", "", 0, x13, y13, 0, new String[] { "" },
            "");
        nTree.insert(sem10);
        nTree.insert(sem11);
        nTree.insert(sem12);
        nTree.insert(sem13);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    Leaf with 1 objects: 10\r\n"
            + "    Leaf with 1 objects: 11\r\n"
            + "  I\r\n"
            + "    Leaf with 1 objects: 12\r\n"
            + "    Leaf with 1 objects: 13\r\n"
            + "");
        systemOut().clearHistory();
        nTree.search(x10, y10, 0);
        nTree.search(x11, y11, 0);
        nTree.search(x12, y12, 0);
        nTree.search(x13, y13, 0);
        history = systemOut().getHistory();
        assertEquals(history, "Seminars within 0 units of 127, 127:\r\n"
            + "Found a record with key value 10 at 127, 127\r\n"
            + "3 nodes visited in this search\r\n"
            + "Seminars within 0 units of 127, 128:\r\n"
            + "Found a record with key value 11 at 127, 128\r\n"
            + "3 nodes visited in this search\r\n"
            + "Seminars within 0 units of 128, 127:\r\n"
            + "Found a record with key value 12 at 128, 127\r\n"
            + "3 nodes visited in this search\r\n"
            + "Seminars within 0 units of 128, 128:\r\n"
            + "Found a record with key value 13 at 128, 128\r\n"
            + "3 nodes visited in this search\r\n"
            + "");
        nTree.delete(sem10);
        nTree.delete(sem11);
        nTree.delete(sem12);
        nTree.delete(sem13);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "E\n");
        nTree.insert(sem10);
        nTree.insert(sem11);
        nTree.insert(sem13);
        nTree.insert(sem12);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    Leaf with 1 objects: 10\r\n"
            + "    Leaf with 1 objects: 11\r\n"
            + "  I\r\n"
            + "    Leaf with 1 objects: 12\r\n"
            + "    Leaf with 1 objects: 13\r\n"
            + "");
    }
    
    public void testInsertDeleteSearch()
    {
        BinTree nTree = new BinTree(256);
        short x1 = 134;
        short y1 = 76;
        Seminar sem1 = new Seminar(1, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        short x2 = 1;
        short y2 = 1;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        short x3 = 43;
        short y3 = 177;
        Seminar sem3 = new Seminar(3, "", "", 0, x3, y3, 0, new String[] { "" },
            "");
        short x4 = 240;
        short y4 = 28;
        Seminar sem4 = new Seminar(4, "", "", 0, x4, y4, 0, new String[] { "" },
            "");
        short x5 = 19;
        short y5 = 255;
        Seminar sem5 = new Seminar(5, "", "", 0, x5, y5, 0, new String[] { "" },
            "");
        short x6 = 243;
        short y6 = 22;
        Seminar sem6 = new Seminar(6, "", "", 0, x6, y6, 0, new String[] { "" },
            "");
        short x7 = 223;
        short y7 = 143;
        Seminar sem7 = new Seminar(7, "", "", 0, x7, y7, 0, new String[] { "" },
            "");
        short x8 = 20;
        short y8 = 255;
        Seminar sem8 = new Seminar(8, "", "", 0, x8, y8, 0, new String[] { "" },
            "");
        short x9 = 255;
        short y9 = 255;
        Seminar sem9 = new Seminar(9, "", "", 0, x9, y9, 0, new String[] { "" },
            "");
        short x10 = 2;
        short y10 = 2;
        Seminar sem10 = new Seminar(10, "", "", 0, x10, y10, 0, new String[] { "" },
            "");
        nTree.insert(sem7);
        nTree.insert(sem2);
        nTree.insert(sem1);
        systemOut().clearHistory();
        nTree.print();
        String history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  Leaf with 1 objects: 2\r\n"
            + "  I\r\n"
            + "    Leaf with 1 objects: 1\r\n"
            + "    Leaf with 1 objects: 7\r\n"
            + "");
        systemOut().clearHistory();
        nTree.search(x1, y1, 0);
        nTree.search(x2, y2, 0);
        nTree.search(x7, y7, 0);
        nTree.search(x10, y10, 0);
        nTree.search(x10, y10, 1);
        nTree.insert(sem10);
        nTree.search(x10, y10, 0);
        history = systemOut().getHistory();
        assertEquals(history, "Seminars within 0 units of 134, 76:\r\n"
            + "Found a record with key value 1 at 134, 76\r\n"
            + "3 nodes visited in this search\r\n"
            + "Seminars within 0 units of 1, 1:\r\n"
            + "Found a record with key value 2 at 1, 1\r\n"
            + "2 nodes visited in this search\r\n"
            + "Seminars within 0 units of 223, 143:\r\n"
            + "Found a record with key value 7 at 223, 143\r\n"
            + "3 nodes visited in this search\r\n"
            + "Seminars within 0 units of 2, 2:\r\n"
            + "2 nodes visited in this search\r\n"
            + "Seminars within 1 units of 2, 2:\r\n"
            + "2 nodes visited in this search\r\n"
            + "Seminars within 0 units of 2, 2:\r\n"
            + "Found a record with key value 10 at 2, 2\r\n"
            + "14 nodes visited in this search\r\n"
            + "");
        nTree.delete(sem7);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        I\r\n"
            + "          I\r\n"
            + "            I\r\n"
            + "              I\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    I\r\n"
            + "                      I\r\n"
            + "                        I\r\n"
            + "                          Leaf with 1 objects: 2\r\n"
            + "                          Leaf with 1 objects: 10\r\n"
            + "                        E\r\n"
            + "                      E\r\n"
            + "                    E\r\n"
            + "                  E\r\n"
            + "                E\r\n"
            + "              E\r\n"
            + "            E\r\n"
            + "          E\r\n"
            + "        E\r\n"
            + "      E\r\n"
            + "    E\r\n"
            + "  Leaf with 1 objects: 1\r\n"
            + "");
        nTree.delete(sem1);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        I\r\n"
            + "          I\r\n"
            + "            I\r\n"
            + "              I\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    I\r\n"
            + "                      I\r\n"
            + "                        I\r\n"
            + "                          Leaf with 1 objects: 2\r\n"
            + "                          Leaf with 1 objects: 10\r\n"
            + "                        E\r\n"
            + "                      E\r\n"
            + "                    E\r\n"
            + "                  E\r\n"
            + "                E\r\n"
            + "              E\r\n"
            + "            E\r\n"
            + "          E\r\n"
            + "        E\r\n"
            + "      E\r\n"
            + "    E\r\n"
            + "  E\r\n"
            + "");
        systemOut().clearHistory();
        nTree.insert(sem3);
        nTree.insert(sem7);
        nTree.insert(sem9);
        nTree.insert(sem8);
        nTree.search(x3, y3, 100);
        nTree.insert(sem1);
        nTree.insert(sem6);
        nTree.insert(sem4);
        nTree.search(x6, y6, 20);
        nTree.insert(sem5);
        nTree.insert(sem3);
        nTree.search(x3, y3, 100);
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "Seminars within 100 units of 43, 177:\r\n"
            + "Found a record with key value 3 at 43, 177\r\n"
            + "Found a record with key value 8 at 20, 255\r\n"
            + "15 nodes visited in this search\r\n"
            + "Seminars within 20 units of 243, 22:\r\n"
            + "Found a record with key value 6 at 243, 22\r\n"
            + "Found a record with key value 4 at 240, 28\r\n"
            + "17 nodes visited in this search\r\n"
            + "Seminars within 100 units of 43, 177:\r\n"
            + "Found a record with key value 3 at 43, 177\r\n"
            + "Found a record with key value 3 at 43, 177\r\n"
            + "Found a record with key value 5 at 19, 255\r\n"
            + "Found a record with key value 8 at 20, 255\r\n"
            + "30 nodes visited in this search\r\n"
            + "I\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        I\r\n"
            + "          I\r\n"
            + "            I\r\n"
            + "              I\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    I\r\n"
            + "                      I\r\n"
            + "                        I\r\n"
            + "                          Leaf with 1 objects: 2\r\n"
            + "                          Leaf with 1 objects: 10\r\n"
            + "                        E\r\n"
            + "                      E\r\n"
            + "                    E\r\n"
            + "                  E\r\n"
            + "                E\r\n"
            + "              E\r\n"
            + "            E\r\n"
            + "          E\r\n"
            + "        E\r\n"
            + "      E\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        Leaf with 2 objects: 3 3\r\n"
            + "        I\r\n"
            + "          I\r\n"
            + "            E\r\n"
            + "            I\r\n"
            + "              E\r\n"
            + "              I\r\n"
            + "                E\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    E\r\n"
            + "                    I\r\n"
            + "                      Leaf with 1 objects: 5\r\n"
            + "                      Leaf with 1 objects: 8\r\n"
            + "                  E\r\n"
            + "          E\r\n"
            + "      E\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      Leaf with 1 objects: 1\r\n"
            + "      I\r\n"
            + "        I\r\n"
            + "          E\r\n"
            + "          I\r\n"
            + "            I\r\n"
            + "              E\r\n"
            + "              I\r\n"
            + "                E\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    Leaf with 1 objects: 6\r\n"
            + "                    Leaf with 1 objects: 4\r\n"
            + "                  E\r\n"
            + "            E\r\n"
            + "        E\r\n"
            + "    I\r\n"
            + "      E\r\n"
            + "      I\r\n"
            + "        Leaf with 1 objects: 7\r\n"
            + "        Leaf with 1 objects: 9\r\n"
            + "");
        nTree.delete(sem6);
        nTree.delete(sem9);
        nTree.delete(sem7);
        nTree.delete(sem5);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        I\r\n"
            + "          I\r\n"
            + "            I\r\n"
            + "              I\r\n"
            + "                I\r\n"
            + "                  I\r\n"
            + "                    I\r\n"
            + "                      I\r\n"
            + "                        I\r\n"
            + "                          Leaf with 1 objects: 2\r\n"
            + "                          Leaf with 1 objects: 10\r\n"
            + "                        E\r\n"
            + "                      E\r\n"
            + "                    E\r\n"
            + "                  E\r\n"
            + "                E\r\n"
            + "              E\r\n"
            + "            E\r\n"
            + "          E\r\n"
            + "        E\r\n"
            + "      E\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        Leaf with 2 objects: 3 3\r\n"
            + "        Leaf with 1 objects: 8\r\n"
            + "      E\r\n"
            + "  I\r\n"
            + "    I\r\n"
            + "      Leaf with 1 objects: 1\r\n"
            + "      Leaf with 1 objects: 4\r\n"
            + "    E\r\n"
            + "");
        nTree.delete(sem1);
        nTree.delete(sem2);
        nTree.delete(sem10);
        nTree.delete(sem3);
        nTree.delete(sem4);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "I\r\n"
            + "  I\r\n"
            + "    E\r\n"
            + "    I\r\n"
            + "      I\r\n"
            + "        Leaf with 1 objects: 3\r\n"
            + "        Leaf with 1 objects: 8\r\n"
            + "      E\r\n"
            + "  E\r\n"
            + "");
        nTree.delete(sem8);
        nTree.delete(sem3);
        systemOut().clearHistory();
        nTree.print();
        history = systemOut().getHistory();
        assertEquals(history, "E\r\n"
            + "");
    }
    
    public void testSearch()
    {
        BinTree nTree = new BinTree(4);
        short x1 = 1;
        short y1 = 1;
        Seminar sem1 = new Seminar(1, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        short x2 = 1;
        short y2 = 2;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        short x3 = 2;
        short y3 = 1;
        Seminar sem3 = new Seminar(3, "", "", 0, x3, y3, 0, new String[] { "" },
            "");
        nTree.insert(sem1);
        nTree.insert(sem2);
        nTree.insert(sem3);
        systemOut().clearHistory();    
        nTree.search(x1, y1, 1);
        String history = systemOut().getHistory();
        assertEquals(history, "Seminars within 1 units of 1, 1:\r\n"
            + "Found a record with key value 1 at 1, 1\r\n"
            + "Found a record with key value 2 at 1, 2\r\n"
            + "Found a record with key value 3 at 2, 1\r\n"
            + "5 nodes visited in this search\r\n"
            + "");
    }
    
    public void testInsertDeleteSearch3()
    {
        BinTree nTree = new BinTree(256);
        short x1 = 1;
        short y1 = 10;
        Seminar sem1 = new Seminar(1, "", "", 0, x1, y1, 0, new String[] { "" },
            "");
        short x2 = 10;
        short y2 = 127;
        Seminar sem2 = new Seminar(2, "", "", 0, x2, y2, 0, new String[] { "" },
            "");
        short x3 = 10;
        short y3 = 10;
        Seminar sem3 = new Seminar(3, "", "", 0, x3, y3, 0, new String[] { "" },
            "");
        short x4 = 10;
        short y4 = 10;
        Seminar sem4 = new Seminar(4, "", "", 0, x4, y4, 0, new String[] { "" },
            "");
        short x5 = 30;
        short y5 = 127;
        Seminar sem5 = new Seminar(5, "", "", 0, x5, y5, 0, new String[] { "" },
            "");
        nTree.insert(sem1);
        nTree.insert(sem2);
        nTree.insert(sem3);
        nTree.insert(sem4);
        nTree.insert(sem5);
        nTree.print();
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
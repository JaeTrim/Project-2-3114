/**
 * 
 */
public class LeafNode implements BinNode {

    private int level;
    private int xStart;
    private int xEnd;
    private int yStart;
    private int yEnd;
    private DLList<Seminar> seminars;

    public LeafNode() {
        seminars = new DLList<Seminar>();
    }


    public boolean isEmpty() {
        if (seminars.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }


    public void setLevel(int lev) {
        level = lev;

    }


    public int getLevel() {
        return level;
    }


    public BinNode left() {
        return null;
    }


    public BinNode right() {
        return null;
    }


    public DLList<Seminar> value() {
        return seminars;
    }


    public void setLeft(BinNode left) {
    }


    public void setRight(BinNode right) {
    }


    public void setValue(Seminar sem) {
        seminars.add(sem);

    }


    public void setList(DLList<Seminar> sems) {
        seminars = sems;
    }


    public BinNode insert(Seminar sem, BinNode flyNode) {
        int decision = level % 2;
        int x = sem.x();
        int y = sem.y();
        if (isEmpty()) {
            setValue(sem);
            return this;
        }
        else if (seminars.get(0).x() == x && seminars.get(0).y() == y) {
            seminars.add(sem);
            return this;
        }
        else {
            if (decision == 0) {
                int split = xStart + ((xEnd - xStart) / 2);
                InternalNode internal = new InternalNode();
                internal.setXStart(xStart);
                internal.setXEnd(xEnd);
                internal.setYStart(yStart);
                internal.setYEnd(yEnd);
                internal.setLevel(level);
                if ((x > split) && (seminars.get(0).x() > split)) {
                    this.setLevel(level + 1);
                    this.setYStart(yStart);
                    this.setYEnd(yEnd);
                    this.setXStart(split);
                    this.setXEnd(xEnd);
                    internal.setRight(this);
                    internal.setLeft(flyNode);
                    return internal.insert(sem, flyNode);
                }
                else if (((x <= split) && (seminars.get(0).x() <= split))) {
                    this.setLevel(level + 1);
                    this.setYStart(yStart);
                    this.setYEnd(yEnd);
                    this.setXStart(xStart);
                    this.setXEnd(split);
                    internal.setRight(flyNode);
                    internal.setLeft(this);
                    return internal.insert(sem, flyNode);
                }
                else if (seminars.get(0).x() > x) {
                    LeafNode curr = new LeafNode();
                    curr.setXStart(xStart);
                    curr.setYStart(yStart);
                    curr.setXEnd(split);
                    curr.setYEnd(yEnd);
                    curr.setLevel(level + 1);

                    curr.setList(seminars);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setXStart(xStart);
                    curr2.setYStart(yStart);
                    curr2.setXEnd(split);
                    curr2.setYEnd(yEnd);
                    curr2.setLevel(level + 1);
                    curr2.setValue(sem);
                    internal.setLeft(curr2);
                    return internal;
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setXStart(split);
                    curr.setYStart(yStart);
                    curr.setXEnd(xEnd);
                    curr.setYEnd(yEnd);
                    curr.setLevel(level + 1);
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setXStart(xStart);
                    curr2.setYStart(yStart);
                    curr2.setXEnd(split);
                    curr2.setYEnd(yEnd);
                    curr2.setLevel(level + 1);
                    curr2.setList(seminars);
                    internal.setLeft(curr2);
                    return internal;
                }
            }
            else {
                int split = yStart + ((yEnd - yStart) / 2);
                InternalNode internal = new InternalNode();
                if ((y > split) && (seminars.get(0).y() > split)) {
                    internal.setXStart(xStart);
                    internal.setXEnd(xEnd);
                    internal.setYStart(yStart);
                    internal.setYEnd(yEnd);
                    internal.setLevel(level);
                    this.setLevel(level + 1);
                    this.setYStart(split);
                    this.setYEnd(yEnd);
                    this.setXStart(xStart);
                    this.setXEnd(xEnd);
                    internal.setRight(this);
                    internal.setLeft(flyNode);
                    return internal.insert(sem, flyNode);
                }
                else if (((y <= split) && (seminars.get(0).y() <= split))) {
                    internal.setXStart(xStart);
                    internal.setXEnd(xEnd);
                    internal.setYStart(yStart);
                    internal.setYEnd(yEnd);
                    internal.setLevel(level);
                    this.setLevel(level + 1);
                    this.setYStart(yStart);
                    this.setYEnd(split);
                    this.setXStart(xStart);
                    this.setXEnd(xEnd);
                    internal.setRight(flyNode);
                    internal.setLeft(this);
                    return internal.insert(sem, flyNode);
                }
                else if (seminars.get(0).y() > y) {
                    LeafNode curr = new LeafNode();
                    curr.setXStart(xStart);
                    curr.setYStart(yStart);
                    curr.setXEnd(yEnd);
                    curr.setYEnd(split);
                    curr.setLevel(level + 1);
                    curr.setList(seminars);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setXStart(xStart);
                    curr2.setYStart(yStart);
                    curr2.setXEnd(yEnd);
                    curr2.setYEnd(split);
                    curr2.setLevel(level + 1);
                    curr2.setValue(sem);
                    internal.setLeft(curr2);
                    return internal;
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setXStart(xStart);
                    curr.setYStart(split);
                    curr.setXEnd(yEnd);
                    curr.setYEnd(yEnd);
                    curr.setLevel(level + 1);
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setXStart(xStart);
                    curr2.setYStart(yStart);
                    curr2.setXEnd(yEnd);
                    curr2.setYEnd(split);
                    curr2.setLevel(level + 1);
                    curr2.setList(seminars);
                    internal.setLeft(curr2);
                    return internal;
                }
            }
        }

    }


    public void print() {
        if (seminars.size() > 1) {
            System.out.print("Leaf with " + seminars.size() + " objects: ");
            for (int j = 0; j < seminars.size(); j++) {
                System.out.print(seminars.get(j).id() + " ");
            }
            System.out.println("");

        }
        else {
            System.out.println("Leaf with " + seminars.size() + " objects: "
                + seminars.get(0).id());
        }

    }


    public void setXStart(int x_coord) {
        xStart = x_coord;
    }


    public int getXStart() {
        return xStart;
    }


    public void setXEnd(int x_coord) {
        xEnd = x_coord;
    }


    public int getXEnd() {
        return xEnd;
    }


    public void setYStart(int y_coord) {
        yStart = y_coord;
    }


    public int getYStart() {
        return yStart;
    }


    public void setYEnd(int y_coord) {
        yEnd = y_coord;
    }


    public int getYEnd() {
        return yEnd;
    }

}

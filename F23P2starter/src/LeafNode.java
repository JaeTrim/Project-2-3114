/**
 * 
 */
public class LeafNode implements BinNode {

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


    public DLList<Seminar> value() {
        return seminars;
    }


    public void setValue(Seminar sem) {
        seminars.add(sem);

    }


    public void setList(DLList<Seminar> sems) {
        seminars = sems;
    }


    public BinNode insert(
        Seminar sem,
        BinNode flyNode,
        int x,
        int y,
        int xEnd,
        int yEnd,
        int level) {
        int decision = level % 2;
        int newX = sem.x();
        int newY = sem.y();
        if (this == flyNode) {
            LeafNode leaf = new LeafNode();
            return leaf.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        }
        else if (this.isEmpty()) {
            setValue(sem);
            return this;
        }
        else if (seminars.get(0).x() == newX && seminars.get(0).y() == newY) {
            seminars.add(sem);
            sortListAscending();
            return this;
        }
        else {
            if (decision == 0) {
                int split = 0;
                if ((xEnd - x) % 2 == 0) {
                    split = x + (((xEnd - x) / 2) - 1);
                }
                else {
                    split = x + ((xEnd - x) / 2);
                }
                InternalNode internal = new InternalNode(flyNode);
                if (((newX > split) && (seminars.get(0).x() > split))
                    || ((newX <= split) && (seminars.get(0).x() <= split))) {
                    for (int i = 0; i < seminars.size(); i++) {
                        internal.insert(seminars.get(i), flyNode, x, y, xEnd,
                            yEnd, level);
                    }
                    return internal.insert(sem, flyNode, x, y, xEnd, yEnd,
                        level);
                }
                else if (seminars.get(0).x() > newX) {
                    internal.setRight(this);
                    LeafNode leaf = new LeafNode();
                    leaf.setValue(sem);
                    internal.setLeft(leaf);
                    return internal;
                }
                else {
                    LeafNode leaf = new LeafNode();
                    leaf.setValue(sem);
                    internal.setRight(leaf);
                    internal.setLeft(this);
                    return internal;
                }
            }
            else {
                int split = 0;
                if ((yEnd - y) % 2 == 0) {
                    split = y + (((yEnd - y) / 2) - 1);
                }
                else {
                    split = y + ((yEnd - y) / 2);
                }
                InternalNode internal = new InternalNode(flyNode);
                if (((newY > split) && (seminars.get(0).y() > split))
                    || ((newY <= split) && (seminars.get(0).y() <= split))) {
                    for (int i = 0; i < seminars.size(); i++) {
                        internal.insert(seminars.get(i), flyNode, x, y, xEnd,
                            yEnd, level);
                    }
                    return internal.insert(sem, flyNode, x, y, xEnd, yEnd,
                        level);
                }
                else if (seminars.get(0).y() > newY) {
                    internal.setRight(this);
                    LeafNode curr = new LeafNode();
                    curr.setValue(sem);
                    internal.setLeft(curr);
                    return internal;
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setValue(sem);
                    internal.setRight(curr);
                    internal.setLeft(this);
                    return internal;
                }
            }
        }

    }


    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        if (seminars.size() >= 1) {
            System.out.print("Leaf with " + seminars.size() + " objects:");
            for (int j = 0; j < seminars.size(); j++) {
                System.out.print(" " + seminars.get(j).id());
            }
            System.out.println("");

        }
        else {
            System.out.println("E");
        }
    }


    public BinNode delete(
        Seminar sem,
        int level,
        int x,
        int y,
        int xEnd,
        int yEnd,
        BinNode fly) {
        if (seminars.get(0).x() == sem.x() && seminars.get(0).y() == sem.y()) {
            for (int i = 0; i < seminars.size(); i++) {
                if (seminars.get(i).id() == sem.id()) {
                    seminars.remove(i);
                }
            }
        }
        if (seminars.size() == 0) {
            return fly;
        }
        return this;
    }


    public int search(
        int searchX,
        int searchY,
        int radius,
        int nodeX,
        int nodeY,
        int xEnd,
        int yEnd,
        int level,
        int numNodes,
        BinNode fly) {
        if (seminars.size() == 0) {
            return numNodes;
        }
        else {
            int pX = seminars.get(0).x() - searchX;
            int pY = seminars.get(0).y() - searchY;
            if (pX * pX + pY * pY <= (radius * radius)) {
                for (int i = 0; i < seminars.size(); i++) {
                    System.out.println("Found a record with key value "
                        + seminars.get(i).id() + " at " + seminars.get(i).x()
                        + ", " + seminars.get(i).y());
                }
            }
        }
        return numNodes;
    }


    private void sortListAscending() {
        for (int i = 0; i < seminars.size() - 1; i++) {
            for (int j = i + 1; j < seminars.size(); j++) {
                if (seminars.get(i).id() > seminars.get(j).id()) {
                    Seminar temp = seminars.get(j);
                    seminars.remove(j);
                    seminars.add(i, temp);
                }
            }
        }
    }
}

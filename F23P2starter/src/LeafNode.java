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


    public BinNode insert(Seminar sem, BinNode flyNode, int x, int y, int xEnd, int yEnd, int level) {
        int decision = level % 2;
        int newX = sem.x();
        int newY = sem.y();
        if (this == flyNode) {
            LeafNode leaf = new LeafNode();
            return leaf.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        }
        else if (this.isEmpty())
        {
            setValue(sem);
            return this;
        }
        else if (seminars.get(0).x() == newX && seminars.get(0).y() == newY) {
            seminars.add(sem);
            return this;
        }
        else {
            if (decision == 0) {
                int split = x + ((xEnd - x) / 2);
                InternalNode internal = new InternalNode(flyNode);
                if (((newX > split) && (seminars.get(0).x() > split)) || ((newX <= split) && (seminars.get(0).x() <= split))) {
                    for (int i = 0; i < seminars.size(); i++)
                    {
                        internal.insert(seminars.get(i), flyNode, x, y, xEnd, yEnd, level);
                    }
                    return internal.insert(sem, flyNode, x, y, xEnd, yEnd, level);
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
                int split = y + ((yEnd - y) / 2);
                InternalNode internal = new InternalNode(flyNode);
                if (((newY > split) && (seminars.get(0).y() > split)) || ((newY <= split) && (seminars.get(0).y() <= split))) {
                    for (int i = 0; i < seminars.size(); i++)
                    {
                        internal.insert(seminars.get(i), flyNode, x, y, xEnd, yEnd, level);
                    }
                    return internal.insert(sem, flyNode, x, y, xEnd, yEnd, level);
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


    public void print() {
        if (seminars.size() >= 1) {
            System.out.print("Leaf with " + seminars.size() + " objects: ");
            for (int j = 0; j < seminars.size(); j++) {
                System.out.print(seminars.get(j).id() + " ");
            }
            System.out.println("");

        }
        else if (seminars.size() == 0)
        {
            System.out.println("E");
        }
    }

    
    public BinNode delete(Seminar sem, int level, int x, int y, int xEnd, int yEnd, BinNode fly)
    {
        if (seminars.get(0).x() == sem.x() && seminars.get(0).y() == sem.y())
        {
            for (int i = 0; i < seminars.size(); i++)
            {
                if (seminars.get(i).id() == sem.id())
                {
                    seminars.remove(i);
                }
            }
        }
        if (seminars.size() == 0)
        {
            return fly;
        }
        return this;
    }
}

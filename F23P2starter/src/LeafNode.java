/**
 * 
 */
public class LeafNode implements BinNode {

    private int level;
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
        ;

    }


    public BinNode insert(Seminar sem, int decision) {
        int x = sem.x();
        int y = sem.y();
        if (isEmpty()) {
            seminars.add(sem);
            return this;
        }
        else if (seminars.get(0).x() == x && seminars.get(0).y() == y) {
            seminars.add(sem);
            return this;
        }
        else {
            InternalNode internal = new InternalNode();
            internal.setLevel(level);
            if (decision == 0) {
                if (seminars.get(0).x() > x) {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(seminars.get(0));
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(sem);
                    internal.setLeft(curr);
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(seminars.get(0));
                    internal.setLeft(curr);
                }
            }
            else {
                if (seminars.get(0).y() > y) {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(seminars.get(0));
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(sem);
                    internal.setLeft(curr);
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(seminars.get(0));
                    internal.setLeft(curr);
                }
            }
            return internal;
        }
    }


    public void print() {
        for (int i = 0; i < seminars.size(); i++) {
            System.out.println("Leaf with " + seminars.size() + " objects: "
                + seminars.get(i).id());
        }
    }

}

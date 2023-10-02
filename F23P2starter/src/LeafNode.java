/**
 * 
 */
public class LeafNode implements BinNode {

    private int level;
    private Seminar val;

    public boolean isEmpty() {
        if (val == null) {
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


    public Seminar value() {
        return val;
    }


    public void setLeft(BinNode left) {
    }


    public void setRight(BinNode right) {
    }


    public void setValue(Seminar sem) {
        val = sem;

    }


    public BinNode insert(Seminar sem, int decision) {
        int x = sem.x();
        int y = sem.y();
        if (isEmpty()) {
            val = sem;
            return this;
        }
        else {
            InternalNode internal = new InternalNode();
            if (decision == 0) {
                if (val.x() > x) {
                    LeafNode curr = new LeafNode();
                    curr.setValue(val);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setValue(sem);
                    internal.setLeft(curr);
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setValue(val);
                    internal.setLeft(curr);
                }
            }
            else {
                if (val.y() > y) {
                    LeafNode curr = new LeafNode();
                    curr.setValue(val);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setValue(sem);
                    internal.setLeft(curr);
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setValue(val);
                    internal.setLeft(curr);
                }
            }
            return internal;  
        }
    }

}

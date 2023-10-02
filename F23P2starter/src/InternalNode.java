
public class InternalNode implements BinNode {

    private Seminar val;
    private BinNode left;
    private BinNode right;
    private int level;

    public InternalNode() {
        left = right = null;
    }


    public InternalNode(Seminar val) {
        left = right = null;
        this.val = val;
    }


    public InternalNode(Seminar val, BinNode l, BinNode r) {
        left = l;
        right = r;
        this.val = val;
    }


    public Seminar value() {
        return val;
    }


    public void setValue(Seminar sem) {
        val = sem;
    }


    public BinNode left() {
        return left;
    }


    public void setLeft(BinNode temp) {
        left = temp;
    }


    public void setRight(BinNode temp) {
        right = temp;
    }


    public BinNode right() {
        return right;
    }


    public boolean isLeaf() {
        return (left == null) && (right == null);
    }


    public void setLevel(int lev) {
        level = lev;

    }


    public int getLevel() {
        return level;
    }

}

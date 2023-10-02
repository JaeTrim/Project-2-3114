/**
 * 
 */
public class LeafNode implements BinNode {

    private int level;
    private BinNode left;
    private BinNode right;
    private Seminar val;

    public boolean isEmpty() {
        if (val != null) {
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
        return left;
    }


    public BinNode right() {
        return right;
    }


    public Seminar value() {
        return val;
    }


    public void setLeft(BinNode left) {
        this.left = left;

    }


    public void setRight(BinNode right) {
        this.right = right;

    }


    public void setValue(Seminar sem) {
        val = sem;

    }

}

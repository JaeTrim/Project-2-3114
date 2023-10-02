
public class InternalNode implements BinNode {

    private BinNode left;
    private BinNode right;
    private int level;

    public InternalNode() {
        left = right = null;
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


    public void setLevel(int lev) {
        level = lev;
    }


    public int getLevel() {
        return level;
    }


    public BinNode insert(Seminar sem, int decision) {
        if (decision == 0) {
            return right.insert(sem, decision);
        }
        else {
            return left.insert(sem, decision);
        }
    }

}

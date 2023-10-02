
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


    public BinNode setLeft(BinNode temp) {
        left = temp;
        return left;
    }


    public BinNode setRight(BinNode temp) {
        right = temp;
        return right;
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
            setRight(right.insert(sem, decision));
            return this;
        }
        else {
            setLeft(left.insert(sem, decision));
            return this;
        }
    }


    public void print() {
        if (left != null) {
            System.out.println("I");
            left.print();
        }
        if (right != null) {
            System.out.println("I");
            right.print();
        }
        
    }

}

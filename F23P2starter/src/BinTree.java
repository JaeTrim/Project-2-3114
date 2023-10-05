
/**
 * BinTree Class
 */
public class BinTree {

    private LeafNode flyNode;
    private int worldSize;
    private BinNode root;

    public BinTree(int size) {
        worldSize = size;
        flyNode = new LeafNode();
        root = flyNode;
    }


    /**
     * Returns 0 if splitting by x. 1 if splitting by y.
     */
    public void insert(Seminar sem) {
        if (root == flyNode) {
            LeafNode leaf = new LeafNode();
            leaf.insert(sem, flyNode, 0, 0, worldSize - 1, worldSize - 1, 0);
            root = leaf;
        }
        else {
            root = root.insert(sem, flyNode, 0, 0, worldSize - 1, worldSize - 1,
                0);
        }
    }


    public void print() {
        root.print();
    }

    public BinNode getRoot() {
        return root;
    }
    
    public void delete(Seminar sem)
    {
        root = root.delete(sem, 0, 0, 0, worldSize - 1, worldSize - 1, flyNode);
    }
}
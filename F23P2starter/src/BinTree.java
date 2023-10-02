
/**
 * BinTree Class
 */
public class BinTree {

    private static BinNode flyweightNode;

    // private FlyweightNode flyNode;
    private int worldSize;
    private BinNode root;

    // tree will always be two dimensions for x and y coords
    final int dimensions = 2;

    public BinTree(int size) {
        worldSize = size;
        root = flyweightNode;
    }


    /**
     * Returns 0 if splitting by x. 1 if splitting by y.
     */
    public int splitDecision(int level) {
        return level % dimensions;
    }
    
    public void insert(Seminar sem)
    {
        if (root == flyweightNode)
        {
            LeafNode leaf = new LeafNode();
            leaf.insert(sem, splitDecision(leaf.getLevel()));
            root = leaf;
        }
        else
        {
            root.insert(sem, root.getLevel());
        }
    }

}

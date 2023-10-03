
/**
 * BinTree Class
 */
public class BinTree {

    private BinNode flyweightNode;

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
            leaf.setLevel(0);
            leaf.setXStart(0);
            leaf.setYStart(0);
            leaf.setXEnd(worldSize - 1);
            leaf.setYEnd(worldSize - 1);
            leaf.insert(sem, flyweightNode);
            root = leaf;
        }
        else
        {
            root = root.insert(sem, flyweightNode);
        }
    }
    
    
    public void print() {
        if (root == flyweightNode) {
            System.out.println("E");
        }
        else {
            root.print();
        }
    }

}

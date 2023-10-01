
/**
 * BinTree Class
 */
public class BinTree<E extends Comparable<? super E>> {
    
    //private FlyweightNode flyNode;
    private int worldSize;
    private BinNode root;

    // tree will always be two dimensions for x and y coords
    final int dimensions = 2;
    
    public BinTree(int size) {
        worldSize = size;
        
    }
    
    /**
     * Returns 0 if splitting by x.  1 if splitting by y.
     */
    public int splitDecision(int level)
    {
        return level % dimensions;
    }
    
    
}

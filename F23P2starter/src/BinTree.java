
/**
 * BinTree Class
 */
public class BinTree<E extends Comparable<? super E>> {
    
    private FlyweightNode flyNode;
    //private E root;
    private int worldSize;
    
    // tree will always be two dimensions for x and y coords
    final int dimensions = 2;
    
    private LeafNode leaf;
    private E Root;
    

    public BinTree<>(int size) {
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

/**
 * 
 */
public class BinNode implements LeafNode, InternalNode {
    
    private int level;
    private Seminar val;

    @Override
    public boolean leafIsFull() {
        if (val != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void leafSetLevel(int lev) {
        level = lev;
        
    }

    @Override
    public int leafGetLevel() {
        return level;
    }

}

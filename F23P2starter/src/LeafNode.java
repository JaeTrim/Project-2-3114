
public class LeafNode<E extends Comparable<? super E>> {
    
    private int level;
    private E val;
    
    public LeafNode()
    {
        
    }
    
    public boolean isFull()
    {
        if (val != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setLevel(int lev)
    {
        level = lev;
    }
    
    public int getLevel()
    {
        return level;
    }
}

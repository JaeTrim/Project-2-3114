
public interface BinNode {
   
    
    public void setLevel(int lev);
    
    public int getLevel();
    
    public BinNode left();
    
    public void setLeft(BinNode left);
    
    public BinNode right();
    
    public void setRight(BinNode right);
    
    public Seminar value();
    
    public void setValue(Seminar sem);
    
    public BinNode insert(Seminar node, int decision);
    
}

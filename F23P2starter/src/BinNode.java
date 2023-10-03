
public interface BinNode {
   
    public void setLevel(int lev);
    
    public int getLevel();
    
    public BinNode insert(Seminar node, BinNode flyNode);
    
    public void print();
    
    public void setXStart(int x_coord);
    
    public int getXStart();
    
    public void setXEnd(int x_coord);
    
    public int getXEnd();
    
    public void setYStart(int y_coord);
    
    public int getYStart();
    
    public void setYEnd(int y_coord);
    
    public int getYEnd();
        
}

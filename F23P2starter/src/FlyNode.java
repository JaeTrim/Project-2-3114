
public class FlyNode implements BinNode {
    
    private int xStart;
    private int xEnd;
    private int yStart;
    private int yEnd;

    @Override
    public void setLevel(int lev) {
    }

    @Override
    public int getLevel() {  
        return 0;
    }

    @Override
    public BinNode insert(Seminar node, BinNode flyNode) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void print() {
        System.out.println("E");
    }

    public void setXStart(int x_coord)
    {
        xStart = x_coord;
    }
    
    public int getXStart()
    {
        return xStart;
    }
    
    public void setXEnd(int x_coord)
    {
        xEnd = x_coord;
    }
    
    public int getXEnd()
    {
        return xEnd;
    }
    
    public void setYStart(int y_coord)
    {
        yStart = y_coord;
    }
    
    public int getYStart()
    {
        return yStart;
    }
    
    public void setYEnd(int y_coord)
    {
        yEnd = y_coord;
    }
    
    public int getYEnd()
    {
        return yEnd;
    }
    

}

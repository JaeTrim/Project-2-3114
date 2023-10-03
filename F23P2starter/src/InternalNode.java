
public class InternalNode implements BinNode {

    private BinNode left;
    private BinNode right;
    private int xStart;
    private int xEnd;
    private int yStart;
    private int yEnd;
    private int level;

    public InternalNode() {
        left = right = null;
    }


    public BinNode left() {
        return left;
    }


    public BinNode setLeft(BinNode temp) {
        left = temp;
        return left;
    }


    public BinNode setRight(BinNode temp) {
        right = temp;
        return right;
    }


    public BinNode right() {
        return right;
    }


    public void setLevel(int lev) {
        level = lev;
    }


    public int getLevel() {
        return level;
    }
    
    


    public BinNode insert(Seminar sem, int decision) {
        
        
        if (decision == 0) {
            if (sem.x() > xEnd)
            {
                setRight(right.insert(sem, decision));       
                return this;
            }
            else
            {
                
            }
        }
        else {
            setLeft(left.insert(sem, decision));
            return this;
        }
    }


    public void print() {
        if (left != null) {
            //System.out.println("I");
            left.print();
        }
        if (right != null) {
            //System.out.println("I");
            right.print();
        }
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

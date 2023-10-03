
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

    public BinNode insert(Seminar sem, BinNode flyNode) {
        int decision = level % 2;
        
        if (decision == 0) {
            if (sem.x() > xEnd)
            {
                setRight(right.insert(sem, flyNode));       
                return this;
            }
            else
            {
                if ((sem.x() > (xStart + (xEnd - xStart)/ 2)))
                {
                    if (right == flyNode)
                    {
                        LeafNode leaf = new LeafNode();
                        leaf.setLevel(level + 1);
                        leaf.setXEnd(xEnd);
                        leaf.setXStart((xStart - xEnd)/ 2);
                        leaf.setYStart(yStart);
                        leaf.setYEnd(yEnd);
                        leaf.insert(sem, flyNode);
                        return this;
                    }
                    else
                    {
                        setRight(right.insert(sem, flyNode));       
                        return this;
                    }
                    
                }
                else
                {
                    if (left == flyNode)
                    {
                        LeafNode leaf = new LeafNode();
                        leaf.setLevel(level + 1);
                        leaf.setXEnd(xEnd);
                        leaf.setXStart((xStart - xEnd)/ 2);
                        leaf.setYStart(yStart);
                        leaf.setYEnd(yEnd);
                        leaf.insert(sem, flyNode);
                        return this;
                    }
                    else
                    {
                        setLeft(left.insert(sem, flyNode));       
                        return this;
                    }
                }
            }
        }
        else {
            if (sem.y() > xEnd)
            {
                setRight(right.insert(sem, flyNode));       
                return this;
            }
            else
            {
                if ((sem.y() > (yStart + (yEnd - yStart)/ 2)))
                {
                    if (right == flyNode)
                    {
                        LeafNode leaf = new LeafNode();
                        leaf.setLevel(level + 1);
                        leaf.setXEnd(xEnd);
                        leaf.setXStart(xStart);
                        leaf.setYStart((yStart - yEnd)/ 2);
                        leaf.setYEnd(yEnd);
                        leaf.insert(sem, flyNode);
                        return this;
                    }
                    else
                    {
                        setRight(right.insert(sem, flyNode));       
                        return this;
                    }
                    
                }
                else
                {
                    if (left == flyNode)
                    {
                        LeafNode leaf = new LeafNode();
                        leaf.setLevel(level + 1);
                        leaf.setXEnd(xEnd);
                        leaf.setXStart(xStart);
                        leaf.setYStart((yStart - yEnd)/ 2);
                        leaf.setYEnd(yEnd);
                        leaf.insert(sem, flyNode);
                        return this;
                    }
                    else
                    {
                        setLeft(left.insert(sem, flyNode));       
                        return this;
                    }
                }
            }
        }
    }


    public void print() {
        System.out.println("I");
        if (left != null) {
         
            left.print();
        }
        else
        {
            System.out.println("E");
        }
        if (right != null) {
            
            right.print();
        }
        else
        {
            System.out.println("E");
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

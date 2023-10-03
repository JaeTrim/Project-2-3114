/**
 * 
 */
public class LeafNode implements BinNode {

    private int level;
    private int xStart;
    private int xEnd;
    private int yStart;
    private int yEnd;
    private Seminar seminar;
    
    public LeafNode() {
        seminar = null;
    }
   
    public boolean isEmpty() {
        if (seminar == null) {
            return true;
        }
        else {
            return false;
        }
    }


    public void setLevel(int lev) {
        level = lev;

    }


    public int getLevel() {
        return level;
    }


    public BinNode left() {
        return null;
    }


    public BinNode right() {
        return null;
    }


    public Seminar value() {
        return seminar;
    }


    public void setLeft(BinNode left) {
    }


    public void setRight(BinNode right) {
    }


    public void setValue(Seminar sem) {
        seminar = sem;
        

    }


    public BinNode insert(Seminar sem, int decision) {
        int x = sem.x();
        int y = sem.y();
        //int id = sem.id();
        if (isEmpty()) {
            setValue(sem);
            return this;
        }
//        else if (seminar.x() == x && seminar.y() == y && seminar.id() == id) {
//            setValue(sem);
//            return this;
//        }
        else {
            InternalNode internal = new InternalNode();
            internal.setLevel(level);
            if (decision == 0) {
                if (seminar.x() > x) {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(seminar);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(sem);
                    internal.setLeft(curr2);
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(seminar);
                    internal.setLeft(curr2);
                }
            }
            else {
                if (seminar.y() > y) {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(seminar);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(sem);
                    internal.setLeft(curr2);
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setLevel(level + 1);
                    curr.setValue(sem);
                    internal.setRight(curr);
                    LeafNode curr2 = new LeafNode();
                    curr2.setLevel(level + 1);
                    curr2.setValue(seminar);
                    internal.setLeft(curr2);
                }
            }
            return internal;
        }
    }


    public void print() {
//        for (int i = 0; i < level; i++)
//        {
//            System.out.println("I");
//        }
//        for (int i = 0; i < seminars.size(); i++) {
//            System.out.println("Leaf with " + seminars.size() + " objects: "
//                + seminars.get(i).id());
//        }
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

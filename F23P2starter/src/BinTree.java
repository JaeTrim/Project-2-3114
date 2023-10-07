
/**
 * BinTree Class
 */
public class BinTree {

    private LeafNode flyNode;
    private int worldSize;
    private BinNode root;

    public BinTree(int size) {
        worldSize = size;
        flyNode = new LeafNode();
        root = flyNode;
    }


    /**
     * Returns 0 if splitting by x. 1 if splitting by y.
     */
    public void insert(Seminar sem) {
            root = root.insert(sem, flyNode, 0, 0, worldSize - 1, worldSize - 1,
                0);  
    }

    public void print() {
        root.print(0);
    }

    public BinNode getRoot() {
        return root;
    }
    
    public void delete(Seminar sem)
    {
        root = root.delete(sem, 0, 0, 0, worldSize - 1, worldSize - 1, flyNode);
    }
    
    public void search(int x, int y, int radius)
    {
        System.out.println("Seminars within " + radius + " units of "+ x + ", " + y + ":");
        int numNodes = root.search(x, y, radius, 0, 0, worldSize, worldSize, 0, 1, flyNode);
        System.out.println(numNodes + " nodes visited in this search");
    }
}

/**
 * BinTree Class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-09-2023
 */
public class BinTree {

    private LeafNode flyNode;
    private int worldSize;
    private BinNode root;

    /**
     * Bin Tree Constructor
     * 
     * @param size
     *            of tree
     */
    public BinTree(int size) {
        worldSize = size;
        flyNode = new LeafNode();
        root = flyNode;
    }


    /**
     * Returns 0 if splitting by x. 1 if splitting by y.
     * 
     * @param sem
     *            object
     */
    public void insert(Seminar sem) {
        root = root.insert(sem, flyNode, 0, 0, worldSize - 1, worldSize - 1, 0);
    }


    /**
     * Prints the BinTree
     */
    public void print() {
        root.print(0);
    }


    /**
     * Gets the root of tree
     * 
     * @return root of BinTree
     */
    public BinNode getRoot() {
        return root;
    }


    /**
     * Deletes from BinTree
     * 
     * @param sem
     *            object
     */
    public void delete(Seminar sem) {
        root = root.delete(sem, 0, 0, 0, worldSize - 1, worldSize - 1, flyNode);
    }


    /**
     * Searches in a radius in the BinTree
     * 
     * @param x
     *            coor
     * @param y
     *            coor
     * @param radius
     *            of search region
     */
    public void search(int x, int y, int radius) {
        System.out.println("Seminars within " + radius + " units of " + x + ", "
            + y + ":");
        int numNodes = root.search(x, y, radius, 0, 0, worldSize, worldSize, 0,
            1);
        System.out.println(numNodes + " nodes visited in this search");
    }
}

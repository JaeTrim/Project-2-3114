/**
 * Bin Node Interface
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-09-2023
 */

public interface BinNode {

    /**
     * Insert for BinNode
     * 
     * @param sem
     *            object
     * @param flyNode
     *            for empty leaf
     * @param x
     *            coor
     * @param y
     *            coor
     * @param xEnd
     *            coor
     * @param yEnd
     *            coor
     * @param level
     *            of node
     * @return BinNode inserted
     */
    public BinNode insert(
        Seminar sem,
        BinNode flyNode,
        int x,
        int y,
        int xEnd,
        int yEnd,
        int level);


    /**
     * Print for BinNode
     * 
     * @param level
     *            of node
     */
    public void print(int level);


    /**
     * 
     * @param sem
     *            object
     * @param level
     *            of node
     * @param x
     *            coor
     * @param y
     *            coor
     * @param xEnd
     *            coor
     * @param yEnd
     *            coor
     * @param fly
     *            node
     * @return BinNode deleted
     */
    public BinNode delete(
        Seminar sem,
        int level,
        int x,
        int y,
        int xEnd,
        int yEnd,
        BinNode fly);


    /**
     * 
     * @param searchX
     *            coor
     * @param searchY
     *            coor
     * @param w
     *            radius
     * @param nodeX
     *            coor
     * @param nodeY
     *            coor
     * @param xEnd
     *            coor
     * @param yEnd
     *            coor
     * @param level
     *            of node
     * @param numNodes
     *            number of nodes
     * @return nodes searched
     */
    public int search(
        int searchX,
        int searchY,
        int w,
        int nodeX,
        int nodeY,
        int xEnd,
        int yEnd,
        int level,
        int numNodes);
}

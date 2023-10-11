
/**
 * Internal Node class that implements BinNode interface
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */
public class InternalNode implements BinNode {

    private BinNode left;
    private BinNode right;

    /**
     * Internal Node Constructor
     * 
     * @param fly
     *            Node
     */
    public InternalNode(BinNode fly) {
        left = fly;
        right = fly;
    }


    /**
     * Gets the left reference
     * 
     * @return left reference
     */
    public BinNode left() {
        return left;
    }


    /**
     * Sets the left node
     * 
     * @param temp
     *            new Node
     * @return left node
     */
    public BinNode setLeft(BinNode temp) {
        left = temp;
        return left;
    }


    /**
     * Sets the right node
     * 
     * @param temp
     *            new Node
     * @return right node
     */
    public BinNode setRight(BinNode temp) {
        right = temp;
        return right;
    }


    /**
     * Gets the right reference
     * 
     * @return right reference
     */
    public BinNode right() {
        return right;
    }


    /**
     * Inserts InternalNode
     * 
     * @param sem
     *            for Seminar
     * @param flyNode
     *            for flyNode
     * @param x
     *            for x Coord
     * @param y
     *            for y Coord
     * @param xEnd
     *            for xEnd Coord representing end of world size
     * @param yEnd
     *            for yEnd Coord representing end of world size
     * @param level
     *            for level of tree
     * @return this representing the internal node being returned
     */
    public BinNode insert(
        Seminar sem,
        BinNode flyNode,
        int x,
        int y,
        int xEnd,
        int yEnd,
        int level) {
        int decision = level % 2;
        if (decision == 0) {
            int split = getSplit(decision, xEnd, x);
            if (sem.x() > split) {
                setRight(right.insert(sem, flyNode, split + 1, y, xEnd, yEnd,
                    level + 1));
                return this;
            }
            else {
                setLeft(left.insert(sem, flyNode, x, y, split, yEnd, level
                    + 1));
                return this;
            }
        }
        else {
            int split = getSplit(decision, yEnd, y);
            if (sem.y() > split) {
                setRight(right.insert(sem, flyNode, x, split + 1, xEnd, yEnd,
                    level + 1));
                return this;

            }
            else {
                setLeft(left.insert(sem, flyNode, x, y, xEnd, split, level
                    + 1));
                return this;
            }
        }
    }


    /**
     * Prints out the internal node and children
     * 
     * @param level
     *            for level of tree
     */
    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println("I");
        left.print(level + 1);
        right.print(level + 1);
    }


    /**
     * Deletes an InternalNode
     * 
     * @param sem
     *            for Seminar
     * @param fly
     *            for flyNode
     * @param x
     *            for x Coord
     * @param y
     *            for y Coord
     * @param xEnd
     *            for xEnd Coord representing end of world size
     * @param yEnd
     *            for yEnd Coord representing end of world size
     * @param level
     *            for level of tree
     * @return updated node representing the node being deleted
     */
    public BinNode delete(
        Seminar sem,
        int level,
        int x,
        int y,
        int xEnd,
        int yEnd,
        BinNode fly) {
        int decision = level % 2;
        if (decision == 0) {
            int split = getSplit(decision, xEnd, x);
            if (sem.x() > split) {
                setRight(right.delete(sem, level + 1, split + 1, y, xEnd, yEnd,
                    fly));
            }
            else {
                setLeft(left.delete(sem, level + 1, x, y, split, yEnd, fly));
            }
        }
        else {
            int split = getSplit(decision, yEnd, y);
            if (sem.y() > split) {
                setRight(right.delete(sem, level + 1, x, split + 1, xEnd, yEnd,
                    fly));
            }
            else {
                setLeft(left.delete(sem, level + 1, x, y, xEnd, split, fly));
            }
        }
        if (left == fly && right == fly) {
            return fly;
        }
        else if (left != fly && right == fly && left instanceof LeafNode) {
            return left;
        }
        else if (left == fly && right != fly && right instanceof LeafNode) {
            return right;
        }
        return this;
    }


    /**
     * Searches for nodes within a given area
     * 
     * @param searchX
     *            searching along X
     * @param searchY
     *            searching along Y
     * @param radius
     *            for radius of area
     * @param nodeX
     *            x coor
     * @param nodeY
     *            y coor
     * @param xEnd
     *            for end of world size along X
     * @param yEnd
     *            for end of world size along Y
     * @param level
     *            for level of tree
     * @param numNodes
     *            for num of nodes
     * @return number of nodes in searched region
     */
    public int search(
        int searchX,
        int searchY,
        int radius,
        int nodeX,
        int nodeY,
        int xEnd,
        int yEnd,
        int level,
        int numNodes) {
        int decision = level % 2;
        int boundaryX = searchX - radius;
        int boundaryY = searchY - radius;
        int w = 2 * radius + 1;
        if (decision == 0) {
            int split = getSplit(decision, xEnd, nodeX);
            if ((boundaryX <= split) && ((boundaryX + w) <= split + 1)) {
                return left.search(searchX, searchY, radius, nodeX, nodeY,
                    split, yEnd, level + 1, numNodes + 1);
            }
            else if ((boundaryX > split) && ((boundaryX + w) > split + 1)) {
                return right.search(searchX, searchY, radius, split + 1, nodeY,
                    xEnd, yEnd, level + 1, numNodes + 1);
            }
            else {
                int currNum = numNodes;
                currNum = left.search(searchX, searchY, radius, nodeX, nodeY,
                    split, yEnd, level + 1, currNum + 1);
                currNum = right.search(searchX, searchY, radius, split + 1,
                    nodeY, xEnd, yEnd, level + 1, currNum + 1);
                return currNum;
            }
        }
        else {
            int split = getSplit(decision, yEnd, nodeY);
            if ((boundaryY <= split) && ((boundaryY + w) <= split + 1)) {
                return left.search(searchX, searchY, radius, nodeX, nodeY, xEnd,
                    split, level + 1, numNodes + 1);
            }
            else if ((boundaryY > split) && ((boundaryY + w) > split + 1)) {
                return right.search(searchX, searchY, radius, nodeX, split + 1,
                    xEnd, yEnd, level + 1, numNodes + 1);
            }
            else {
                int currNum = numNodes;
                currNum = left.search(searchX, searchY, radius, nodeX, nodeY,
                    xEnd, split, level + 1, currNum + 1);
                currNum = right.search(searchX, searchY, radius, nodeX, split
                    + 1, xEnd, yEnd, level + 1, currNum + 1);
                return currNum;
            }
        }
    }


    /**
     * Helper function for split that will split the world based on coordinates
     * 
     * @param decision
     *            that decides to split based on x or y
     * @param end
     *            for end of region
     * @param coor
     *            for coor of seminar
     * @return the split line
     */
    public int getSplit(int decision, int end, int coor) {
        int split = 0;
        if ((end - coor) % 2 == 0) {
            split = coor + (((end - coor) / 2) - 1);

        }
        else {
            split = coor + ((end - coor) / 2);
        }
        return split;
    }
}

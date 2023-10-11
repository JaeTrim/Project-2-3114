/**
 * LeafNode class that implements BinNode Interface
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */
public class LeafNode implements BinNode {

    private DLList<Seminar> seminars;

    /**
     * LeafNode Constructor
     */
    public LeafNode() {
        seminars = new DLList<Seminar>();
    }


    /**
     * Checks if leaf is empty
     * 
     * @return true or false if empty
     */
    public boolean isEmpty() {
        if (seminars.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Returns list of seminars
     * 
     * @return semianrs is DLList of semianrs
     */
    public DLList<Seminar> value() {
        return seminars;
    }


    /**
     * Adds a seminar to DLList of Seminars
     * 
     * @param sem
     *            new seminar
     */
    public void setValue(Seminar sem) {
        seminars.add(sem);

    }


    /**
     * Sets the DLList to new DLlist of seminars
     * 
     * @param sems
     *            new DLList of seminars
     */
    public void setList(DLList<Seminar> sems) {
        seminars = sems;
    }


    /**
     * Inserts into LeafNode
     * 
     * @param sem
     *            for Seminar
     * @param flyNode
     *            for empty leaf flyNode
     * @param x
     *            is xCoord
     * @param y
     *            is yCoord
     * @param xEnd
     *            represents end of world size along X
     * @param yEnd
     *            represents end of world size along Y
     * @param level
     *            is the level of the true
     * @return leaf node or internal node based on what was inserted
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
        int newX = sem.x();
        int newY = sem.y();
        if (this == flyNode) {
            LeafNode leaf = new LeafNode();
            return leaf.insert(sem, flyNode, x, y, xEnd, yEnd, level);
        }
        else if (this.isEmpty()) {
            setValue(sem);
            return this;
        }
        else if (seminars.get(0).x() == newX && seminars.get(0).y() == newY) {
            seminars.add(sem);
            sortListAscending();
            return this;
        }
        else {
            if (decision == 0) {
                int split = getSplit(decision, xEnd, x);
                InternalNode internal = new InternalNode(flyNode);
                if (sameSideSplit(split, newX, seminars, 0)) {
                    for (int i = 0; i < seminars.size(); i++) {
                        internal.insert(seminars.get(i), flyNode, x, y, xEnd,
                            yEnd, level);
                    }
                    return internal.insert(sem, flyNode, x, y, xEnd, yEnd,
                        level);
                }
                else if (seminars.get(0).x() > newX) {
                    internal.setRight(this);
                    LeafNode leaf = new LeafNode();
                    leaf.setValue(sem);
                    internal.setLeft(leaf);
                    return internal;
                }
                else {
                    LeafNode leaf = new LeafNode();
                    leaf.setValue(sem);
                    internal.setRight(leaf);
                    internal.setLeft(this);
                    return internal;
                }
            }
            else {
                int split = getSplit(decision, yEnd, y);
                InternalNode internal = new InternalNode(flyNode);
                if (sameSideSplit(split, newY, seminars, 1)) {
                    for (int i = 0; i < seminars.size(); i++) {
                        internal.insert(seminars.get(i), flyNode, x, y, xEnd,
                            yEnd, level);
                    }
                    return internal.insert(sem, flyNode, x, y, xEnd, yEnd,
                        level);
                }
                else if (seminars.get(0).y() > newY) {
                    internal.setRight(this);
                    LeafNode curr = new LeafNode();
                    curr.setValue(sem);
                    internal.setLeft(curr);
                    return internal;
                }
                else {
                    LeafNode curr = new LeafNode();
                    curr.setValue(sem);
                    internal.setRight(curr);
                    internal.setLeft(this);
                    return internal;
                }
            }
        }

    }


    /**
     * Prints the tree with proper depth based on level
     * 
     * @param level
     *            for level of tree
     */
    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        if (seminars.size() >= 1) {
            System.out.print("Leaf with " + seminars.size() + " objects:");
            for (int j = 0; j < seminars.size(); j++) {
                System.out.print(" " + seminars.get(j).id());
            }
            System.out.println("");

        }
        else {
            System.out.println("E");
        }
    }


    /**
     * Deletes from LeafNode
     * 
     * @param sem
     *            for Seminar
     * @param fly
     *            for empty leaf flyNode
     * @param x
     *            is xCoord
     * @param y
     *            is yCoord
     * @param xEnd
     *            represents end of world size along X
     * @param yEnd
     *            represents end of world size along Y
     * @param level
     *            is the level of the true
     * @return node based on what was deleted
     */
    public BinNode delete(
        Seminar sem,
        int level,
        int x,
        int y,
        int xEnd,
        int yEnd,
        BinNode fly) {
        if (seminars.get(0).x() == sem.x() && seminars.get(0).y() == sem.y()) {
            for (int i = 0; i < seminars.size(); i++) {
                if (seminars.get(i).id() == sem.id()) {
                    seminars.remove(i);
                }
            }
        }
        if (seminars.size() == 0) {
            return fly;
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
        if (seminars.size() == 0) {
            return numNodes;
        }
        else {
            int pX = seminars.get(0).x() - searchX;
            int pY = seminars.get(0).y() - searchY;
            if (pX * pX + pY * pY <= (radius * radius)) {
                for (int i = 0; i < seminars.size(); i++) {
                    System.out.println("Found a record with key value "
                        + seminars.get(i).id() + " at " + seminars.get(i).x()
                        + ", " + seminars.get(i).y());
                }
            }
        }
        return numNodes;
    }


    /**
     * Sorts list of seminars in increasing order
     */
    public void sortListAscending() {
        for (int i = 0; i < seminars.size() - 1; i++) {
            for (int j = i + 1; j < seminars.size(); j++) {
                if (seminars.get(i).id() > seminars.get(j).id()) {
                    Seminar temp = seminars.get(j);
                    seminars.remove(j);
                    seminars.add(i, temp);
                }
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


    /**
     * Returns boolean based on what side of the split two seminars are on
     * 
     * @param split
     *            is split line
     * @param newCoor
     *            is new Seminar coor
     * @param sems
     *            is DLList of seminars
     * @param xOrY
     *            is 0 or 1 based on splitting along x or y
     * @return true or false if on same side of the split line for two seminars
     */
    public boolean sameSideSplit(
        int split,
        int newCoor,
        DLList<Seminar> sems,
        int xOrY) {
        if (xOrY == 0) {
            if (((newCoor > split) && (sems.get(0).x() > split))
                || ((newCoor <= split) && (sems.get(0).x() <= split))) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (((newCoor > split) && (sems.get(0).y() > split))
                || ((newCoor <= split) && (sems.get(0).y() <= split))) {
                return true;
            }
            else {
                return false;
            }
        }

    }

}

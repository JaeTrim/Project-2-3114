/**
 * 
 */

/**
 * BST Node Class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 * @param <E>
 */
public class BSTNode<E extends Comparable<? super E>> {

    private E elem;
    private BSTNode<E> left;
    private BSTNode<E> right;

    /**
     * BSTNode Constructor
     */
    public BSTNode() {
        left = null;
        right = null;
    }


    /**
     * BSTNode Constructor that includes the elem
     * @param val for value
     */
    public BSTNode(E val) {
        left = null;
        right = null;
        elem = val;
    }


    /**
     * BSTNode Constructor passes through parameters
     * 
     * @param val
     *            for value
     * @param l
     *            for left
     * @param r
     *            for right
     */
    public BSTNode(E val, BSTNode<E> l, BSTNode<E> r) {
        left = l;
        right = r;
        elem = val;
    }


    /**
     * Returns the value of the node
     * 
     * @return elem value
     */
    public E value() {
        return elem;
    }


    /**
     * Sets the value of the node
     * 
     * @param v
     *            for value
     */
    public void setValue(E v) {
        elem = v;
    }


    /**
     * Returns the node's left reference
     * 
     * @return left reference
     */
    public BSTNode<E> left() {
        return left;
    }


    /**
     * Sets the left reference
     * 
     * @param p
     *            new left
     */
    public void setLeft(BSTNode<E> p) {
        left = p;
    }


    /**
     * Returns the node's right reference
     * 
     * @return right reference
     */
    public BSTNode<E> right() {
        return right;
    }


    /**
     * Sets the right reference
     * 
     * @param p
     *            new right
     */
    public void setRight(BSTNode<E> p) {
        right = p;
    }
}

/**
 * 
 */

/**
 * 
 */
public class BSTNode<E extends Comparable<? super E>> {

    private E elem;
    private BSTNode<E> left;
    private BSTNode<E> right;

    public BSTNode() {
        left = right = null;
    }


    public BSTNode(E val) {
        left = right = null;
        elem = val;
    }


    public BSTNode(E val, BSTNode<E> l, BSTNode<E> r) {
        left = l;
        right = r;
        elem = val;
    }


    public E value() {
        return elem;
    }


    public void setValue(E v) {
        elem = v;
    }


    public BSTNode<E> left() {
        return left;
    }


    public void setLeft(BSTNode<E> p) {
        left = p;
    }


    public BSTNode<E> right() {
        return right;
    }


    public void setRight(BSTNode<E> p) {
        right = p;
    }


//    public boolean isLeaf() {
//        return (left == null) && (right == null);
//    }
}

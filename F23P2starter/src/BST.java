
/**
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-09-2023
 * @param <K>
 *            tag
 * @param <E>
 *            tag
 */
public class BST<K extends Comparable<K>, E> {

    private BSTNode<KVPair<K, E>> root;
    private int nodeCount;

    /**
     * BST Constructor
     */
    public BST() {
        root = null;
        nodeCount = 0;
    }


    /**
     * Returns the amount of nodes in the BST
     * 
     * @return nodeCount for amount of nodes
     */
    public int size() {
        return nodeCount;
    }


    /**
     * Returns the BST root
     * 
     * @return root of BST
     */
    public BSTNode<KVPair<K, E>> getRoot() {
        return root;
    }


    /**
     * Inserts node into Tree
     * 
     * @param node
     *            is new node
     */
    public void insert(KVPair<K, E> node) {
        root = insertHelp(root, node);
        nodeCount++;
    }


    private BSTNode<KVPair<K, E>> insertHelp(
        BSTNode<KVPair<K, E>> rt,
        KVPair<K, E> node) {
        if (rt == null) {
            return new BSTNode<KVPair<K, E>>(node);
        }
        if (rt.value().compareTo(node) >= 0) {
            rt.setLeft(insertHelp(rt.left(), node));
        }
        else {
            rt.setRight(insertHelp(rt.right(), node));
        }
        return rt;
    }


    /**
     * Searches node in given range
     * 
     * @param node
     *            used to search
     * @param low
     *            of range
     * @param high
     *            of range
     * @param output
     *            for formatting output
     * @return the output
     */
    public SearchResult rangeSearch(
        BSTNode<KVPair<K, E>> node,
        K low,
        K high,
        SearchResult output) {
        if (node == null) {
            return output;
        }
        if (node.value().key().compareTo(low) >= 0) {
            output.setNodesVisited(output.getNodesVisited() + 1);
            rangeSearch(node.left(), low, high, output);
        }
        if (low.compareTo(node.value().key()) <= 0 && high.compareTo(node
            .value().key()) >= 0) {
            output.setOutput(output.getOutput() + node.value().value()
                .toString() + "\n");

        }
        if (node.value().key().compareTo(high) < 0) {
            output.setNodesVisited(output.getNodesVisited() + 1);
            rangeSearch(node.right(), low, high, output);
        }
        return output;
    }


    /**
     * Finds the node given the KV Pair
     * 
     * @param key
     *            of pair
     * @param value
     *            of pair
     * @return the node if found
     */
    public BSTNode<KVPair<K, E>> findValue(K key, E value) {
        if (helpFindValue(getRoot(), key, value) != null) {
            return helpFindValue(getRoot(), key, value);
        }
        else {
            return null;
        }
    }


    private BSTNode<KVPair<K, E>> helpFindValue(
        BSTNode<KVPair<K, E>> node,
        K key,
        E value) {
        if (node == null) {
            return null;
        }

        K nodeKey = node.value().key();
        if (nodeKey.compareTo(key) == 0) {
            if (!node.value().value().equals(value)) {
                return helpFindValue(node.left(), key, value);
            }
            else {
                return node;
            }
        }
        else if (nodeKey.compareTo(key) > 0) {
            return helpFindValue(node.left(), key, value);
        }
        else {
            return helpFindValue(node.right(), key, value);
        }

    }


    /**
     * Removes a node from the tree
     * 
     * @param key
     *            from pair
     * @param value
     *            from pair
     * @return the KV Pair
     */
    public KVPair<K, E> remove(K key, E value) {
        KVPair<K, E> temp = findHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, key, value);
            nodeCount--;
        }
        return temp;
    }


    private BSTNode<KVPair<K, E>> removeHelp(
        BSTNode<KVPair<K, E>> rt,
        K key,
        E value) {
        if (rt == null) {
            return null;
        }
        if (rt.value().compareTo(key) > 0) {
            rt.setLeft(removeHelp(rt.left(), key, value));
        }
        else if (rt.value().compareTo(key) < 0) {
            rt.setRight(removeHelp(rt.right(), key, value));
        }
        else {
            if (rt.value().value() != value) {
                rt.setLeft(removeHelp(rt.left(), key, value));
            }
            else if (rt.left() == null) {
                return rt.right();
            }
            else if (rt.right() == null) {
                return rt.left();
            }
            else {
                BSTNode<KVPair<K, E>> temp = getmax(rt.left());
                rt.setValue(temp.value());
                rt.setLeft(deletemax(rt.left()));
            }
        }
        return rt;
    }


    /**
     * Find a KV Pair from a key
     * 
     * @param key
     *            from pair
     * @return KV Pair if found
     */
    public KVPair<K, E> find(K key) {
        return findHelp(root, key);
    }


    private KVPair<K, E> findHelp(BSTNode<KVPair<K, E>> rt, K key) {
        if (rt == null) {
            return null;
        }
        if (rt.value().compareTo(key) > 0) {
            return findHelp(rt.left(), key);
        }
        else if (rt.value().compareTo(key) == 0) {
            return rt.value();
        }
        else {
            return findHelp(rt.right(), key);
        }
    }


    private BSTNode<KVPair<K, E>> getmax(BSTNode<KVPair<K, E>> rt) {
        if (rt.right() == null)
            return rt;
        return getmax(rt.right());
    }


    private BSTNode<KVPair<K, E>> deletemax(BSTNode<KVPair<K, E>> rt) {
        if (rt.right() == null) {
            return rt.left();
        }
        rt.setRight(deletemax(rt.right()));
        return rt;
    }


    /**
     * Prints tree
     */
    public void print() {
        printTree(root, 0);
    }


    private void printTree(BSTNode<KVPair<K, E>> bstNode, int lev) {
        if (bstNode == null) {
            for (int i = 0; i < lev; i++) {
                System.out.print("  ");
            }
            System.out.println("null");
            return;
        }
        printTree(bstNode.right(), lev + 1);
        for (int i = 0; i < lev; i++) {
            System.out.print("  ");
        }
        System.out.print(bstNode.value().key() + "\n");
        printTree(bstNode.left(), lev + 1);
    }
}

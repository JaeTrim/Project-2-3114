
/**
 * BinTree Class
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


    public void insert(KVPair<K, E> node) {
        root = insertHelp(root, node);
        nodeCount++;
    }


    public BSTNode<KVPair<K, E>> getRoot() {
        return root;
    }


    public SearchResult rangeSearch(BSTNode<KVPair<K, E>> node, K low, K high, SearchResult output) {
        if (node == null) {
            return output;
        }
        if (node.value().key().compareTo(low) >= 0)
        {
            output.setNodesVisited(output.getNodesVisited() + 1);
            rangeSearch(node.left(), low, high, output);
        }
        if (low.compareTo(node.value().key()) <= 0 && high.compareTo(node
            .value().key()) >= 0) {
            output.setOutput(output.getOutput() + node.value().value().toString() + "\n");
            
        }
        if (node.value().key().compareTo(high) < 0)
        {
            output.setNodesVisited(output.getNodesVisited() + 1);
            rangeSearch(node.right(), low, high, output);
        }
        return output;
    }


    public BSTNode<KVPair<K, E>> findValue(K key, E value) {
        if (helpFindValue(getRoot(), key, value) != null) {
            return helpFindValue(getRoot(), key, value);
        }
        else {
            return null;
        }
    }


    private BSTNode<KVPair<K, E>> helpFindValue(BSTNode<KVPair<K, E>> root, K key, E value) {
        if (root == null) {
            return null;
        }
        
        K nodeKey = root.value().key();
        if (nodeKey.compareTo(key) == 0) {
            if (!root.value().value().equals(value))
            {
                return helpFindValue(root.left(), key, value);
            }
            else
            {
                return root;
            }
        }
        else if (nodeKey.compareTo(key) > 0) {
            return helpFindValue(root.left(), key, value);
        }
        else {
            return helpFindValue(root.right(), key, value);
        }

    }


    public KVPair<K, E> remove(K key, E value) {
        KVPair<K, E> temp = findHelp(root, key);
        if (temp != null) {
            root = removeHelp(root, key, value);
            nodeCount--;
        }
        return temp;
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


    private BSTNode<KVPair<K, E>> insertHelp (
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


    private BSTNode<KVPair<K, E>> removeHelp(BSTNode<KVPair<K, E>> rt, K key, E value) {
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
            if (rt.value().value() != value)
            {
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


    public KVPair<K, E> find(K key) {
        return findHelp(root, key);
    }


    public int size() {
        return nodeCount;
    }


    public void print() {
        printTree(root);
    }


    private void printTree(BSTNode<KVPair<K, E>> bstNode) {
        int count = 0;
        if (bstNode == null) {
            if (count > 0) {
                System.out.println("null");
                count++;
            }
            System.out.println("null");
            return;
        }
        printTree(bstNode.right());
        System.out.println(bstNode.value().key());
        printTree(bstNode.left());
    }
}

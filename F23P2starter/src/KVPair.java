/**
 * KV Pair Class
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 * 
 * @param <K>
 *            tag
 * @param <E>
 *            tag
 */
public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {
    
    private K theKey;
    private E theVal;

    /**
     * KV Pair Constructor
     * 
     * @param k
     *            key
     * @param v
     *            value
     */
    KVPair(K k, E v) {
        theKey = k;
        theVal = v;
    }


    /**
     * Compares current key to new key
     * 
     * @param it
     *            new KV Pair
     * @return integer representing relative size
     */
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    /**
     * Compares current key to new key with key directly passed through
     * 
     * @param it
     *            new key
     * @return integer representing relative size
     */
    public int compareTo(K it) {
        return theKey.compareTo(it);
    }


    /**
     * Returns the key
     * 
     * @return theKey is key
     */
    public K key() {
        return theKey;
    }


    /**
     * Returns the value
     * 
     * @return theVal for value
     */
    public E value() {
        return theVal;
    }


    /**
     * Returns KV Pair in string form
     * 
     * @return s for string
     */
    public String toString() {
        String s = "(";
        if (theKey != null) {
            s += theKey.toString();
        }
        else {
            s += "null";
        }
        s += ", ";
        if (theVal != null) {
            s += theVal.toString();
        }
        else {
            s += "null";
        }
        s += ")";
        return s;
    }
}

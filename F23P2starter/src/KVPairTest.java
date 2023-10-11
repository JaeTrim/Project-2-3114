
import student.TestCase;

/**
 * KVPair Test
 * 
 * @author Jae Trimboli (jaetrim)
 * @author Mohammad Mian (mohammadm21)
 * @version 10-10-2023
 */

public class KVPairTest extends TestCase {
    private KVPair<String, String> pair;

    /**
     * setUp Constructor
     */
    public void setUp() {
        pair = new KVPair<>("10", "Test");
    }


    /**
     * Test Key
     */
    public void testKey() {
        assertEquals("10", pair.key());

    }


    /**
     * Test Val
     */
    public void testValue() {
        assertEquals("Test", pair.value());
    }


    /**
     * Test ToString
     */
    public void testToString() {
        KVPair<Integer, String> pair2 = new KVPair<>(null, "Test");
        assertEquals("(10, Test)", pair.toString());
        assertEquals("(null, Test)", pair2.toString());
        KVPair<String, String> pair3 = new KVPair<>("Test", null);
        assertEquals("(Test, null)", pair3.toString());

    }


    /**
     * Test Compare
     */
    public void testCompareToKVPair() {
        KVPair<Integer, String> pair1 = new KVPair<>(40, "Test");
        KVPair<Integer, String> otherKVPair = new KVPair<>(25, "Test1");
        assertTrue(pair1.compareTo(otherKVPair) > 0);
        assertTrue(otherKVPair.compareTo(pair1) < 0);

        KVPair<Integer, String> sameKeyKVPair = new KVPair<>(40, "Test2");
        assertEquals(0, pair1.compareTo(sameKeyKVPair));
    }


    /**
     * Test Compare
     */
    public void testCompareToKey() {
        KVPair<Integer, String> pair1 = new KVPair<>(40, "Test");
        Integer key = 25;
        assertTrue(pair1.compareTo(key) > 0);

        Integer sameKey = 40;
        assertEquals(0, pair1.compareTo(sameKey));

        Integer greaterKey = 50;
        assertTrue(pair1.compareTo(greaterKey) < 0);
    }
}

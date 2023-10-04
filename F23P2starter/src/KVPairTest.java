
import student.TestCase;

public class KVPairTest extends TestCase {
    private KVPair<String, String> pair;

    public void setUp() {
        pair = new KVPair<>("10", "Test");
    }


    public void testKey() {
        assertEquals("10", pair.key());
        
    }
    
    public void testValue() {
        assertEquals("Test", pair.value());
    }
    
    public void testToString() {
        assertEquals("(10, Test)", pair.toString());
    }
    
    public void testCompareToKVPair() {
        KVPair<Integer, String> pair = new KVPair<>(40, "Test");
        KVPair<Integer, String> otherKVPair = new KVPair<>(25, "Test1");
        assertTrue(pair.compareTo(otherKVPair) > 0);
        assertTrue(otherKVPair.compareTo(pair) < 0);

        KVPair<Integer, String> sameKeyKVPair = new KVPair<>(40, "Test2");
        assertEquals(0, pair.compareTo(sameKeyKVPair));
    }
    
    public void testCompareToKey() {
        KVPair<Integer, String> pair = new KVPair<>(40, "Test");
        Integer key = 25;
        assertTrue(pair.compareTo(key) > 0);

        Integer sameKey = 40;
        assertEquals(0, pair.compareTo(sameKey));

        Integer greaterKey = 50;
        assertTrue(pair.compareTo(greaterKey) < 0);
    }
}

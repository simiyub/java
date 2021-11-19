import junit.framework.TestCase;

public class UniqueTest extends TestCase {

    public void testIsUnique() {

            Unique unique = new UniqueImpl();
            assertTrue(unique.isUnique("HSBC"));
            assertFalse(unique.isUnique("Hello"));
        assertFalse(unique.isUnique("1He1"));
    }
}
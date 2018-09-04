package org.marasm.hotstart;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CacheTest {
    private Cache cache = new Cache(CacheTest.class);

    @Test
    public void test() {
        String defaultTestValue = "defaultTestValue";
        String val1 = cache.get("test", defaultTestValue);
        String val2 = cache.get("test", defaultTestValue);
        assertEquals(val1, val2);
        assertEquals(val1, defaultTestValue);
    }
}
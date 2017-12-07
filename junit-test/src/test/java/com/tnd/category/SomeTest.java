package com.tnd.category;

import static junit.framework.TestCase.fail;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SomeTest {

    @Test
    public void a() {
        fail();
    }

    @Category(CrazyTests.class)
    @Test
    public void b() {
    }

}

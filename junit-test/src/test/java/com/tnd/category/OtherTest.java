package com.tnd.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({ CrazyTests.class, SmartTests.class})
public class OtherTest {
    @Test
    public void c() {
    }
}

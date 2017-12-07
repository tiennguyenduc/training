package com.tnd;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.junit.runners.model.TestTimedOutException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BasicTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("***Before Class is invoked");
    }

    @Before
    public void before(){
        System.out.println("____________________");
        System.out.println("\t Before is invoked");
    }

    @After
    public void after(){
        System.out.println("\t After is invoked");
        System.out.println("____________________");
    }

    @Test
    public void assertTrueAndFalseTest() throws Exception {
        Assert.assertTrue(true);
        Assert.assertFalse(false);
    }

    @Test
    public void assertNullAndNotNullTest() throws Exception {
        Object myObject = null;
        Assert.assertNull(myObject);

        myObject = new String("Some value");
        Assert.assertNotNull(myObject);
    }

    @Test
    public void assertEqualsAndNotEquals() throws Exception {
        Integer i = new Integer("5");
        Integer j = new Integer("5");;
        Assert.assertEquals(i,j);

        Assert.assertNotEquals(5,3);

    }

    @Test
    public void assertSameAndNotSame() throws Exception {
        Integer i = new Integer("5");
        Integer j = new Integer("5");;
        Assert.assertNotSame(i,j);

        i = j;
        Assert.assertSame(i,j);

    }

    @Test(expected=RuntimeException.class)
    public void exception() {
        throw new RuntimeException();
    }

    @Test
    @Ignore("Ignore for test")
    public void ignore() {

    }

    boolean isSonarRunning = false;
    @Test
    public void very_critical_test() throws Exception {
        isSonarRunning = false;
        Assume.assumeFalse(isSonarRunning);
        Assert.assertTrue(true);
    }

    @Test(timeout=10)
    public void forEver() throws Exception {
        Thread.sleep(100000);
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("***After Class is invoked");
    }

}

package com.tnd.rule;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeOutRuleTest {

    /** global time out **/
    @Rule
    public Timeout globalTimeout =  new Timeout(20, TimeUnit.MILLISECONDS);

    @Test
    public void testInfiniteLoop1() throws InterruptedException{
        Thread.sleep(30);
    }
    /** -- END -- **/

}

package com.tnd.rule;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class ErrorCollectorRuleTest {

    /** allows the execution of a test to continue after the  rst problem is found **/
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Test
    public void fails_after_execution() {
        collector.checkThat("a", equalTo("b"));
        collector.checkThat(1, equalTo(2));
        collector.checkThat("ae", equalTo("g"));
    }
    /** -- END -- **/

}

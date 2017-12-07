package com.tnd.rule;

import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Verifier;

public class VerifyRuleTest {

    /** otherwise turn passing tests into failing tests if a veri cation check fails **/
    private String errorMsg = null;

    @Rule
    public TestRule rule = new Verifier() {
        protected void verify() {
            assertNull("ErrorMsg should be null after each test execution", errorMsg);
        }
    };

    @Test
    public void testName() throws Exception {
        errorMsg = "Giving a value";
    }
    /** -- END -- **/

}

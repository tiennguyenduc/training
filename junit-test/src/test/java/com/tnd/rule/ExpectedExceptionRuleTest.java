package com.tnd.rule;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.Timeout;
import org.junit.rules.Verifier;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExpectedExceptionRuleTest {

    /** global expected exception **/
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void throwsNothing() {
    }

    @Test
    public void throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        throw new NullPointerException();
    }
    @Test
    public void throwsIllegalStateExceptionWithMessage() {
        thrown.expect(IllegalStateException.class);
        thrown.expectMessage("Is this a legal state?");
        throw new IllegalStateException("Is this a legal state?");
    }
    /** -- END -- **/

}

package com.tnd;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.spy;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockPrivateMethodExample.class)
public class PowerMockTest {

    private MockPrivateMethodExample mockPrivateMethodExample;

    // This is the name of the private method which we want to mock
    private static final String METHOD = "iAmPrivate";

    @Test
    public void testPrivateMethod() throws Exception {
        mockPrivateMethodExample = new MockPrivateMethodExample();

        System.out.println(mockPrivateMethodExample.getDetails());

        MockPrivateMethodExample spy = spy(mockPrivateMethodExample);
        PowerMockito.doReturn("Test").when(spy, METHOD);
        String value = spy.getDetails();

        System.out.println(value);

        Assert.assertEquals(value, "Mock private method example: Test");
        PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke(METHOD);
    }

}

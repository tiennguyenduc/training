package com.tnd.mokito;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tnd.mokito.POJO.DefaultTestMatcher;
import com.tnd.mokito.POJO.TestDAO;
import com.tnd.mokito.POJO.TestService;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentMatcherTest {

    @InjectMocks
    private TestService testService = new TestService();

    @Mock
    private TestDAO testDAO;

    @Test
    public void argumentMatcher() {
        com.tnd.mokito.POJO.Test entry = new com.tnd.mokito.POJO.Test();
        entry.setKey("D");
        entry.setValue("Default");

        when(testDAO.insert(argThat(new DefaultTestMatcher()))).thenReturn(false);

        Assert.assertFalse(testDAO.insert(entry));
    }

}

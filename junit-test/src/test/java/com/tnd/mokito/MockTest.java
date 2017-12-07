package com.tnd.mokito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import com.tnd.mokito.POJO.TestDAO;
import com.tnd.mokito.POJO.TestService;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @InjectMocks
    private TestService testService = new TestService();

    @Mock
    private TestDAO testDAO;

    /** when @RunWith(MockitoJUnitRunner.class) isn't added **/
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void sanity() throws Exception {
        assertNotNull(testService);
        assertNotNull(testDAO);
    }

}

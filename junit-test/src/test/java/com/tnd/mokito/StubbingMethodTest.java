package com.tnd.mokito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import com.tnd.mokito.POJO.TestDAOImpl;
import com.tnd.mokito.POJO.TestService;

@RunWith(MockitoJUnitRunner.class)
public class StubbingMethodTest {

    @InjectMocks
    private TestService testService = new TestService();

    @Mock
    private TestDAOImpl testDAO;

    /** thenReturn **/
    @Test
    public void insertOrUpdateCallInsertMethod() {

        String key = "A";
        String value = "Apple";

        when(testDAO.get(key)).thenReturn(null);
        testService.insertOrUpdate(key, value);

        verify(testDAO).insert(key, value);
        verify(testDAO, never()).update(key, value);

    }

    @Test
    public void insertOrUpdateCallUpdateMethod() {

        String key = "A";
        String value = "Apple";

        when(testDAO.get(key)).thenReturn("App");
        testService.insertOrUpdate(key, value);

        verify(testDAO, never()).insert(key, value);
        verify(testDAO).update(key, value);

    }

    @Test
    public void thenCallRealMethodTest() {

        String defaultKey = "D";
        String defaultValue = "Default";

        Assert.assertNull(testDAO.get(defaultKey));

        when(testDAO.get(anyString())).thenCallRealMethod();

        Assert.assertEquals(defaultValue, testDAO.get(defaultKey));

    }

    @Test(expected = NullPointerException.class)
    public void thenThrowTest() {

        when(testDAO.get(anyString())).thenThrow(NullPointerException.class);

        testDAO.get("anyString");

    }

    @Test
    public void thenAnswerTest() {

        String defaultValue = "Default";

        when(testDAO.get(anyString())).thenAnswer(new Answer<String>() {
            public String answer(InvocationOnMock invocation) throws Throwable {
                return "Default";
            }
        });

        Assert.assertEquals(defaultValue, testDAO.get("anyString"));

    }

    @Test(expected = NullPointerException.class)
    public void doThrowWithVoidMethodTest() {

        testDAO.delete("D");

        doThrow(NullPointerException.class).when(testDAO).delete(anyString());

        testDAO.delete("D");

    }

    @Test
    public void subbingVoidMethodTest() {

        doNothing().when(testDAO).delete(anyString());

        testDAO.delete("D");

        doAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("doAnswer ");

                return null;
            }
        }).when(testDAO).delete(anyString());

        testDAO.delete("D");

    }

    @Test
    public void consecutiveCallsTest() {

        when(testDAO.get(anyString())).thenReturn("A", "B", "C");

        Assert.assertEquals("A", testDAO.get("A"));
        Assert.assertEquals("B", testDAO.get("A"));
        Assert.assertEquals("C", testDAO.get("A"));
        Assert.assertEquals("C", testDAO.get("A"));

    }

    @Test
    public void spying() {

        com.tnd.mokito.POJO.Test realObject = new com.tnd.mokito.POJO.Test("D", "Default");

        com.tnd.mokito.POJO.Test spyObject = spy(realObject);

        Assert.assertEquals("D", spyObject.getKey());

        spyObject.setValue("Modified");
        Assert.assertEquals("Modified", spyObject.getValue());

        when(spyObject.getValue()).thenReturn("Stubbed");

        spyObject.setValue("Modified");
        Assert.assertNotEquals("Modified", spyObject.getValue());
        Assert.assertEquals("Stubbed", spyObject.getValue());
    }

    @Test
    public void argumentCaptorTest() throws Exception {

        when(testDAO.get(anyString())).thenReturn("A");

        testDAO.get("D");

        ArgumentCaptor<String> stringCaptor = ArgumentCaptor.forClass(String.class);

        verify(testDAO).get(stringCaptor.capture());

        Assert.assertEquals("D", stringCaptor.getValue());

    }

    @Test
    public void inOrderTest() throws Exception {

        testDAO.get("D");
        testDAO.delete("D");

        InOrder inOrder=inOrder(testDAO);
        inOrder.verify(testDAO).get(anyString());
        inOrder.verify(testDAO).delete(anyString());

    }

    @Test
    public void BDDTest() {

        given(testDAO.get(eq("?"))).willReturn("!");

        Assert.assertEquals("!", testDAO.get("?"));

    }

}

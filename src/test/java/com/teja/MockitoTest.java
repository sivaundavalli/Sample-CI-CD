/*package com.saran;

import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;

public class MockitoTest  {

    @Mock
    MyDatabase databaseMock; 

   / @Rule public MockitoRule mockitoRule = MockitoJUnit.rule(); 

    @Test
    public void testQuery()  {
        ClassToTest t  = new ClassToTest(databaseMock); 
        boolean check = t.query("* from t"); 
        assertTrue(check); 
        verify(databaseMock).query("* from t"); 
    }
}*/
package com.teja;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WhenThen {

	@Test
	public void test1()  {
	        //  create mock
	        Calculate test = mock(Calculate.class);

	        // define return value for method  add method
	        when(test.add(20,23)).thenReturn(43);

	        // use mock in test....
	        assertEquals(test.add(20,23), 43);
	}
	@Test
	public void testMoreThanOneReturnValue()  {
	        Iterator<String> i= mock(Iterator.class);
	        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
	        String result= i.next()+" "+i.next();
	        //assert
	        assertEquals("Mockito rocks", result);
	}
	@Test
	public void testReturnValueDependentOnMethodParameter()  {
	        Comparable<String> c= mock(Comparable.class);
	        when(c.compareTo("Mockito")).thenReturn(1);
	        when(c.compareTo("Eclipse")).thenReturn(2);
	        //assert
	        assertEquals(1, c.compareTo("Mockito"));
	}
	@Test
	public void testReturnValueInDependentOnMethodParameter()  {
	        Comparable<Integer> c= mock(Comparable.class);
	        when(c.compareTo(anyInt())).thenReturn(-1);
	        //assert
	        assertEquals(-1, c.compareTo(9));
	}
	@Test
	public void testLinkedListSpyWrong() {
	    // Lets mock a LinkedList
	    List<String> list = new LinkedList<>();
	    list.add("tejaswi");
	    List<String> spy = spy(list);
//	    System.out.println(spy.get(0)+" "+list.get(0));
	    // this does not work
	    // real method is called so spy.get(0)
	    // throws IndexOutOfBoundsException (list is still empty)
	    when(spy.get(0)).thenReturn("foo");
//System.out.println(spy.get(0)+" "+list.get(0));
	    assertEquals("foo", spy.get(0));
	}

	@Test
	public void testLinkedListSpyCorrect() {
	    // Lets mock a LinkedList
	    List<String> list = new LinkedList<>();
	    List<String> spy = spy(list);
	    
	    // You have to use doReturn() for stubbing
	    doReturn("foo").when(spy).get(0);
	     
	    assertEquals("foo", spy.get(0));
	}
	@Test
	public void testVerify()  {
	    // create and configure mock
	   Calculate test = Mockito.mock(Calculate.class);
	    when(test.add(15,18)).thenReturn(33);


	    // call method testing on the mock with parameter 12
	     
	   // test.someMethod("called at least twice");
	   // test.someMethod("called at least twice");
	    test.someOtherMethod("abc");
	  /*  verify(test, never()).someMethod("never called");
	    verify(test, atLeastOnce()).someOtherMethod("abc");
	   verify(test, atLeast(2)).someMethod("called at least twice");
	   verify(test, times(5)).someMethod("called five times");*/
	    verify(test, atMost(3)).someMethod("called at most 3 times");
	}
}

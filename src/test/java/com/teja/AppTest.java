package com.teja;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 

    
{
	Calculate c1;
	@BeforeClass
	public static void b4class() throws Exception {
		System.out.println("App Test calling b4class");
	}
	@AfterClass
	public static void afterclass() throws Exception {
		System.out.println("App Test calling after class");
	}
	 
	 
	@Before
	public void setUp() throws Exception {
		System.out.println("App Test calling init");
	}
	
	@Test
	public void methodTest(){
		  c1=new Calculate();
		int x=c1.add(12,34);
		assertEquals(46,x);
		System.out.println("App Test calling business logic"+x);
		
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("App Test calling destroy");
	}
    
    
}

package com.teja;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathCalcTest {
	MathCalc matchCacl;
	@BeforeClass
	public static void b4class() throws Exception {
		System.out.println("calling b4class");
	}
	@AfterClass
	public static void afterclass() throws Exception {
		System.out.println("calling after class");
	}
	 
	@Before
	public void setUp() throws Exception {
		matchCacl=new MathCalc();
		 
		System.out.println("Math calling init");
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("Math calling destroy");
	}
	
	@Test
	public void testAdd(){
		matchCacl=new MathCalc();
		int result=10+10-5-5;
		assertEquals(result,matchCacl.sum(10));
		System.out.println("Math Business Logic"+result);
	}
				
		
	
    

}

package com.template.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDome5 {
	
	@Before
	public void printBefore() {
		System.out.println("testPrint() ִ��֮ǰ");
	}
	
	@After
	public void printAfter() {
		System.out.println("testPrint() ִ��֮��");
	}
	
	@Test
	public void testPrint() {
		
		System.out.println("����һ����Ԫ����~~~~~");
	}
	
	@Test
	public void testPrint2() {
		
		System.out.println("����һ����Ԫ����2~~~~~");
	}

}

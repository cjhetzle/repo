package edu.ncsu.csc316.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.util.LinkedStack;

/**
 * tests the LinkedStack class
 * @author Team 7
 * @version 1.8
 */
public class LinkedStackTest {

	/**
	 * tests the push method
	 */
	@Test
	public void testPush() {
		LinkedStack<String> stack = new LinkedStack<String>();
		assertTrue(stack.isEmpty());
		try {
			assertNull(stack.peek());
			fail();
		} catch (Exception e) {
			//passed
		}
		try {
			assertNull(stack.pop());
			fail();
		} catch (Exception e) {
			//passed
		}
		stack.push("cameron");
		assertFalse(stack.isEmpty());
		assertEquals(stack.peek(), "cameron");
		stack.push("String1");
		assertEquals(stack.peek(), "String1");
	}
	
	/**
	 * tests the pop method
	 */
	@Test
	public void testPop() {
		LinkedStack<String> stack = new LinkedStack<String>();
		assertTrue(stack.isEmpty());
		try {
			assertNull(stack.peek());
			fail();
		} catch (Exception e) {
			//passed
		}
		try {
			assertNull(stack.pop());
			fail();
		} catch (Exception e) {
			//passed
		}
		stack.push("String1");
		assertFalse(stack.isEmpty());
		assertEquals("String1", stack.pop());
		assertTrue(stack.isEmpty());
		stack.push("String2");
		stack.push("String3");
		stack.push("String4");
		assertEquals("String4", stack.pop());
		stack.push("String5");
		assertEquals("String5", stack.pop());
		assertEquals("String3", stack.peek());
		assertEquals("String3", stack.pop());
		assertEquals("String2", stack.pop());
		assertTrue(stack.isEmpty());
	}

}

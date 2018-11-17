package edu.ncsu.csc316.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.util.ArrayQueue;

/**
 * tests the ArrayQueue class
 * @author Team 7
 * @version 1.8
 */
public class ArrayQueueTest {

	/**
	 * tests the ArrayQueue enqueue, dequeue, and isEmpty methods
	 */
	@Test
	public void testArrayQueue() {
		ArrayQueue<String> queue = new ArrayQueue<String>();
		assertTrue(queue.isEmpty());
		queue.enqueue("cameron");
		assertFalse(queue.isEmpty());
		assertEquals("cameron", queue.dequeue());
		assertTrue(queue.isEmpty());
		queue.enqueue("String1");
		queue.enqueue("String2");
		assertFalse(queue.isEmpty());
		queue.enqueue("String3");
		queue.enqueue("String4");
		assertEquals("String1", queue.dequeue());
		assertEquals("String2", queue.dequeue());
		queue.enqueue("String5");
		queue.enqueue("String6");
		assertEquals("String3", queue.dequeue());
		assertEquals("String4", queue.dequeue());
		queue.enqueue("String7");
		queue.dequeue();
		queue.dequeue();
		assertEquals("String7", queue.dequeue());
		assertTrue(queue.isEmpty());
		
	}
	

}

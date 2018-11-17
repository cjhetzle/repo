package edu.ncsu.csc316.util;

/**
 * contains all behavior Queues are capable of
 * @author Team 7
 * @version 1.8
 * @param <E> the type of object contained within the Queue
 */
public interface Queue<E> {
	
	/**
	 * adds an element to the end of the queue
	 * @param element the element to be added to the queue
	 */
	public void enqueue(E element);
	
	/**
	 * removes the object from the front of the queue
	 * @return the object removed from the queue
	 */
	public E dequeue();
	
	/**
	 * tells whether or not the queue is empty
	 * @return true if the queue is empty, false if not
	 */
	public boolean isEmpty();
}

package edu.ncsu.csc316.util;

import java.util.NoSuchElementException;

/**
 * Maintains a Queue as a LinkedList
 * @author Team 7
 * @version 1.8
 * @param <E> the type of object contained in the Queue
 */
public class LinkedQueue<E> implements Queue<E> {
	
	/** the LinkedList the queue is based off of */
	private LinkedList<E> list;
	
	/**
	 * creates a new, empty queue
	 */
	public LinkedQueue() {
		list = new LinkedList<E>();
	}

	/**
	 * adds an element to the end of the queue
	 * @param element the element to be added to the queue
	 */
	@Override
	public void enqueue(E element) {
		list.add(list.size(), element);
	}

	/**
	 * removes the object from the front of the queue
	 * @return the object removed from the queue
	 */
	@Override
	public E dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		else if (list.size() > 0) {
			E obj = list.get(0);
			list.remove(0);
			return obj;
		}
		return null;
	}

	/**
	 * tells whether or not the queue is empty
	 * @return true if the queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (list.size() == 0)
			return true;
		return false;
	}
}

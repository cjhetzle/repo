package edu.ncsu.csc316.util;

/**
 * Contains all behavior Stacks are capable of
 * @author Team 7
 * @version 1.8
 * @param <E> the type of object contained within the stack
 */
public interface Stack<E> {
	
	/**
	 * adds an element to the top of the stack
	 * @param element the element to be added to the stack
	 */
	public void push(E element);
	
	/**
	 * removes an element from the top of the stack
	 * @return the element removed from the stack
	 */
	public E pop();
	
	/**
	 * returns the element at the top of the stack without removing it
	 * @return the element at the top of the stack
	 */
	public E peek();
	
	/**
	 * tells whether or not the stack is empty
	 * @return true if the stack is empty, false if not
	 */
	public boolean isEmpty();
}

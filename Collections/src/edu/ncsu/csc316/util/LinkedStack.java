package edu.ncsu.csc316.util;

import java.util.EmptyStackException;

/**
 * implements a stack as a LinkedList
 * @author Team 7
 * @version 1.8
 * @param <E> the type of object contained within the ArrayStack
 */
public class LinkedStack<E> implements Stack<E> {
	
	/** the LinkedList the stack is based off of */
	private LinkedList<E> linkedList;
	
	/**
	 * creates a new, empty stack
	 */
	public LinkedStack() {
		linkedList = new LinkedList<E>();
	}
	
	/**
	 * adds an element to the top of the stack
	 * @param element the element to be added to the stack
	 */
	public void push(E element) {
		linkedList.add(element);
	}
	
	/**
	 * removes an element from the top of the stack
	 * @return the element removed from the stack
	 */
	public E pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else if (linkedList.size() > 0)
		{
			E obj = linkedList.get(linkedList.size() - 1);
			linkedList.remove(linkedList.size() - 1);
			return obj;
		}
		return null;
	}
	
	/**
	 * returns the element at the top of the stack without removing it
	 * @return the element at the top of the stack
	 */
	public E peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else if (linkedList.size() > 0) {
			return linkedList.get(linkedList.size() - 1);
		}
		return null;
	}
	
	/**
	 * tells whether or not the stack is empty
	 * @return true if the stack is empty, false if not
	 */
	public boolean isEmpty() {
		if (linkedList.size() == 0)
			return true;
		return false;
	}
}

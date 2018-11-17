package edu.ncsu.csc316.util;

import java.util.AbstractList;

/**
 * Maintains a LinkedListAL of generic E objects
 * @author Team 7
 * @version 1.8
 * @param <E> the type of object contained within the list
 */
public class LinkedListAL<E> extends AbstractList<E> {
	
	/** Node at the front of the list */
	private Node<E> front;
	
	/** size of the list */
	private int size;

	/**
	 * constructs a new empty LinkedListAL
	 */
	public LinkedListAL() {
		front = null;
		size = 0;
	}

	/**
	 * sets the item at the given index to the given element
	 * @param index where the element is to be set
	 * @param element that is to be inserted into the list
	 * @throws IndexOutOfBoundsException if index is out of bounds
	 * @throws NullPointerException if element parameter is null
	 * @return ret the item that was replaced and is no longer in the list
	 */
	@Override
	public E set(int index, E element) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(element == null) {
			throw new NullPointerException();
		}
		Node<E> temp = front;
		for(int i = 0; i <= index; i++) {
			temp = temp.next;
		}
		E ret = temp.data;
		temp.data = element;
		return ret;
	}

	/**
	 * adds a given element at a given index
	 * @param index the index where the element should be added
	 * @param element the element to be added to the list
	 * @throws IndexOutOfBoundsException if index is out of bounds
	 * @throws NullPointerException if element is null
	 */
	@Override
	public void add(int index, E element) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if(element == null) {
			throw new NullPointerException();
		}
		if(index == 0 && size == 0) {
			front = new Node<E>(element);
		}
		else if(index == 0) {
			front = new Node<E>(element, front.next);
		}
		Node<E> temp = front;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		temp.next = new Node<E>(element, temp.next);
		size++;
	}

	/**
	 * removes the item from the list at the given index
	 * @param index of the item to be removed
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 */
	@Override
	public E remove(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp = front;
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		Node<E> ret = temp.next;
		temp.next = temp.next.next;
		size--;
		return ret.data;
	}

	/**
	 * gets the element at the given index
	 * @return the element at the given index
	 */
	@Override
	public E get(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<E> temp = front;
		if(index < size && index >= 0) {
			for(int i = 0; i <= index; i++) {
				temp = temp.next;
				}
			return temp.data;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}
	
	/**
	 * An individual data node with a connection to the next node in the list
	 * for use in LinkedListAL
	 * @author Team 7
	 * @version 1.8
	 * @param <E> type of object contained within the node
	 */
	@SuppressWarnings("hiding")
	private class Node<E> {
		
		/** data contained within the node */
		private E data;
		
		/** next node in the list */
		private Node<E> next;
		
		/**
		 * Creates a node with the given data null next node
		 * @param data contained within the new node
		 */
		private Node(E data) {
			this.data = data;
			this.next = null;
		}
		
		/**
		 * creates a node with the given data and next node
		 * @param data contained within the node
		 * @param next node associated with this node
		 */
		private Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
		
		
	}

}

package edu.ncsu.csc316.util;

/**
 * Implements a LinkedList recursively
 * @author Team 7
 * @version 1.8
 * @param <E> the type of data contained within each Node
 */
public class LinkedListRecursive<E> {

	/** first item in the list*/
	private ListNode front;
	
	/** size of the list */
	private int size;
	
	/**
	 * constructs a new, empty list
	 */
	public LinkedListRecursive() {
		front = null;
		size = 0;
	}

	/**
	 * adds an element to the end of the list
	 * @param element to be added to the end of the list
	 * @return true if the element is added successfully, false if not
	 */
	public boolean add(E element) {
		if(element == null) {
			throw new IllegalArgumentException();
		}
		if(!isEmpty()) {
			front.add(element);
			size++;
			return true;
		}
		else {
			front = new ListNode(element);
			size++;
			return true;
		}
	}
	
	/**
	 * Adds the given element to the list at the given index
	 * @param index where the element is to be added
	 * @param element the element to be added
	 * @return true if the element is added successfully, false if not

	 */
	public boolean add(int index, E element) {
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(element == null) {
			throw new IllegalArgumentException();
		}
		if(index == 0) {
			ListNode newFront = new ListNode(element, front);
			front = newFront;
			size++;
			return true;
		}
		if(!isEmpty()) {
			front.add(index, element);
			size++;
			return true;
		}
		return false;

	}

	/**
	 * Gets the data at the given index
	 * @param index where the desired data is located
	 * @return the data within the node at the given location
	 */
	public E get(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		return front.get(index);
	}

	/**
	 * removes the element at the given index
	 * @param index of the element to be removed
	 * @return the removed data piece
	 */
	public E remove(int index) {
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			E dataRemoved = front.data;
			front = front.next;
			size--;
			return dataRemoved;
		}
		else {
			size--;
			return front.remove(index);
		}
	}

	/**
	 * tells the size of the list
	 * @return the size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * sets the element at the given index to the given element
	 * @param index where the element is to be added
	 * @param element that is to be added
	 * @return the element that was replaced
	 */
	public E set(int index, E element) {
		if(index >= size || index < 0 ) {
			throw new IndexOutOfBoundsException();
		}
		if(element == null) {
			throw new IllegalArgumentException();
		}
		if(index == 0) {
			E dataRemoved = front.data;
			front.data = element;
			return dataRemoved;
		}
		else {
			return front.set(index, element);
		}
	}

	/**
	 * tells whether or not the list is empty
	 * @return true if the list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Maintains each individual data piece in the list
	 * @author Team 7
	 * @version 1.8
	 */
	private class ListNode {
		
		/** data contained within the Node*/
		public E data;
		
		/** next node in the list*/
		public ListNode next;
		
		/**
		 * constructs a new ListNode with the given data and null next node
		 * @param data data contained within the node
		 */
		public ListNode(E data) {
			this(data, null);
		}
		
		/**
		 * constructs a new ListNode with the given data and next node
		 * @param data data contained within the node
		 * @param next next node in the list
		 */
		public ListNode(E data, ListNode next) {
			this.data = data;
			this.next = next;
		}
		
		/**
		 * private helper method for adding items to the end of list
		 * @param element to be added to the list
		 */
		private void add(E element) {
			if(this.next == null) {
				this.next = new ListNode(element);
			}
			else {
				add(size, element);
			}
		}
		
		/**
		 * private helper method for adding items to a given index in the list
		 * @param index number of spaces ahead of the current node where the element
		 * is to be added
		 * @param element the element to be added
		 */
		private void add(int index, E element) {
			if(index == 1) {
				ListNode newNode = new ListNode(element, this.next);
				this.next = newNode;
			}
			else {
				this.next.add(index - 1, element);
			}
		}
		
		/**
		 * private helper method for getting items at an index
		 * @param index number of spaces ahead of the current node where the
		 * desired node is located
		 */
		private E get(int index) {
			if(index == 0) {
				return this.data;
			}
			else {
				return this.next.get(index - 1);
			}
		}
		
		/**
		 * private helper method for the remove function
		 * @param index number of spaces ahead of the current node where the item
		 * is to be removed
		 * @return the removed data piece
		 */
		private E remove(int index) {
			if(index == 1) {
				E dataRemoved = this.next.data;
				this.next = this.next.next;
				return dataRemoved;
			}
			else {
				return this.next.remove(index - 1);
			}
		}
		
		/**
		 * private helper method for the set function
		 * @param index number of spaces ahead of the current node where the item
		 * is to be removed
		 * @param element to be added to the list
		 * @return the removed data piece
		 */
		private E set(int index, E element) {
			if(index == 0) {
				E dataRemoved = this.data;
				this.data = element;
				return dataRemoved;
			}
			else {
				return this.next.set(index - 1, element);
			}
		}
	}

	
	
	
	
	

}

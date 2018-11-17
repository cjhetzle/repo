/**
 * 
 */
package edu.ncsu.csc316.util;

import java.util.AbstractSequentialList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Maintains a LinkedList of generic E objects
 * 
 * @author Team 7
 * @version 1.8
 * @param <E> generic object in list
 */
public class LinkedList<E> extends AbstractSequentialList<E> {

	/** Node at the front of the list */
	private ListNode front;

	/** Node at the back of the list */
	private ListNode back;

	/** size of the list */
	private int size;

	/**
	 * constructs a new LinkedList
	 */
	public LinkedList() {
		front = new ListNode(null);
		back = new ListNode(null);
		front.next = back;
		back.setPrev(front);
		size = 0;
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence).
	 */
	@Override
	public ListIterator<E> listIterator(int index) {
		LinkedListIterator iterator = new LinkedListIterator(index);
		return iterator;
	}

	/**
	 * returns the size of the LinkedList
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Contains each individual data piece and links to previous and next Nodes
	 * within the LinkedList
	 * 
	 * @author Team 7
	 * @version 1.8
	 */
	private class ListNode {
		/** data contained within the Node */
		public E data;

		/** Node before the current Node */
		private ListNode prev;

		/** Node after the current Node */
		public ListNode next;

		/**
		 * constructs a new ListNode with the given data and null prev and next
		 * Node
		 * 
		 * @param data
		 *            data within the Node
		 */
		public ListNode(E data) {
			this(data, null, null);
		}

		/**
		 * constructs a new ListNode with the given data, prev Node, and next
		 * Node
		 * 
		 * @param data
		 *            data contained within the Node
		 * @param prev
		 *            Node before this one in the LinkedList
		 * @param next
		 *            Node after this one in the LinkedList
		 */
		public ListNode(E data, ListNode prev, ListNode next) {
			this.data = data;
			this.setPrev(prev);
			this.next = next;
		}

		@SuppressWarnings("unused")
		public ListNode getPrev() {
			return prev;
		}

		public void setPrev(ListNode prev) {
			this.prev = prev;
		}
	}

	/**
	 * Iterates through the LinkedList
	 * 
	 * @author Team 7
	 * @version 1.8
	 */
	private class LinkedListIterator implements ListIterator<E> {

		/** item after the iterator's current position */
		private ListNode next;

		/** item before the iterator's current position */
		private ListNode prev;

		/** last node retrieved. For use in remove() */
		private ListNode lastNodeRetrieved;

		/** index of the item before the iterator */
		private int previousIndex;

		/** index of the item after the iterator */
		private int nextIndex;

		private boolean flag;

		/**
		 * creates a new iterator at index 0
		 */
		@SuppressWarnings("unused")
		public LinkedListIterator() {
			new LinkedListIterator(0);
		}

		/**
		 * Creates a new iterator at the index of the parameter
		 * 
		 * @param index
		 *            index of current node
		 */
		public LinkedListIterator(int index) {
			if (index > size || index < 0) {
				throw new IndexOutOfBoundsException();
			}
			if (size == 0) {
				prev = front;
				next = null;
				return;
			}
			ListNode temp = front;
			for (int i = 0; i < size; i++) {
				if (i == (index - 1)) {
					prev = temp;
					previousIndex = i;
				}
				if (i == index) {
					next = temp;
					nextIndex = i;
				}
				if (temp != null) {
					temp = temp.next;
				}
			}
		}

		/**
		 * tells whether or not there is a Node after the current Node
		 * 
		 * @return true if there is a next Node, false if there is not
		 */
		@Override
		public boolean hasNext() {
			if (this.next != null) {
				return true;
			}
			return false;
		}

		/**
		 * traverses to the next Node in the LinkedList
		 * 
		 * @return the data contained within the next Node
		 */
		@Override
		public E next() {
			if (this.next == null) {
				throw new NoSuchElementException();
			}
			E value = this.next.data;
			lastNodeRetrieved = this.next;
			previousIndex++;
			nextIndex++;
			flag = false;
			return value;
		}

		/**
		 * tells whether or not there is a Node before the current Node
		 * 
		 * @return true if there is a previous Node, false if there is not
		 */
		@Override
		public boolean hasPrevious() {
			if (this.prev != null) {
				return true;
			}
			return false;
		}

		/**
		 * traverses to the previous Node in the LinkedList
		 * 
		 * @return the data contained within the previous Node
		 */
		@Override
		public E previous() {
			if (this.prev == null) {
				throw new NoSuchElementException();
			}
			E value = this.prev.data;
			lastNodeRetrieved = this.prev;
			previousIndex--;
			nextIndex--;
			flag = false;
			return value;
		}

		/**
		 * gets the index of the next item in the LinkedList
		 * 
		 * @return index of the next item
		 */
		@Override
		public int nextIndex() {
			return nextIndex;
		}

		/**
		 * gets the index of the previous item in the LinkedList
		 * 
		 * @return index of the previous item
		 */
		@Override
		public int previousIndex() {
			return previousIndex;
		}

		/**
		 * removes the current Node from the LinkedList
		 */
		@Override
		public void remove() {
			if (flag) {
				return;
			}
			if (next != null && prev != null){
				prev.next = next.next;
				next = prev;
				size--;
			} else if (next != null){
				front = next.next;
				size--;
			}
			//size--;
			flag = true;
		}

		/**
		 * sets the data within the current Node to the given data
		 */
		@Override
		public void set(E e) {
			if (e == null) {
				throw new IllegalArgumentException();
			}
			if (flag) {
				return;
			}
			lastNodeRetrieved.data = e;

		}

		/**
		 * adds a new Node with the given data to the current index
		 */
		@Override
		public void add(E e) {
			if (e == null) {
				throw new IllegalArgumentException();
			}
			ListNode newNode = new ListNode(e);
			if (size == 0) {
				front = newNode;
				size++;
				flag = true;
				return;
			}
			newNode.next = next;
			if (prev != null) {
				prev.next = newNode;
			} else {
				front = newNode;
			}
			size++;
			flag = true;
		}

	}

}

package edu.ncsu.csc316.util;

public class LinkedPositionalList<E> implements PositionalList<E> {

	private static class Node<E> implements Position<E> {

		private E element;
		private Node<E> prev;
		private Node<E> next;

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() throws IllegalStateException {
			if (next == null)
				throw new IllegalStateException("Position no longer vallid");
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setElement(E e) {
			element = e;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----end of nested class ----

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	/** Contructs a new empty list */
	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	/** Validates the position and returns it as a node */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Invalid p");
		Node<E> node = (Node<E>) p;
		if (node.getNext() == null)
			throw new IllegalArgumentException("p is no longer in thelist");
		return node;
	}

	/** Returns the given node as a Position (or null if it is a sentinel) */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null;
		return node;
	}

	// public accessor methods
	/** Returns the number of elements in the linked list */
	public int size() {
		return size;
	}

	/** Tests whether the linked list is empty */
	public boolean isEmtpy() {
		return size == 0;
	}

	/** Returns the first Position in the linked list (or null, if empty) */
	public Position<E> first() {
		return position(header.getNext());
	}

	/** Returns the last Position in the linked list (or null, if empty) */
	public Position<E> last() {
		return position(trailer.getPrev());
	}

	/**
	 * Returns the Position immediately before Position p (or null, if p is
	 * first)
	 */
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}
	
	/** Returns the Position immediately after Position p (or null, if p is last) */
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	// preivate utilities
	/** Adds element e to the linked list between the given nodes */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		Node<E> newest = new Node<>(e, pred, succ); // create and link a new node
		pred.setNext(newest);
		succ.setPrev(newest);
		size++;
		return newest;
	}
	
	// public update methods
	/** Inserts element e at the front of the linked list and returns its new Position */
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext()); // just add the header
	}
	
	/** Inserts element e at the front of the linked list and returns its new Position */
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	/** Inserts element e immediately before Position p, and returns its new Position */
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	/** Inserts element e immediately after Position p, and returns its new Position */
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}
	
	/** Replaces the element stored at Position p and returns the replaced element */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node  = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
	/** Removes the element stored at Position p and returns it (invalidating p) */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		predecessor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
}

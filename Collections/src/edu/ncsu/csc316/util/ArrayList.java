package edu.ncsu.csc316.util;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * The ArrayBasedList<E> class maintains an ArrayBasedList of generic E objects
 * 
 * @author Team 7
 * @version 1.8
 * @param <E>
 *            type of object the ArrayBasedList contains
 */
public class ArrayList<E> implements Iterable<E> {

	/** Array of elements */
	private E[] list;

	/** number of elements in the array */
	private int size = 0;

	/** current CAPACITY of the array */
	private int capacity;

	/**
	 * constructs a new ArrayBasedList
	 */
	public ArrayList() {
		this(4);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		this.capacity = capacity;
		list = (E[]) new Object[capacity];
	}

	/**
	 * sets the element at a given index to the given element
	 * 
	 * @param index
	 *            the index of the element that is being set
	 * @param element
	 *            the element that is being put into the list
	 * @return the element that was removed from the list
	 */
	public E set(int i, E e) {
		checkIndex(i, size);

		if (e == null)
			throw new NullPointerException();

		E temp = list[i];
		list[i] = e;
		return temp;

	}

	/**
	 * adds an element to a specific index of the list
	 * 
	 * @param index
	 *            the index to add the element to
	 * @param element
	 *            the element to be added
	 */
	@SuppressWarnings("unchecked")
	public void add(int i, E e) {
		checkIndex(i, size + 1);
		if (e == null)
			throw new NullPointerException();

		if (size == capacity) {
			capacity *= 2;
			E[] list2 = (E[]) new Object[capacity];

			for (int k = 0; k < size; k++) {
				list2[k] = list[k];
			}
			list = list2;
		}
		if (i < size) {
			for (int k = size; k > i; k--) {
				list[k] = list[k - 1];
			}
		}

		list[i] = e;
		size++;
	}

	/**
	 * adds an element to a specific index of the list
	 * 
	 * @param element
	 *            the element to be added
	 */
	public void add(E e) {
		add(size, e);
	}

	/**
	 * removes the object at the given index
	 * 
	 * @param i
	 *            the index to remove
	 * @return the removed object
	 */
	public E remove(int i) {
		checkIndex(i, size);
		E temp = list[i];

		int max = size - 1;

		for (int k = i; k < max; k++)
			list[k] = list[k + 1];

		list[max] = null;
		size--;
		return temp;
	}

	/**
	 * gets the element at the given index
	 * 
	 * @return the element at the given index
	 */
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return list[i];
	}
	
	   /**
     * Checks to see if the list contains the object in question, returns true
     * (or false if it doesn't exist)
     * 
     * @param e
     *            The object to find
     * @return True if the list contains the object, false if not
     */
    public boolean contains(E e) {
        Iterable<E> it = iterable();
        for (E object : it) {
            if (object.equals(e))
                return true;
        }
        return false;
    }

	/**
	 * Checks to see whether or not i is a legal index of a list of size n
	 * 
	 * @param i
	 *            The index in question
	 * @param n
	 *            The size of the list or array
	 * @throws IndexOutOfBoundsException
	 *             Thrown if i < 0 or >= n
	 */
	private void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

	/**
	 * returns the size of the ArrayBasedList
	 * 
	 * @returns the size of the list
	 */
	public int size() {
		return size;
	}

	/**
	 * returns true if the size of the list is 0, otherwise false
	 * 
	 * @return Boolean
	 */
	public boolean isEmpty() {
		return size == 0;
	}

    /**
     * Array iterator class
     * 
     * @author Cameron
     *
     */
    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;

        /**
         * Returns whether or not there is a next index
         * 
         * @param boolean
         *            is there a next node
         */
        public boolean hasNext() {
            return j < size;
        }

        /**
         * Returns the next item in the array
         * 
         * @return E the next element in the array
         * @throws NoSuchElementException
         *             thrown if there is not another element
         */
        public E next() throws NoSuchElementException {
            if (j == size)
                throw new NoSuchElementException("No next element");
            removable = true;
            return list[j++];
        }

        /**
         * Removes the current element of the list
         * 
         * @throws IllegalStateException
         *             if there is no object
         */
        public void remove() throws IllegalStateException {
            if (!removable)
                throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j - 1);
            j--;
            removable = false;
        }
    }

    /**
     * Iterator<E> returns an iterator
     * 
     * @return Iterator<E> is returned
     */
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    /**
     * Wraps the arrayIterator in an iterable class
     * 
     * @author Cameron
     *
     */
    private class ArrayIterable implements Iterable<E> {

        /**
         * Iterator returns an iterable iterator
         * 
         * @return Iterator returns an iterator
         */
        public Iterator<E> iterator() {
            return new ArrayIterator();
        }
    }

    /**
     * Returns an iterable iterator
     * 
     * @return Iterable iterator
     */
    public Iterable<E> iterable() {
        return new ArrayIterable();
    }
}

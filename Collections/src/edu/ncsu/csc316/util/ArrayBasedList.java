package edu.ncsu.csc316.util;

/**
 * The ArrayBasedList<E> class maintains an ArrayBasedList of generic E objects
 * 
 * @author Team 7
 * @version 1.8
 * @param <E>
 *            type of object the ArrayBasedList contains
 */
public class ArrayBasedList<E> {

	/** Array of elements */
	private E[] list;

	/** number of elements in the array */
	private int size;

	/** current capacity of the array */
	private int capacity;

	/**
	 * constructs a new ArrayBasedList
	 */
	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		size = 0;
		capacity = 10;
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
	public E set(int index, E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		E ret = list[index];
		list[index] = element;
		return ret;

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
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (element == null) {
			throw new NullPointerException();
		}
		if (size == capacity) {
			capacity *= 2;
			E[] list2 = (E[]) new Object[capacity];

			for (int i = 0; i < size; i++) {
				list2[i] = list[i];
			}
			list = list2;
		}
		if (index < size) {
			for (int i = size; i > index; i--) {
				list[i] = list[i - 1];
			}
		}

		list[index] = element;
		size++;
	}

	/**
	 * adds an element to a specific index of the list
	 * 
	 * @param element
	 *            the element to be added
	 */
	@SuppressWarnings("unchecked")
	public void add(E element) {
		int index = size();

		if (element == null) {
			throw new NullPointerException();
		}
		if (size == capacity) {
			capacity *= 2;
			E[] list2 = (E[]) new Object[capacity];

			for (int i = 0; i < size; i++)
				list2[i] = list[i];

			list = list2;
		}

		list[index] = element;
		size++;
	}

	/**
	 * removes the object at the given index
	 * 
	 * @return the removed object
	 */
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E elementRemoved = list[index];

		for (int i = index; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[size - 1] = null;
		size--;
		return elementRemoved;
	}

	/**
	 * gets the element at the given index
	 * 
	 * @return the element at the given index
	 */
	public E get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index < size && index >= 0) {
			return list[index];
		}
		return null;
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

}

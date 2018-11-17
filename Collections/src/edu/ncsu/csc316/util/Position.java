package edu.ncsu.csc316.util;

public interface Position<E> {
	/**
	 * Returns the element stored at this position
	 * 
	 * @return the stored element
	 * @throws IllegalStateException if position no longer valid
	 */
	E getElement() throws IllegalStateException;
}



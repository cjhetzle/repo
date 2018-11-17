package edu.ncsu.csc316.util;

import java.util.Iterator;

public abstract class AbstractTree<E> implements Tree<E> {
	public boolean isInternal(Position<E> p) {
		return numChildren(p) > 0;
	}

	public boolean isExternal(Position<E> p) {
		return numChildren(p) == 0;
	}

	public boolean isRoot(Position<E> p) {
		return p == root();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int depth(Position<E> p) {
		if (isRoot(p))
			return 0;
		else
			return 1 + depth(parent(p));
	}

	public int height(Position<E> p) {
		int h = 0;
		for (Position<E> c : children(p))
			h = Math.max(h, 1 + height(c));
		return h;
	}

	// ------- nested ElementIterator class -----
	/*
	 * This class adapts the iteration produced by positions() to return
	 * elements
	 */
	private class ElementIterator implements Iterator<E> {
		Iterator<Position<E>> posIterator = positions().iterator();

		public boolean hasNext() {
			return posIterator.hasNext();
		}

		public E next() {
			return posIterator.next().getElement();
		}

		public void remove() {
			posIterator.remove();
		}
	}

	public Iterator<E> iterator() {
		return new ElementIterator();
	}

	public Iterable<Position<E>> positions() {
		return preorder();
	}

	/**
	 * Adds positions of the subtree rooted at Positoin p to the given snapshot
	 */
	private void preorderSubtree(Position<E> p, ArrayList<Position<E>> snapshot) {
		snapshot.add(p);
		for (Position<E> c : children(p))
			preorderSubtree(c, snapshot);
	}

	/**
	 * Adds positions of the subtree rooted at Position p to the given snapshot
	 */
	private void postorderSubtree(Position<E> p, ArrayList<Position<E>> snapshot) {
		for (Position<E> c : children(p))
			postorderSubtree(c, snapshot);
		snapshot.add(p);
	}

	/**
	 * Returns an iterable collection of positions of the tree, reported in
	 * postorder
	 */
	public Iterable<Position<E>> postorder() {
		ArrayList<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			postorderSubtree(root(), snapshot);
		return snapshot;
	}

	public Iterable<Position<E>> preorder() {
		ArrayList<Position<E>> snapshot = new ArrayList<>();
		if (!isEmpty())
			preorderSubtree(root(), snapshot);
		return snapshot;
	}
}

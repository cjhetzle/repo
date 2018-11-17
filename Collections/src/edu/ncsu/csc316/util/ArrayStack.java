package edu.ncsu.csc316.util;

import java.util.EmptyStackException;

/**
 * implements a stack as an ArrayBasedList
 * 
 * @author Team 7
 * @version 1.8
 * @param <E>
 *            the type of object contained within the ArrayStack
 */
public class ArrayStack<E> implements Stack<E> {

    /** the ArrayBasedList the stack is based off of */
    private ArrayList<E> list;

    /**
     * creates a new, empty stack
     */
    public ArrayStack() {
        list = new ArrayList<E>();
    }

    /**
     * adds an element to the top of the stack
     * 
     * @param element
     *            the element to be added to the stack
     */
    @Override
    public void push(E element) {
        list.add(element);
    }

    /**
     * removes an element from the top of the stack
     * 
     * @return the element removed from the stack
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else if (list.size() > 0) {
            E obj = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return obj;
        }
        return null;
    }

    /**
     * returns the element at the top of the stack without removing it
     * 
     * @return the element at the top of the stack
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else if (list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    /**
     * tells whether or not the stack is empty
     * 
     * @return true if the stack is empty, false if not
     */
    @Override
    public boolean isEmpty() {
        if (list.size() == 0)
            return true;
        return false;
    }

}

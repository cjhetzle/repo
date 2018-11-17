/**
 * 
 */
package edu.ncsu.csc316.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.collections.CSC216ArrayList;
import edu.ncsu.csc316.util.LinkedListAL;

/**
 * Tests the CSC216ArrayList class
 * @author SarahHeckman
 *
 */
public class LinkedListALTest {
	/**
	 * list of 
	 */
	LinkedListAL<String> list;
	/**
	 * Sets up a new list before each test
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new LinkedListAL<String>();
	}

	/**
	 * Tests that a CSC216ArrayList is constructed correctly.  A CSC216ArrayList of
	 * any generic type should be not null and empty, which implies a size of 0.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#CSC216ArrayList()}.
	 */
	@Test
	public void testLinkedList() {
		//Test that the list field is created correctly.
		assertTrue(list.isEmpty());
		assertNotNull(list);
		assertEquals(0, list.size());
		CSC216ArrayList<String> list2 = new CSC216ArrayList<String>();
		assertTrue(list.equals(list2));
		try {
			list.get(0);
			fail();
		} catch(Exception e) {
			//pass
		}
		try {
			list.remove(0);
			fail();
		} catch(Exception e) {
			//pass
		}
	}

	/**
	 * Tests adding elements to an empty CSC216ArrayList.  Then tests adding elements to the 
	 * front, middle, and back of a CSC216ArrayList.  The size and contents should be checked
	 * after each insertion.  Additionally, the bounds of the list should be checked and null
	 * elements should not be added to the list.  Finally, test that the ArrayList with an
	 * initial capacity of 10 grows when an 11th element is added.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		//Attempt to add an element to index 1 in an empty list.
		//Check that the element was not added.
		try {
			list.add(1, "apple");
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		
		//Add element to empty list
		list.add(0, "apple");
		assertEquals(1, list.size());
		assertEquals("apple", list.get(0));
		
		//Add element to the front of a list
		list.add(0, "potato");
		assertEquals(2, list.size());
		assertEquals("potato", list.get(0));
		assertEquals("apple", list.get(1));
		
		//Add element to the middle of a list
		list.add(1, "orange");
		assertEquals(3, list.size());
		assertEquals("potato", list.get(0));
		assertEquals("orange", list.get(1));
		assertEquals("apple", list.get(2));
		
		//Add element to the back of a list
		list.add(3, "table");
		assertEquals(4, list.size());
		assertEquals("potato", list.get(0));
		assertEquals("orange", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("table", list.get(3));
		
		
		//Attempt to add a null element.  Check that the element
		//was not added.
		String nullElement = null;
		try {
			list.add(4, nullElement);
			fail();
		} catch(NullPointerException e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("potato", list.get(0));
		assertEquals("orange", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("table", list.get(3));
		
		//Attempt to add at index -1.  Check that the element was not
		//added.
		try {
			list.add(-1, "laptop");
			fail();
		} catch(Exception e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("potato", list.get(0));
		assertEquals("orange", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("table", list.get(3));
		
		//Attempt to add at index 5 (since there are 4 elements in the list).
		//Check that the element was not added.
		try {
			list.add(5, "phone");
			fail();
		} catch(Exception e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("potato", list.get(0));
		assertEquals("orange", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("table", list.get(3));
		
		//Test adding an 11th element to an ArrayList with an initial 
		//capacity of 10.
		list.add(4, "things");
		list.add(5, "thing2");
		list.add(6, "thing3");
		list.add(7, "thing4");
		list.add(8, "eight");
		list.add(9, "nine");
		assertEquals(10, list.size());
		list.add(10, "11th element");
		assertEquals(11, list.size());
		assertEquals("11th element", list.get(10));
		
	}

	/**
	 * Tests that elements are correctly removed from the front, middle, and back of an 
	 * ArrayList.  Removing the last element should leave an empty list.  The bounds are
	 * checked for the appropriate exceptions.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		//Attempt to remove an element from an empty list
		try {
			list.remove(0);
			fail();
		} catch(Exception e) {
			//pass
		}
		
		//Add 4 elements to the list and test that the contents are correct.
		//Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.remove(-1);
			fail();
		} catch(IndexOutOfBoundsException e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when remove() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.remove(list.size());
			fail();
		} catch(IndexOutOfBoundsException e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Remove middle element.  Test that the removed element is correct and
		//that the remaining list is correct after the removal.
		String s1 = list.remove(1);
		assertEquals(s1, "banana");
		assertEquals(3, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("apple", list.get(1));
		assertEquals("kiwi", list.get(2));
		
		//Remove first element
		list.remove(0);
		assertEquals(2, list.size());
		assertEquals("apple", list.get(0));
		assertEquals("kiwi", list.get(1));
		
		//Remove last element
		list.remove(1);
		assertEquals(1, list.size());
		assertEquals("apple", list.get(0));
		
		//Remove only element
		list.remove(0);
		assertEquals(0, list.size());
						
	}

	/**
	 * Tests setting an element in an empty list, the bounds of the list when
	 * using the set() method, and setting an element at the front, middle, and back
	 * of the list.  The set() method is also passed null.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetIntE() {
		//Attempt to set a value in an empty list
		try {
			list.set(0, "element");
			fail();
		} catch(IndexOutOfBoundsException e) {
			//pass
		}
		assertEquals(0, list.size());
		
		//Add 4 elements to the list and test that the contents are correct.
		//Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when set() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.set(-1, "element");
			fail();
		} catch(IndexOutOfBoundsException e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when set() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.set(list.size(), "element");
			fail();
		} catch(IndexOutOfBoundsException e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Set middle element.  Test that the element is modified correctly, set() returns the
		//right value, and that the rest of the list is correct.
		String s1 = list.set(1, "strawberry");
		assertEquals(s1, "banana");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Set first element
		list.set(0, "first element");
		assertEquals(4, list.size());
		assertEquals("first element", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Set last element
		list.set(3, "last element");
		assertEquals("first element", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("last element", list.get(3));
		
		//Attempt to set an element to null.  Check that the element
		//was not modified.
		try {
		list.set(3, null);
		fail();
		} catch(NullPointerException e) {
			//pass
		}
		assertEquals("first element", list.get(0));
		assertEquals("strawberry", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("last element", list.get(3));

	}

	/**
	 * Main get() functionality is tested in the other test methods.  This method will
	 * focus on testing the exceptions associated with bounds.
	 * Test method for {@link edu.ncsu.csc216.collections.CSC216ArrayList#get(int)}.
	 */
	@Test
	public void testGetInt() {
		//Add 4 elements to the list and test that the contents are correct.
		//Reuse code from your testAddIntE.
		list.add(0, "orange");
		list.add(1, "banana");
		list.add(2, "apple");
		list.add(3, "kiwi");
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//a negative index.  Make sure the list is unchanged.
		try {
			list.get(-5);
			fail();
		} catch(IndexOutOfBoundsException e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
		//Test that IndexOutOfBoundsException is thrown when get() is passed
		//an index > size() - 1.  Make sure the list is unchanged.
		try {
			list.get(list.size());
			fail();
		} catch(IndexOutOfBoundsException e) {
			//pass
		}
		assertEquals(4, list.size());
		assertEquals("orange", list.get(0));
		assertEquals("banana", list.get(1));
		assertEquals("apple", list.get(2));
		assertEquals("kiwi", list.get(3));
	}
	
	/**
	 * tests the LinkedListAL for objects of type Integer
	 */
	public void testIntegerLinkedList() {
		//create empty list of Integers
		LinkedListAL<Integer> intList = new LinkedListAL<Integer>();
		
		//add 5 numbers
		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		
		intList.add(0, two);
		intList.add(0, one);
		intList.add(2, five);
		intList.add(2, four);
		intList.add(2, three);
		assertEquals(one, intList.get(0));
		assertEquals(two, intList.get(1));
		assertEquals(three, intList.get(2));
		assertEquals(four, intList.get(3));
		assertEquals(five, intList.get(4));
		
		//remove the middle number (index 2)
		intList.remove(2);
		assertEquals(one, intList.get(0));
		assertEquals(two, intList.get(1));
		assertEquals(four, intList.get(2));
		assertEquals(five, intList.get(3));
		
		//add 2 more numbers
		Integer six = new Integer(6);
		Integer seven = new Integer(7);
		intList.add(intList.size() - 1, six);
		intList.add(intList.size() - 2, seven);
		assertEquals(one, intList.get(0));
		assertEquals(two, intList.get(1));
		assertEquals(four, intList.get(2));
		assertEquals(five, intList.get(3));
		assertEquals(six, intList.get(5));
		assertEquals(seven, intList.get(4));
		
		//remove the first number
		intList.remove(0);
		assertEquals(two, intList.get(0));
		assertEquals(four, intList.get(1));
		assertEquals(five, intList.get(2));
		assertEquals(six, intList.get(4));
		assertEquals(seven, intList.get(3));
		
		//add a number
		intList.add(0, one);
		assertEquals(one, intList.get(0));
		assertEquals(two, intList.get(1));
		assertEquals(four, intList.get(2));
		assertEquals(five, intList.get(3));
		assertEquals(six, intList.get(5));
		assertEquals(seven, intList.get(4));
		
		//remove the last number
		intList.remove(intList.size() - 1);
		assertEquals(one, intList.get(0));
		assertEquals(two, intList.get(1));
		assertEquals(four, intList.get(2));
		assertEquals(five, intList.get(3));
		assertEquals(seven, intList.get(4));
		
		//add a number
		intList.add(2, three);
		assertEquals(one, intList.get(0));
		assertEquals(two, intList.get(1));
		assertEquals(four, intList.get(3));
		assertEquals(five, intList.get(4));
		assertEquals(seven, intList.get(5));
		assertEquals(three, intList.get(2));
		
		//remove the second number
		intList.remove(1);
		assertEquals(one, intList.get(0));
		assertEquals(four, intList.get(2));
		assertEquals(five, intList.get(3));
		assertEquals(seven, intList.get(4));
		assertEquals(three, intList.get(1));
		
		//remove the remaining numbers in the list
		while(intList.size() > 0) {
			list.remove(0);
		}
		assertEquals(0, intList.size());
		
	}

}

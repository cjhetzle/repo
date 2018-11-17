package edu.ncsu.csc316.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortedTableMapTest {

	SortedTableMap<String, Integer> table = null;
	
	@Before
	public void setUp() throws Exception {
		table = new SortedTableMap<String, Integer>();
	}

	@Test
	public void testOrder() {
		table.put("Cameron", 1);
		table.put("Alicia", 2);
		table.put("Tally", 3);
		table.put("Collin", 4);
		table.put("Alex", 5);
		table.put("Udeh", 6);
		
		ArrayList<Entry<String, Integer>> list = table.entrySet();
		
		assertEquals(5, (int)list.get(0).getValue());
		assertEquals(2, (int)list.get(1).getValue());
		assertEquals(1, (int)list.get(2).getValue());
		assertEquals(4, (int)list.get(3).getValue());
		assertEquals(3, (int)list.get(4).getValue());
		assertEquals(6, (int)list.get(5).getValue());
	}

}

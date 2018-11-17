package edu.ncsu.csc316.util;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.util.ChainHashMap;

/**
 * ChainHashMapTest will test the ChainHapMap class and each method in it
 * 
 * @author Cameron
 *
 */
public class ChainHashMapTest {

	/**
	 * testChainHashMap will test the ability to create hash maps and initialize
	 * them
	 */
	@Test
	public void testChainHashMap() {
		ChainHashMap<Integer, String> map = new ChainHashMap<>();

		String[] n = { "Cameron", "Tally", "Collin", "Ellis" };
		Integer[] k = new Integer[n.length];

		for (int i = 0; i < 4; i++) {
			Integer key = 0;
			for (int j = 0; j < n[i].length(); j++)
				key += n[i].charAt(j);
			k[i] = key;
			assertNull(map.bucketPut(map.hashValue(key), key, n[i]));
		}

		assertNotNull(map.get(k[0]));
		assertNotNull(map.get(k[3]));
		assertNotNull(map.get(k[1]));
		assertNotNull(map.get(k[2]));
	}

	/**
	 * testBucketRemove will test the remove method of the hashTable
	 */
	@Test
	public void testBucketRemove() {
		ChainHashMap<Integer, String> map = new ChainHashMap<>(25147);

		String[] n = { "Cameron", "Tally", "Collin", "Ellis", "Christian", "Tony", "Isaic" };
		Integer[] k = new Integer[n.length];

		for (int i = 0; i < 7; i++) {
			Integer key = 0;
			for (int j = 0; j < n[i].length(); j++)
				key += n[i].charAt(j);
			k[i] = key;
			assertNull(map.bucketPut(map.hashValue(key), key, n[i]));
		}

		assertEquals(n[0], map.bucketRemove(map.hashValue(k[0]), k[0]));
		assertEquals(n[1], map.bucketRemove(map.hashValue(k[1]), k[1]));
		assertEquals(n[2], map.bucketRemove(map.hashValue(k[2]), k[2]));
		assertEquals(n[3], map.bucketRemove(map.hashValue(k[3]), k[3]));
		assertEquals(n[4], map.bucketRemove(map.hashValue(k[4]), k[4]));
		assertEquals(n[5], map.bucketRemove(map.hashValue(k[5]), k[5]));
		assertNull(map.bucketRemove(0, 23));
		assertEquals(n[6], map.bucketRemove(map.hashValue(k[6]), k[6]));
		assertNull(map.bucketRemove(map.hashValue(k[0]), k[0]));

	}

	/**
	 * testBucketGet will test the get method of the hash table
	 */
	@Test
	public void testBucketGet() {
		ChainHashMap<Integer, String> map = new ChainHashMap<>(25147);

		String[] n = { "Cameron", "Tally", "Collin", "Ellis", "Christian", "Tony", "Isaic" };
		Integer[] k = new Integer[n.length];

		for (int i = 0; i < 7; i++) {
			Integer key = 0;
			for (int j = 0; j < n[i].length(); j++)
				key += n[i].charAt(j);
			k[i] = key;
			assertNull(map.bucketPut(map.hashValue(key), key, n[i]));
		}

		assertNotNull(map.get(k[0]));
		assertNotNull(map.get(k[1]));
		assertNotNull(map.get(k[2]));
		assertNotNull(map.get(k[3]));
		assertNotNull(map.get(k[4]));
		assertNotNull(map.get(k[5]));
		assertNull(map.bucketGet(1, 23));
		assertNotNull(map.get(k[6]));
	}

}

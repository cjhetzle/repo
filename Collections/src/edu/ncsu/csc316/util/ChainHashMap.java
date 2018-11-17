package edu.ncsu.csc316.util;

/**
 * Taken from Data Structures and Algorithms ChainHashMap is a map that uses
 * both hashing and chaining as a collision resolution
 * 
 * @author Cameron Hetzler
 *
 * @param <K>
 *            The key value type
 * @param <V>
 *            The value type
 */
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {

	private UnsortedTableMap<K, V>[] table;

	/**
	 * ChainHashMap() will initialize the super class without arguments
	 */
	public ChainHashMap() {
		super();
	}

	/**
	 * ChainHashMap(cap) will initialize the super class with the capacity of
	 * cap
	 * 
	 * @param cap
	 *            The capacity of the table
	 */
	public ChainHashMap(int cap) {
		super(cap);
	}

	/**
	 * ChainHashMap(cap, p) will initialize the super class with the capacity of
	 * cap and use the prime number p
	 * 
	 * @param cap
	 *            The capacity of the table
	 * @param p
	 *            Prime number of the table
	 */
	public ChainHashMap(int cap, int p) {
		super(cap, p);
	}

	/**
	 * Create table will initialize a blank table with the capacity the user
	 * defined
	 */
	@SuppressWarnings("unchecked")
	protected void createTable() {
		table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
	}

	/**
	 * bucketGet will find the bucket in the hashTable at the specified index h
	 * and pull from that bucket the item with the correct key
	 * 
	 * @param h
	 *            Index of the hashtable the bucket is at
	 * @param k
	 *            The Key of the item in the bucket requested
	 * @return V the value of the item in the requested bucket with the key
	 */
	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		return bucket.get(k);
	}

	/**
	 * bucketPut will add a Value with a given Key and HashValue to the table If
	 * the bucket at h is empty a new instance will be created
	 * 
	 * @param h
	 *            The index of the table to add to
	 * @param k
	 *            The Key of the item to add, to find it later
	 * @param v
	 *            The value of the item being added to the table
	 * @return V the item that was successfully added to the table
	 */
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			bucket = table[h] = new UnsortedTableMap<>();
		int oldSize = bucket.size();
		V answer = bucket.put(k, v);
		n += (bucket.size() - oldSize);
		return answer;
	}

	/**
	 * bucketRemove will remove the item with the Key in the bucket h in the
	 * hash table
	 * 
	 * @param h
	 *            The index and bucket of the table to look at
	 * @param k
	 *            The key of the item that needs to be removed
	 * @return The value of the item removed
	 */
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if (bucket == null)
			return null;
		int oldSize = bucket.size();
		V answer = bucket.remove(k);
		n -= (oldSize - bucket.size());
		return answer;
	}

	/**
	 * entrySet will return an iterable list of entry data objects in the map
	 * 
	 * @return Iterable<Entry<K, V>> is the arrayList that will be returned when
	 *         the operation is completed
	 */
	public Iterable<Entry<K, V>> entrySet() {
		ArrayList<Entry<K, V>> buffer = new ArrayList<>();
		for (int h = 0; h < capacity; h++)
			if (table[h] != null)
				for (Entry<K, V> entry : table[h].entrySet())
					buffer.add(entry);
		return buffer;
	}
	
	
}

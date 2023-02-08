package hashmap;

import java.util.*;

/**
 * A hash table-backed Map implementation. Provides amortized constant time
 * access to elements via get(), remove(), and put() in the best case.
 * <p>
 * Assumes null keys will never be inserted, and does not resize down upon remove().
 *
 * @author YOUR NAME HERE
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    // You should probably define some more!
    private int size;
    private int numBuckets;
    private float loadFactor; // number of elements in map / number of buckets

    /**
     * Constructors
     */
    public MyHashMap() {
        buckets = createTable(16);
        size = 0;
        loadFactor = (float) 0.75;
        numBuckets = 16;
    }

    public MyHashMap(int initialSize) {
        buckets = createTable(initialSize);
        size = 0;
        numBuckets = initialSize;
        loadFactor = (float) 0.75;
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad     maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        buckets = createTable(initialSize);
        size = 0;
        numBuckets = initialSize;
        loadFactor = (float) maxLoad;
    }

    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     * <p>
     * The only requirements of a hash table bucket are that we can:
     * 1. Insert items (`add` method)
     * 2. Remove items (`remove` method)
     * 3. Iterate through items (`iterator` method)
     * <p>
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     * <p>
     * Override this method to use different data structures as
     * the underlying bucket type
     * <p>
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        LinkedList<Node> list = new LinkedList<>();
        return list;
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     * <p>
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        Collection<Node>[] buckets = new Collection[tableSize];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = createBucket();
        }
        return buckets;
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    private int lastDigitCalc(K key) {
        return Math.floorMod(key.hashCode(), 10);

    }


    @Override
    public void put(K key, V value) {
        int lastDigit = lastDigitCalc(key);
        for (Node n : buckets[lastDigit]) {
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        buckets[lastDigit].add(createNode(key, value));
        size++;
        }


        @Override
        public void clear () {
            size = 0;
            buckets = createTable(16);
        }

        @Override
        public boolean containsKey (K key){
            int lastDigit = lastDigitCalc(key);
            for (Node n : buckets[lastDigit]) {
                if (n.key.equals(key)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public V get (K key){
            int lastDigit = lastDigitCalc(key);
            for (Node n : buckets[lastDigit]) {
                if (n.key.equals(key)) {
                    return n.value;
                }
            }
            return null;
        }

        @Override
        public int size () {
            return size;
        }


        @Override
        public Set<K> keySet () {
            Set<K> keySet = new HashSet<>();
            for (K key : this) {
                keySet.add(key);
            }
            return keySet;
        }

        @Override
        public V remove (K key){
            throw new UnsupportedOperationException();
        }

        @Override
        public V remove (K key, V value){
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterator<K> iterator () {
            return new HashMapSetIterator();
        }

        private class HashMapSetIterator implements Iterator<K> {

            private int arrayPos;
            private Iterator<Node> bucketsIt = buckets[arrayPos].iterator();

            public HashMapSetIterator() {
                arrayPos = 0;
            }

            public boolean hasNext() {
                while (!bucketsIt.hasNext() && arrayPos < buckets.length - 1) {
                    arrayPos++;
                    bucketsIt = buckets[arrayPos].iterator();
                }
                return bucketsIt.hasNext();
            }

            public K next() {
                if (hasNext()) {
                    return bucketsIt.next().key;
                }
                throw new NoSuchElementException();
            }
        }
    }

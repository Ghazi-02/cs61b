package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {

    private class BSTNode {
        private K key;
        private V value;
        private BSTNode left, right;
        private int size;

        public BSTNode(K k, V v, int s) {
            key = k;
            value = v;
            size = s;
        }
    }


    private BSTNode root;

    public BSTMap() {

    }

    @Override
    public void clear() {
        root.size = 0;
        root.left = null;
        root.right = null;
        root = null;

    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(root,key);
    }
    private boolean containsKey(BSTNode t,K key){
        if (t == null) {
            return false;
        }
        int cmp = key.compareTo( t.key);
        if (cmp < 0) {
            return  containsKey(t.left, key);
        } else if (cmp > 0) {
            return containsKey(t.right, key);
        } else {
            return true;
        }
    }
    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(BSTNode t, K key) {
        if (t == null) {
            return null;
        }
        int cmp = key.compareTo( t.key);
        if (cmp < 0) {
            return  get(t.left, key);
        } else if (cmp > 0) {
            return  get(t.right, key);
        } else {
            return t.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BSTNode t) {
        if (t == null) {
            return 0;
        } else {
            return t.size;
        }
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    public BSTNode put(BSTNode t, K key, V value) {
        if (t == null) {
            return new BSTNode(key, value, 1);
        }
        int cmp = key.compareTo(t.key);
        if (cmp > 0) {
            t.right = put(t.right, key, value);
        } else if (cmp < 0) {
            t.left = put(t.left, key, value);
        } else {
            t.value = value;
        }
        t.size = 1 + size(t.left) + size(t.right);
        return t;

    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();

    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}

package deque;

import afu.org.checkerframework.checker.oigj.qual.O;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {

    private T[] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        firstIndex = 0;
        lastIndex = 0;
    }

    @Override
    public int size() {
        return size;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    private void resize(int capacity, int pos) {
        T[] array = (T[]) new Object[capacity];
        System.arraycopy(items, firstIndex, array, pos, size);
        items = array;
        firstIndex = pos;
        lastIndex = firstIndex + size - 1;

    }

    @Override
    public void addFirst(T n) {
        //Needs to resize of item[0] is taken to adjust for parameter n
        float ratio = ((float) size) / ((float) items.length);
        if (firstIndex > 0 && get(firstIndex - 1) == null) {
            items[firstIndex - 1] = n;
            firstIndex = firstIndex - 1;
        }
        if (ratio > 0.75) {
            resize((int) (items.length * 1.5), 0);
        }
        if (size > 0) {
            resize((items.length + 1), 1);
            firstIndex = 0;
        }

        items[firstIndex] = n;
        size++;
    }

    @Override
    public void addLast(T n) {
        float ratio = ((float) size) / ((float) items.length);
        if (ratio > 0.75) {
            resize((int) (items.length * 1.5), 0);
        }
        items[size] = n;
        size++;
        lastIndex = size + firstIndex - 1;
    }


    @Override
    public T removeFirst() {
        float ratio = ((float) size) / ((float) items.length);
        if ((ratio) < 0.25 && size > 8) {
            resize((int) (items.length * 0.50), 1);
        }
        if (size == 0) {
            return null;
        }
        if (lastIndex == 1) {

        }
        T removedVal = items[firstIndex];
        items[firstIndex] = null;
        lastIndex = size + firstIndex - 1;
        size--;
        firstIndex++;
        return removedVal;

    }

    @Override
    public T removeLast() {
        float ratio = ((float) size) / ((float) items.length);
        if ((ratio) < 0.25 && size > 8) {
            resize((int) (items.length * 0.50), 0);
        }
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            size--;
            T removedVal = items[lastIndex];
            items[lastIndex] = null;
            return removedVal;
        }

        T removedVal = items[lastIndex];
        items[lastIndex] = null;
        lastIndex--;
        size--;
        return removedVal;

    }

    @Override
    public void printDeque() {
        String repr = "";
        for (int x = firstIndex; x < size + firstIndex; x++) {
            repr = repr + " " + items[x];
        }
        System.out.println(repr);
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("{");
        for (int i = firstIndex; i < lastIndex; i += 1) {
            returnString.append(items[i].toString());
            returnString.append(", ");
        }
        returnString.append(items[lastIndex]);
        returnString.append("}");
        return returnString.toString();
    }


    @Override
    public T get(int index) {
        return items[index];
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other instanceof Deque) {
            Deque<T> o = (Deque<T>) other;
            if (o.size() != this.size()) {
                return false;
            }
            for (int x = firstIndex; x < lastIndex; x++) {
                if (!this.get(x).equals(o.get(x))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private boolean contains(T x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeSetIterator();
    }

    private class ArrayDequeSetIterator implements Iterator<T> {
        private int pos;

        public ArrayDequeSetIterator() {
            pos = firstIndex;
        }

        @Override
        public boolean hasNext() {
            return pos <= lastIndex;
        }

        @Override
        public T next() {
            T returnItem = items[pos];
            pos++;
            return returnItem;
        }

    }

}

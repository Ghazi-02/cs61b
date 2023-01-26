package deque;

import java.util.Iterator;

public class ArrayDeque<Type> implements Iterable<Type>,Deque<Type>  {

    private Type[] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque() {
        size = 0;
        items = (Type[]) new Object[8];
        firstIndex = 0;
        lastIndex = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int capacity, int pos) {
        Type[] array = (Type[]) new Object[capacity];
        System.arraycopy(items, 0, array, pos, size);
        items = array;
    }
    @Override
    public void addFirst(Type n) {
        //Needs to resize of item[0] is taken to adjust for parameter n
        if (size > 0) {
            resize(size * 2 + 8, 1);
        }

        items[firstIndex] = n;
        size++;
    }

    @Override
    public void addLast(Type n) {
        if (size / items.length > 0.75) {
            resize((int) (size * 1.01 + 8), 0);
        }
        items[size] = n;
        size++;
        lastIndex = size + firstIndex;
    }


    public Type removeFirst() {
        if (size == 0) {
            return null;
        }

        Type removedVal = items[firstIndex];
        items[firstIndex] = null;
        size--;
        firstIndex++;
        return removedVal;
    }

    @Override
    public Type removeLast() {
        if (size / items.length <= 0.25) {
            resize((int) (size * 0.5 + 8), 1);
        }
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            Type removedVal = items[lastIndex];
            items[lastIndex] = null;
            return removedVal;
        }
        lastIndex--;
        size--;
        Type removedVal = items[lastIndex];
        items[lastIndex] = null;

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
        for (int i = firstIndex; i < lastIndex - 1; i += 1) {
            returnString.append(items[i].toString());
            returnString.append(", ");
        }
        returnString.append(items[lastIndex - 1]);
        returnString.append("}");
        return returnString.toString();
    }


    @Override
    public Type get(int index) {
        return items[index];
    }


    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArrayDeque<Type> o = (ArrayDeque<Type>) other;
        if (o.size() != this.size()) {
            return false;
        }
        for (Type item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }
    private boolean contains(Type x) {
        for (int i = 0; i < size; i += 1) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Iterator<Type> iterator() {
        return new ArrayDequeSetIterator();
    }

    private class ArrayDequeSetIterator implements Iterator<Type> {
        private int pos;

        public ArrayDequeSetIterator() {
            pos = firstIndex;
        }

        @Override
        public boolean hasNext() {
            return pos < lastIndex;
        }

        @Override
        public Type next() {
            Type returnItem = items[pos];
            pos++;
            return returnItem;
        }

    }

}

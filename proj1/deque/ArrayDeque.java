package deque;

import java.util.Iterator;

public class ArrayDeque<Type> implements Iterable<Type>, Deque<Type> {

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
        System.arraycopy(items, firstIndex, array, pos, size);
        items = array;
        firstIndex = pos;
        lastIndex = firstIndex + size - 1;

    }

    @Override
    public void addFirst(Type n) {
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
    public void addLast(Type n) {
        float ratio = ((float) size) / ((float) items.length);
        if (ratio > 0.75) {
            resize((int) (items.length * 1.5), 0);
        }
        items[size] = n;
        size++;
        lastIndex = size + firstIndex - 1;
    }


    public Type removeFirst() {
        float ratio = ((float) size) / ((float) items.length);
        if ((ratio) < 0.25 && size > 8) {
            resize((int) (items.length * 0.50), 1);
        }
        if (size == 0) {
            return null;
        }
        if (lastIndex == 1) {

        }
        Type removedVal = items[firstIndex];
        items[firstIndex] = null;
        lastIndex = size + firstIndex - 1;
        size--;
        firstIndex++;
        return removedVal;

    }

    @Override
    public Type removeLast() {
        float ratio = ((float) size) / ((float) items.length);
        if ((ratio) < 0.25 && size > 8) {
            resize((int) (items.length * 0.50), 1);
        }
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            size--;
            Type removedVal = items[lastIndex];
            items[lastIndex] = null;
            return removedVal;
        }

        Type removedVal = items[lastIndex];
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
    public Type get(int index) {
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
            Deque<Type> o = (Deque<Type>) other;
            if (o.size() != this.size()) {
                return false;
            }
            for (int x = 0; x < this.size; x++) {
                if (this.get(x) != o.get(x)) {
                    return false;
                }
            }
            return true;
        }

        return false;
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

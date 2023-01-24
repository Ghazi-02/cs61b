package deque;

public class ArrayDeque<Type> {

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

    public int size() {
        return size;
    }

    public void resize(int capacity, int pos) {
        Type[] array = (Type[]) new Object[capacity];
        System.arraycopy(items, 0, array, pos, size);
        items = array;
    }

    public void addFirst(Type n) {
        //Needs to resize of item[0] is taken to adjust for parameter n
        if (size > 0) {
            resize(size * 2 + 8, 1);
        }

        items[firstIndex] = n;
        size++;
    }

    public void addLast(Type n) {
        if (size / items.length > 0.75) {
            resize((int) (size * 1.01 + 8), 0);
        }
        items[size] = n;
        size++;
        lastIndex=size+firstIndex;
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

    public Type removeLast() {
        if (size / items.length == 0.25) {
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

    public String printDeque() {
        String repr = "";
        for (int x = firstIndex; x < size + firstIndex; x++) {
            repr = repr + " " + items[x];
        }
        return repr;
    }

    public Type get(int index) {
        return items[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

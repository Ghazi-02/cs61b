package deque;

public class ArrayDeque<Type> {

    private Type [] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque(){
        items = (Type[]) new Object[8];
        size=0;
        firstIndex=0;
        lastIndex=0;
    }
    public int size(){
        return size;
    }
    private void resize(int capacity) {
        Type[] array = (Type[]) new Object[capacity];
        System.arraycopy(items,firstIndex,array,firstIndex,size);
        items = array;
    }
    private int indexFinder(Type x){
        /* finds the index of param x in item */
        for (int i = 0; i < size;i++){
                if (items[i] == x){
                        return i;
                }
        }
        return -1;
    }
    public void addLast(Type x){
    if (size == items.length){
        resize((int)(size*1.01));
    }
    items[lastIndex + 1] = x;
    lastIndex ++;
    size ++;
    }
    public void addFirst(Type x){
        if (firstIndex == 0){

        }
        items[firstIndex-1] = x;
        size ++;
        firstIndex--;
    }
    public Type removeLast(){
    if(size / items.length == 0.25){
        resize((int)(size * 0.5));
    }
        Type x = get(lastIndex);
        items[lastIndex] = null;
        size--;
        lastIndex -= 1;
        return x;
    }
    public Type removeFirst(){
        Type x = items[firstIndex];
        items[firstIndex] = null;
        size--;
        firstIndex++;
        return x;
    }
    public Type get(int index){
        return items[index];
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }
}

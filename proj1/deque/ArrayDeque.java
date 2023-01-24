package deque;

public class ArrayDeque<Type> {

    private Type [] items;
    private int size;
    private int firstIndex;
    private int lastIndex;

    public ArrayDeque(){
        size = 0;
        items = (Type[]) new Object[8];
        firstIndex=0;
        lastIndex=size-1;
    }
    public int size(){
        return size;
    }
    public void resize(int capacity){
        Type [] array = (Type[]) new Object[capacity];
        System.arraycopy(items,0,array,1,size);
        items = array;
    }
    public void addFirst(Type n){
        //Needs to resize of item[0] is taken to adjust for parameter n
          if (size > 0){
              resize(size*2 + 8);
          }
          items[firstIndex] = n;
            size ++;
    }
    public void addLast(Type n){
        if( size == items.length){
             resize((int)(size*1.01 + 8));
        }
        items[size] = n;
        size ++;
    }
    public Type removeFirst(){
        if (size == 0){
            return null;
        }
        Type removedVal = items[0];
        items[0]= null;
        size --;
        firstIndex++;
        return removedVal;
    }
    public Type removeLast(){
        if(size / items.length == 0.25){
            resize((int)(size * 0.5 + 8));
        }
        if (size == 0){
            return null;
        }
        Type removedVal = items[size-1];
        items[size-1] = null;
        size --;
        return removedVal;

    }
    public String printDeque(){
        String repr = "";
        for (int x = firstIndex; x < size + firstIndex;x ++){
            repr = repr + " " + items[x];
        }
        return repr;
    }
    public Type get(int index){
        return items[index];
    }
    public boolean isEmpty(){
        return size == 0;
    }
}

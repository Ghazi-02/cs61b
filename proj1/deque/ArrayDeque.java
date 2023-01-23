package deque;

public class ArrayDeque<Type> {

    private Type [] items;
    private int size;

    public ArrayDeque(){
        items = (Type[]) new Object[8];
        size=0;
    }
    private void resize(int capacity) {

    }
    public void addLast(Type x){

    }
    public void addFirst(Type x){

    }
    public Type removeLast(){
        return null;
    }
    public Type removeFirst(){
        return null;
    }
    public Type get(int index){
        return items[index];
    }
}

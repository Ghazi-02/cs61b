package deque;

public class LinkedListDeque {

    private class LinkedNode {
        public int item;
        public LinkedNode next;
        public LinkedNode(int i, LinkedNode n ){
            item = i;
            next = n;
        }
    }
    private int size = 0;
    private LinkedNode sentinel;
    public LinkedListDeque(){
        sentinel = new LinkedNode(0,null);
        size = 0;
    }
    public LinkedListDeque(int n){
        sentinel = new LinkedNode(0,null);
        sentinel.next = new LinkedNode(n,null);
            size = 1;
    }
    public int size(){
        return size;
    }
    public void addFirst(int n){
        sentinel.next = new LinkedNode(n, sentinel.next);
        size ++;
    }
    public void addLast(int n){
        size++;
    }
    public void removeFirst(){
    size--;
    }
    public void removeLast(){
    size--;
    }
    public int get(int index){

        return index;
    }
    public int getRecursive(int index){
        LinkedNode Node = sentinel.next;
        return getRecursiveHelper(index,Node);
    }
    private int getRecursiveHelper(int index, LinkedNode l){

    return index;
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }
}

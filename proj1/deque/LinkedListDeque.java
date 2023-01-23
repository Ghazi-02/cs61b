package deque;

public class LinkedListDeque<Type> {

    private class LinkedNode {
        public LinkedNode prev;
        public Type item;
        public LinkedNode next;
        public LinkedNode(Type i, LinkedNode n){
            item = i;
            next = n;

        }
    }
    private int size;
    private LinkedNode sentFront;
    private LinkedNode sentBack;
    public LinkedListDeque(){
        sentFront = new LinkedNode(null,null);
        sentBack = new LinkedNode(null,null);
        size = 0;
    }
    public LinkedListDeque(Type n){
        sentFront = new LinkedNode(null,null);
        sentBack = new LinkedNode(null,null);
        sentFront.next = new LinkedNode(n,null);
        sentBack.next =  new LinkedNode(sentFront.next.item,null);
        size = 1;
    }
    public int size(){
        return size;
    }
    public void addFirst(Type n){
    sentFront.next = new LinkedNode(n,sentFront.next);
    //sentBack.next = new LinkedNode(sentFront.next.item,sentBack.next);
    size ++;
    }
    public void addLast(Type n){
        sentBack.next = new LinkedNode(n,null);
        sentBack = sentBack.next;
        size++;

    }
    public Type removeFirst() {
        if (size == 0  ){
            return null;
        }

        Type removed = sentFront.next.item;

        sentFront.next = new LinkedNode(null, sentFront.next);
        size--;
        return removed;
    }
    public Type removeLast(){
        if (size == 0){
            return null;
        }
        size--;
    sentBack.next = new LinkedNode(null,sentBack.next);
    return sentBack.next.item;
    }
    public Type get(int index){
        LinkedNode l = sentFront.next;
        for (int i = 0; i <= index ; i++){
            l = l.next;
        }
        return l.item;
    }
    public int getRecursive(int index){
        LinkedNode Node = sentFront.next;
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

    public void printDeque(){
        System.out.print(this);
        System.out.println();
    }
}

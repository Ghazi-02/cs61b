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

    int size = 0;
    public LinkedNode first;
    public LinkedListDeque(int n){
        first = new LinkedNode(n,null);
    }
    public int size(){
        return size;
    }
    public void addFirst(int n){

    }
    public void addLast(int n, LinkedListDeque l){

    }
    public void removeFirst(int n, LinkedListDeque l){

    }
    public void removeLast(int n, LinkedListDeque l){

    }
    public int get(int index,LinkedListDeque l){

    return index;
    }
}

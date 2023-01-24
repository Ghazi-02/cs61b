package deque;

import javax.script.ScriptEngine;

public class LinkedListDeque<T> {

    private class LinkedNode {
        public LinkedNode prev;
        public T item;
        public LinkedNode next;

        public LinkedNode(LinkedNode p, T i, LinkedNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    private LinkedNode sentinel;

    public LinkedListDeque() {
        sentinel = new LinkedNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        // SENTINEL.PREV => LAST.NEXT
        // LAST.NEXT => SENTINEL.NEXT
        size = 0;
    }

    /* public LinkedListDeque(T n) {
         sentFront = new LinkedNode(null,null, null);
         sentBack = new LinkedNode(null,null, null);
         sentFront.next = new LinkedNode(null,n ,null);
         sentBack.next = new LinkedNode(null,sentFront.next.item, null);
         size = 1;
     }
 */
    public int size() {
        return size;
    }

    public void addFirst(T n) {
        sentinel.next = new LinkedNode(sentinel, n, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }


    public T removeFirst() {
        if (size == 0){
            return null;
        }
        LinkedNode First = sentinel.next;
        T FirstItem = First.item;
        sentinel.next = sentinel.next.next;
        size--;
        return FirstItem;
    }

    public void addLast(T n) {

        sentinel.prev = new LinkedNode(sentinel.prev.prev.next, n, sentinel);
        sentinel.prev.prev.next = sentinel.prev;

        size++;

    }

    public T removeLast() {
        if (size == 0){
            return null;
        }

        T LastItem = sentinel.prev.item;

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        size--;
        return LastItem;

    }

    public T get(int index) {
        LinkedNode l = sentinel.next;
        for (int i = 0; i < index; i++) {
            l = l.next;
        }
        return l.item;
    }

    public T getRecur(int index) {
        LinkedNode l = sentinel.next;
        return getRecurHelper(index, l,0);
    }
    public T getRecurHelper(int index, LinkedNode l,int count){
     if    (count == index){
         return l.item;
     }else{
         return getRecurHelper(index,l.next,count + 1);
     }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String printDeque() {
        LinkedNode l = sentinel.next;
        String repr = "";
        while (l != sentinel) {
            repr = repr + " " + l.item;
            l = l.next;
        }

        return repr;

    }

    public void main(String[] args) {

    }
}
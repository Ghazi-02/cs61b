package deque;

import javax.script.ScriptEngine;
import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T> {

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

    public T getRecursive(int index) {
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

    public  void printDeque() {
        LinkedNode l = sentinel.next;
        String repr = "";
        while (l != sentinel) {

            repr = repr + " " + l.item;

            l = l.next;
        }

        System.out.println(repr);

    }
    @Override
    public String toString() {
        LinkedNode l = sentinel.next;
        String repr = "";
        while (l != sentinel) {

            repr = repr + " " + l.item;

            l = l.next;
        }

        return repr;

    }
    @Override
    public Iterator<T> iterator(){
        return new SetLinkedListDequeIterator();
    }
    private class SetLinkedListDequeIterator implements Iterator<T>{
        private LinkedNode p;

        public SetLinkedListDequeIterator(){
            p=sentinel;
        }
        @Override
        public boolean hasNext(){
            return p.next != sentinel;
        }
        @Override
        public T next(){
            T returnedItem = p.next.item;
            p = p.next;
            return returnedItem;

        }
    }
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        LinkedListDeque<T> o = (LinkedListDeque<T>) other;
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
    public void main(String[] args) {

    }
}
package algorithm_structure.structure;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: dell
 * @Date: 2019/8/2 9:33
 */
public class MyLinkedList<T> implements Iterable<T> {

    private int theSize = 0;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int idx, T x) {
        addBefore(getNode(idx, 0, size()), x);
    }

    public T get(int idx) {
        return getNode(idx).data;
    }

    public T set(int idx, T newVal) {
        Node<T> p = getNode(idx);
        T oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public T remove(int idx) {
        return remove(getNode(idx));
    }

    /**
     * Adds an item to this collection, at specified position p.
     * Items at or after that position are slid one position higher
     * 在当前节点前增加链表节点
     *
     * @param p Node to add before
     * @param x any object
     * @throws IndexOutOfBoundsException if idx is not between 0 and size().
     */
    private void addBefore(Node<T> p, T x) {
//        Node<T> newNode = new Node<>(x, p.prev, p);
////        p.prev.next = newNode;
////        p.prev = newNode;
        p.prev = p.prev.next = new Node<>(x, p.prev, p);
        theSize++;
        modCount++;
    }

    /**
     * Removes the object contained in Node p.
     *
     * @param p the Node containing the object
     * @return the item was removed from the collection.
     */
    private T remove(Node<T> p) {
        p.prev.next = p.next;
        p.next.prev = p.prev;
        theSize--;
        modCount++;
        return p.data;
    }

    /**
     * Gets the Node at position idx, which must range from 0 to size() - 1
     * @param idx index to search at
     * @return internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not
     * between 0 and size() - 1, inclusive.
     */
    private Node<T> getNode(int idx){
        return getNode(idx, 0, size() - 1);
    }

    /***
     * Gets the Node at position idx, which must range from lower to upper
     * @param idx index to search at
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corresponding to idx.
     * @throws IndexOutOfBoundsException if idx is not
     * between 0 and size() - 1, inclusive.
     */
    private Node<T> getNode(int idx, int lower, int upper){
        Node<T> p;

        if(idx < lower || idx > upper){
            throw new IndexOutOfBoundsException();
        }
        if(idx < size() / 2){
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        }else{
            p = endMarker;
            for (int i = size(); i > idx ; i--) {
                p = p.prev;
            }
        }
        return p;
    }



    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public T next() {
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }


    private void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<T>(null, beginMarker, null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount++;
    }
}

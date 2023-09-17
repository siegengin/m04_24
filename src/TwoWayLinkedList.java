import java.util.NoSuchElementException;

public class TwoWayLinkedList<E> implements MyList<E> {
    private Node<E> head, tail;
    private int size = 0;

    // Node class for the doubly linked list
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            element = e;
        }
    }

    public TwoWayLinkedList() {
    }

    public TwoWayLinkedList(E[] objects) {
        for (E object : objects) {
            addLast(object);
        }
    }

    public E getFirst() {
        if (size == 0) return null;
        return head.element;
    }

    public E getLast() {
        if (size == 0) return null;
        return tail.element;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        if (head != null) head.previous = newNode;
        head = newNode;
        size++;

        if (tail == null) tail = head;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(e);
        else if (index == size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) current = current.next;

            Node<E> newNode = new Node<>(e);
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
            size++;
        }
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    public E removeFirst() {
        if (size == 0) return null;

        Node<E> temp = head;
        head = head.next;
        if (head != null) head.previous = null;
        size--;

        if (size == 0) tail = null;

        return temp.element;
    }

    public E removeLast() {
        if (size == 0) return null;

        Node<E> temp = tail;
        tail = tail.previous;
        if (tail != null) tail.next = null;
        size--;

        if (size == 0) head = null;

        return temp.element;
    }

    // Other methods like get, indexOf, lastIndexOf, set, contains, etc. remain similar
    // ...

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public java.util.ListIterator<E> iterator() {
        return new TwoWayLinkedListIterator();
    }

    @Override
    public void clear() {

    }

    public java.util.ListIterator<E> listIterator() {
        return new TwoWayLinkedListIterator();
    }

    public java.util.ListIterator<E> listIterator(int index) {
        TwoWayLinkedListIterator iterator = new TwoWayLinkedListIterator();
        for (int i = 0; i < index; i++) iterator.next();
        return iterator;
    }

    private class TwoWayLinkedListIterator implements java.util.ListIterator<E> {
        private Node<E> current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E e = current.element;
            current = current.next;
            index++;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return current.previous != null;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.previous;
            index--;
            return current.element;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }

        // Other methods like nextIndex, previousIndex, add, set, and remove need to be implemented.
        // ...
    }
}

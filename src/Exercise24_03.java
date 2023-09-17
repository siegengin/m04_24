import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Collection;

public class Exercise24_03 {
    public static void main(String[] args) {
        new Exercise24_03();
    }

    public Exercise24_03() {
        TwoWayLinkedList<Double> list = new TwoWayLinkedList<>();
        System.out.print("Enter five numbers: ");
        Scanner input = new Scanner(System.in);
        double[] v = new double[5];
        for (int i = 0; i < 5; i++)
            v[i] = input.nextDouble();

        list.add(v[1]);
        list.add(v[2]);
        list.add(v[3]);
        list.add(v[4]);
        list.add(0, v[0]);
        list.add(2, 10.55);
        list.remove(3);

        java.util.ListIterator<Double> iterator1 = list.listIterator();
        System.out.print("The list in forward order: ");
        while (iterator1.hasNext())
            System.out.print(iterator1.next() + " ");

        java.util.ListIterator<Double> iterator2 = list.listIterator(list.size() - 1);
        System.out.print("\nThe list in backward order: ");
        while (iterator2.hasPrevious())
            System.out.print(iterator2.previous() + " ");
    }
}

interface MyList<E> extends java.util.Collection<E> {
    /** Add a new element at the specified index in this list */
    public void add(int index, E e);

    /** Return the element from this list at the specified index */
    public E get(int index);

    /** Return the index of the first matching element in this list.
     *  Return -1 if no match. */
    public int indexOf(Object e);

    /** Return the index of the last matching element in this list
     *  Return -1 if no match. */
    public int lastIndexOf(E e);

    /** Remove the element at the specified position in this list
     *  Shift any subsequent elements to the left.
     *  Return the element that was removed from the list. */
    public E remove(int index);

    /** Replace the element at the specified position in this list
     *  with the specified element and returns the new set. */
    public E set(int index, E e);

    @Override /** Add a new element at the end of this list */
    public default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override /** Return true if this list contains no elements */
    public default boolean isEmpty() {
        return size() == 0;
    }

    @Override /** Remove the first occurrence of the element e
     *  from this list. Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    public default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }

    @Override
    public default boolean containsAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean addAll(Collection<? extends E> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean removeAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default boolean retainAll(Collection<?> c) {
        // Left as an exercise
        return true;
    }

    @Override
    public default Object[] toArray() {
        // Left as an exercise
        return null;
    }

    @Override
    public default <T> T[] toArray(T[] array) {
        // Left as an exercise
        return null;
    }
}


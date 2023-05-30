package by.it.group151051.goron.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListB<T> implements List<T>{
    private int currCapacity = 10;
    private int listSize = 0;
    private Object[] currList;

    public ListB() {
        currList = new Object[currCapacity];
    }

    public boolean add(T element) {
        if (listSize == currCapacity) {
            updateCapacity();
        }

        currList[listSize] = element;
        ++listSize;
        return true;
    }

    public T remove(int index) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T remElem = (T) currList[index];

        if (index == 0) {
            Object[] newList = new Object[currCapacity];
            System.arraycopy(currList, 1, newList, 0, listSize - 1);
            currList = newList;
        }
        else if (index == listSize - 1) {
            currList[index] = null;
        }
        else {
            for (int i = index; i < listSize - 1; ++i) {
                currList[i] = currList[i + 1];
            }
            currList[listSize - 1] = null;
        }

        --listSize;
        return remElem;
    }

    @Override
    public T get(int index) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return (T) currList[index];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (int i = 0; i < listSize - 1; ++i) {
            str.append(get(i)).append(',').append(' ');
        }
        str.append(get(listSize - 1)).append(']');

        return str.toString();
    }

    public T set(int index, T element) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        T prevElem = (T) currList[index];
        currList[index] = element;

        return prevElem;
    }

    public void add(int index, T element) {
        if (index >= currCapacity || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (listSize == currCapacity) {
            updateCapacity();
        }

        for (int i = listSize; i > index; --i) {
            currList[i] = currList[i - 1];
        }

        ++listSize;
        currList[index] = element;
    }

    public boolean addAll(Collection<? extends T> addedList) {
        for (T elem : addedList) {
            add(elem);
        }

        return true;
    }

    private void updateCapacity() {
        currCapacity = ((3 * currCapacity) / 2) + 1;
        Object[] newList = new Object[currCapacity];
        System.arraycopy(currList, 0, newList, 0, listSize);
        currList = newList;
    }


    /////////////////////////////////////////////////////////////////////////
    //////////         Необязательные к реализации методы          //////////
    /////////////////////////////////////////////////////////////////////////


    public int size() {
        return listSize;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
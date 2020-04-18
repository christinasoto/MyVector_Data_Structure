/**
 *Extends into MyAbstractList to create a structure that behaves like a
 * dynamically allocated vector
 *
 * JDK version: 8.0.0
 *
 * @author Christina Soto
 *  * @version 8.0.0
 *  * @since 04-18-2020
 */

import java.util.Arrays;

public class MyVector<E> extends MyAbstractList<E> {


    private E array[];
    int size;
    private int increment;
    int capIncrement = 5;

    int INITIAL_CAPACITY_INCREMENT;

    @SuppressWarnings("unchecked")
    public MyVector() {
        array = (E[]) new Object[10];
        size = 0;//
        increment = 0;//
    }
    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = 0;
    }
    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity, int capIncrement) {
        array = (E[]) new Object[initCapacity];
        size = 0;
        increment = capIncrement;

    }
//assigns increment to inital value and allows to grow based on input
    public int getCapacity() {
        if(array.length == 10)
        increment = INITIAL_CAPACITY_INCREMENT = 5;
        else
            increment = 4*capIncrement;

        return array.length;

    }

    public int getIncrement() {
        return increment;
    }

    public boolean add(E data) {
        return add(size, data);
    }
    @SuppressWarnings("unchecked")
//clears vector capcity
    public void clear() {
        int capacity = getCapacity();
        array = (E[]) new Object[capacity];
        size = 0;

    }

    public boolean contains(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data))
                return true;
        }
        return false;

    }

    public E get(int index) {
        return array[index];
    }

    public int indexOf(E data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data))
                return i;
        }

        return -1;
    }

    public int lastIndexOf(E data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data))
                return i;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;

    }

    public E remove(int index) throws IndexOutOfBoundsException {

        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        E data = array[index];
        for (int i = index; i < size - 1; i++)
            array[i] = array[i + 1];
        array[size] = null;
        size -= 1;
        return data;

    }

    public void trimToSize() {
        if (size < getCapacity()) {
            array = Arrays.copyOf(array, size);
        }
    }

    public int size() {

        return size;

    }

    //allows vector to grow dynamically
    public boolean add(int index, E data) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();

        int capacity = getCapacity();
        increment = capacity - size;

        if (size >= capacity) {
            if (increment == 0)
                array = Arrays.copyOf(array, array.length * 2); //
            else
                array = Arrays.copyOf(array, array.length + increment);

        }

                for (int i = size - 1; i >= index; i--)
                    array[i + 1] = array[i];
            array[index] = data;
            size += 1;

            return true;

        }

    public String toString() {
        int i;

        if (size < getCapacity()) {
            array = Arrays.copyOf(array, size);
        }
        String result = Arrays.toString(array);


        return result;

    }
}



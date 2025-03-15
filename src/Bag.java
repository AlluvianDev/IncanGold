public class Bag<T> implements IBag<T>{
    int size;
    int capacity = 30;
    Object[] array;

    @Override
    public boolean add(T newEntry) {
        array[size] = newEntry;
        size++;
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0; //return true if empty
    }

    @Override
    public boolean isFull() {
        return size >= capacity; //return true if full
    }

    @Override
    public T removeByIndex(int index) {

        return null;
    }

    @Override
    public boolean remove(T anEntry) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        return 0;
    }

    @Override
    public int getIndexOf(T anEntry) {
        return 0;
    }

    @Override
    public boolean contains(T anEntry) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public void displayItems() {

    }

    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public T[] toArray() {
        return null;
    }
}

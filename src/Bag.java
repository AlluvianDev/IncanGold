public class Bag<T> implements IBag<T>{


    @Override
    public boolean add(T newEntry) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
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

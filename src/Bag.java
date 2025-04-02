public class Bag<T> implements IBag<T> {
    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    @SuppressWarnings("unchecked")
    public Bag() {
        this.bag = (T[]) new Object[DEFAULT_CAPACITY];
        this.numberOfEntries = 0;
    }

    @SuppressWarnings("unchecked")
    public Bag(int capacity) {
        if (capacity <= 0) {
            this.bag = (T[]) new Object[DEFAULT_CAPACITY];
        } else if (capacity > MAX_CAPACITY) {
            this.bag = (T[]) new Object[MAX_CAPACITY];
        } else {
            this.bag = (T[]) new Object[capacity];
        }
        this.numberOfEntries = 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            doubleCapacity();
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    @SuppressWarnings("unchecked")
    private void doubleCapacity() {
        int newCapacity = 2 * bag.length;
        if (newCapacity > MAX_CAPACITY) {
            newCapacity = MAX_CAPACITY;
        }
        T[] newBag = (T[]) new Object[newCapacity];
        for (int i = 0; i < numberOfEntries; i++) {
            newBag[i] = bag[i];
        }
        bag = newBag;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries >= bag.length;
    }

    @Override
    public T removeByIndex(int index) {
        if (index < 0 || index >= numberOfEntries) {
            return null;
        }
        T result = bag[index];
        bag[index] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index >= 0) {
            removeByIndex(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        return removeByIndex(numberOfEntries - 1);
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) >= 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < numberOfEntries; i++) {
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    @Override
    public void displayItems() {
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.println(bag[i]);
        }
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }
}
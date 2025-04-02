import java.util.Arrays;

public class Bag<T> implements IBag<T> {
    private T[] bagArray;
    private int size;

    public Bag(Class<T> clazz) {
        bagArray = (T[]) java.lang.reflect.Array.newInstance(clazz, 10);
        size = 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            resize();
        }
        bagArray[size++] = newEntry;
        return true;
    }

    private void resize() {
        bagArray = Arrays.copyOf(bagArray, bagArray.length * 2);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == bagArray.length;
    }

    @Override
    public T removeByIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        T removedItem = bagArray[index];
        for (int i = index; i < size - 1; i++) {
            bagArray[i] = bagArray[i + 1];
        }
        size--;
        return removedItem;
    }

    @Override
    public boolean remove(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (bagArray[i].equals(anEntry)) {
                removeByIndex(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T removedItem = bagArray[size - 1];
        size--;
        return removedItem;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (bagArray[i].equals(anEntry)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int getIndexOf(T anEntry) {
        for (int i = 0; i < size; i++) {
            if (bagArray[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) != -1;
    }

    @Override
    public void clear() {
        Arrays.fill(bagArray, 0, size, null);
        size = 0;
    }

    @Override
    public void displayItems() {
        for (int i = 0; i < size; i++) {
            System.out.println(bagArray[i]);
        }
    }
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return bagArray[index];
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOf(bagArray, size);
    }
}

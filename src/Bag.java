import java.lang.reflect.Array;
import java.util.Arrays;

public class Bag<T> implements IBag<T>{
    int size = 0;
    int capacity = 30;
    Object[] array;

    @SuppressWarnings("unchecked")
    public Bag(Class<T> clazz){
        this.array = (T[]) Array.newInstance(clazz, capacity);
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            return false;
        }
        array[size] = newEntry;
        size++;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0; //return true if empty
    }

    @Override
    public boolean isFull() {
        return size >= capacity; //return true if full
    }

    @SuppressWarnings("unchecked")
    public T removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        T removedElement = (T) array[index]; // Store the element to return

        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null; // Null out the last position
        size--; // Reduce size after shifting

        return removedElement;
    }

    @Override
    public boolean remove(T anEntry) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(anEntry)){
                for(int j = 0; j < size - i - 1; j++){
                    array[i + j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size--;
                break;
            }

        }
        return false;
    }

    @Override
    public T remove() {

        return null;
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;
        for (int i = 0; i < size ; i++){
            if (array[i].equals(anEntry)){
                frequency += 1;
            }
        }
        return frequency;
    }

    @Override
    public int getIndexOf(T anEntry) {
        for (int i = 0; i < size ; i++){
            if (array[i].equals(anEntry)){
                return i; //found index
            }
        }
        return -1; // not found
    }

    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < size ; i++){
            if (array[i].equals(anEntry)){
                return true; //contains
            }
        }
        return false; //doesn't contain
    }

    @Override
    public void clear() {
        for (int i = 0; i < size ; i++){
            array[i] = null;
        }
    }

    @Override
    public void displayItems() {
        if (size == 0) {
            System.out.println("Bag is empty.");
            return;
        }
        System.out.println("Contents of the bag:");
        for (int i = 0; i < size; i++) {
            System.out.println("Item " + (i + 1) + ": " + array[i]);
        }
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) Arrays.copyOf(array, size);
    }

}


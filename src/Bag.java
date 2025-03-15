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
        String string = "";
        for(int i = 0; i < size; i++ ) {
            string += array[i] + ",";
        }
        System.out.println(string);
    }

    @Override
    public int getCurrentSize() {
        return size;
    }

    @Override
    public T[] toArray() {

            T[] result = (T[]) new Object[size];
            System.arraycopy(array, 0, result, 0, size);
            return result;
        }
    }


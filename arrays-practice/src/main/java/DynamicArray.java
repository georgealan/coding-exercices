public class DynamicArray {
    int capacity;
    int length;
    int[] array;

    public DynamicArray() {
        capacity = 2;
        length = 0;
        array = new int[2];
    }

    // Insert n in the last position of the array
    public void pushBack(int number) {
        if (length == capacity) {
            this.resize();
        }
        // Insert at next empty position
        array[length] = number;
        length++;
    }

    public void resize() {
        // Create new array of double capacity
        capacity = 2 * capacity;
        int[] newArray = new int[capacity];

        // Copy elements to nextArray
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    // Remove the last element in the array
    public void popBack() {
        if (length > 0) {
            length--;
        }
    }

    // Get value at i-th index
    public int get(int i) {
        if (i < length) {
            return array[i];
        }
        // Here we would throw an out of bound exception
        return -1;
    }

    // Insert n at i-th index
    public void insert(int index, int number) {
        if (index < length) {
            array[index] = number;
            return;
        }
        return;
        // Here we would throw an out of bound exception
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {

    }
}

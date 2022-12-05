import java.lang.reflect.Array;
import java.util.Arrays;


public class StaticArray {
    public static void main(String[] args) throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = new int[7];
        System.out.println(arr2.length);
        printArr(arr2, arr2.length);

        System.out.println("Array before remove at end");
        printArr(arr1, arr1.length);

        System.out.println("Array after removed at end");
        removeAtEnd(arr1, arr1.length);
        printArr(arr1, arr1.length);

        System.out.println("Array after insert at middle");
        insertAtMiddle(arr1, 2, 7, arr1.length);
        printArr(arr1, arr1.length);

        System.out.println("Array after remove at middle");
        removeAtMiddle(arr1, 4, arr1.length);
        printArr(arr1, arr1.length);

        System.out.println("Array after remove at end");
        insertAtEnd(arr1, 15, arr1.length - 1, arr1.length);
        printArr(arr1, arr1.length);
    }

    static void insertAtEnd(int[] arr, int number, int length, int capacity) {
        if (length < capacity) {
            arr[length] = number;
        }
    }

    static void removeAtEnd(int[] arr, int length) {
        if (length > 0) {
            arr[length - 1] = 0;
            length--;
        }
    }

    static void insertAtMiddle(int[] arr, int positionIndexForInsertion, int number, int length) throws Exception {
        if (positionIndexForInsertion > length) {
            throw new Exception("This index doesn't exist in this array");
        }
        for (int index = length - 1; index > positionIndexForInsertion; index--) {
            arr[index] = arr[index - 1];
        }
        arr[positionIndexForInsertion] = number;
    }

    static void removeAtMiddle(int[] arr, int positionIndexForRemove, int length) throws Exception {
        if (positionIndexForRemove > length) {
            throw new Exception("This index doesn't exist in this array");
        }
        for (int index = positionIndexForRemove + 1; index < length; index++) {
            arr[index - 1] = arr[index];
        }
        arr[length - 1] = 0;
    }

    static void printArr(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }
}

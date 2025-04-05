package com.gunapvkn.dsa.arrays.basics.coreoperations;

import java.util.Arrays;

public class ArrayDelete {
    // Instance variables:
    // arr: the underlying fixed-size array storage.
    // size: the current number of valid elements in the array.
    private final int[] arr;
    private int size;

    /**
     * Constructor: Initializes the ArrayDelete instance with an existing array.
     * The size is set to the length of the provided array.
     * @param arr the array from which elements can be deleted.
     */
    public ArrayDelete(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    /**
     * Deletes the element at the end of the array.
     * Checks if the array is empty. If not, it decrements the size,
     * effectively removing the last element.
     * @return the new index of the last element (size - 1), or -1 if the array is empty.
     */
    public int deleteAtEnd() {
        if (size == 0) {
            System.out.println("Array is empty");
            return -1;
        }
        // Decrement size, which removes the last element logically.
        return --size;
    }

    /**
     * Deletes the element at the beginning of the array.
     * First, it checks if the array is empty. If not, it shifts all subsequent
     * elements one position to the left, overwriting the first element.
     * Then, it decrements the size.
     * @return 0, indicating that the deletion occurred at index 0, or -1 if the array is empty.
     */
    public int deleteAtBeginning() {
        if (size == 0) {
            System.out.println("Array is empty");
            return -1;
        }
        // Shift all elements one position to the left starting from index 0.
        for (var i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        // Decrement size to reflect the deletion.
        size--;
        return 0;
    }

    /**
     * Deletes the element at the specified index.
     * Checks if the array is empty or if the index is invalid.
     * If valid, it shifts all elements after the specified index one position to the left,
     * then decrements the size.
     * @param index the index from which the element should be deleted.
     * @return the index where deletion occurred, or -1 if the array is empty or the index is invalid.
     */
    public int deleteAtIndex(int index) {
        if (size == 0) {
            System.out.println("Array is empty");
            return -1;
        }
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return -1;
        }
        // Shift elements left from the given index to remove the element.
        for (var i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return index;
    }

    /**
     * Deletes the first occurrence of the specified value from the array.
     * It searches for the value in the array. If found, it calls deleteAtIndex() to remove the element.
     * @param value the value to delete from the array.
     * @return the index from which the element was deleted, or -1 if the value is not found.
     */
    public int deleteByValue(int value) {
        var index = -1;
        // Search for the value in the array.
        for (var i = 0; i < size; i++) {
            if (arr[i] == value) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Value not found");
            return -1;
        }
        // Delete the element at the found index.
        return deleteAtIndex(index);
    }

    /**
     * Utility method to print the current state of the array.
     * Only prints elements from index 0 up to size - 1, representing the current valid elements.
     */
    public void printArray() {
        System.out.print("Current Array (size " + size + "): ");
        // Use stream to print each element up to the current size.
        Arrays.stream(arr).limit(size).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    /**
     * Main method to test all deletion operations:
     * 1. Delete element at the end.
     * 2. Delete element at the beginning.
     * 3. Delete element at a specific index.
     * 4. Delete element by its value.
     * Also demonstrates error handling when attempting deletions on an empty array or with an invalid index.
     */
    public static void main(String[] args) {
        // Initialize an array with sample values.
        int[] initialArray = {10, 20, 30, 40, 50};
        // Create an ArrayDelete instance using the initial array.
        ArrayDelete arrayDelete = new ArrayDelete(initialArray);

        // Print the initial state of the array.
        System.out.println("Initial Array:");
        arrayDelete.printArray();

        // Test 1: Delete the element at the end.
        System.out.println("\nTest: Delete at End");
        int deletedIndex = arrayDelete.deleteAtEnd();
        System.out.println("Deleted element from the end index: " + deletedIndex);
        arrayDelete.printArray();

        // Test 2: Delete the element at the beginning.
        System.out.println("\nTest: Delete at Beginning");
        deletedIndex = arrayDelete.deleteAtBeginning();
        System.out.println("Deleted element from the beginning, deletion occurred at index: " + deletedIndex);
        arrayDelete.printArray();

        // Test 3: Delete the element at index 1 (from current array state).
        System.out.println("\nTest: Delete at Index 1");
        deletedIndex = arrayDelete.deleteAtIndex(1);
        if (deletedIndex != -1) {
            System.out.println("Deleted element at index: " + deletedIndex);
        }
        arrayDelete.printArray();

        // Test 4: Delete by value. Attempt to delete the first occurrence of 30.
        System.out.println("\nTest: Delete by Value (40)");
        deletedIndex = arrayDelete.deleteByValue(40);
        if (deletedIndex != -1) {
            System.out.println("Deleted element with value 30 at index: " + deletedIndex);
        }
        arrayDelete.printArray();

        // Test 5: Attempt to delete a value that does not exist.
        System.out.println("\nTest: Delete by Value (100) - Non-existent");
        deletedIndex = arrayDelete.deleteByValue(100);
        arrayDelete.printArray();
    }
}

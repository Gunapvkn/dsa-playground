package com.gunapvkn.dsa.arrays.coreoperations;

import java.util.Arrays;

public class ArrayInsert {
    // Instance variables:
    // arr: the underlying array storage with fixed capacity.
    // size: the current number of inserted elements in the array.
    // capacity: the maximum number of elements the array can hold (set once in the constructor).
    private final int[] arr;
    private int size;
    private final int capacity;

    /**
     * Constructor: Initializes the array with a specified capacity.
     * Sets the initial size to 0.
     *
     * @param capacity the maximum number of elements that can be stored.
     */
    public ArrayInsert(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Inserts a value at the end of the array.
     * Checks if there is room to insert the value.
     * If the array is full, it prints a message and returns -1.
     * Otherwise, the value is placed at the current 'size' index, the 'size' is incremented,
     * and the index at which the value was inserted is returned.
     *
     * @param value the integer value to insert.
     * @return the index where the value was inserted, or -1 if the array is full.
     */
    public int insertAtEnd(int value) {
        if (size >= capacity) {
            System.out.println("Array is full");
            return -1;
        }
        arr[size] = value;
        // Return the current index and then increment size.
        return size++;
    }

    /**
     * Inserts a value at the beginning of the array.
     * First, it checks if there is space available.
     * If the array is full, it prints a message and returns -1.
     * Otherwise, all existing elements are shifted one position to the right to create a vacant spot at index 0.
     * Then, the new value is inserted at the beginning, the size is incremented, and 0 is returned.
     *
     * @param value the integer value to insert.
     * @return 0 if insertion is successful (value inserted at index 0), or -1 if the array is full.
     */
    public int insertAtBeginning(int value) {
        if (size >= capacity) {
            System.out.println("Array is full");
            return -1;
        }
        // Shift elements right to make room at index 0.
        for (var i = size; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = value;
        size++;
        return 0;
    }

    /**
     * Inserts a value at a specified index in the array.
     * Checks if there is room for another element and if the index is valid (between 0 and size inclusive).
     * If the array is full or the index is invalid, it prints a message and returns -1.
     * Otherwise, it shifts all elements from the given index onwards one position to the right,
     * inserts the new value at the specified index, increments the size, and returns the index.
     *
     * @param index the target position for insertion.
     * @param value the integer value to insert.
     * @return the index where the value was inserted, or -1 if insertion fails.
     */
    public int insertAtIndex(int index, int value) {
        if (size >= capacity) {
            System.out.println("Array is full");
            return -1;
        }
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return -1;
        }
        // Shift elements right from the specified index to make space.
        for (var i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
        return index;
    }

    /**
     * Updates the value at a specified index.
     * This method only allows updating elements that have already been inserted
     * (i.e., indices from 0 to size-1). If the index is invalid, a message is printed and false is returned.
     *
     * @param index the index where the update should occur.
     * @param value the new integer value to set.
     * @return true if the update is successful; false if the index is invalid.
     */
    public boolean updateValue(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return false;
        }
        arr[index] = value;
        return true;
    }

    /**
     * Utility method to print the current state of the array.
     * Only the elements from index 0 to size-1 are printed, since those have been inserted.
     */
    public void printArray() {
        System.out.print("Current Array (size " + size + "): ");
        Arrays.stream(arr).limit(size).forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    /**
     * Main method to test all core operations on the array:
     * 1. Insertion at the end.
     * 2. Insertion at the beginning.
     * 3. Insertion at a specific index.
     * 4. Updating a value at a specific index.
     * Also demonstrates error handling when the array is full or an invalid index is used.
     */
    public static void main(String[] args) {
        // Create an ArrayInsert instance with a capacity of 5.
        ArrayInsert arrayInsert = new ArrayInsert(5);

        // Test 1: Insert at the end.
        System.out.println("Test: Insert at End");
        int index = arrayInsert.insertAtEnd(10);
        System.out.println("Inserted 10 at index: " + index);
        arrayInsert.printArray();

        // Test 2: Insert at the beginning.
        System.out.println("\nTest: Insert at Beginning");
        index = arrayInsert.insertAtBeginning(20);
        System.out.println("Inserted 20 at beginning at index: " + index);
        arrayInsert.printArray();

        // Test 3: Insert at a specific index.
        System.out.println("\nTest: Insert at Index 1");
        index = arrayInsert.insertAtIndex(1, 30);
        System.out.println("Inserted 30 at index: " + index);
        arrayInsert.printArray();

        // Test 4: Update an existing element.
        System.out.println("\nTest: Update Value at Index 1");
        boolean result = arrayInsert.updateValue(1, 40);
        System.out.println("Update at index 1 was " + (result ? "successful" : "unsuccessful"));
        arrayInsert.printArray();

        // Test 5: Insert at end until the array is full.
        System.out.println("\nTest: Insert at End until Full");
        index = arrayInsert.insertAtEnd(50);
        System.out.println("Inserted 50 at index: " + index);
        index = arrayInsert.insertAtEnd(70);
        System.out.println("Inserted 70 at index: " + index);
        arrayInsert.printArray();

        // Attempt to insert when the array is full.
        System.out.println("\nTest: Attempt to Insert when Array is Full");
        index = arrayInsert.insertAtEnd(60);
        if (index == -1) {
            System.out.println("Failed to insert 60 because the array is full.");
        }
        arrayInsert.printArray();

        // Test 6: Attempt to update an invalid index (index outside current size).
        System.out.println("\nTest: Attempt to Update Invalid Index (index 5)");
        result = arrayInsert.updateValue(5, 70);
        System.out.println("Update at index 5 was " + (result ? "successful" : "unsuccessful"));
    }
}

package com.gunapvkn.dsa.queue.coreoperations;

import java.util.Arrays;

/**
 * ArrayQueue is a simple implementation of a FIFO (First In, First Out) queue using an array.
 * It supports basic operations such as enqueuing, dequeuing, checking if the queue is empty or full,
 * retrieving the front element, and printing the contents of the queue.
 */
public class ArrayQueue {
    private final int[] arr;     // Array to store queue elements
    int size, capacity;    // Current number of elements and maximum capacity of the queue

    /**
     * Constructor to initialize the queue with a specified capacity.
     * @param capacity The maximum number of elements the queue can hold.
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    /**
     * Returns the current number of elements in the queue.
     * @return The size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty; false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     * @return true if the queue is full; false otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * Retrieves the front element of the queue without removing it.
     * @return The element at the front of the queue.
     * @throws RuntimeException if the queue is empty.
     */
    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[0];
    }

    /**
     * Prints the elements of the queue from the front to the current size.
     */
    public void printQueue() {
        Arrays.stream(arr, 0, size).forEach(e -> System.out.println(e + " "));
    }

    /**
     * Adds an element to the rear of the queue.
     * @param value The element to add.
     * @throws RuntimeException if the queue is full.
     */
    public void enque(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        arr[size++] = value;
    }

    /**
     * Removes and returns the front element of the queue.
     * After removal, shifts all elements one position to the left.
     * @return The element removed from the front of the queue.
     * @throws RuntimeException if the queue is empty.
     */
    public int deque() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int element = arr[0];
        // Shift all elements left by one position
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;  // Decrement the size after removal
        return element;
    }

    /**
     * Main method to test ArrayQueue operations.
     * This method demonstrates enqueuing, dequeuing, checking status, and handling exceptions.
     */
    public static void main(String[] args) {
        // Create an instance of ArrayQueue with capacity 5.
        ArrayQueue queue = new ArrayQueue(5);

        // Test 1: Check the initial state of the queue (should be empty).
        System.out.println("Test 1: Is the queue empty? " + queue.isEmpty());

        // Test 2: Enqueue several elements into the queue.
        System.out.println("\nTest 2: Enqueuing elements: 10, 20, 30, 40, 50");
        queue.enque(10);
        queue.enque(20);
        queue.enque(30);
        queue.enque(40);
        queue.enque(50);

        // Test 3: Verify the queue size and if the queue is full.
        System.out.println("\nTest 3: Queue size: " + queue.size());
        System.out.println("Is the queue full? " + queue.isFull());

        // Test 4: Print the current contents of the queue.
        System.out.println("\nTest 4: Current queue contents:");
        queue.printQueue();

        // Test 5: Retrieve the front element of the queue (should be 10).
        System.out.println("\nTest 5: Front element: " + queue.getFront());

        // Test 6: Dequeue an element (should remove and return 10).
        System.out.println("\nTest 6: Dequeued element (expected 10): " + queue.deque());

        // Test 7: Print the queue contents after one dequeue to verify the order.
        System.out.println("\nTest 7: Queue contents after one deque:");
        queue.printQueue();

        // Test 8: Dequeue all remaining elements until the queue is empty.
        System.out.println("\nTest 8: Dequeuing all remaining elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.deque());
        }

        // Test 9: Attempt to dequeue from an empty queue to trigger an exception.
        System.out.println("\nTest 9: Attempting to dequeue from an empty queue:");
        try {
            queue.deque();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test 10: Attempt to get the front element from an empty queue.
        System.out.println("\nTest 10: Attempting to get the front element from an empty queue:");
        try {
            queue.getFront();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test 11: Refill the queue with new elements and print its contents.
        System.out.println("\nTest 11: Enqueuing new elements: 60, 70");
        queue.enque(60);
        queue.enque(70);
        System.out.println("Queue contents:");
        queue.printQueue();

        // Test 12: Create a new small queue to test exception handling for a full queue.
        System.out.println("\nTest 12: Testing enqueue exception when queue is full:");
        ArrayQueue smallQueue = new ArrayQueue(2);
        smallQueue.enque(100);
        smallQueue.enque(200);
        try {
            smallQueue.enque(300);
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}

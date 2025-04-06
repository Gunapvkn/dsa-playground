package com.gunapvkn.dsa.queue.coreoperations;

import java.util.NoSuchElementException;

/**
 * LinkedListQueue is a simple implementation of a FIFO (First In, First Out) queue using a singly linked list.
 * It supports basic operations such as enqueuing, dequeuing, checking if the queue is empty,
 * retrieving the front element, and printing the contents of the queue.
 */
public class LinkedListQueue {

    private Node head; // Reference to the first node in the queue (front of the queue)
    private int size;  // Current number of elements in the queue
    private Node tail; // Reference to the last node in the queue (rear of the queue)

    /**
     * Inner static class representing a node in the linked list.
     */
    static class Node {
        int value;  // The integer value stored in the node
        Node next;  // Reference to the next node in the list

        /**
         * Constructor to create a new node with a specified value.
         * @param value The value to be stored in the node.
         */
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * Returns the number of elements currently in the queue.
     * @return The size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retrieves the element at the front of the queue without removing it.
     * @return The value of the front element.
     * @throws RuntimeException if the queue is empty.
     */
    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return head.value;
    }

    /**
     * Prints the elements of the queue from front to rear.
     */
    public void printQueue() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println(); // New line for better readability
    }

    /**
     * Adds an element to the rear of the queue.
     * @param value The value to be added to the queue.
     */
    public void enque(int value) {
        Node newNode = new Node(value);
        // If the queue is empty, the new node is both the head and tail.
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // Attach the new node to the end of the queue and update the tail.
            tail.next = newNode;
            tail = newNode;
        }
        size++; // Increase the size after adding an element
    }

    /**
     * Removes and returns the element at the front of the queue.
     * After removal, the head is updated to the next node.
     * @return The value of the dequeued element.
     * @throws RuntimeException if the queue is empty.
     */
    public int deque() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int element = head.value;
        head = head.next; // Move the head to the next element
        size--;         // Decrement the size after removal

        // If the queue becomes empty, reset the tail to null.
        if (isEmpty()) {
            tail = null;
        }
        return element;
    }

    /**
     * Main method to test the LinkedListQueue operations.
     * This method demonstrates enqueuing, dequeuing, checking status, and handling exceptions.
     */
    public static void main(String[] args) {
        // Create an instance of LinkedListQueue.
        LinkedListQueue queue = new LinkedListQueue();

        // Test 1: Check initial state of the queue (should be empty).
        System.out.println("Test 1: Is the queue empty? " + queue.isEmpty());

        // Test 2: Enqueue several elements into the queue.
        System.out.println("\nTest 2: Enqueuing elements: 10, 20, 30, 40, 50");
        queue.enque(10);
        queue.enque(20);
        queue.enque(30);
        queue.enque(40);
        queue.enque(50);

        // Test 3: Check queue size and print its contents.
        System.out.println("\nTest 3: Queue size: " + queue.size());
        System.out.println("Queue contents:");
        queue.printQueue();

        // Test 4: Retrieve the front element (should be 10).
        System.out.println("\nTest 4: Front element: " + queue.getFront());

        // Test 5: Dequeue an element (should remove and return 10).
        System.out.println("\nTest 5: Dequeued element (expected 10): " + queue.deque());

        // Test 6: Print queue contents after one dequeue.
        System.out.println("\nTest 6: Queue contents after one dequeue:");
        queue.printQueue();

        // Test 7: Dequeue all remaining elements.
        System.out.println("\nTest 7: Dequeuing all remaining elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.deque());
        }

        // Test 8: Attempt to dequeue from an empty queue to check exception handling.
        System.out.println("\nTest 8: Attempting to dequeue from an empty queue:");
        try {
            queue.deque();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test 9: Attempt to get the front element from an empty queue.
        System.out.println("\nTest 9: Attempting to get the front element from an empty queue:");
        try {
            queue.getFront();
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Test 10: Enqueue additional elements to verify the queue is reusable.
        System.out.println("\nTest 10: Enqueuing new elements: 60, 70");
        queue.enque(60);
        queue.enque(70);
        System.out.println("Queue contents:");
        queue.printQueue();
    }
}

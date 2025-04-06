package com.gunapvkn.dsa.stack.coreoperations;

import java.util.Arrays;

/**
 * A simple fixed‑capacity stack implemented with an int array.
 * Supports push, pop, peek, size, isEmpty and print operations.
 */
public class ArrayStack {

    /** Backing array that stores the elements */
    private final int[] arr;

    /** Index of the current top element; -1 means the stack is empty */
    private int top;

    /** Maximum number of elements the stack can hold */
    private final int capacity;

    /**
     * Creates a new stack with the given capacity.
     *
     * @param capacity maximum number of elements allowed
     */
    public ArrayStack(int capacity) {
        this.arr = new int[capacity];
        this.top = -1;
        this.capacity = capacity;
    }

    /** @return the number of elements currently in the stack */
    public int size() {
        return top + 1;
    }

    /** @return {@code true} if the stack has no elements */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Pushes a value onto the stack.
     * If the stack is full, prints a warning and does nothing.
     *
     * @param value value to push
     */
    public void push(int value) {
        if (size() == capacity) {
            System.out.println("Stack is full (overflow)");
            return;
        }
        arr[++top] = value;
    }

    /**
     * Removes and returns the top value.
     *
     * @throws RuntimeException if the stack is empty (underflow)
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty (underflow)");
        }
        return arr[top--];
    }

    /**
     * Returns (but does not remove) the top value.
     *
     * @throws RuntimeException if the stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    /** Prints the current stack contents from bottom to top. */
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Arrays.stream(arr, 0, top + 1).forEach(v -> System.out.print(v + " "));
        System.out.println();
    }

    /** Quick demo / sanity test for all operations */
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);

        System.out.println("Initially empty? " + stack.isEmpty()); // true

        // Push three values (normal case)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.print("After 3 pushes: ");
        stack.printStack(); // 10 20 30

        // Attempt overflow
        stack.push(40); // should print overflow warning

        // Peek at the top element
        System.out.println("Peek: " + stack.peek()); // 30

        // Pop all elements
        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Pop: " + stack.pop()); // 20
        System.out.println("Pop: " + stack.pop()); // 10

        // Attempt underflow
        try {
            stack.pop();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // underflow message
        }

        System.out.println("Empty after pops? " + stack.isEmpty()); // true
    }
}

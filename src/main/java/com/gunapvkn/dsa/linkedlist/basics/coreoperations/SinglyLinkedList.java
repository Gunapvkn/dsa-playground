package com.gunapvkn.dsa.linkedlist.basics.coreoperations;

/**
 * A simple implementation of a singly‑linked list that supports the most common
 * operations required in coding interviews and day‑to‑day development.
 *
 * <p>The list keeps track of its <code>head</code> pointer and a <code>size</code>
 * counter so that <code>isEmpty()</code> and boundary checks run in O(1) time.
 *
 * <p>The public API purposefully mirrors the usual verb‑nomenclature used in
 * textbooks: <em>insert</em> and <em>delete</em> at the <em>beginning</em>,
 * <em>last</em>, or an arbitrary <em>position</em>.
 */
public class SinglyLinkedList {

    /** Pointer to the first node (null when the list is empty). */
    private Node head;

    /** Cached length of the list – keeps every operation O(1) for size checks. */
    private int size;

    // ───────────────────────────────────────────────── Constructors ────────────

    public SinglyLinkedList() {
        // empty list ⇒ head == null && size == 0
    }

    // ──────────────────────────────────────────────── State helpers ───────────

    /**
     * @return <code>true</code> when the list has no elements, otherwise
     *         <code>false</code>.
     */
    public boolean isEmpty() {
        return size == 0; // equivalent to (head == null) but O(1) & crystal‑clear
    }

    // ─────────────────────────────────────────────────── Insertions ────────────

    /** Inserts a node at the very front in O(1). */
    public void insertAtBeginning(int value) {
        var newNode = new Node(value);
        newNode.next = head; // new node now points to former head
        head = newNode;      // head re‑points to the new node
        size++;
    }

    /** Inserts a node at the tail in O(n). */
    public void insertAtLast(int value) {
        if (isEmpty()) {
            insertAtBeginning(value);
            return;
        }

        var current = head;
        while (current.next != null) {
            current = current.next; // walk to last node
        }
        current.next = new Node(value);
        size++;
    }

    /**
     * Inserts a node at a 1‑based position.
     * @param position 1 ≤ position ≤ size + 1
     */
    public void insertAtPosition(int position, int value) {
        if (position == 1) {
            insertAtBeginning(value);
            return;
        }
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid Position");
            return;
        }

        var newNode = new Node(value);
        var current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next; // stop at (position‑1)th node
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // ─────────────────────────────────────────────────── Deletions ────────────

    /** Deletes the head node in O(1). */
    public void deleteAtBeginning() {
        if (isEmpty()) {
            System.out.println("Linked List Is Empty");
            return;
        }
        head = head.next;
        size--;
    }

    /** Deletes the tail node in O(n). */
    public void deleteAtLast() {
        if (isEmpty()) {
            System.out.println("Linked List Is Empty");
            return;
        }
        if (size == 1) {
            head = null;
            size--; // adjust size when the single node is removed
            return;
        }

        var current = head;
        while (current.next.next != null) {
            current = current.next; // stop at second‑last node
        }
        current.next = null;
        size--;
    }

    /**
     * Deletes the node at a 1‑based position.
     * @param position 1 ≤ position ≤ size
     */
    public void deleteAtPosition(int position) {
        if (position == 1) {
            deleteAtBeginning();
            return;
        }
        if (position < 1 || position > size) {
            System.out.println("Invalid Position");
            return;
        }

        var current = head;
        for (var i = 1; i < position - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next; // unlink the node
        size--;
    }

    // ─────────────────────────────────────────────────── Utilities ────────────

    /** Prints the list contents from head to tail. */
    public void printList() {
        var current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    /** @return current number of nodes (handy for tests). */
    public int size() {
        return size;
    }

    // ─────────────────────────────────────────── Internal node class ──────────

    /** Package‑private static nested class to avoid leaking references. */
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}

// ──────────────────────────────────────────────── Demo / Test ────────────────

/**
 * Simple demo harness that exercises every public operation and prints the list
 * after each step so you can eyeball the result or pipe the output into a unit
 * test later.
 */
class LinkedListDemo {
    public static void main(String[] args) {
        var list = new SinglyLinkedList();

        System.out.println("\n▶ Inserting 3, 2, 1 at the beginning:");
        list.insertAtBeginning(3);
        list.insertAtBeginning(2);
        list.insertAtBeginning(1);
        list.printList(); // 1 2 3

        System.out.println("\n▶ Inserting 4 and 5 at the end:");
        list.insertAtLast(4);
        list.insertAtLast(5);
        list.printList(); // 1 2 3 4 5

        System.out.println("\n▶ Inserting 99 at position 3:");
        list.insertAtPosition(3, 99);
        list.printList(); // 1 2 99 3 4 5

        System.out.println("\n▶ Deleting at beginning:");
        list.deleteAtBeginning();
        list.printList(); // 2 99 3 4 5

        System.out.println("\n▶ Deleting at last:");
        list.deleteAtLast();
        list.printList(); // 2 99 3 4

        System.out.println("\n▶ Deleting node at position 2:");
        list.deleteAtPosition(2);
        list.printList(); // 2 3 4

        System.out.println("\n▶ Attempting invalid insert (position 10):");
        list.insertAtPosition(10, 123); // should warn

        System.out.println("\n▶ Attempting invalid delete (position 0):");
        list.deleteAtPosition(0); // should warn

        System.out.println("\n▶ Clearing the list completely:");
        while (!list.isEmpty()) {
            list.deleteAtLast();
        }
        list.printList(); // empty line

        System.out.println("Size after clear = " + list.size()); // 0
    }
}

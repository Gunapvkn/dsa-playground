package com.gunapvkn.dsa.arrays.basics.coreoperations;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayCreationAndTraversal {
    public static void main(String[] args) {
        // -----------------------------------------------------------
        // Section: Array Creation (Method 1: Declaration and Assignment)
        // -----------------------------------------------------------
        // Using 'var' (Java 10+) for local variable type inference.
        // Creates an integer array of size 5.
        var arr = new int[5];
        // Manually initializing each element.
        arr[0] = 2;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 7;
        arr[4] = 11;

        // -----------------------------------------------------------
        // Section: Array Creation (Method 2: Array Initializer)
        // -----------------------------------------------------------
        // Declares and initializes an array using the array initializer syntax.
        int[] arr2 = {2, 3, 5, 7, 11};

        // -----------------------------------------------------------
        // Section: Array Creation (Method 3: 'new' with Initializer)
        // -----------------------------------------------------------
        // Uses the new keyword with an initializer.
        var arr3 = new int[]{2, 3, 5, 7, 11};

        // -----------------------------------------------------------
        // Section: Array Traversal (For Loop with Index)
        // -----------------------------------------------------------
        // Iterates over the array 'arr' using a traditional for loop.
        // 'var' is used for the loop variable (Java 10+), which infers 'int'.
        for (var i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // -----------------------------------------------------------
        // Section: Array Traversal (Enhanced For-Each Loop)
        // -----------------------------------------------------------
        // This loop iterates over arr2 and prints each element.
        // It simplifies the code by avoiding explicit index management.
        for (var num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // -----------------------------------------------------------
        // Section: Array Traversal (While Loop)
        // -----------------------------------------------------------
        // Iterates over arr3 using a while loop.
        // Demonstrates an alternative traversal that requires manual index handling.
        var i = 0;
        while (i < arr3.length) {
            System.out.print(arr3[i] + " ");
            i++;
        }
        System.out.println();

        // -----------------------------------------------------------
        // Section: Array Traversal (Using Streams - Arrays.stream)
        // -----------------------------------------------------------
        // Converts the array 'arr' to a stream and iterates over it with a lambda.
        // This functional approach can be more concise and expressive.
        Arrays.stream(arr).forEach(element -> System.out.print(element + " "));
        System.out.println();

        // -----------------------------------------------------------
        // Section: Array Traversal (Using IntStream.range)
        // -----------------------------------------------------------
        // Uses IntStream.range to iterate over the index range of 'arr'.
        // This method provides flexibility if you need both the index and element.
        IntStream.range(0, arr.length).forEach(index -> System.out.print(arr[index] + " "));
        System.out.println();
    }
}

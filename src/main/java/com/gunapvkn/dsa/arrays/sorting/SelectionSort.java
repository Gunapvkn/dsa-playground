package com.gunapvkn.dsa.arrays.sorting;

import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] arr) {
        for (var i = 0; i < arr.length - 1; i++) {
            var smallestIndex = i;
            for (var j = i + 1; j < arr.length; j++) {
                if (arr[smallestIndex] > arr[j]) {
                    smallestIndex = j;
                }
            }
            var smallest = arr[smallestIndex];
            for (var k = smallestIndex; k > i; k--) {
                arr[k] = arr[k - 1];
            }
            arr[i] = smallest;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {10, 12, 6, 11, 5};
        selectionSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

}

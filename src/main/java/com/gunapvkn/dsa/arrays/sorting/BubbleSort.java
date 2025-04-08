package com.gunapvkn.dsa.arrays.sorting;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }
        for (var i = arr.length - 1; i > 0; i--) {
            for (var j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    var tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {10, 12, 6, 11, 5};
        bubbleSort.sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}

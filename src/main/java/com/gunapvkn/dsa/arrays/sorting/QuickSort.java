package com.gunapvkn.dsa.arrays.sorting;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {10, 12, 6, 11, 5};
        quickSort.quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            var partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        var pivotIndex = ThreadLocalRandom.current().nextInt(low, high + 1);
        var pivot = arr[pivotIndex];
        swap(arr, pivotIndex, high);

        var i = low;
        for (var j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

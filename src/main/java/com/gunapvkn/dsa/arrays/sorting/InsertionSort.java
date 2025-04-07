package com.gunapvkn.dsa.arrays.sorting;

import java.util.Arrays;

public class InsertionSort {

	public void sort(int[] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println("Array is empty");
			return;
		}
		for (var i = 1; i < arr.length; i++) {
			var insertIndex = i;
			var currentElement = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > currentElement) {
				arr[j + 1] = arr[j];
				insertIndex = j;
				j--;
			}
			arr[insertIndex] = currentElement;
		}
	}

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int[] arr = { 10, 12, 6, 11, 5 };
		insertionSort.sort(arr);
		Arrays.stream(arr).forEach(System.out::print);
	}

}

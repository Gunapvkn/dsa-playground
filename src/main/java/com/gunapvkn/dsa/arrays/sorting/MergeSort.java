package com.gunapvkn.dsa.arrays.sorting;

import java.util.Arrays;

public class MergeSort {

	public void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			var mid = start + ((end - start) / 2);
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private void merge(int[] arr, int start, int mid, int end) {
		var leftArraySize = mid - start + 1;
		var rightArraySize = end - mid;
		int[] tempLeftArray = new int[leftArraySize];
		int[] tempRightArray = new int[rightArraySize];

		for (var i = 0; i < leftArraySize; i++) {
			tempLeftArray[i] = arr[start + i];
		}

		for (var i = 0; i < rightArraySize; i++) {
			tempRightArray[i] = arr[mid + 1 + i];
		}

		var i = 0;
		var j = 0;
		var k = start;
		while (i < leftArraySize && j < rightArraySize) {
			if (tempLeftArray[i] < tempRightArray[j]) {
				arr[k] = tempLeftArray[i];
				i++;
			} else {
				arr[k] = tempRightArray[j];
				j++;
			}
			k++;
		}

		while (i < leftArraySize) {
			arr[k++] = tempLeftArray[i];
			i++;
		}

		while (j < rightArraySize) {
			arr[k++] = tempRightArray[j];
			j++;
		}
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] arr = { 10, 12, 6, 11, 5 };
		mergeSort.sort(arr);
		Arrays.stream(arr).forEach(System.out::print);
	}
}

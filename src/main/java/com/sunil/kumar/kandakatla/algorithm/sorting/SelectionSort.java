package com.sunil.kumar.kandakatla.algorithm.sorting;

public class SelectionSort {

	static void sortAscending(final int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minElementIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minElementIndex] > arr[j]) {
					minElementIndex = j;
				}
			}

			if (minElementIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minElementIndex];
				arr[minElementIndex] = temp;
			}
		}
	}

	static void sortDescending(final int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int maxElementIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[maxElementIndex] < arr[j]) {
					maxElementIndex = j;
				}
			}

			if (maxElementIndex != i) {
				int temp = arr[i];
				arr[i] = arr[maxElementIndex];
				arr[maxElementIndex] = temp;
			}
		}
	}

	static void sort(int arr[]) {
		int n = arr.length;

		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n - 1; i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}
	
	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int array[] = { 64, 25, 12, 22, 11 };
		sortAscending(array);
		System.out.println("Sorted array: ");
		printArray(array, array.length);

		sortDescending(array);
		System.out.println("Sorted array: ");
		printArray(array, array.length);

		sort(array);
		System.out.println("Sorted array: ");
		printArray(array, array.length);
	}

}

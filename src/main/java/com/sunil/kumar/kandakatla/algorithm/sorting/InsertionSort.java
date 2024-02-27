package com.sunil.kumar.kandakatla.algorithm.sorting;

/**
 * @author sunil
 * 
 *         https://www.baeldung.com/java-insertion-sort
 * 
 *         https://www.geeksforgeeks.org/insertion-sort/
 *
 */
public class InsertionSort {

	static void sort(int input[]) {
		int n = input.length;
		for (int i = 1; i < n; ++i) {
			int key = input[i];
			int j = i - 1;

			/*
			 * Move elements of arr[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && input[j] > key) {
				input[j + 1] = input[j];
				j = j - 1;
			}
			input[j + 1] = key;
		}
	}

	static void recursiveSort(int[] input, int i) {
		if (i <= 1) {
			return;
		}
		recursiveSort(input, i - 1);
		int key = input[i - 1];
		int j = i - 2;
		while (j >= 0 && input[j] > key) {
			input[j + 1] = input[j];
			j = j - 1;
		}
		input[j + 1] = key;
	}
	
	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int array[] = { 64, 25, 12, 22, 11 };
		sort(array);
		System.out.println("Sorted array: ");
		printArray(array, array.length);

		array = new int[] { 64, 25, 12, 22, 11 };
		recursiveSort(array, array.length);
		System.out.println("Sorted array: ");
		printArray(array, array.length);
	}

}

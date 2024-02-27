package com.sunil.kumar.kandakatla.sorting;

import java.util.stream.IntStream;

/**
 * @author sunil
 * 
 * 
 *         https://www.baeldung.com/java-bubble-sort
 * 
 *         https://www.geeksforgeeks.org/bubble-sort/
 *
 */
public class BubbleSort {

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		IntStream.range(0, n - 1)
		.flatMap(i -> IntStream.range(1, n - i))
		.forEach(j -> {
			if (arr[j - 1] > arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}
		});
	}

	static void optimizedBubbleSort(int[] arr) {
		int i = 0, n = arr.length;
		boolean swapNeeded = true;
		while (i < n - 1 && swapNeeded) {
			swapNeeded = false;
			for (int j = 1; j < n - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					swapNeeded = true;
				}
			}
			if (!swapNeeded) {
				break;
			}
			i++;
		}
	}

	static void bubbleSort(int arr[], int n) {
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// Swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// If no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int array[] = { 64, 34, 25, 12, 22, 11, 90 };
		bubbleSort(array, array.length);
		System.out.println("Sorted array: ");
		printArray(array, array.length);

		bubbleSort(array);
		System.out.println("Sorted array: ");
		printArray(array, array.length);

		optimizedBubbleSort(array);
		System.out.println("Sorted array: ");
		printArray(array, array.length);

	}

}

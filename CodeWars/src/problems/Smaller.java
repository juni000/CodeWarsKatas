package problems;

import java.util.Arrays;
import java.util.Random;

public class Smaller {
	/*
	 * Write
	 * 
	 * function smaller(arr) that given an array arr, you have to return the amount
	 * of numbers that are smaller than arr[i] to the right.
	 * 
	 * For example:
	 * 
	 * smaller([5, 4, 3, 2, 1]) === [4, 3, 2, 1, 0] smaller([1, 2, 0]) === [1, 1, 0]
	 */
	public static void main(String[] args) {
		int[] ram = new Random().ints(100000, 0, 100000000).toArray();
		int[] arr = smaller(ram);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	public static int[] smaller(int[] unsorted) {
		int[] sorted = unsorted.clone();
		Arrays.parallelSort(sorted);
		int[] solv = new int[unsorted.length];
		for (int i = 0; i < unsorted.length; i++) {
			solv[i] = indexSearch(sorted, unsorted[i]);
			sorted = deleteByIndex(sorted, unsorted[i]);
		}
		return solv;
	}

	public static int[] deleteByIndex(int[] sortedArray, int target) {
		int[] solve = new int[sortedArray.length - 1];
		boolean found = false;
		for (int i = 0, k = 0; i < sortedArray.length; i++) {
			if (sortedArray[i] != target || found) {
				solve[k] = sortedArray[i];
				k++;
			} else {
				found = true;
			}

		}

		return solve;
	}

	public static int indexSearch(int[] sortedArray, int target) {
		int left = 0;
		int right = sortedArray.length - 1;
		int result = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (sortedArray[mid] == target) {
				result = mid;
				right = mid - 1;
			} else if (sortedArray[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}
}

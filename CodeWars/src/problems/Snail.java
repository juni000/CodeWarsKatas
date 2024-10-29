package problems;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Snail {
	/*
	 * Given an n x n array, return the array elements arranged from outermost
	 * elements to the middle element, traveling clockwise.
	 * 
	 * array = [[1,2,3], [4,5,6], [7,8,9]] snail(array) #=> [1,2,3,6,9,8,7,4,5] For
	 * better understanding, please follow the numbers of the next array
	 * consecutively:
	 * 
	 * array = [[1,2,3], [8,9,4], [7,6,5]] snail(array) #=> [1,2,3,4,5,6,7,8,9] This
	 * image will illustrate things more clearly:
	 * 
	 * 
	 * NOTE: The idea is not sort the elements from the lowest value to the highest;
	 * the idea is to traverse the 2-d array in a clockwise snailshell pattern.
	 * 
	 * NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an
	 * array [[]].
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		int[][] arrNew = horizontalUp(array)[0].getValue();
//		int[] solv = horizontalUp(array)[0].getKey();
//		for (int i = 0; i < solv.length; i++) {
//			System.out.print(solv[i] + ", ");
//		}
//		System.out.println("\n");
//		for (int i = 0; i < arrNew.length; i++) {
//			for (int j = 0; j < arrNew[i].length; j++) {
//				System.out.print(arrNew[i][j] + ", ");
//			}
//			System.out.println();
//		}
		int[] arr = snail(new int[][] {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}});
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + ", ");
		}
	}

	public static int[] snail(int[][] array) {
		if (array.length <= 0 ) {
			return new int[] {};
		}
		SimpleEntry<int[], int[][]>[] map = new SimpleEntry[1];
		List<Integer> list = new ArrayList<Integer>();
		while (true) {
			if (array[0].length * array.length > 1) {
				map = verticalRigth(array);
				addArr(list,map[0].getKey());
				array = map[0].getValue();
			}else {
				list.add(array[0][0]);
				int[] solv = list.stream().mapToInt(i->i).toArray();
				return solv;
			}
			if (array[0].length * array.length > 1) {
				map = horizontalDown(array);
				addArr(list,map[0].getKey());
				array = map[0].getValue();
			}else {
				list.add(array[0][0]);
				int[] solv = list.stream().mapToInt(i->i).toArray();
				return solv;
			}
			if (array[0].length * array.length > 1) {
				map = verticalLeft(array);
				addArr(list,map[0].getKey());
				array = map[0].getValue();
			}else {
				list.add(array[0][0]);
				int[] solv = list.stream().mapToInt(i->i).toArray();
				return solv;
			}
			if (array[0].length * array.length > 1) {
				map = horizontalUp(array);
				addArr(list,map[0].getKey());
				array = map[0].getValue();
			}else {
				list.add(array[0][0]);
				int[] solv = list.stream().mapToInt(i->i).toArray();
				return solv;
			}
			
		}
	}
	public static void addArr(List<Integer> lst,int[] arr){
		for (int i = 0; i < arr.length; i++) {
			lst.add(arr[i]);
		}
	}
	public static SimpleEntry<int[], int[][]>[] verticalRigth(int[][] array) {
		int[][] arrNew = new int[array.length - 1][array[0].length];
		SimpleEntry<int[], int[][]>[] map = new SimpleEntry[1];
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				arrNew[i - 1][j] = array[i][j];
			}
		}
		map[0] = new SimpleEntry<>(array[0], arrNew);
		return map;
	}

	public static SimpleEntry<int[], int[][]>[] verticalLeft(int[][] array) {
		int[][] arrNew = new int[array.length - 1][array[0].length];
		SimpleEntry<int[], int[][]>[] map = new SimpleEntry[1];
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array[i].length; j++) {
				arrNew[i][j] = array[i][j];
			}
		}
		int[] reverseLine = new int[array[array.length - 1].length];
		for (int i = array[array.length - 1].length - 1, j = 0; i >= 0; i--, j++) {
			reverseLine[j] = array[array.length - 1][i];
		}
		map[0] = new SimpleEntry<>(reverseLine, arrNew);
		return map;

	}

	public static SimpleEntry<int[], int[][]>[] horizontalDown(int[][] array) {
		int[][] arrNew = new int[array.length][array[0].length - 1];
		SimpleEntry<int[], int[][]>[] map = new SimpleEntry[1];
		for (int i = 0; i < array.length ; i++) {
			for (int j = 0; j < array[i].length - 1; j++) {
				arrNew[i][j] = array[i][j];
			}
		}
		int[] lastColumn = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			lastColumn[i] = array[i][array[i].length - 1];
		}
		map[0] = new SimpleEntry<>(lastColumn, arrNew);
		return map;
	}
	
	public static SimpleEntry<int[], int[][]>[] horizontalUp(int[][] array) {
		int[][] arrNew = new int[array.length][array[0].length - 1];
		SimpleEntry<int[], int[][]>[] map = new SimpleEntry[1];
		for (int i = 0; i < array.length ; i++) {
			for (int j = 1; j < array[i].length; j++) {
				arrNew[i][j-1] = array[i][j];
			}
		}
		int[] firstColumn = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			firstColumn[i] = array[array.length - 1 -i][0];
		}
		map[0] = new SimpleEntry<>(firstColumn, arrNew);
		return map;
	}
	
}

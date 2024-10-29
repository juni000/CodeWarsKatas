package problems;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinear {
	/*
	 * Consider a sequence u where u is defined as follows:
	 * 
	 * The number u(0) = 1 is the first one in u. For each x in u, then y = 2 * x +
	 * 1 and z = 3 * x + 1 must be in u too. There are no other numbers in u. Ex: u
	 * = [1, 3, 4, 7, 9, 10, 13, 15, 19, 21, 22, 27, ...]
	 * 
	 * 1 gives 3 and 4, then 3 gives 7 and 10, 4 gives 9 and 13, then 7 gives 15 and
	 * 22 and so on...
	 * 
	 * Task: Given parameter n the function dbl_linear (or dblLinear...) returns the
	 * element u(n) of the ordered (with <) sequence u (so, there are no
	 * duplicates).
	 * 
	 * Example: dbl_linear(10) should return 22
	 */
	public static void main(String[] args) {
		dblLinear2(20).stream().sorted().forEach(n -> System.out.print(n + " "));
		System.out.println();
		dblLinear2(50).stream().sorted().forEach(n -> System.out.print(n + " "));
		System.out.println();
		dblLinear2(100).stream().sorted().forEach(n -> System.out.print(n + " "));
		System.out.println();
		System.out.println(dblLinear(50));
	}

	public static int dblLinear(int n) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		dblRecursive(arr, new int[] { 1 }, n *2);
		arr = arr.stream().distinct().sorted().toList();
		return arr.get(n);
	}

	public static List<Integer> dblLinear2(int n) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		dblRecursive(arr, new int[] { 1 }, n);
		arr = arr.stream().distinct().sorted().toList();
		return arr;
	}

	public static void dblRecursive(List<Integer> arr, int[] nums, int size) {
		if (arr.size()-1 >= size)
			return;
		List<Integer> nums2 = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			arr.add(nums[i] * 2 + 1);
			arr.add(nums[i] * 3 + 1);
			nums2.add(nums[i] * 2 + 1);
			nums2.add(nums[i] * 3 + 1);
		}
		nums2 = nums2.stream().distinct().sorted().toList();
		
		dblRecursive(arr, nums2.stream().mapToInt(n -> Integer.valueOf(n)).toArray(), size);

	}
}

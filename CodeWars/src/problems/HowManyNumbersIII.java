package problems;

import java.util.ArrayList;
import java.util.List;

public class HowManyNumbersIII {

	public static void main(String[] args) {
		System.out.println(findAll(57, 11));

	}

	public static List<Long> findAll(final int sumDigits, final int numDigits) {
		if (sumDigits < 0 || sumDigits > numDigits * 9) {
			return new ArrayList<>();
		}
		List<Long> list = new ArrayList<Long>();
		numberGenerator(list, new int[numDigits], sumDigits, 0, 1, 0); 
		if (list.size() >0) {
			List<Long> solution = new ArrayList<>();
			solution.add((long) list.size());
			solution.add(list.get(0));
			solution.add(list.get(list.size()-1));
			return solution;
		}
		return list;
	}

	public static int[] split(long n) {
		String temp = Integer.toString((int) n);
		int[] arr = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			arr[i] = temp.charAt(i) - '0';
		}
		return arr;

	}

	public static long unSplit(int[] ar) {
		long res = 0;
		for (int i = 0; i < ar.length; i++) {
			res = res * 10 + ar[i];
		}
		return res;
	}

	public static void numberGenerator(List<Long> list, int[] num, int sumDigits, int actualDigit, int startingNum,
			int sum) {
		for (int i = startingNum; i < 10; i++) {
			num[actualDigit] = i;
			if (actualDigit == 0) {
				sum = num[actualDigit];
				numberGenerator(list, num, sumDigits, actualDigit + 1, num[actualDigit], sum);
			} else if (num[actualDigit - 1] > num[actualDigit]) {
				return;
			} else if (sum + num[actualDigit] == sumDigits && actualDigit == num.length - 1) {
				list.add(unSplit(num));
			} else if (sum > sumDigits || actualDigit == num.length - 1) {
				
			} else {
				numberGenerator(list, num, sumDigits, actualDigit + 1, num[actualDigit], sum + num[actualDigit]);
			}

		}
	}
//	public static boolean valid(int[] num, int actualNum, int sum, int sumDigits) {
//		if (actualNum == 0) {
//			return valid(num, actualNum + 1, num[actualNum], sumDigits);
//		} else if (num[actualNum - 1] > num[actualNum]) {
//			return false;
//		} else if (sum + num[actualNum] == sumDigits && actualNum == num.length - 1) {
//			return true;
//		} else if (sum > sumDigits || actualNum == num.length - 1) {
//			return false;
//		} else {
//			return valid(num, actualNum + 1, sum + num[actualNum], sumDigits);
//		}
//	}

}

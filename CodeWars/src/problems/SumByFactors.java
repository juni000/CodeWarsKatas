package problems;

import java.util.ArrayList;
import java.util.List;

public class SumByFactors {
	/*
	 * Given an array of positive or negative integers
	 * 
	 * I= [i1,..,in]
	 * 
	 * you have to produce a sorted array P of the form
	 * 
	 * [ [p, sum of all ij of I for which p is a prime factor (p positive) of ij]
	 * ...]
	 * 
	 * P will be sorted by increasing order of the prime numbers. The final result
	 * has to be given as a string in Java, C#, C, C++ and as an array of arrays in
	 * other languages.
	 */
	public static void main(String[] args) {
		System.out.print(sumOfDivided(new int[]{12, 15}));
	}

	public static List<Integer> PRIMES = new ArrayList<Integer>();

	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= num / i; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void primesNoReps(int n) {
		List<Integer> prim = PRIMES;
		for (int i = 2; i <= Math.abs(n); i++) {
			prim = PRIMES;
			for (int j = 0; j < PRIMES.size(); j++) {
				if (i % PRIMES.get(j) == 0 && !PRIMES.contains(i)) {
					i++;
					break;
				}
			}
			if (n % i == 0) {
				if (!PRIMES.contains(i)) {
					PRIMES.add(i);
				}
				n /= i;
				i--;
			} else if (PRIMES.size() != 0) {
				do {
					i++;
				} while (!isPrime(i));
				i--;
			}
		}
	}

	public static String sumOfDivided(int[] l) {
		List<Integer[]> list = new ArrayList<Integer[]>();
		String solution = "";
		int sum = 0;
		for (int i = 0; i < l.length; i++) {
			primesNoReps(l[i]);
		}
		PRIMES.sort(null);
		for (int i = 0; i < PRIMES.size(); i++) {
			for (int j = 0; j < l.length; j++) {
				if (l[j] % PRIMES.get(i) == 0) {
					sum += l[j];
				}

			}
			list.add(new Integer[] { PRIMES.get(i), sum });
			sum = 0;
		}
		for (int i = 0; i < list.size(); i++) {
			solution += "(" + list.get(i)[0] + " " + list.get(i)[1] + ")";
		}
		PRIMES.clear();
		return solution;
	}
}

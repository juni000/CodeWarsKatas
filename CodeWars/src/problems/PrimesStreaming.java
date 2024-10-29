package problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimesStreaming {

	/*
	 * Create an endless stream of prime numbers - a bit like
	 * IntStream.of(2,3,5,7,11,13,17), but infinite. The stream must be able to
	 * produce a million primes in a few seconds.
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		IntStream stream = stream();
		stream.forEach(System.out::println);
		System.out.println(stream.count());
		long endTime   = System.nanoTime();
		long totalTime = (endTime - startTime);
		System.out.println(totalTime);

	}

	static List<Integer> PRIMES = new ArrayList<Integer>();

	public static boolean isPrime(int num) {
		int max = (int) Math.sqrt(num) + 1;
		for (int i = 2, j = 0; j < PRIMES.size(); i = PRIMES.get(j), j++) {
			if (num % i == 0) {
				return false;
			} else if (i > max)
				break;

		}
		PRIMES.add(num);
		return true;
	}

	public static IntStream stream() {
		int[] hundredPrimes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83,
				89, 97 };
		for (int i = 0; i < hundredPrimes.length; i++) {
			PRIMES.add(hundredPrimes[i]);
		}
		return IntStream.range(2, Integer.MAX_VALUE).filter(n -> BigInteger.valueOf(n).isProbablePrime(n));
	}
}

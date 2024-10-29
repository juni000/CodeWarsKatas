package problems;

public class ProductOfConsecutiveFibonacci {

	/*
	 * The Fibonacci numbers are the numbers in the following integer sequence (Fn):
	 * 
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
	 * 
	 * such as
	 * 
	 * F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.
	 * 
	 * Given a number, say prod (for product), we search two Fibonacci numbers F(n)
	 * and F(n+1) verifying
	 * 
	 * F(n) * F(n+1) = prod.
	 * 
	 * Your function productFib takes an integer (prod) and returns an array:
	 * 
	 * [F(n), F(n+1), true] or {F(n), F(n+1), 1} or (F(n), F(n+1), True) depending
	 * on the language if F(n) * F(n+1) = prod.
	 * 
	 * If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prodyou will
	 * return
	 * 
	 * [F(n), F(n+1), false] or {F(n), F(n+1), 0} or (F(n), F(n+1), False) F(n)
	 * being the smallest one such as F(n) * F(n+1) > prod.
	 */

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			System.out.println(productFib(800)[i]);
		}
	}

	public static long[] productFib(long prod) {
		long fiboPrev = 1;
		long fiboAct = 1;
		long fiboPost = 2;
		long fiboProb = fiboPrev * fiboAct;
		while (fiboProb < prod) {
			fiboPrev = fiboAct;
			fiboAct = fiboPost;
			fiboPost = fiboPrev + fiboAct;
			fiboProb = fiboPrev * fiboAct;
		}
		if (fiboProb == prod) {
			long solution[] = { fiboPrev, fiboAct, 1 };
			return solution;
		} else {
			long solution[] = { fiboPrev, fiboAct, 0 };
			return solution;
		}
	}
}

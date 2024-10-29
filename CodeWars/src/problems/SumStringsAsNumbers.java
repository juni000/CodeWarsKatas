package problems;

public class SumStringsAsNumbers {
	/*
	 * Given the string representations of two integers, return the string
	 * representation of the sum of those integers.
	 * 
	 * For example:
	 * 
	 * sumStrings('1','2') // => '3' A string representation of an integer will
	 * contain no characters besides the ten numerals "0" to "9".
	 * 
	 * I have removed the use of BigInteger and BigDecimal in java
	 * 
	 * Python: your solution need to work with huge numbers (about a milion digits),
	 * converting to int will not work.
	 */
	public static void main(String[] args) {

		System.out.println(sumStrings("962733087818704576869067696969869845764576456987325927390457250923749058723490572039750509570923849058230945820398459084576131802", "451239048128749619264986329847641743891632498760121275745745457689573975732597320495872039875029387567457680856341372"));


	}

	public static String sumStrings(String a, String b) {
		if (a.length() <= 0 && b.length() <= 0) {
			return "";
		} else if (b.length() <= 0) {
			return a;
		} else if (a.length() <= 0) {
			return b;
		}
		if (a.length() < 10 && b.length() < 10) {
			return Integer.valueOf(a) + Integer.valueOf(b) + "";
		}
		b = removeLeftZeros(b);
		a = removeLeftZeros(a);
		return reverseSum(a.split(""), b.split(""), a.length() - 1, b.length() - 1, "", 0);
	}

	public static String removeLeftZeros(String a) {
		String[] arr = a.split("");
		a = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("0")) {
				arr[i] = "";
			} else
				break;
		}
		for (int i = 0; i < arr.length; i++) {
			a += arr[i];
		}
		return a;
	}

	public static String restArr(String[] arr, int actualDigit, String solv, boolean extra) {
		if (!extra) {
			for (int i = actualDigit; i >= 0; i--) {
				solv = arr[i] + solv;
			}
			return solv;
		}
		if (actualDigit == 0 && extra) {
			return (Integer.valueOf(arr[actualDigit]) + 1) + solv;
		} else if (actualDigit == 0) {
			return solv;
		}
		solv += restArr(arr, actualDigit - 1, solv, (Integer.valueOf(arr[actualDigit]) + 1) > 9 ? true : false)
				+ (Integer.valueOf(arr[actualDigit]) + 1 > 9 ? 0 : Integer.valueOf(arr[actualDigit]) + 1);
		return solv;
	}

	public static String reverseSum(String[] a, String[] b, int lengthA, int lengthB, String solv, int extra) {
		if (lengthA == 0 && lengthB == 0) {
			solv += Integer.valueOf(Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra);
			return solv;
		} else if (lengthA == 0) {
			solv += ((Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra) > 9
					? restArr(b, lengthB - 1, "", true)
							+ ((Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra) % 10)
					: restArr(b, lengthB - 1, "", false)
							+ (Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra));
			return solv;
		} else if (lengthB == 0) {
			solv += ((Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra) > 9
					? restArr(a, lengthA - 1, "", true)
							+ ((Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra) % 10)
					: restArr(a, lengthA - 1, "", false)
							+ (Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra));
			return solv;
		}

		solv += reverseSum(a, b, lengthA - 1, lengthB - 1, solv,
				((Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra) > 9 ? 1 : 0))

				+ ((Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra > 9
						? ((Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra) % 10)
						: (Integer.valueOf(a[lengthA]) + Integer.valueOf(b[lengthB]) + extra)));

		return solv;

	}

}

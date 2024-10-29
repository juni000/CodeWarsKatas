package problems;

public class LongToIp {

	public static void main(String[] args) {
		System.out.println(longToIP(26784));
	}
	public static String longToIP(long ip) {
		String bit = Long.toBinaryString(ip);
		bit = String.format("%32s", bit).replace(' ', '0');
		String part = "";
		String solution = "";
		for (int i = 0; i < bit.length(); i += 8) {
			for (int j = 0; j < 8; j++) {
				part += bit.charAt(j + i);
			}
			if (i == bit.length() - 8) {
				solution += Long.parseLong(part, 2);
				part = "";
			} else {
				solution += Long.parseLong(part, 2) + ".";
				part = "";
			}
		}
		return solution; // do it!
	}
}

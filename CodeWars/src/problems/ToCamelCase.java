package problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ToCamelCase {

	public static void main(String[] args) {
		System.out.println(replace("Sum Strings as Numbers"));
	}

	public static String replace(final String s) {
		return Arrays.stream(s.split("[-|_| ]"))
				.map(n -> n.replaceFirst(String.valueOf(n.charAt(0)), String.valueOf(n.charAt(0)).toUpperCase()))
				.collect(Collectors.joining()); // coding and coding....
	}
}

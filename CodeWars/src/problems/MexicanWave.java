package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MexicanWave {

	/*
	 * Task In this simple Kata your task is to create a function that turns a
	 * string into a Mexican Wave. You will be passed a string and you must return
	 * that string in an array where an uppercase letter is a person standing up.
	 * 
	 * Rules 1. The input string will always be lower case but maybe empty. 2. If
	 * the character in the string is whitespace then pass over it as if it was an
	 * empty seat
	 * 
	 * Example wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}
	 */

	public static void main(String[] args) {
		String[] chain = wave(" g ap ");
		for (int i = 0; i < chain.length; i++) {
			System.out.println(chain[i]);
		}

	}

	public static String[] wave(String str) {
		ArrayList<String> chains = new ArrayList<String>();
		String[] wordSplit = str.split("");
		String word = "";
		for (int i = 0; i < str.length(); i++) {
			if (wordSplit[i].equals(" ")) {

			} else {
				wordSplit[i] = wordSplit[i].toUpperCase();
				word = Arrays.stream(wordSplit).collect(Collectors.joining());
				chains.add(word);
				wordSplit[i] = wordSplit[i].toLowerCase();
			}
		}
		String[] chain = chains.stream().toArray(String[]::new);

		return chain;
	}
}

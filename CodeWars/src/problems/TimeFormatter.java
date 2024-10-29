package problems;

import java.util.ArrayList;
import java.util.List;

public class TimeFormatter {

	/*
	 * Your task in order to complete this Kata is to write a function which formats
	 * a duration, given as a number of seconds, in a human-friendly way.
	 * 
	 * The function must accept a non-negative integer. If it is zero, it just
	 * returns "now". Otherwise, the duration is expressed as a combination of
	 * years, days, hours, minutes and seconds.
	 */

	public static void main(String[] args) {
		System.out.println(formatDuration(3451512));
	}

	public static String formatDuration(int seconds) {
		String solution = "";
		List<String> list = new ArrayList<String>();
		if (seconds == 0) {
			return "now";
		}
		if (seconds < 60) {
			list.add(seconds + (seconds == 1 ? " second" : " seconds"));
		} else if (seconds % 60 != 0) {
			list.add(seconds % 60 + (seconds % 60 == 1 ? " second" : " seconds"));
		}
		if (seconds / 60 < 60 && seconds >= 60) {
			list.add(seconds / 60 + (seconds / 60 == 1 ? " minute" : " minutes"));
		} else if ((seconds % 3600) / 60 != 0) {
			list.add((seconds % 3600) / 60 + ((seconds % 3600) / 60 == 1 ? " minute" : " minutes"));
		}
		if (seconds / 3600 < 24 && seconds / 60 >= 60) {
			list.add(seconds / 3600 + (seconds / 3600 == 1 ? " hour" : " hours"));
		} else if ((seconds % 86400) / 3600 != 0) {
			list.add((seconds % 86400) / 3600 + ((seconds % 86400) / 3600 == 1 ? " hour" : " hours"));
		}
		if (seconds / 86400 < 365 && seconds / 3600 >= 24) {
			list.add(seconds / 86400 + (seconds / 86400 == 1 ? " day" : " days"));
		} else if ((seconds % 31536000) / 86400 != 0) {
			list.add((seconds % 31536000) / 86400 + ((seconds % 31536000) / 86400 == 1 ? " day" : " days"));
		}
		if (seconds / 86400 >= 365) {
			list.add(seconds / 31536000 + (seconds / 31536000 == 1 ? " year" : " years"));
		}
		for (int i = 0; i < list.size(); i++) {
			solution += list.get(list.size() - 1 - i)
					+ (i == (list.size() - 1) ? "" : i == (list.size() - 2) ? " and " : ", ");

		}
		return solution.trim();
	}
}

package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObservedPin {
	/*
	 * lright, detective, one of our colleagues successfully observed our target
	 * person, Robby the robber. We followed him to a secret warehouse, where we
	 * assume to find all the stolen stuff. The door to this warehouse is secured by
	 * an electronic combination lock. Unfortunately our spy isn't sure about the
	 * PIN he saw, when Robby entered it.
	 * 
	 * The keypad has the following layout: 
	 * ┌───┬───┬───┐ 
	 * │ 1 │ 2 │ 3 │
	 * ├───┼───┼───┤ 
	 * │ 4 │ 5 │ 6 │ 
	 * ├───┼───┼───┤ 
	 * │ 7 │ 8 │ 9 │ 
	 * └───┼───┼───┘ 
	 * 	   │ 0 │
	 *     └───┘
	 * ¡He noted the PIN 1357, but he also said, it is possible that each of
	 * the digits he saw could actually be another adjacent digit (horizontally or
	 * vertically, but not diagonally). E.g. instead of the 1 it could also be the 2
	 * or 4. And instead of the 5 it could also be the 2, 4, 6 or 8.
	 * 
	 * He also mentioned, he knows this kind of locks. You can enter an unlimited
	 * amount of wrong PINs, they never finally lock the system or sound the alarm.
	 * That's why we can try out all possible (*) variations.
	 */
	public static void main(String[] args) {
		System.out.println(getPINs("369"));

	}

	public static HashMap<String, String[]> NUMBERS = new HashMap<String, String[]>() {
		{
			put("1", new String[] { "1", "2", "4" });
			put("2", new String[] { "1", "2", "3", "5" });
			put("3", new String[] { "2","3", "6" });
			put("4", new String[] { "1", "4", "5", "7" });
			put("5", new String[] { "2", "4", "5", "6", "8" });
			put("6", new String[] { "3", "5", "6", "9" });
			put("7", new String[] { "4", "7", "8" });
			put("8", new String[] { "5", "7", "8", "9", "0" });
			put("9", new String[] { "6", "8", "9" });
			put("0", new String[] { "0","8" });

		}
	};

	public static void pinGenrator(String[] number, int posicion, int size, String pin, List<String> pins) {
        if (posicion == size) {
            pins.add(pin);
            return;
        }
        for (int i = 0; i < NUMBERS.get(number[posicion]).length; i++) {
            String posibleNum = NUMBERS.get(number[posicion])[i];
            pinGenrator(number, posicion + 1, size, pin + posibleNum, pins);
        }
		
	}

	public static List<String> getPINs(String observed) {
		String[] arrObs = observed.split("");
		
		List<String> pins = new ArrayList<String>();
		pinGenrator(arrObs, 0, arrObs.length, "", pins);
		return pins;
	}
}

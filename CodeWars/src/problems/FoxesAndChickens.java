package problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FoxesAndChickens {

	public static void main(String[] args) {
		System.out.println(hungryFoxes("CC.CC[.FCC.]CXF.CCCCCXC.XC.CC[X.C][..FC..C...F..CC..]F"));
	}

	public static String hungryFoxes(final String farm) {

//		int lastXOrFox = 0;
//		List<String> arrList = Arrays.stream(farm.split("")).toList();
//		ArrayList<String> arr = new ArrayList<String>(arrList);
//		ArrayList<String> beforeFox = null;
//		ArrayList<String> afterFox = null;
//		String solution = "";
//
//		for (int i = 0; i < arr.size(); i++) {
//
//			if (arr.get(i).equals("X")) {
//				beforeFox = new ArrayList<String>(arr.subList(lastXOrFox, i));
//				solution += String.join("", beforeFox);
//				arr = new ArrayList<String>(arr.subList(i, arr.size() - 1));
//				i=0;
//				lastXOrFox=0;
//				
//			} else if (arr.get(i).equals("F")) {
//				beforeFox = new ArrayList<String>(arr.subList(lastXOrFox, i + 1));
//				lastXOrFox=i;
//				for (int j = beforeFox.size() - 2; j >= 0; j--) {
//					if (beforeFox.get(j).equals("C")) {
//						beforeFox.set(j, ".");
//					} else if (beforeFox.get(j).equals("F") || beforeFox.get(j).equals("]")
//							|| beforeFox.get(j).equals("["))
//						break;
//					else if (beforeFox.get(j).equals("X")) {
//						beforeFox.set(beforeFox.size() - 1, ".");
//						break;
//					}
//				}
//				solution += String.join("", beforeFox);
//				
//				for (int j = i; j < arr.size(); j++) {
//					if (arr.get(j).equals("X") || arr.get(j).equals("]") || arr.get(j).equals("[")) {
//						afterFox = new ArrayList<String>(arr.subList(i+1, j));
//						for (int j2 = 0; j2 < afterFox.size(); j2++) {
//							if (afterFox.get(j2).equals("C")) {
//								afterFox.set(j2, ".");
//							}
//						}
//						break;
//					}
//				}
//				solution += String.join("", afterFox);
//			}
//		}
		String solution = "";
		String[] arr = farm.split("");
		boolean inside = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("F")) {
				// before fox
				for (int j = i; j >= 0; j--) {
					if (arr[j].equals("C") && inside == false) {
						arr[j] = ".";
					} else if (arr[j].equals("]")) {
						inside = !inside;
					} else if (arr[j].equals("[") && inside == true) {
						inside = !inside;
					} else if (arr[j].equals("[") && inside == false) {
						break;
					} else if (arr[j].equals("X") && inside == false) {
						arr[i] = ".";
						break;
					}else if (arr[j].equals("X") && inside == true) {
						
					}
				}
				// after fox
				inside = false;
				for (int j = i; j < arr.length; j++) {
					if (arr[j].equals("C") && inside == false) {
						arr[j] = ".";
					} else if (arr[j].equals("[")) {
						inside = !inside;
					} else if (arr[j].equals("]") && inside == true) {
						inside = !inside;
					} else if (arr[j].equals("]") && inside == false) {
						break;
					} else if (arr[j].equals("X") && inside == false) {
						arr[i] = ".";
						break;
					} else if (arr[j].equals("X") && inside == true) {
						
					}
				}
			}
			inside = false;
		}
		solution = Arrays.stream(arr).collect(Collectors.joining());
		return solution;
	}

}

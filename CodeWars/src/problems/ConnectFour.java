package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConnectFour {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>(Arrays.asList("E_Yellow","A_Red","C_Yellow","C_Red","G_Yellow","B_Red","D_Yellow","B_Red","A_Yellow","E_Red","A_Yellow","G_Red","G_Yellow","D_Red"));

		System.out.println(whoIsWinner(arr));
	}

	public static HashMap<Character, Integer> MOVES = new HashMap<Character, Integer>() {
		{
			put('A', 0);
			put('B', 1);
			put('C', 2);
			put('D', 3);
			put('E', 4);
			put('F', 5);
			put('G', 6);

		}
	};

	public static String whoIsWinner(List<String> piecesPositionList) {
		int game[][] = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0 } };
		int number = 0;
		for (int i = 0; i < piecesPositionList.size(); i++) {
			number = MOVES.get(piecesPositionList.get(i).charAt(0));

			if (piecesPositionList.get(i).contains("Red")) {

				for (int j = 0; j < game.length; j++) {
					if (game[j][number] == 0) {
						game[j][number] = -1;
						break;
					}
				}
				if (didWin(game)) {
					CHECK = false;
					for (int k = 0; k < game.length; k++) {
						for (int j = 0; j < game[k].length; j++) {
							System.out.print(" " + (game[k][j] == 1 ? "Y" : game[k][j] == -1 ? "R" : 0) + ", ");
						}
						System.out.println();
					}
					return "Red";
				}

			} else if (piecesPositionList.get(i).contains("Yellow")) {

				for (int j = 0; j < game.length; j++) {
					if (game[j][number] == 0) {
						game[j][number] = 1;
						break;
					}
				}
				if (didWin(game)) {
					for (int k = 0; k < game.length; k++) {
						for (int j = 0; j < game[k].length; j++) {
							System.out.print(" " + (game[k][j] == 1 ? "Y" : game[k][j] == -1 ? "R" : 0) + ", ");
						}
						System.out.println();
					}
					CHECK = false;
					return "Yellow";
				}

			}
		}
		for (int k = 0; k < game.length; k++) {
			for (int j = 0; j < game[k].length; j++) {
				System.out.print(" " + (game[k][j] == 1 ? "Y" : game[k][j] == -1 ? "R" : 0) + ", ");
			}
			System.out.println();
		}
		return "Draw";
	}

	public static void verticalCheck(int[] line, int numI) {
		if (numI > 3)
			return;
		if (Math.abs(line[numI] + line[numI + 1] + line[numI + 2] + line[numI + 3]) == 4) {
			CHECK = true;
		} else if (numI < 4) {
			verticalCheck(line, numI + 1);
		}
	}

	public static void horizontalCheck(int[][] game, int numI, int numJ) {
		if (numI == 6)
			return;
		if (Math.abs(game[numJ][numI] + game[numJ + 1][numI] + game[numJ + 2][numI] + game[numJ + 3][numI]) == 4) {
			CHECK = true;
		} else {
			horizontalCheck(game, numI + 1, numJ);
		}
	}

	public static void diagonalRightCheck(int[][] game, int numI, int numJ) {
		if (numI > 3)
			return;
		if (Math.abs(game[numJ][numI] + game[numJ + 1][numI + 1] + game[numJ + 2][numI + 2]
				+ game[numJ + 3][numI + 3]) == 4) {
			CHECK = true;
		} else {
			diagonalRightCheck(game, numI + 1, numJ);
		}

	}

	public static void digonalLeftCheck(int[][] game, int numI, int numJ) {
		if (numI < 3)
			return;
		if (Math.abs(game[numJ][numI] + game[numJ + 1][numI - 1] + game[numJ + 2][numI - 2]
				+ game[numJ + 3][numI - 3]) == 4) {
			CHECK = true;
		} else {
			digonalLeftCheck(game, numI - 1, numJ);
		}
	}

	static boolean CHECK = false;

	public static boolean didWin(int[][] game) {

		for (int i = 0; i < game.length; i++) {
			verticalCheck(game[i], 0);
		}
		for (int i = 0; i < 3; i++) {
			horizontalCheck(game, 0, i);
		}
		for (int i = 0; i < 3; i++) {
			diagonalRightCheck(game, 0, i);
		}
		for (int i = 0; i < 3; i++) {
			digonalLeftCheck(game, 6, i);
		}

		return CHECK;
	}
}

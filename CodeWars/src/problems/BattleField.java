package problems;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BattleField {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(fieldValidator(battleField));
	}
	private static int[][] battleField = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
								            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
								            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
								            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
								            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
								            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
								            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
								            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
								            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
								            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

	public static boolean fieldValidator(int[][] field) {
		List<Point> list = getPoints(field);
		int nearPoints = 0;
		int battleship = 0, cruisers = 0, destroyers = 0, submarines = 0 , shipSize = 0;
		double distance = 0;
		Point[] twoNearPoints = new Point[2];
		for (int i = 0; i < list.size(); i++) {
			nearPoints = 0;
			for (int j = 0; j < list.size(); j++) {
				if (!list.get(i).equals(list.get(j))) {
					distance = list.get(i).distance(list.get(j));
					if (distance < 2) {
						twoNearPoints[0] = list.get(j);
						nearPoints++;
						if (nearPoints > 2 || (distance < 2 && distance > 1)) {
							return false;
						} else if (nearPoints == 2) {
							twoNearPoints[1] = list.get(j);
							if (twoNearPoints[0].y == twoNearPoints[1].y || twoNearPoints[0].x == twoNearPoints[1].x) {
							} else
								return false;
						}
					}
				}
			}
		}
		for (int i = 0; i < list.size() ; i++) {
			nearPoints = 0;
			for (int j = 0; j < list.size(); j++) {
				if (!list.get(i).equals(list.get(j))) {
					distance = list.get(i).distance(list.get(j));
					if (distance < 2) {
						nearPoints++;
					}
					if (distance == 1) {
						shipSize = shipLong(list, i, j, 2);
						if (shipSize == 2) {
							destroyers++;
						}else if (shipSize == 3) {
							cruisers++;
						}else if (shipSize == 4) {
							battleship++;
						}else if (shipSize>4) {
							return false;
						}
					}
				}
			}
			if (nearPoints == 0) {
				submarines++;
			}
		}
		System.out.println("Submarines = " + submarines);
		System.out.println("Destroyers = " + destroyers);
		System.out.println("Cruisers = " + cruisers);
		System.out.println("Battleship = " + battleship);
		if (destroyers == 12 && submarines == 4 && cruisers == 6 && battleship==2) {
			return true;
		}else {
			return false;
		}
	}
	public static int shipLong(List<Point> list, int prevP, int actualP, int size) {
		double distance = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i != prevP && i != actualP) {
				distance = list.get(actualP).distance(list.get(i));
				if (distance == 1) {
					return shipLong(list, actualP, i, size + 1);
				}
			}
		}
		return size;
	}
	public static List<Point> getPoints(int[][] field) {
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == 1) {
					list.add(new Point(i, j));
				}
			}
		}
		return list;
	}
}

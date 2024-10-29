package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPairOfPoints {
	/*
	 * Given a number of points on a plane, your task is to find two points with the smallest distance between them in linearithmic O(n log n) time.
		
		Example
		  1  2  3  4  5  6  7  8  9
		1  
		2    . A
		3                . D
		4                   . F       
		5             . C
		6              
		7                . E
		8    . B
		9                   . G
		For the plane above, the input will be:
		
		[
		  [2,2], // A
		  [2,8], // B
		  [5,5], // C
		  [6,3], // D
		  [6,7], // E
		  [7,4], // F
		  [7,9]  // G
		]
		=> closest pair is: [[6,3],[7,4]] or [[7,4],[6,3]]
		(both answers are valid)
		The two points that are closest to each other are D and F.
		Expected answer should be an array with both points in any order.*/
	public static void main(String[] args) {
		List<Point> points = Arrays.asList(new Point(2, 2), // A
				new Point(2, 8), // B
				new Point(6, 6), 
				new Point(6, 6), // C
				new Point(6, 3), // D
				new Point(6, 7), // E
				new Point(7, 4), // F
				new Point(7, 9) // G
		);
		List<Point> allPointsPairs = closestPair(points);
		for (Point points2 : allPointsPairs) {
			System.out.println(points2.hashCode() + points2.toString());
		}
	}

	public static List<Point> closestPair(List<Point> points) {
		Point nearPoint0 = new Point(Double.MAX_VALUE, Double.MAX_VALUE);
		int point1 = 0, point2 = 0;
		List<Point> solution = new ArrayList<Point>();
		for (int i = 0; i < points.size(); i++) {
			for (int j = i + 1; j < points.size(); j++) {
				if (nearPoint0.x + nearPoint0.y > Math.abs(points.get(i).x - points.get(j).x)
						+ Math.abs(points.get(i).y - points.get(j).y)) {
					nearPoint0 = new Point(Math.abs(points.get(i).x - points.get(j).x),
							Math.abs(points.get(i).y - points.get(j).y));
					point1 = i;
					point2 = j;
				}
			}

		}

		solution.add(points.get(point1));
		solution.add(points.get(point2));

		return solution;
	}
}

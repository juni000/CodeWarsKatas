package problems;

public class InsaneColouredTriangles {

	public static void main(String[] args) {
		System.out.println("RGBG");
		System.out.println(String.valueOf((triangle("RGBG"))));
		System.out.println(String.valueOf((triangle("RBRGBRB"))));
		System.out.println(String.valueOf((triangle("RBRGBRBGGRRRBGBBBGG"))));

	}

	public static char triangle(String row) {
		
//		row = reduceRow(row);
		if (row.length() == 1) {
			return row.charAt(0);
		}
		String newRow = "";
		for (int i = 0; i < row.length() - 1; i++) {
			newRow += row.charAt(i) == row.charAt(i + 1) ? row.charAt(i)
					: (row.charAt(i) != 'R' && row.charAt(i + 1) != 'R') ? 'R'
							: (row.charAt(i) != 'G' && row.charAt(i + 1) != 'G') ? 'G'
									: (row.charAt(i) != 'B' && row.charAt(i + 1) != 'B') ? 'B' : 0;
		}
		return triangle(newRow);
	}

	public static String reduceRow(String rows) {
		if (rows.length()<3) {
			return rows;
		}
		String[] row = rows.split("");
		String reduced = "";
		for (int i = 0; i < row.length-2; i++) {
			if (!row[i].equals(row[i+1]) && !row[i].equals(row[i+2])) {
				reduced += row[i];
			}
		}
		reduced += row[row.length-2];
		reduced += row[row.length-1];
		return reduced;
	}

//	public static char reduceTriangle(char[] row) {
//		if (row.length == 1) {
//			return row[0];
//		}
//		char[] newRow = new char[row.length-1];
//		for (int i = 0; i < newRow.length; i++) {
//			newRow[i] = row[i] == row[i+1] ? row[i]
//					: (row[i] != 'R' && row[i+1] != 'R') ? 'R' : (row[i] != 'G' && row[i+1] != 'G') ? 'G' : (row[i] != 'B' && row[i+1] != 'B') ? 'B' : 0;
//		}
//		return reduceTriangle(newRow);
//	}

}
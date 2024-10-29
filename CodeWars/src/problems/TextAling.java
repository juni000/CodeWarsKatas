package problems;

public class TextAling {

	/*
	 * Your task in this Kata is to emulate text justification in monospace font.
	 * You will be given a single-lined text and the expected justification width.
	 * The longest word will never be greater than this width.
	 */

	public static void main(String[] args) {
		String LIPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sa"
				+ "gittis dolor mauris, at elementum ligula tempor eget. In quis rhoncus nunc, at aliquet orci. Fusc"
				+ "e at dolor sit amet felis suscipit tristique. Nam a imperdiet tellus. Nulla eu vestibulum urna. V"
				+ "ivamus tincidunt suscipit enim, nec ultrices nisi volutpat ac. Maecenas sit amet lacinia arcu, no"
				+ "n dictum justo. Donec sed quam vel risus faucibus euismod. Suspendisse rhoncus rhoncus felis at f"
				+ "ermentum. Donec lorem magna, ultricies a nunc sit amet, blandit fringilla nunc. In vestibulum vel"
				+ "it ac felis rhoncus pellentesque. Mauris at tellus enim. Aliquam eleifend tempus dapibus. Pellent"
				+ "esque commodo, nisi sit amet hendrerit fringilla, ante odio porta lacus, ut elementum justo nulla"
				+ " et dolor.";
		String solucion = justify(LIPSUM, 30);
		String expected = "Lorem  ipsum  dolor  sit amet,\nconsectetur  adipiscing  elit.\n"
				+ "Vestibulum    sagittis   dolor\nmauris,  at  elementum  ligula\ntempor  eget.  In quis rhoncus\n"
				+ "nunc,  at  aliquet orci. Fusce\nat   dolor   sit   amet  felis\nsuscipit   tristique.   Nam  a\n"
				+ "imperdiet   tellus.  Nulla  eu\nvestibulum    urna.    Vivamus\ntincidunt  suscipit  enim, nec\n"
				+ "ultrices   nisi  volutpat  ac.\nMaecenas   sit   amet  lacinia\narcu,  non dictum justo. Donec\n"
				+ "sed  quam  vel  risus faucibus\neuismod.  Suspendisse  rhoncus\nrhoncus  felis  at  fermentum.\n"
				+ "Donec lorem magna, ultricies a\nnunc    sit    amet,   blandit\nfringilla  nunc. In vestibulum\n"
				+ "velit    ac    felis   rhoncus\npellentesque. Mauris at tellus\nenim.  Aliquam eleifend tempus\n"
				+ "dapibus. Pellentesque commodo,\nnisi    sit   amet   hendrerit\nfringilla,   ante  odio  porta\n"
				+ "lacus,   ut   elementum  justo\nnulla et dolor.";
		System.out.println(solucion + solucion.length());

	}

	public static String justify(String text, int width) {
		if (width >= text.length()) {
			return text;
		}
		String subString = "", solution = "", addspace = "";

		String numWords[];

		int textSize = text.length();
		int numLines = textSize % width == 0 ? textSize / width : textSize / width + 1;
		int endLine = width;
		int spacesToAdd = 0, spacesInLine = 0, spacesPerSpace = 0, spacesExcess = 0, totalSpacesMoreThanWidth = 0;

		for (int i = 0; i < numLines; i++) {
			spacesToAdd = 0;
			spacesInLine = 0;
			spacesPerSpace = 0;
			spacesExcess = 0;
			while (text.charAt(endLine) != '\s') {
				endLine--;
			}
			subString = text.substring(0, endLine);
			numWords = subString.split(" ");
			spacesToAdd = width - endLine;
			spacesInLine = numWords.length - 1;
			spacesPerSpace = spacesInLine > 0 ? spacesToAdd / spacesInLine : 0;
			spacesExcess = spacesInLine > 0 ? spacesToAdd % spacesInLine : 0;
			for (int j = 0; j < numWords.length; j++) {
				if (spacesPerSpace > 0 && spacesExcess > 0) {
					addspace += numWords[j]
							+ " ".repeat(spacesPerSpace + 1).concat(" ".repeat(spacesExcess > 0 ? 1 : 0));
					spacesExcess--;
				} else if (spacesExcess == 0) {
					addspace += numWords[j] + " ".repeat(spacesPerSpace + 1);
				} else if (spacesExcess > 0) {
					addspace += numWords[j] + " ".repeat(spacesExcess > 0 ? 2 : 0);
					spacesExcess--;
				} else if (spacesPerSpace == 0) {
					addspace += numWords[j] + " ".repeat(spacesPerSpace + 1);
					spacesExcess--;
				}
			}
			totalSpacesMoreThanWidth += spacesToAdd;
			if (totalSpacesMoreThanWidth >= width && i != numLines - 1) {
				numLines++;
				totalSpacesMoreThanWidth = totalSpacesMoreThanWidth - width;
			}

			solution += addspace.strip() + "\n";
			addspace = "";
			text = text.substring(endLine + 1);

			endLine = width;
			if (text.length() <= width)
				break;
		}
		solution += text;
		return solution;
	}

}

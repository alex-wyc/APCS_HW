public class Shapes {

	public static void main(String[] args) {
		
		System.out.println(tri1(10));

		System.out.println(tri2(10));

		System.out.println(tri3(4));

		System.out.println(diamond(5));

		System.out.println(diamond(6));

		System.out.println(tri4(4));

	}

	public static String tri1(int h) {

		int width = 1;
		String triangle = "";

		while (width < h + 1) {

			for (int i = 0 ; i < width ; i++) {

				triangle = triangle + "*";
			
			}

			triangle = triangle + "\n";

			width++;
		
		}
		
		return triangle;
	}

	public static String tri2(int h) {

		int width = 1;
		String triangle = "";

		while (width < h + 1) {

			for (int i = 0; i < (h - width) ; i++) {

				triangle = triangle + " ";
			}

			for (int i = 0; i < width; i++) {

				triangle = triangle + "*";
			}

			triangle = triangle + "\n";

			width++;

		}

		return triangle;
	}

	public static String tri3(int h) {

		int lastRow = 2*h-1;
		int currentRow = 1;
		String result = "";

		while (currentRow <= lastRow) {
			int blanks = (lastRow - currentRow) / 2;
			for (int i = 0 ; i < blanks ; i++) {
				result = result + " ";
			}
			for (int i = 0 ; i < currentRow ; i++) {
				result = result + "*";
			}
			result = result + "\n";
			currentRow = currentRow + 2;
		}

		return result;
	}

	public static String diamond(int h) {

		int middleRow = h;
		int currentRow = 1;
		String result = "";

		if (h%2 == 0) {
			middleRow = middleRow + 1;
		}

		while (currentRow < h) {

			int blanks = (middleRow - currentRow) / 2;

			for(int i = 0; i < blanks; i++) {
				result = result + " ";
			}

			for(int i = 0 ; i < currentRow ; i++) {
				result = result + "*";
			}

			result = result + "\n";

			currentRow = currentRow + 2;
		}

		while (currentRow > 0) {
			
			int blanks = (middleRow - currentRow) / 2;

			for(int i = 0 ; i < blanks ; i++) {
				result = result + " ";
			}

			for(int i = 0 ; i < currentRow ; i++) {
				result = result + "*";
			}

			result = result + "\n";

			currentRow = currentRow - 2;
		}

		return result;
	}

	public static String tri4(int h) {

		int topRow = h;
		int currentRow = h;
		String result = "";

		while (currentRow > 0) {

			int blanks = topRow - currentRow;

			for(int i = 0 ; i < blanks ; i++) {
				result = result + " ";
			}

			for(int i = 0 ; i < currentRow ; i++) {
				result = result + "*";
			}

			result = result + "\n";

			currentRow = currentRow - 1;
		}
		
		return result;
	}

}

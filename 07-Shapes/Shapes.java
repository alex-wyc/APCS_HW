public class Shapes {

	public static void main(String[] args) {
		
		System.out.print(tri1(10));

		System.out.print(tri2(10));

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
}

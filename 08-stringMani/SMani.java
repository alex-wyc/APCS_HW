public class SMani {

	public static void main(String[] args) {

		System.out.println(frame(10,5));

		System.out.println(stringSplosion("code"));

		System.out.println(stringX("xhajgfxxhgjfhaiux"));
	
	}

	public static String frame(int r, int c) {

		int rowCount = 0;
		String result = "";

		for (int i = 0 ; i < c ; i++) {
			result = result + "*";
		}

		result = result + "\n";

		for (int i = 0 ; i < r-1 ; i++) {
			
			result = result + "*";

			for (int ii = 0 ; ii < c-2 ; ii++) {

				result = result + " ";
			
			}

			result = result + "*\n";
		}

		for (int i = 0 ; i < c ; i++) {
			result = result + "*";
		}

		return result;
	}

	public static String stringSplosion(String str) {

		int n = 0;
		String result = "";

		while (n <= str.length()) {

			result = result + str.substring(0,n);
			
			n++;

		}

		return result;
	}

	public static String stringX(String str) {

		String result = "";

		result = str.replaceAll("x","");

		if (str.substring(0,0) == "x") {
			result = "x" + result;
		}

		if (str.substring(str.length() - 1) == "x") {
			result = result + "x";
		}

		return result;
	}
}

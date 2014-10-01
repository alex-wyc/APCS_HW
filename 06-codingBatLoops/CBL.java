public class CBL {
	
	// Written within 3 min
	public String frontTimes(String str, int n) {
		
		if (n == 0) {
			
			return "";
			
		}
		
		if (str.length() >= 3) {

			str = str.substring(0,3);

		}
		
		String ori = new String();
		ori = str;

		while (n > 1) {

			str = str + ori;
			n--;
		
		}

		return str;
	}

	// Written within 3 min
	public String stringBits(String str) {
		
		int n = 0;

		String result = new String();

		while (n < str.length()) {

			if (n % 2 == 0) {
				
				result = result + str.subString(n,n+1);
			
			}

			n++;
		}

		return result;
	}

	public String stringYak(String str) {

		int n = 0;
		boolean hasYak = false

		while (n < str.length()) {
			
			hasYak = str.substring(n, n + 3) == "yak";
			
			n ++
		}

		if (hasYak) {
			
			str = str.replaceAll("yak", "");
		}
		
		return str;
	}

	public int stringMatch(String a, String b) {

		int counter = 0;
		int position = 0;

		if (b.length() > a.length()) {

			String temp = new String();

			temp = a;
			a = b;
			b = temp;

		}

		while (position < (b.length() - 1)) {

			if (a.subString(position, position + 2) == b.subString(position, position + 2)) {

				counter++;
			
			}

			position++;
		
		}

		return counter;
	}
}

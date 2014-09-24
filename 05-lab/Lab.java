public class Lab {

	// Working
	public boolean nearHundred(int n) {
		return Math.abs(100-n) < 10	|| Math.abs(200 - n) < 10;
	}


	// Working
	public Boolean mixStart(String str) {
		if (str.length() > 2) {
			return str.substring(0,3).endsWith("ix");
		}
		else {
			return false;
		}
	}

	// Working
	public int teaParty(int tea, int candy) {
		
		if (tea < 5 || candy < 5) {
			return 0;
		}

		else if (tea >= candy*2 || candy >= tea*2) {
			return 2;
		}

		else {
			return 1;
		}
	}

	// Working
	public boolean lastDigit(int a, int b, int c) {

		if (mod10(a) != mod10(b) && mod10(a) != mod10(c) && mod10(c) != mod10(b)) {
			
			return false;

		}
		else {
			return true;
		}


	}

	private int mod10(int a) {
		
		return a % 10;

	}

}

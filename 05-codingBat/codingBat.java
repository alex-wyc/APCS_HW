public class codingBat {

	public String nonStart(String str0, String str1) {

		return str0.substring(1) + str1.substring(1);

	}

	public String makeABBA(String A, String B) {

		return A+B+B+A;

	}

	public int diff21(int n) {

		if (n <= 21) {
			return (21 - n);
		}
		else {
			return 2*(n - 21);
		}
	}

}

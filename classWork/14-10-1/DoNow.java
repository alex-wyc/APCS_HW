public class DoNow {

	public String box(int h, int w) {

		int n = 0;
		String box = new String();
		
		while(n < w) {

			box = box + "*";
			n++;

		}

		box = box + "\n";
		
		String line = box;

		n = 0;

		while(n < h - 1) {

			box = box + line;
			n++;

		}

		return box;
	}

}

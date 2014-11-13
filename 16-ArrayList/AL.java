import java.util.*;

public class AL {

	private ArrayList<Integer> Al = new ArrayList<Integer>();

	public AL(int n) {
		for (int i = 0 ; i < n ; i++) {
			Al.add(i);
		}
	}

	public AL() {
		for (int i = 0 ; i < 6 ; i++) {
			Al.add(i);
		}
	}

	public ArrayList<Integer> get() {
		return Al;
	}

	public void Randomize() {
		ArrayList<Integer> AlCP = (ArrayList<Integer>)Al.clone();
		Al.clear();
		Random randgen = new Random();
		int size = AlCP.size();

		for (int i = 0 ; i < size ; i++) {
			int place = randgen.nextInt(AlCP.size());
			Al.add(AlCP.get(place));
			AlCP.remove(place);
		}

		//System.out.printf(Al.toString());
	}
}

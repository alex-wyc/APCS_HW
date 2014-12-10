import java.util.Random;
import java.util.Arrays;

/* Interface structure:

interface name {
	method1_signatrure
	method2_signature
	etc.
}
*/

public class Interval implements Comparable{

	// Instance Vars

	private int lowerBound;
	private int higherBound;
	private static Random randgen = new Random();

	// Constructors

	public Interval(int lower, int higher) {
		this.lowerBound = lower;
		this.higherBound = higher;
	}

	public Interval() {
		int h = 1 + randgen.nextInt(999);
		int l = randgen.nextInt(h);
		setUp(l,h);
	}

	private void setUp(int l, int h) {
		this.lowerBound = l;
		this.higherBound = h;
	}

	// Functions

	public String toString() {
		String s = "[" + lowerBound + "," + higherBound + "]";
		return s;
	}

	public int getLowerBound() {
		return lowerBound;
	}

	public int getHigherBound() {
		return higherBound;
	}

	public void setLowerBound(int low) {
		lowerBound = low;
	}

	public void setHigherBound(int high) {
		higherBound = high;
	}

	public int compareTo(Object Other) {
		Interval O = (Interval)Other;
		if (O.getLowerBound() == lowerBound) {
			return higherBound - O.getHigherBound();
		}
		else {
			return lowerBound - O.getLowerBound();
		}
	}

	public static void isort(Interval[] data) {
		for (int i = 1 ; i < data.length ; i++){ // Sorting index
			Interval newVal = data[i];
			int a;
			for (a = i ; a > 0 && newVal.compareTo(data[a - 1]) < 0 ; a--) {
				data[a] = data[a-1];
			}
			data[a] = newVal;
		}
	}

	public static void main(String[] args) {
		Interval a = null;
		
		for (int i = 0 ; i < 50 ; i++) {
			a = new Interval();
			//System.out.println(a.toString());
		}

		/*
		Interval c = new Interval(0,20);
		Interval d = new Interval(5,25);
		System.out.println(c.compareTo(d));
		*/

		Interval[] b = new Interval[10];

		for (int i = 0 ; i < 10 ; i++) {
			b[i] = new Interval();
		}

		Arrays.sort(b);

		//isort(b);

		System.out.println(Arrays.toString(b));
	}
}

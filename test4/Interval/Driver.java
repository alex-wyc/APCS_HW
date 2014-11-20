import java.util.*;

public class Driver{

	public static void main(String[] args) {
		// there are 6 different scenarios:
		// a a b b --> false
		// a b a b --> true
		// a b b a --> true
		// b b a a --> false
		// b a b a --> true
		// b a a b --> true

		// Case 1: a a b b
		Interval a = new Interval(0,1);
		Interval b = new Interval(1,3);
		System.out.println(Overlap(a,b)); // Returns false, check

		// Case 2: a b a b
		a = new Interval(0,2);
		b = new Interval(1,3);
		System.out.println(Overlap(a,b)); // Returns true, check

		// Case 3: a b b a
		a = new Interval(0,3);
		b = new Interval(1,2);
		System.out.println(Overlap(a,b)); // Returns true, check

		// Case 4: b b a a
		a = new Interval(2,3);
		b = new Interval(0,1);
		System.out.println(Overlap(a,b)); // Returns false, check

		// Case 5: b a b a
		b = new Interval(0,2);
		a = new Interval(1,3);
		System.out.println(Overlap(a,b)); // Returns true, check

		// Case 3: b a a b
		b = new Interval(0,3);
		a = new Interval(1,2);
		System.out.println(Overlap(a,b)); // Returns true, check
	}

	public static boolean Overlap (Interval a, Interval b) {
		return !(a.getHigh() < b.getLow() || b.getHigh() < a.getLow()); // problem => less than or greater than, NO EQUAL SIGNS HERE
	}

}

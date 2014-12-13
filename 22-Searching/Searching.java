import java.util.*;

public class Searching {

	// Instance vars
	private Comparable[] data;

	// Constructors
	public Searching(int n) {
		data = new Comparable[n];
	}

	// Methods

	public String toString() {
		return Arrays.toString(data);
	}

	public void add(Comparable item) {
		
		for (int i = 0 ; i < data.length ; i++) {
			if (data[i] == null) {
				data[i] = item;
				return;
			}
		}

		throw new ArrayIndexOutOfBoundsException();
	}

	public static Comparable ISearch(Comparable[] dataset, Comparable item) {
		
		for (int i = 0 ; i < dataset.length ; i++) {
			if (dataset[i].equals(item)) {
				return dataset[i];
			}
		}

		return null;
	}

	public Comparable ISearch(Comparable item) {

		for (int i = 0 ; i < data.length ; i++) {
			if (data[i].equals(item)) {
				return data[i];
			}
		}

		return null;
	}

	private void sort() {
		Arrays.sort(data);
	}

//	public Comparable bsearch() {
//
//	}

	public Comparable rbsearch(Comparable item) {
		// wrapper function!
		return rbsearch(data, item, data.length / 2);
	}

	private Comparable rbsearch(Comparable[] data, Comparable item, int pivotIndex) {

		// base case

		if (data.length == 1) { // division by two can caust truncation, which isn't good
			if (data[0].equals(item)) {
				return data[0];
			}

			return null;
		}

		// recursive statement

		if (item.compareTo(data[pivotIndex]) == 0) { // If I am very lucky!
			return data[pivotIndex];
		}

		if (item.compareTo(data[pivotIndex]) > 0) { // item is larger, searches pivot -> end
			return rbsearch(Arrays.copyOfRange(data, pivotIndex, data.length), item, (data.length - pivotIndex) / 2);
		}

		else { // item is lower, searches 0 -> pivot
			return rbsearch(Arrays.copyOfRange(data, 0, pivotIndex), item, pivotIndex / 2);
		}
	}

	// MAIN!!

	public static void main(String args[]) {
		Searching test = new Searching(100);

		for (int i = 0 ; i < 100 ; i++) {
			test.add(i);
		}

		System.out.println(test.toString());

		for (int i = 0 ; i < 100 ; i++) {
			System.out.println(test.rbsearch(i));
		}

		System.out.println(test.rbsearch(105));
	}
}

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

	public Comparable[] getData() {
		return data;
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

	public Comparable bsearch(Comparable item) {

		Comparable[] dataset = Arrays.copyOf(data, data.length);
		Arrays.sort(dataset);
		int pivot = dataset.length / 2;
		int flag = 0;

		while (dataset.length != 1) {

			flag = item.compareTo(dataset[pivot]);

			System.out.println("Data: " + Arrays.toString(dataset) + " Pivot: " + pivot + " Flag: " + flag);		

			if (flag == 0) {
				return dataset[pivot];
			}

			else if (flag > 0) {
				dataset = Arrays.copyOfRange(dataset, pivot + 1, data.length);
				pivot = (data.length - pivot) / 2;
			}

			else {
				dataset = Arrays.copyOfRange(dataset, 0, pivot);
				pivot = pivot / 2;
			}
		}

		if (dataset[0].equals(item)) {
			return dataset[0];
		}
		else {
			return null;
		}
	}

	public Comparable rbsearch(Comparable item) {
		Comparable[] dataset = Arrays.copyOf(data, data.length);
		
		Arrays.sort(dataset);
		// wrapper function!
		return rbsearch(dataset, item, dataset.length / 2);
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
			return rbsearch(Arrays.copyOfRange(data, pivotIndex + 1, data.length), item, (data.length - pivotIndex) / 2);
		}

		else { // item is lower, searches 0 -> pivot
			return rbsearch(Arrays.copyOfRange(data, 0, pivotIndex), item, pivotIndex / 2);
		}
	}

	// MAIN!!

	public static void main(String args[]) {
		
		int size = Integer.parseInt(args[0]);
		
		Searching test = new Searching(size);
		Random randgen = new Random();

		for (int i = 0 ; i < size ; i++) {
			test.add(randgen.nextInt(1000));
		}

		System.out.println(test.toString());

		//System.out.print("\n[");

		for (int i = 0 ; i < size ; i++) {
			System.out.println(test.bsearch(test.getData()[i]));
		}
		//System.out.print("]\n");
	}
}

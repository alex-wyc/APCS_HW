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

	public static Comparable lsearch(Comparable[] dataset, Comparable item) {
		
		for (int i = 0 ; i < dataset.length ; i++) {
			if (dataset[i].equals(item)) {
				return dataset[i];
			}
		}

		return null;
	}

	public Comparable lsearch(Comparable item) {

		for (int i = 0 ; i < data.length ; i++) {
			if (data[i].equals(item)) {
				return data[i];
			}
		}

		return null;
	}

	public static Comparable SortedBsearch(Comparable[] dataset, Comparable item) {

		int pivot = dataset.length / 2;
		int flag = 0;
		int originalLength;

		while (dataset.length != 1) {

			flag = item.compareTo(dataset[pivot]);

			if (flag == 0) {
				return dataset[pivot];
			}

			else if (flag > 0) {
				originalLength = dataset.length;
				dataset = Arrays.copyOfRange(dataset, pivot + 1, originalLength);
				pivot = (originalLength - pivot) / 2;
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

	public Comparable bsearch(Comparable item) {

		Comparable[] dataset = Arrays.copyOf(data, data.length);
		Arrays.sort(dataset);
		return SortedBsearch(dataset,item);
	}

	public static Comparable SortedRbsearch(Comparable[] dataset, Comparable item) {
		return rbsearch(dataset, item, dataset.length / 2);
	}

	public Comparable rbsearch(Comparable item) {
		Comparable[] dataset = Arrays.copyOf(data, data.length);
		
		Arrays.sort(dataset);
		// wrapper function!
		return rbsearch(dataset, item, dataset.length / 2);
	}

	private static Comparable rbsearch(Comparable[] data, Comparable item, int pivotIndex) {

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
		
		Searching btest = new Searching(size);
		Searching ltest = new Searching(size);
		Searching rbtest = new Searching(size);
		Integer[] OrderedLtest = new Integer[size];
		Integer[] OrderedBtest = new Integer[size];
		Integer[] OrderedRbtest = new Integer[size];

		Random randgen = new Random(100);

		int el;

		for (int i = 0 ; i < size ; i++) {
			el = randgen.nextInt(1000);

			btest.add(el);
			ltest.add(el);
			rbtest.add(el);
			OrderedBtest[i] = i;
			OrderedLtest[i] = i;
			OrderedRbtest[i] = i;

		}

		//System.out.println(test.toString());

		System.out.println("UNSORTED TEST");

		long beginTime = System.currentTimeMillis();

		for (int i = 0 ; i < size ; i++) {
			ltest.lsearch(ltest.getData()[i]);
		}

		long endTime = System.currentTimeMillis();

		System.out.println("Linear Search took: " + (endTime - beginTime) + " milliseconds.");

		beginTime = System.currentTimeMillis();

		for (int i = 0 ; i < size ; i++) {
			btest.bsearch(btest.getData()[i]);
		}

		endTime = System.currentTimeMillis();

		System.out.println("Binary Search took: " + (endTime - beginTime) + " milliseconds.");
				

		beginTime = System.currentTimeMillis();

		for (int i = 0 ; i < size ; i++) {
			rbtest.rbsearch(rbtest.getData()[i]);
		}

		endTime = System.currentTimeMillis();

		System.out.println("Recursive Binary Search took: " + (endTime - beginTime) + " milliseconds.");
		
		System.out.println("SORTED TEST");

		beginTime = System.currentTimeMillis();

		for (int i = 0 ; i < size ; i++) {
			Searching.lsearch(OrderedLtest, OrderedLtest[i]);
		}

		endTime = System.currentTimeMillis();

		System.out.println("Linear Search took: " + (endTime - beginTime) + " milliseconds.");

		beginTime = System.currentTimeMillis();

		for (int i = 0 ; i < size ; i++) {
			Searching.SortedBsearch(OrderedBtest, OrderedBtest[i]);
		}

		endTime = System.currentTimeMillis();

		System.out.println("Binary Search took: " + (endTime - beginTime) + " milliseconds.");
				

		beginTime = System.currentTimeMillis();

		for (int i = 0 ; i < size ; i++) {
			Searching.SortedBsearch(OrderedRbtest, OrderedRbtest[i]);
		}

		endTime = System.currentTimeMillis();

		System.out.println("Recursive Binary Search took: " + (endTime - beginTime) + " milliseconds.");

	}
}

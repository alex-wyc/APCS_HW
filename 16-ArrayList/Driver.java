import java.util.*;
import java.io.*;

public class Driver{

	public static void main(String[] args) {

		// Funny thing, when ran together it also takes approx. 0.060s

		System.out.println("ARRAYLIST");
		// Runtime = approx. 0.060s with 1.6 GHz Processor

		AL blah = new AL(10);
		System.out.println(blah.get().toString());
		blah.Randomize();
		System.out.println(blah.get().toString());

		System.out.println("ARRAYS");
		// Runtime = approx. 0.060s with 1.6 GHz Processor
		
		ArrayRandom AR = new ArrayRandom(10);
		System.out.println(Arrays.toString(AR.get()));
		AR.Randomize();
		System.out.println(Arrays.toString(AR.get()));

		
		/*
		ArrayList<Integer> AL = new ArrayList<Integer>();

		Random randgen = new Random();

		//System.out.println(AL.size());
		//try {
		for (int i = 0 ; i < 20 ; i++) {
			AL.add(randgen.nextInt(5));
		}
		//}
		//catch (Exception e) {
		//	System.out.println("Crashed here");
		//}

		//System.out.println(AL.size());
		System.out.println("Original Array");

		for (int i = 0 ; i < AL.size() ; i++) {
			System.out.print(AL.get(i) + ", ");
		}
		System.out.println();

		int temp = AL.get(0);

		for (int i = 1 ; i < AL.size() ; i++) {
			if (AL.get(i) == temp) {
				AL.remove(i);
				i--;
			}
			else {
				temp = AL.get(i);
			}
		}

		System.out.println("After the Purge");

		for (int i = 0 ; i < AL.size() ; i++) {
			System.out.print(AL.get(i) + ", ");
		}
		System.out.println();

		return;
		*/
	}
}

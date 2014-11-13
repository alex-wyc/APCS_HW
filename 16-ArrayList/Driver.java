import java.util.*;
import java.io.*;

public class Driver{

	public static void main(String[] args) {
		
		ArrayList<Integer> AL = new ArrayList<Integer>();

		Random randgen = new Random();

		//System.out.println(AL.size());
		//try {
		for (int i = 0 ; i < 20 ; i++) {
			AL.add(randgen.nextInt(21));
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
	}
}

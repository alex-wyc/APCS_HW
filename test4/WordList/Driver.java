import java.util.*;

public class Driver{

	public static void main(String[] args) {
		ArrayList<String> newList = new ArrayList<String>();
		String input = "";
		for (int i = 1 ; i < 10 ; i++) {
			for (int a = 0 ; a < i ; a++) {
				input = input + "a";
			}
			newList.add(input);
			input = "";
		}
		
		WordList wl0 = new WordList(newList);

		System.out.println(wl0.get().toString());

		for (int i = 5 ; i < 10 ; i++) {
			wl0.removeWordsOfLength(i);
			System.out.println(i + ": " + wl0.get().toString());
		}

		System.out.println("Test 2 -- Multiple occurances");
		newList.clear();
		newList.add("cat");
		newList.add("mouse");
		newList.add("frog");
		newList.add("dog");
		newList.add("dog");

		wl0 = new WordList(newList);
		System.out.println(wl0.get().toString());

		// 4 works
		wl0.removeWordsOfLength(3);
		System.out.println(wl0.get().toString());

	}
}

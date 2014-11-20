import java.util.*;

public class WordList{

	private ArrayList<String> myList;

	public WordList(ArrayList<String> list) {
		myList = list;
	}

	public int numWordsOfLength(int len) {
		int counter = 0;
		for (int i = 0 ; i < myList.size() ; i++) {
			if (myList.get(i).length() == len) {
				counter++;
			}
		}

		return counter;
	}

	public void removeWordsOfLength(int len) {
		for (int i = 0 ; i < myList.size() ; i++) {
			if (myList.get(i).length() == len) {
				myList.remove(i);
				i--; // Mistake was here...
			}
		}
	}

	public ArrayList<String> get() {
		return myList;
	}
}

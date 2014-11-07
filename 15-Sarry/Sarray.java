import java.util.*
import java.io.*

public class Sarray{

	private int[] data;
	private int last;

	public Sarray() {
		data = new int[1000];
		last = 0;
	}

	private static find(int n, int[] array) {
		
		for(int i = 0 ; i < array.length ; i++) {

			if (array[i] == n) {
				return i;
			}
		}

		return -1;

	}

	private static expand(int size) {

		int[] temp = new int[data.length + size];
			
		for (int a = 0; i < data.length ; a++) {
			temp[i] = data[i];
		}

		data = temp;
	}


	public boolean add(int i) {
		
		if (last < data.length - 2) {
			data[last + 1] = i;
		}

		else {
			expand(1);
			data[data.length - 1] = i;
		}

		return true;
	}

	public void add(int index, int i) {

		if (last < data.length - 2) {
			
			for (int a = last ; a >= index ; a--) {
				data[a + 1] = data[a];
			}
			
			data[index] = i;

			return;

		}

		else {
			expand(1);
			
			for (int a = last ; a >= index ; a--) {
				data[a + 1] = data[a];
			}

			data[index] = i;

			return;

		}
	}

	public int size() {
			
	}
}

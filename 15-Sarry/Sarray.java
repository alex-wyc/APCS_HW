import java.util.*;
import java.io.*;

public class Sarray{

	private int[] data;
	private int last;

	public Sarray() {
		data = new int[1000];
		last = 0; // Index of last element != 0
	}

	public Sarray(int[] Ndata) {
		data = Ndata;
		last = Ndata.length;
	}

	private int find(int n, int[] array) {
		
		for(int i = 0 ; i < last ; i++) {

			if (array[i] == n) {
				return i;
			}
		}

		return -1;

	}

	private void expand(int size) {

		throw new ArrayIndexOutOfBoundsException(); // Expand, but just tell the user it's out-of-bounds
		/*
		I lied, throw terminates the thing

		int[] temp = new int[data.length + size];
			
		for (int a = 0; a < data.length ; a++) {
			temp[a] = data[a];
		}

		data = temp;
		*/
	}


	public boolean add(int i) {
		
		if (last < data.length - 2) {
			data[last + 1] = i;
		}

		else {
			expand(1);
			data[data.length - 1] = i;
		}

		last++;

		return true;
	}

	public void add(int index, int i) {

		if (last < data.length - 2) {
			
			for (int a = last ; a >= index ; a--) {
				data[a + 1] = data[a];
			}
			
			data[index] = i;
		}

		else {
			expand(1);
			
			for (int a = last ; a >= index ; a--) {
				data[a + 1] = data[a];
			}

			data[index] = i;

		}
		
		last++;

		return;
	}

	public void addChunk(int[] chunk, int index) {

		if (last < data.length - chunk.length - 1) {

			for (int i = last ; i >= index ; i--) {
				data[i+1] = data[i];
			}

			for (int a = index ; a < chunk.length ; a++) {
				data[a] = chunk[a];
			}
		}

		else {
			expand(chunk.length);
		
			for (int i = last ; i >= index ; i--) {
				data[i+1] = data[i];
			}

			for (int a = index ; a < chunk.length ; a++) {
				data[a] = chunk[a];
			}
		}

		return;
	}

	public int size() {

		return last + 1; // last marks the last index, everything before it (0 index) included represent the size of the list
	}

	public int get(int index) {

		if (index > last) {
			return -1; // 0's should mark empty space
		}

		else {
			return data[index];
		}
	}

	public int set(int index, int i) {

		if (index > data.length) {
			expand(index - data.length);
			last = index;
			data[last] = i;
			return -1; // Means one needed to expand the data
		}

		else {
			int temp = data[index];
			data[index] = i;
			return temp;
		}
	}

	public int remove(int index) {
		int temp = data[index];

		for (int i = index + 1; i <= last ; i++) {
			data[i] = data[i - 1];
		}

		data[last] = 0;
		last--;

		return temp;
	}
}

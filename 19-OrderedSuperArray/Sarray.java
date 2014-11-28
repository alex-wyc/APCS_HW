import java.util.*;
import java.io.*;

public class Sarray<T>{

	public T[] data;
	public int last;

	public Sarray() {
		data = (T[])(new Object[1000]);
		last = -1; // Index of last element != 0
	}

	public Sarray(T[] Ndata) {
		data = Ndata;
		last = Ndata.length - 1;
	}

	public String toString() {
		T[] temp = Arrays.copyOfRange(data,0,last + 1);
		return Arrays.toString(temp);
	}

	private int find(T n) {
		
		for(int i = 0 ; i < last ; i++) {

			if (data[i].equals(n)) {
				return i;
			}
		}

		return -1;

	}

	private void expand(int size) {
		
		if (size > 1) {
			throw new ArrayIndexOutOfBoundsException(); // Expand, but just tell the user it's out-of-bounds
		}

		else {
			//I lied, throw terminates the thing

			T[] temp = (T[])(new Object[data.length + size]);
				
			for (int a = 0; a < data.length ; a++) {
				temp[a] = data[a];
			}

			data = temp;
		}
	}


	public boolean add(T i) {
		
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

	public void add(int index, T i) {

		if (last < data.length - 2) {
			
			for (int a = last ; a >= index ; a--) {
				data[a+1] = data[a];
			}
			
			data[index] = i;
		}

		else {
			expand(1);
			
			for (int a = last ; a >= index ; a--) {
				data[a+1] = data[a];
			}

			data[index] = i;

		}
		
		last++;

		return;
	}
	/*

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

	*/

	public int size() {

		return last + 1; // last marks the last index, everything before it (0 index) included represent the size of the list
	}

	public T get(int index) {

		if (index > last) {
			return null; // 0's should mark empty space
		}

		else {
			return data[index];
		}
	}

	public T set(int index, T i) {

		if (index > data.length) {
			expand(index - data.length);
			last = index;
			data[last] = i;
			return null; // Means one needed to expand the data
		}

		else {
			T temp = data[index];
			data[index] = i;
			return temp;
		}
	}

	public T remove(int index) {
		T temp = data[index];

		for (int i = index + 1; i <= last ; i++) {
			data[i - 1] = data[i];
		}

		data[last] = null;
		last--;

		return temp;
	}
}

import java.util.*;
import java.io.*;

public class Sarray<T extends Object & Comparable>{

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

			T[] temp = (T[])(new Object[data.length + 1]);
				
			for (int a = 0; a < data.length ; a++) {
				temp[a] = data[a];
			}

			temp[temp.length - 1] = null;

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
	
	public void isort() {
		for (int i = 1 ; i <= last ; i++){ // Sorting index
			T newVal = data[i];
			int a;
			for (a = i ; a > 0 && newVal.compareTo(data[a - 1]) < 0 ; a--) {
				data[a] = data[a-1];
			}
			data[a] = newVal;
		}
	}

	public void ssort() {
		T minValue;
		int minIndex = 0;
		for (int i = 0 ; i <= last ; i++) {
			minValue = data[i];
			minIndex = i;
			for (int a = i ; a <= last; a++) {
				if (data[a].compareTo(minValue) <= 0) {
					minValue = data[a];
					minIndex = a;
				}
			}
			data[minIndex] = data[i];
			data[i] = minValue;
		}
	}

	public void bsort() {
		for (int i = 0 ; i <= last ; i++){
			for (int j = i+1 ; j <= last ; j++)  {
				if (data[i].compareTo(data[j]) >= 0) {
					T temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	/*

	private void mergeSort() {
		if (data.length % 2 != 0) {
			expand(1);
		}

		T[] superCollection = (T[])(new Object[data.length / 2]);

		for (int i = 0 ; i < superCollection.length ; i++) {
			dataIndex = 2*i;
			superCollection[i] = Arrays.copyOfRange(data,dataIndex,dataIndex + 2);
		}
		
		
	}
	
	private T[] sortedMerge(T[] data, T[] data2) {
		if (data.length < data2.length) {
			T[] temp = data2;
			data2 = data;
			data = temp;
		}

		T[] out = (T[])(new Object[data.length + data2.length]);
		pos = 0;

		while (data2.length != 0 && data.length != 0) {
			if (data[0] <= data2[0]) {
				out[pos] = data[0];
				data = Arrays.copyOfRange(data,1,data.length);
			}
			else {
				out[pos] = data2[0];
				data2 = Arrays.copyOfRange(data2,1,data2.length);
			}

			pos++;
		}

		for (int i = 0 ; i < data.length ; i++) {
			out[pos] = data[i];
			pos++;
		}

		for (int i = 0 ; i < data2.length ; i++) {
			out[pos] = data2[i];
			pos++;
		}

		return out;
	}
	*/
}

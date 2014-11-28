import java.util.*;
import java.io.*;

public class OrderedSarray<T extends Object & Comparable> extends Sarray<T> {

	public OrderedSarray() {
		super();
	}

	public boolean add(T element) {

		for (int i = 0 ; i <= last ; i++) {
			if (data[i].compareTo(element) >= 0) {
				super.add(i,element);
				return true;
			}
		}
		super.add(element);

		return true;
	}

	public void add(int index, T i) {
		this.add(i);
	}
}

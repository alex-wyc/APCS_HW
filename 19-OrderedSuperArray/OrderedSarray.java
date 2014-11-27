import java.util.*;
import java.io.*;

public class OrderedSarray<T> extends Sarray<T> {

	public OrderedSarray() {
		super();
	}

	public boolean add(T element) {

		for (int i = 0 ; i < last ; i++) {
			if (data[i] >= element) {
				super.add(i,element);
				return true;
			}
		}
		super.add(element);

		return true;
	}

	public void add(int index, T i) {
		add(i);
	}
}

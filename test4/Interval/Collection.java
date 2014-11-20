import java.util.*;

public class Collection{

	private ArrayList<Interval> collection;
	private int lastInterval; // Last used index in the collection

	public Collection(ArrayList<Interval> c) {
		collection = c;
	}

	public boolean Overlap (Interval a, Interval b) {
		return !(a.getHigh() < b.getLow() || b.getHigh() < a.getLow());
	}
}

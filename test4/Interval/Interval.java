import java.util.*;

public class Interval{

	private double low, high;
	public Interval(double l, double h) {
		low = l; high = h;
	}

	public void setLow(double l) {
		low = l;
	}

	public void setHigh(double h) {
		high = h;
	}

	public double getLow() {
		return low;
	}

	public double getHigh() {
		return high;
	}
}

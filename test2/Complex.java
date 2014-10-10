public class Complex {
	private int Real;
	private int Imaginary;

	public Complex(int x, int y) {
		Real = x;
		Imaginary = y;
	}

	public String toString() {
		return Real + " + " + Imaginary + "i";
	}

	public double norm() {
		return Math.sqrt(Real*Real + Imaginary*Imaginary);
	}

	public int compareTo(Complex other) {
		if (norm() == other.norm()) {
			return 0;
		}

		else if (norm() > other.norm()) {
			return 1;
		}
		
		else {
			return -1;
		}
	}
}

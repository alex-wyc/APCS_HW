public class Driver {

	public static void main(String[] args) {
		Complex c1, c2;
		
		c1 = new Complex(1,3);
		c2 = new Complex(3,1);

		System.out.println(c1.toString());
		System.out.println(c2.toString());

		System.out.println(c1.compareTo(c2));
	}
}

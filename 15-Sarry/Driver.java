public class Driver{

	public static void main(String[] args) {
		Sarray SA = new Sarray();

		for (int i = 0 ; i < 1001 ; i++){
			System.out.println(i);
			try {
				SA.add(i);
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Index out of bounds, expanded");
			}
		}

		try {
			SA.add(1005,100);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index out of bounds, expanded");
		}

		System.out.println(SA.get(1005));
		System.out.println(SA.get(1001));
		System.out.println(SA.get(95));
		System.out.println(SA.remove(94));
		System.out.println(SA.get(94));


	}
}

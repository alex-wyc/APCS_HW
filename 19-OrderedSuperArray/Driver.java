public class Driver{

	public static void main(String[] args) {
		Sarray<String> SAS = new Sarray<String>();
		Sarray<Integer> SAI = new Sarray<Integer>();
		Sarray<Double> SAD = new Sarray<Double>();

		SAS.add("hello");
		SAS.add("alpha");
		SAS.add("beta");
		System.out.println(SAS.toString());
		SAS.remove(0);
		System.out.println(SAS.toString());
		SAS.add("gamma");
		System.out.println(SAS.toString());
		
		SAI.add(10);
		SAI.add(20);
		SAI.add(30);
		System.out.println(SAI.toString());
		
		SAD.add(10.1);
		SAD.add(10.3);
		SAD.add(10.4);
		System.out.println(SAD.toString());
		
		}
}

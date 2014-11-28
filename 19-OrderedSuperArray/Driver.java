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
		SAS.add(0,"NEW");
		SAS.add(1,"ONE");
		System.out.println(SAS.toString());
		
		SAI.add(10);
		SAI.add(20);
		SAI.add(30);
		System.out.println(SAI.toString());
		
		SAD.add(10.1);
		SAD.add(10.3);
		SAD.add(10.4);
		System.out.println(SAD.toString());
		
		OrderedSarray<Integer> OSAI = new OrderedSarray<Integer>();

		OSAI.add(10);
		OSAI.add(5);
		OSAI.add(18);
		OSAI.add(13);
		System.out.println(OSAI.toString());
		OSAI.remove(2);
		System.out.println(OSAI.toString());
		OSAI.remove(0);
		System.out.println(OSAI.toString());
		OSAI.add(50);
		OSAI.add(0,30);
		System.out.println(OSAI.toString());



		OrderedSarray<String> OSAS = new OrderedSarray<String>();

		OSAS.add("Alpha");
		OSAS.add("Beta");
		OSAS.add("Charlie");
		OSAS.add("Alice");
		OSAS.add("Bob");
		OSAS.add("cake");
		System.out.println(OSAS.toString());

		OrderedSarray<Double> OSAD = new OrderedSarray<Double>();

		OSAD.add(10.2);
		OSAD.add(9.5);
		OSAD.add(10.234);
		OSAD.add(4.0);
		System.out.println(OSAD.toString());
		}
}

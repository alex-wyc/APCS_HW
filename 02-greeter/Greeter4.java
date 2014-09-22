public class Greeter4 {
	private String greeting; // = new String ("Hello World!");
	
	public Greeter4(String s) {
		greeting = s;
	}
	public Greeter4() {
		greeting = "Hello World!"; // This can be done instead of new String
								   // This is SLIGHTLY different
	}
	public void greet() {
		//	String greeting = new String("Sup!");
		System.out.println(greeting);
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String s) {
		greeting = s;
	}
	public void ungreet() {
		System.out.println("I'm out!'");	
	}
}

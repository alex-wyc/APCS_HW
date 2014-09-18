public class Driver4 {
	public static void main(String[] args) {
		Greeter4 g1 = new Greeter4();
		Greeter4 g2 = new Greeter4();
		//g1.greeting = new String("Bonjour!");
		g1.setGreeting("Bonjour");
		g1.greet();
		g2.greet();

		System.out.println("g1's greeting is: " + g1.getGreeting());
	}
}

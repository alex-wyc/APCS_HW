import java.io.*;

public class Greeter{
	// instance variables
	private String greet;

	// Constructors

	//public Greeter(String greeting) {
	//	greet = greeting;
	//}

	public Greeter() {
		greet = "Hello!";
	}

	// methods
	public String greetPerson(String name) {
		return greet + " " + name;
	}

	public String loudGreet() {
		return greet.toUpperCase();
	}
}

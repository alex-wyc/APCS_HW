import java.io.*;

public class Driver{

	public static void main(String[] args) {
		
		Greeter g0 = new Greeter();

		System.out.println(g0.greetPerson("Tom"));

		System.out.println(g0.greetPerson("Harry"));

		System.out.println(g0.loudGreet());

	}

}

import java.io.*;
import java.util.*;

public class Greeter {

    public void greet() {

		// Simple hello world program
		System.out.println("Hello World!");
		ungreet();
    
    }

	private void ungreet() {
		// private = only accessed from within the class
		System.out.println("I'm out");
	}

}

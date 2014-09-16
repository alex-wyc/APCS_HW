import java.io.*;
import java.util.*;

public class Greeter3 {

	// Attributes go here
	public String t = "This is a long-lived STRING";

    public void greet() {

		// Simple hello world program
		System.out.println("Hello World!");
		//ungreet();
    
		String s;
		// String = built-in java class, immutable stuff
		s = new String("This is a STRING!");
		System.out.println(s);
		// Strings are short lived stuff... These get garbage collected after the function exits
    }

	private void ungreet() {
		// private = only accessed from within the class
		System.out.println("I'm out");
	}

}

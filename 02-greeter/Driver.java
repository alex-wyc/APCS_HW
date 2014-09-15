import java.io.*;
import java.util.*;

public class Driver {
	public static void main(String[] args) {
		
		//How to use the greeter within the driver.
		
		Greeter g;
		//Creates a local variable to be of type greeter

		/*
		Variable declaration, all variables must be declared
		like global, turtles-own and patches-own variables in netlogo
		Declaration specifies the type of the variable
		local variable = a variable only visible/usable within a method, created when the method is called, destroyed when the function exits
		*/

		/*
		When main is ran, it occupies some memory on the computer
		Greeter g is a small box within main, we need to do something with it
		or java refuses to do stuff with it
		*/

		g = new Greeter();
		/*
		New:
		 1. Allocates enough memory to store a Greeter.
		 2. Do whatever's necessary to setup / initiates the memory to be a Greeter.
		 3. Returns the address of the memory that was allocated.

		 The assignment statement stores the address in g.
		*/

		//System.out.println(g);
		
		// This prints the location of the variable g within the memory

		/*
		When this file is compiled, Greeter is compiled as well
		All methods/class called during main are compiled as well
		*/

		g.greet();
		/*
		Accesses the greet method within the class g.
		*/
		//g.ungreet(); <-- Can't do because ungreet = private, but greet() can call ungreet()
	}
}

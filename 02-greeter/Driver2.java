import java.io.*;
import java.util.*;

public class Driver2 {
	public static void main(String[] args) {

	Greeter g1 = new Greeter();
	Greeter g2,g3;

	/*
	LHS of the equal sign: make a small block of memory for the var g1
	RHS of the equal sign: give the mem. location of new Greeter() to g1
	*/

	g2 = new Greeter();
	g3 = g2;
	// Assign loc. of g2 to g3

	//g1.greet();

	System.out.println("BEFORE:");
	System.out.println("g1 is at "+g1);
	System.out.println("g2 is at "+g2);
	System.out.println("g3 is at "+g3);
	
	//Greeter g2,g3;
	// One can create many similar vars by using commas

	g2 = new Greeter();

	System.out.println("AFTER:");
	System.out.println("g1 is at "+g1);
	System.out.println("g2 is at "+g2);
	System.out.println("g3 is at "+g3);
	
	// g3 will be at the old g2 spot, g2 will change

	g1 = new Greeter();
	// Old g1 is NO LONGER REACHABLE
	// They say Java is a garbage-collecting language, it frees unreachable memories from time to time
	// Ex. Netlogo grows really slow from time to time...

	System.out.println("AFTER AFTER:");
	System.out.println("g1 is at "+g1);
	System.out.println("g2 is at "+g2);
	System.out.println("g3 is at "+g3);

	}
}

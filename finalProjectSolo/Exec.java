import java.util.*;
import java.io.*;
import java.math.*;

public class Exec{

	private static Scanner sc = new Scanner(System.in);
	private static int choice = 0;
	private static String Choice = "";
	private static int cryptoSystem = 0;
	private static String path = "";

	public static void main(String[] args) {
		clearScreen();
		System.out.println("Welcome to <INSERT NAME> tool!");
		System.out.println();
		System.out.println("Please chose the cipher you want to use:");
		System.out.println("1). RSA");
		System.out.println("2). XOR");
		System.out.println("3). Rotational");
		System.out.println();

		try {
			choice = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Please enter an integer next time");
			System.exit(1);
		}

		while (!(choice < 2 && choice > 0)) {
			System.out.print("Not implemented yet, please try again: ");

			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Please enter an integer next time");
				System.exit(1);
			}

		}

		cryptoSystem = choice;

		clearScreen();

		switch (cryptoSystem) {
			
			case 1:
				System.out.println("Do you want to:");
				System.out.println("1). Encrypt");
				System.out.println("2). Decrypt");
				System.out.println();

				try {
					choice = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {
					System.out.println("Please enter an integer next time");
				}

				switch (choice) {
					case 1:
						System.out.print("Please enter the file you want to encrypt: ");
						path = sc.nextLine();

						RSA toEncrypt = new RSA(path);
						toEncrypt.Encrypt();

						break;

					case 2:
						System.out.print("Please enter the location of the encrypted file: ");
						path = sc.nextLine();

						RSA toDecrypt = new RSA(path);

						System.out.println();

						System.out.print("Do you have the private key? (y/n) ");
						Choice = sc.nextLine();

						while (!(Choice.equals("y") || Choice.equals("n"))) {
							System.out.println("That ain't a choice buddy.");
							System.out.print("Do you have the private key? (y/n) ");
							Choice = sc.nextLine();
						}

						BigInteger n;
						BigInteger e;

						switch (Choice) {
							case "y":

								System.out.println("Please enter the public key:");
								System.out.print("n: ");
								n = new BigInteger(sc.nextLine());
								System.out.print("e: ");
								e = new BigInteger(sc.nextLine());
								System.out.println();

								System.out.println("Please enter the private key:");
								System.out.print("d: ");
								BigInteger d = new BigInteger(sc.nextLine());

								toDecrypt.Decrypt(d,n);

								break;

							case "n":
	
								String choice2 = "";
								System.out.println("You have the complete public key right? (y/n) ");
								choice2 = sc.nextLine();

								while (!(choice2.equals("y") || choice2.equals("n"))) {
									System.out.println("That ain't a choice buddy.");
									System.out.println("You have the complete public key right? (y/n) ");
									choice2 = sc.nextLine();
								}

								switch (choice2) {
									case "y":

										System.out.println("No Problemo!");
										System.out.println("\nPlease enter the public key:");
										System.out.print("n: ");
										n = new BigInteger(sc.nextLine());
										System.out.print("e: ");
										e = new BigInteger(sc.nextLine());
										System.out.println();

										toDecrypt.Decrypt2(n,e);

										break;

									case "n":

										System.out.println("This may be a problem (this only works on small files (size <= 256 bytes))");
										System.out.println("Let's give this a try!");
										System.out.println("\nPlease enter the public key:");
										System.out.print("n: ");
										n = new BigInteger(sc.nextLine());

										toDecrypt.DecryptUlt(n);
								}

								break;
						}

						break;
				}

				break;
		}
	}

	private static void clearScreen() {
		System.out.println("\033\143");
	}
}

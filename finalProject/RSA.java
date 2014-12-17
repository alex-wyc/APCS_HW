import java.math.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class RSA {

	// Instance Variables

	private byte[] output;
	private byte[] data;
	private Path path;
	private ArrayList<Integer> primeList = new ArrayList<Integer>();
	private Random randgen = new Random();
	private Scanner sc = new Scanner(System.in);
	private BufferedReader br = null;
	private BigInteger modulus;
	private BigInteger exponent;
	private BigInteger privatekey;
	private final BigInteger ONE = new BigInteger("1");

	// Constructor

	public RSA(String inputPath) {
		try {
			File file = new File(inputPath);
			FileInputStream fis = new FileInputStream(file);
			int fileLen = (int)(file.length());
			data = new byte[fileLen];
			fis.read(data);
			fis.close();
		} catch (Exception e) {
			System.out.println("Invalid path to file. Program will exit now.");
			System.exit(1);
		}
	}

	// Methods

	public void Decrypt(BigInteger privatekey, BigInteger n) {

		System.out.print("Decrypting...					");

		BigInteger cipher = new BigInteger(data);

		BigInteger result = cipher.modPow(privatekey,n);

		output = result.toByteArray();

		System.out.println("[done]\n");

		System.out.println("Decryption complete, please specify which file you want to save the result to:");

		String OutputPath = "";

		OutputPath = sc.nextLine();

		writeMessage(OutputPath);

		return;
	}

	public void Encrypt() {
		System.out.print("Prime list loading...					");
		
		loadPrimes();

		System.out.println("[done]");
		System.out.println();
		System.out.print("Generating Keys...					");

		keyGen();

		System.out.println("[done]");
		System.out.println();
		System.out.print("Encryption in progress...				");

		output = encrypt(data);

		System.out.println("[done]");
		System.out.println();

		System.out.println("Encryption complete, please specify which file you want to save the result to:");

		String OutputPath = "";

		OutputPath = sc.nextLine();

		writeMessage(OutputPath);

		System.out.println("Output file " + path + " created.");
		System.out.println();
		System.out.println("Your public key:\nn: " + modulus.toString() + "\ne: " + exponent.toString());
		System.out.println();
		System.out.println("Your private key (please keep this safe): \n" + privatekey.toString() + "\ntyping <ENTER> will clear this screen.");

		sc.nextLine();
		clearScreen();
	
	}

	private byte[] encrypt(byte[] data) {
		BigInteger m = new BigInteger(data);

		BigInteger cipher = m.modPow(exponent, modulus);

		return cipher.toByteArray();
	}

	private void loadPrimes() {

		try {
			br = new BufferedReader(new FileReader(".primeList.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("\nPrime list file corrupt or missing, please reinstall this program.");
			System.exit(1);
		}
		
		String line = "";
		try {
			while ((line = br.readLine()) != null) {
				primeList.add(Integer.parseInt(line, 10));
			}
		} catch (IOException e) {
			System.out.println("\nPrime list file corrupt or missing, please reinstall this program.");
			System.exit(1);
		}

		return;
	}

	private void writeMessage(String path) {
		
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(path);
			fos.write(output);
			fos.close();

		} catch (Exception e) {
			System.out.println("Invalid path, please check your permission and typing and try again.");
			System.exit(1);
		}
	}


	private void keyGen() {

		long p1, p2; // Prime numbers
		BigInteger totient;

		p1 = primeList.get(randgen.nextInt(primeList.size() / 2));
		p2 = primeList.get((primeList.size() / 2) + randgen.nextInt(primeList.size() / 2));

		modulus = BigInteger.valueOf(p1 * p2);
		totient = BigInteger.valueOf((p1 - 1) * (p2 - 1));

		exponent = BigInteger.valueOf((long)(100 + randgen.nextInt(totient.intValue())));

		while (!(exponent.gcd(totient).equals(ONE))) {
			exponent = BigInteger.valueOf((long)(100 + randgen.nextInt(totient.intValue())));
		}

		privatekey = exponent.modInverse(modulus);
	}

	private void clearScreen() {
		System.out.println("\033\143");
	}
}

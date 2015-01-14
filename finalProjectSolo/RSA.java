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
	private BigInteger totient;
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

	// Decryption Methods

	public void Decrypt(BigInteger privatekey, BigInteger n) {

		System.out.print("Decrypting...						");

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

	public void Decrypt2(BigInteger n, BigInteger e) {
		System.out.print("Generating private key...				");

		totient = totientCalc(n);

		BigInteger privateKey = e.modInverse(totient);

		System.out.println("[done]");
		System.out.println();

		Decrypt(privateKey, n);
	}

	
	public void DecryptUlt(BigInteger n) {
		System.out.println("This may take a while...");

		modulus = n;
		totient = totientCalc(n);

		exponent = new BigInteger("2");

		String yesNo = "";

		while (!(yesNo.equals("y"))) {
			System.out.println("Is this it: " + testDecrypt() + " (y/n)");
			yesNo = sc.nextLine();
		}
	}

	private String testDecrypt() {

		BigInteger publickey;
		byte[] result;

		while (!(exponent.gcd(totient).equals(ONE))) {
			exponent = exponent.add(ONE);
		}

		publickey = exponent.modInverse(totient);

		BigInteger cipher = new BigInteger(data);

		result = cipher.modPow(privatekey, modulus).toByteArray();

		while (!(alphanumeric(result))) {

			exponent = exponent.add(ONE);
			while (!(exponent.gcd(totient).equals(ONE))) {
				exponent = exponent.add(ONE);
			}

			publickey = exponent.modInverse(totient);

			cipher = new BigInteger(data);

			result = cipher.modPow(privatekey,modulus).toByteArray();
		}

		return new String(result);
	}

	private boolean alphanumeric(byte[] data) {
		return true;
	}

	// Encryption Methods

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

		p1 = primeList.get(randgen.nextInt(primeList.size() / 2));
		p2 = primeList.get((primeList.size() / 2) + randgen.nextInt(primeList.size() / 2));

		modulus = BigInteger.valueOf(p1 * p2);
		totient = BigInteger.valueOf((p1 - 1) * (p2 - 1));

		exponent = BigInteger.valueOf((long)(Math.pow(2,16) + 1));

		while (!(exponent.gcd(totient).equals(ONE))) {
			exponent = exponent.add(ONE);
		}

		privatekey = exponent.modInverse(totient);
	}

	
	private BigInteger totientCalc(BigInteger modulo) {
		long n = modulo.longValue();
		long tot = n;

		for (int p = 2 ; p*p <= n ; p++) {
			if (n%p == 0) {
				tot /= p;
				tot *= (p-1);
				while (n % p == 0) {
					n /= p;
				}
			}
		}

		if (n > 1) {
			tot /= n;
			tot *= (n - 1);
		}

		return BigInteger.valueOf(tot);
	}

	/*
	private bool printableAscii(String str) {

	}
	*/

	private void clearScreen() {
		System.out.println("\033\143");
	}
}

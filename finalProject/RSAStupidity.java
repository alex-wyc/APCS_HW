import java.util.*;
import java.io.*;
import java.math.*;

public class RSA{
	
	// Instance variables
	private String message;
	private String output;
	private ArrayList<Integer> primeList = new ArrayList<Integer>();
	private BigInteger m;
	private int p;
	private int q;
	private BigInteger n;
	private BigInteger totient;
	private BigInteger e = BigInteger.valueOf((long)Math.pow(2, 16));
	private BigInteger d;
	private BigInteger c;
	private static Random randgen = new Random();
	private static Scanner sc = new Scanner(System.in);

	// Constructor
	public RSA(String original) {
		message = original;
	}

	// Methods

	public void Decrypt(BigInteger n, BigInteger d) {
		c = new BigInteger(dehexify(message));
		System.out.print("Decrypting...        ");
		m = c.modPow(d,n);
		output = stringfy(m);
		System.out.println("[done]");
		System.out.println(m);
		System.out.println("Your decrypted message is: " + output);
		return;
	}

	public void Encrypt() {
		System.out.print("Prime list loading...			");
		
		loadPrimes();

		System.out.println("[done]");
		System.out.println();
		System.out.print("Generating Keys.");

		p = primeList.get(randgen.nextInt(primeList.size()));
		q = primeList.get(randgen.nextInt(primeList.size()));

		n = new BigInteger(String.valueOf(p)).add(new BigInteger(String.valueOf(q)));

		totient = new BigInteger(String.valueOf(p - 1)).add(new BigInteger(String.valueOf(q - 1)));

		System.out.print(".");

		while (!(e.gcd(totient).equals(new BigInteger("1")))) {
			e = e.add(new BigInteger("1"));
		}

		System.out.print(".			");

		d = e.modInverse(totient);
		
		System.out.println("[done]");
		System.out.println();
		System.out.print("Encryption in progress.");

		m = toAscii(message);

		System.out.print(".");

		c = m.modPow(e, n);

		System.out.print(".		");

		output = c.toString(16);

		System.out.println("[done]");

		System.out.println();

		System.out.println("Encryption complete, please specify which file you want to save the result to:");

		String path = "";

		path = sc.nextLine();

		writeMessage(path);

		System.out.println("Output file " + path + " created.");
		System.out.println();
		System.out.println("Your private key (please keep this safe): \n" + d.toString() + "\ntyping <ENTER> will clear this screen.");

		sc.nextLine();
		clearScreen();
	}

	private void clearScreen() {
		System.out.println("\033\143");
	}

	private BigInteger toAscii(String s) {
		StringBuilder sb = new StringBuilder();
		String asciiStr = null;
		char[] chars = s.toCharArray();
		BigInteger asciiInt;
		int newVal;

		for (int i = 0 ; i < chars.length ; i++) {
			sb.append((int)chars[i]);
		}

		asciiStr = sb.toString();
		asciiInt = new BigInteger(asciiStr);

		return asciiInt;
	}

	private String dehexify(String hexStr) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < hexStr.length() - 1 ; i += 2) {
			String output = hexStr.substring(i, (i + 2));
			int decimal = Integer.parseInt(output, 16);
			sb.append(decimal);
		}

		return sb.toString();
	}

	private String stringfy(BigInteger n) {
		String original = n.toString();
		
		for (int i = 0 ; i < 2 - original.length() % 3 ; i++) {
			original = "0" + original;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0 ; i < original.length() - 3 ; i += 3) {
			sb.append((char)Integer.parseInt(original.substring(i, (i+3))));
		}

		String out = sb.toString();
		return out;
	}

	private void loadPrimes() {
		BufferedReader br = null;

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
		
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(path, "UTF-8");
		} catch (Exception e) {
			System.out.println("Invalid path, please check your permission and typing and try again.");
			System.exit(1);
		}

		pw.println("Cipher: " + output);
		pw.println("Public key: " + n.toString() + ", " + e.toString());

		pw.close();
	}
}

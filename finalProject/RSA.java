import java.util.*;

public class RSA {
	
	// Instance variables
	private String message;
	private String output;
	private ArrayList<Integer> primeList = new ArrayList<Long>();
	private BigInteger m;
	private int p;
	private int q;
	private BigInteger n;
	private BigInteger totient;
	private BigInteger e = Math.pow(2, 16);
	private BigInteger d;
	private BigInteger c;
	private static Random randgen = new Random();
	private static Scanner sc = new Scanner(System.in);

	// Constructor
	public RSA(String original) {
		message = original;
	}

	// Methods
	public Encrypt() {
		System.out.print("Prime list loading...        ");
		
		loadPrimes();

		System.out.println("[done]");
		System.out.println();
		System.out.print("Generating Keys.");

		p = primeList.get(randgen.nextInt(primeList.size()));
		q = primeList.get(randgen.nextInt(primeList.size()));

		n = ((BigInteger)p) * ((BigInteger)q);

		totient = ((BigInteger)(p - 1)) * ((BigInteger)(q - 1));

		System.out.print(".");

		while (e.gcd(totient) != 1) {
			e += 1;
		}

		System.out.print(".        ");

		d = e.modInverse(totient);
		
		System.out.println("[done]");
		System.out.print("Encryption in progress...         ");

		m = toAscii(message);

		c = m.pow(e.intValue()).mod(n);

		output = stringfy(c);

		System.out.println("[done]");

		System.out.println("Encryption complete, please specify which file you want to save the result to:");

		String path = "";

		path = sc.nextLine();

		writeMessage()
		}
	}

	private BigInteger toAscii(String s) {
		StringBuilder sb = new StringBuilder();
		String asciiStr = null;
		BigInteger asciiInt;

		for (int i = 0 ; i < s.length() ; i++) {
			sb.append((int)s.charAt(i));
		}

		asciiStr = sb.toString();
		asciiInt(asciiStr);

		return asciiInt;
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
}

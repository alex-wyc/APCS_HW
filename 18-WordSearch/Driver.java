import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		if (args.length < 2 || Arrays.asList(args).contains("--help") || Arrays.asList(args).contains("-h") || Arrays.asList(args).contains("-help")) {
			Usage();
		}

		int height = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);
		String boardPath = "";
		String keyPath = "";
		String dictPath = "/usr/share/dict/words"; // Default path
		boolean willScan = Arrays.asList(args).contains("-s");

		for (int i = 2 ; i < args.length ; i++) {
			if (args[i].equals("-b")) {
				boardPath = args[i+1];
			}
			else if (args[i].equals("-k")) {
				keyPath = args[i+1];
			}
			else if (args[i].equals("-f")) {
				dictPath = args[i+1];
			}
		}

		if (height * width < 250) {
			System.out.println("MAKE A BIGGER BOARD!!");
			System.exit(0);
		}

		if (height * width > 10000) {
			System.out.println("BOARD TOO BIG!!");
			System.exit(0);
		}
/*		
		try {
			bigEnough(height);
			bigEnough(width);
		} catch (ExceptionOfNoFun e) {
			System.out.println("MAKE A BIGGER BOARD!!!");
			System.exit(1);
		}
*/
		WordSearch ws = new WordSearch(height,width,willScan,dictPath);
		
		System.out.println(ws.ToString());

		if (!(boardPath.equals(""))) {
			ws.writeBoard(boardPath);
		}

		if (!(keyPath.equals(""))) {
			ws.writeKey(keyPath);
		}

	}

	private static void Usage() {
		System.out.println("USAGE: java Driver <height> <width>");
		System.out.println("\tOPTIONS:");
		System.out.println("\t\t-b [board plain text file output path]");
		System.out.println("\t\t-k [solution plain text file output path]");
		System.out.println("\t\t-f [path to the dictionary file seperated by newlines]");
		System.out.println("\t\t-s scan word from user");
		System.exit(0);
	}
/*
	private static void bigEnough(int num) {
		if (num < 6) {
			throw new ExceptionOfNoFun(); // Small board = no fun = discouraged by law
		}
	}
*/
}

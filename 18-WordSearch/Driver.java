public class Driver {

	public static void main(String[] args) {
		
		if (args.length < 2) {
			Usage();
		}

		int height = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);
		String boardPath = "";
		String keyPath = "";

		for (int i = 2 ; i < args.length ; i++) {
			if (args[i].equals("-b")) {
				boardPath = args[i+1];
			}
			else if (args[i].equals("-k")) {
				keyPath = args[i+1];
			}
		}

		if (height * width < 400) {
			System.out.println("MAKE A BIGGER BOARD!!");
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
		WordSear ws = new WordSear(height,width);
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

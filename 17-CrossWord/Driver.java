public class Driver {

	public static void main(String[] args) {
		
		if (args.length < 2) {
			System.out.println("USAGE: java Driver <height> <width>");
			System.exit(0);
		}

		int height = Integer.parseInt(args[0]);
		int width = Integer.parseInt(args[1]);
/*		
		try {
			bigEnough(height);
			bigEnough(width);
		} catch (ExceptionOfNoFun e) {
			System.out.println("MAKE A BIGGER BOARD!!!");
			System.exit(1);
		}
*/
		CrossWord cw = new CrossWord(height,width);
		System.out.println(cw.ToString());

	}
/*
	private static void bigEnough(int num) {
		if (num < 6) {
			throw new ExceptionOfNoFun(); // Small board = no fun = discouraged by law
		}
	}
*/
}

public class XOR {
	
	// Instance Variables

	byte[] data;
	byte[] result;

	// Constructor

	public XOR(String inputPath) {
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
}

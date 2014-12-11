import java.util.Random;
import java.util.Arrays;

public class Driver {

	public static Random randgen = new Random();
	
	public static void main(String[] args) {

		Basechar[] charList = new Basechar[10];
		
		for (int i = 0 ; i < 10 ; i++) {
			charList[i] = new Basechar(randomStr(1 + randgen.nextInt(10)));
		}
		
		System.out.println(Arrays.toString(charList));

		Arrays.sort(charList);
		
		System.out.println(Arrays.toString(charList));

		Akholyte[] akhList = new Akholyte[10];

		for (int i = 0 ; i < 10 ; i++) {
			akhList[i] = new Akholyte(randomStr(1 + randgen.nextInt(10)));
		}
		
		System.out.println(Arrays.toString(akhList));

		Arrays.sort(akhList);

		System.out.println(Arrays.toString(akhList));
	}

	public static String randomStr(int length) {
		final String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String out = "";
		for (int i = 0 ; i < length ; i++) {
			out = out + Character.toString(alphabet.charAt(randgen.nextInt(alphabet.length())));
		}
		return out;
	}
}

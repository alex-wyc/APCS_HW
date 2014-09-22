public class Driver {

	public static void main(String[] args) {
		
		String s = new String("yicheng wang");
		String firstName,lastName = new String();

		lastName = s.substring(s.indexOf(" ")+1);

		firstName = s.substring(0,s.indexOf(" "));

		System.out.println(s);
		System.out.println(lastName);
		System.out.println(firstName);
	}
}

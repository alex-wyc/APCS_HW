public class Driver {
	public static void main(String[] args) {
		
		SS ss1 = new SS();

		System.out.println(ss1.mixStart("xix world"));
		System.out.println(ss1.mixStart("abc world"));
		System.out.println();
		System.out.println(ss1.makeOutWord("<<>>","Hello World"));
		System.out.println(ss1.makeOutWord("[[]]","Bye World"));
		System.out.println();
		System.out.println(ss1.firstHalf("123456"));
		System.out.println(ss1.firstHalf("HelloWorld"));
	}

}

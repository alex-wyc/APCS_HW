public class Driver {

	public static void main(String[] args) {

		Lab lab = new Lab();

		System.out.println(lab.nearHundred(93));
		System.out.println(lab.nearHundred(193));
		System.out.println(lab.nearHundred(83));
		System.out.println(lab.teaParty(5,10));
		System.out.println(lab.teaParty(1,2));
		System.out.println(lab.teaParty(7,7));
		System.out.println(lab.lastDigit(93,193,1));
		System.out.println(lab.lastDigit(1,12,13));
		System.out.println(lab.lastDigit(3,193,93));
		System.out.println(lab.mixStart("mix Speak"));
		System.out.println(lab.mixStart("LOLSPEAK"));
		System.out.println(lab.mixStart("pixSPEAK"));
		System.out.println(lab.mixStart("LO"));
	}
}

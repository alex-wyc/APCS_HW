public class SS{
	public Boolean mixStart(String str) {
		return str.substring(0,3).endsWith("ix");
	}

	public String makeOutWord(String prompt, String word) {
		return prompt.substring(0,2) + word + prompt.substring(2);
	}
	public String firstHalf(String str) {
		return str.substring(0,str.length()/2);
	}
}

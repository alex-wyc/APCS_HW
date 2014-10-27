public class ArrayStuff{

	public int[] array = new int[100];

	public ArrayStuff() {
		
		Random randgen = new Random();

		for (i = 0; i < 100; i++) {
			int[i] = 75 + randgen.nextInt(76);
		}
	}

	public int find(int n) {
		
		for(int i = 0 ; i < 100 ; i++) {

			if (array[i] == n) {
				return i;
			}
		}

		return -1;

	}

	public int maxVal() {

		int maxValue = array[0];

		for(int i = 0 ; i < 100 ; i++) {

			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}

		return maxValue
	}

	public static void main(String[] args) {

		ArrayStuff as = new ArrayStuff();
		
		System.out.println(as.array);
		System.out.println(as.find(100));
		System.out.println(as.maxVal());
	}
}

public class ArrayStuff{

	public int[] array = new int[100];

	public ArrayStuff() {
		
		Random randgen = new Random();

		for (i = 0; i < 100; i++) {
			array[i] = 75 + randgen.nextInt(76);
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

		return maxValue;
	}

	public static int frequency(int i) {

		int loc = array[i];
		int counter = 0;

		for (int a = 0 ; a < array.length() ; a++) {
			if (array[a] == loc) {
				counter ++;
			}
		}

		return counter;
	}

	public static int sum67(int[] nums) {

		int sum = 0;
		boolean count = true;

		for (int i = 0; i < nums.length ; i++) {
			if (nums[i] == 6) {
				count = false;
			}

			else if (!(count) && (nums[i] == 7)) {
				count = true;
			}
			
			else if (count) {
				sum = sum + nums[i];
			}
		}

		return sum;
	}

	public static boolean more14(int[] nums) {
		int oneCounter = 0 , fourCounter = 0;
		
		for (int i = 0 ; i < nums.length ; i++) {
			if (nums[i] == 1) {
				oneCounter++;
			}

			else if (nums[i] == 4) {
				fourCounter++;
			}
		}

		return oneCounter > fourCounter;
	}

	public static int[] tenRun(int[] nums) {
		
		boolean replacing = false;
		int replacer = 0;
		int[] result = new int[nums.length];

		for(int i = 0 ; i < nums.length ; i++) {
			
			if (replacing && (nums[i] % 10 == 0)) {
				replacer = nums[i];
				result[i] = replacer;
			}
			
			else if ((nums[i] % 10 == 0) && !(replacing)) {
				replacer = nums[i];
				replacing = true;
				result[i] = nums[i];
			}

			else if (replacing) {
				result[i] = replacer;
			}

			else {
				result[i] = nums[i];
			}
		}

		return result;
	}

	public static boolean tripleUp(int[] nums) {

		if (nums.length < 3) {
			return false;
		}

		for (int i = 0 ; i < nums.length - 2 ; i++) {

			if ((nums[i+1] - nums[i]) == 1 && (nums[i+2] - nums[i+1]) == 1) {
				return true;
			}
		}

		return false;
	}

	public static boolean canBalance(int[] nums){

		if (nums.length < 2) {
			return false;
		}

		for (int i = 0 ; i < nums.length ; i++) {
			int sum1 = 0, sum2 = 0;
			
			for (int a = 0 ; a < i ; a++) {
				sum1 = sum1 + nums[a];
			}

			for (int b = i ; b < nums.length ; b++) {
				sum2 = sum2 + nums[b];
			}

			if (sum1 == sum2) {
				return true;
			}
		}
		
		return false;
	}

	public static int[] seriesUp(int degree) {

		int[] result = new int[degree * (degree + 1) / 2];
		int pos = 0;

		for (int i = 0 ; i < degree ; i++) {

			for (int j = 0 ; j <= i ; j++) {
				result[pos+j] = j+1;
			}

			pos = pos + i + 1;
		}

		return result;
	}

	public static void main(String[] args) {

		ArrayStuff as = new ArrayStuff();
		
		System.out.println(as.array);
		System.out.println(as.find(100));
		System.out.println(as.maxVal());
	}
}

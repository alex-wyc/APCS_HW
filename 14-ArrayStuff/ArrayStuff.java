import java.util.*;

public class ArrayStuff{

	public int[] array = new int[100];

	public ArrayStuff() {
		
		Random randgen = new Random();

		for (int i = 0; i < 100; i++) {
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

	public int maxValId(int[] array) {

		int maxValue = 0;

		for(int i = 0 ; i < array.length ; i++) {

			if (array[i] > maxValue) {
				maxValue = i;
			}
		}

		return maxValue;
	}

	public int maxVal(int[] array) {

		int maxValue = 0;

		for(int i = 0 ; i < array.length ; i++) {

			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}

		return maxValue;
	}


	public static int frequency(int i , int[] array) {

		int loc = array[i];
		int counter = 0;

		for (int a = 0 ; a < array.length ; a++) {
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

	public static int maxMirror(int[] nums) {

		boolean ok = true;

		if (Arrays.equals(nums,MirrorGen(nums))) {
			return nums.length;
		}

		for (int i = 0 ; i < nums.length ; i++) { // possible maxSize
			
			for (int j = 0 ; j < nums.length - i ; j++) { // Checking each position to see if it fits the possible maxSize
				
				int[] testing = Arrays.copyOfRange(nums, j, j + i);
				int[] mirror = MirrorGen(testing);

				System.out.println("The testing string is: " + Arrays.toString(testing));
				System.out.println("The mirror is: " + Arrays.toString(mirror));

				if (contains(nums, mirror)) {
					ok = true;
					break;
				}

				else {
					ok = false;
				}

			}

			if (ok) {
				System.out.println(i + " is A-OK");
			}

			else {
				return i - 1;
			}

		}

		return nums.length - 1 ; // Debugging reason only
	}

	public static int[] MirrorGen(int[] array) { // generates the mirror array

		int[] mirror = new int[array.length];

		for (int i = 0 ; i < array.length ; i++) {
			mirror[array.length - 1 - i] = array[i];
		}

		return mirror;

	}

	public static boolean contains(int[] array1, int[] array2) { // Checks if array1 contains array2
		
		int[] empty = {};

		if (Arrays.equals(array2,empty)) { // everything contains the empty array
			return true;
		}

		else if (Arrays.equals(array1,array2)) {
			return true;
		}

		for (int i = 0 ; i < array1.length - array2.length ; i++) {
			
			if (Arrays.equals(Arrays.copyOfRange(array1, i , i + array2.length), array2)) {
				
				return true;
			}
		}

		return false;
	}

	public static int mode(int[] num) {
		int[] freq = new int[num.length];

		for (i = 0 ; i < num.length ; i++) {
			freq[i] = frequency(num[i], num);
		}

		a = maxValId(freq);

		return num[a];
	}

	public static int mode2(int[] nums){

		int holder = new int[maxVal(nums)];

		for (i = 0 ; i < num.length ; i++) {
			holder[i] = holder[i] + 1;
		}

		return maxValId(holder);
		
	}

	public static void main(String[] args) {
		
		int[] a = {} , b = {1} , c = {1,2,3,4,3,2,1} , d = {21,22,9,8,7,6,23,24,6,7,8,9,25,7,8,9}, e = {1,2,1,4};
		
		//System.out.println(array);
		//System.out.println(find(100));
		//System.out.println(as.maxVal());
		System.out.println("a: " + maxMirror(a));
		System.out.println("b: " + maxMirror(b));
		System.out.println("c: " + maxMirror(c));
		System.out.println("d: " + maxMirror(d));
		System.out.println("e: " + maxMirror(e));
	}
}

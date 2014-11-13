import java.util.*;

public class ArrayRandom{
	
	private int[] nums;

	public ArrayRandom() {
		nums = new int[10];
		for (int i = 0 ; i < 10 ; i++) {
			nums[i] = i;
		}
	}

	public ArrayRandom(int len) {
		nums = new int[len];
		for (int i = 0 ; i < len ; i++) {
			nums[i] = i;
		}
	}

	public int[] get(){
		return nums;
	}

	public void Randomize() {
		Random randgen = new Random();
		int[] numsCP = new int[nums.length];
		for (int i = 0 ; i < nums.length ; i++) {
			numsCP[i] = nums[i];
		}

		for (int i = 0 ; i < nums.length ; i++) {
			int place = randgen.nextInt(numsCP.length);
			nums[i] = numsCP[place];
			numsCP = remove(numsCP,place);
		}
	}

	private int[] remove(int[] data, int index) {
		int[] newArray = new int[data.length - 1];
		for (int i = 0 ; i < index ; i++) {
			newArray[i] = data[i];
		}

		for (int i = index ; i < data.length - 1 ; i++) {
			newArray[i] = data[i+1];
		}

		return newArray;
	}
}

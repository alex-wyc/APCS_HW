public class StartingArray{

	public int[] frontPiece(int[] a) {
		
		if (a.length <= 2) {
			return a;
		}

		else {

			int[] result = new int[2];

			for (int i = 0 ; i < 2 ; i++) {
				result[i] = a[i];
			}

			return result;
		}
	}

	public int sum13(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		else if (nums.length == 1) {

			if (nums[0] == 13) {
				return 0;
			}

			else {
				return nums[0];
			}
		}

		else {
			int i = 0;
			int sum = 0;
			
			while (i < (nums.length - 1)) {
				
				if (nums[i] == 13) {
					i++;
				}

				else {
					sum = sum + nums[i];
				}

				i++;
			}

			if (nums[nums.length - 1] == 13) {

				return sum;

			}

			else if (nums[nums.length - 2] == 13){

				return sum;
			}

			else {
				return sum + nums[nums.length - 1];
			}
		}
	}
}

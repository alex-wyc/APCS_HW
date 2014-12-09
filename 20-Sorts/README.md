# Comparison of Different Sorting Algorithms with the Aid of Java

In this exercise, we explore the efficiencies of different types of sorting algorithms under different circumstances.

The sort studied in this exercise include:
* Insertion Sort
	* Procedure
		1. Split the array into two parts -- an unsorted section followed by a sorted section (initialized with 0 elements).
		2. Starting from the beginning of the unsorted section, take the element out (call it A), move everything forward until into the realm ofthe sorted section.
		3. Check each element in the sorted section, if the element in the sorted section is smaller than A, move it forward a spot, if not, insert A before the current element.
		4. Repeat step 2 and 3 until the unsorted section becomes empty.
	* Efficiency Analysis
		* The best case scenario for the insertion sort is if everything is already in order, or when everything is in reverse order, then it only takes n operations to sort out an array of n elements.
		* This sort works well on small sample sizes, but becomes more and more inefficient as randomness and size increases, with the worse case scenario having to do n^2 operations to sort out an array.
	* Code:
	```java
	public void isort() {
		for (int i = 1 ; i <= last ; i++){ // Sorting index
			T newVal = data[i];
			int a;
			for (a = i ; a > 0 && newVal.compareTo(data[a - 1]) < 0 ; a--) {
				data[a] = data[a-1];
			}
			data[a] = newVal;
		}
	}
	```
* Selection Sort
	* Procedure
		1. Create a cursor that points to the division between the sorted part of the array and the unsorted part of the array (initialized at 0).
		2. Find the minimum value of the part of the array from (inclusive) the cursor location to the end of the array.
		3. Swap tne minimum value with the value at the current cursor location.
		4. Move the cursor 1 position down.
		5. Repeat steps 2 to 4 until the cursor points to the last element of the array.
	* Efficiency Analysis
		* For the ith time the cursor has moved, finding the minimum takes 1 operation in the best case scenario and n-1 operation in the worst case scenario.
		* Therefore, for an array of n lists, the best case scenario will consist of n operations (resulted from the best case in each scan) and the worst case scenario results from the sum from 1 to n-1, which simplifies to n(n-1).
		* This sort is not as efficient as insertion sort for small datasets, but becomes more efficient as the sample size and array length become larger. However, it is still not as efficient as some of the more complicated algorithms.
	* Code:
	```java
	public void ssort() {
		T minValue;
		int minIndex = 0;
		for (int i = 0 ; i <= last ; i++) {
			minValue = data[i];
			minIndex = i;
			for (int a = i ; a <= last; a++) {
				if (data[a].compareTo(minValue) <= 0) {
					minValue = data[a];
					minIndex = a;
				}
			}
			data[minIndex] = data[i];
			data[i] = minValue;
		}
	}

	```
* Bubble Sort
	* Procedure
		1. Start with index i = 0 and a boolean value swapOccured = true.
		2. Compare the ith and (i + 1)th element of the array, if they are out of place, switch them.
		3. Increment i by 1.
		4. Repeat steps 1 - 3 until i is at the last element.
	* Efficiency Analysis
		* This sorting algorithm is extrememly inefficient for large data sets due to the fact that it has to always pass through the array n^2 times
		* Therefore this is NOT recommended for data set of any length and randomness (at low end insertion sort is better, at high end, quick sort and merge sort are better)
	* Code:
	```java
	public void bsort() {
		for (int i = 0 ; i <= last ; i++){
			for (int j = i+1 ; j <= last ; j++)  {
				if (data[i].compareTo(data[j]) >= 0) {
					T temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}

	```
* Timsort
	* This is the default sorting algorithm for java SE 7.
	* It is a combination of insertion sort and modified merge sort, it uses insertion sort if the dataset is less than 7 element long, and uses a modified merge sort for everything else
	* More info at this [Wikipedia page](http://en.wikipedia.org/wiki/Timsort)


## Results:


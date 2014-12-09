# Comparison of Different Sorting Algorithms with the Aid of Java

In this exercise, we explore the efficiencies of different types of sorting algorithms under different circumstances.

The sort studied in this exercise include:
* Insertion Sort
	* Procedure
		1. Split the array into two parts -- an unsorted section followed by a sorted section (initialized with 0 elements)
		2. Starting from the beginning of the unsorted section, take the element out (call it A), move everything forward until into the realm ofthe sorted section
		3. Check each element in the sorted section, if the element in the sorted section is smaller than A, move it forward a spot, if not, insert A before the current element
		4. Repeat step 2 and 3 until the unsorted section becomes empty
	* Efficiency
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
		1. For each 
* Bubble Sort
* Timsort

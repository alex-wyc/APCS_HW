#!/usr/bin/python

import random;
import sys;
import time;

toBeSorted = [];

if len(sys.argv) == 1:
	print "USAGE: ./quicksort.py <length of random list> <upper bound for randomness>"
	sys.exit();

for i in range(0,int(sys.argv[1])):
	toBeSorted.append(random.randint(0,int(sys.argv[2])));

print "To be sorted: " + str(toBeSorted)

def sort(array):
	lower = []
	higher = []
	equal = []
	if len(array) > 1:
		pivot = array[0]
		for element in array:
			if element > pivot:
				higher.append(element)
			elif element < pivot:
				lower.append(element)
			else:
				equal.append(element)
		return sort(lower) + equal + sort(higher)
	else:
		return array

startTime = time.time();
sortedArray = sort(toBeSorted);
endTime = time.time();

print "Sorted: " + str(sortedArray);
print "Time: " + str(endTime - startTime);

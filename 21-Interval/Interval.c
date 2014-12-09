#include<stdlib.h>
#include<stdio.h>
#include<time.h>

int main() {
	srand(time(NULL));
	int higherBound = rand() % 1000;
	int lowerBound = rand() % higherBound;
	printf("[%d,%d]\n",lowerBound,higherBound);
	return 0;
}

#include <stdio.h>
#include <math.h>


int main(void) {
	
	/* get array of 10 numbers */
	int sum = 0;
	int arr[10] = { 79, 10, 71, 82, 37,
		30, 86, 56, 27, 67 };
	for (int i = 0; i < 10; i++) {
		
		arr[i] = sqrt(arr[i]);
		sum = sum + arr[i];
	}

	int avg = (sum / 10);
	printf("The average of the square roots of the array is: %d", avg);
	getchar();
	return 0;


}
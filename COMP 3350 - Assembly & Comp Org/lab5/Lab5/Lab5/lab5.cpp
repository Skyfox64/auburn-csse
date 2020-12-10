#include <cstdint>
#include <iostream>
/* The minimum procedure is defined in util.asm */
extern "C" int32_t __cdecl minimum(int32_t a, int32_t b);

int32_t obvious_min(int32_t a, int32_t b) {
	return a < b ? a : b; 
}

void checkMin(int32_t a, int32_t b) { 

	int32_t expected = obvious_min(a, b);
	int32_t actual = minimum(a, b);  
	if (expected != actual) {
		std::cerr << "MINIMUM INCORRECT: " << a << ", " << b << std::endl; 
	} 
}

int32_t maximum(int32_t a, int32_t b) {
	int32_t maximumInt = 0;
	
	__asm {
			//Compute the theorem
			//Thm: max = a xor((a xor b) & ((a - b) >> s 31))

			//ecx = a xor b
			mov eax, [ebp + 8]
			mov ebx, [ebp + 12]
			xor eax, ebx
			mov ecx, eax; move into ecx

			//edx = (a - b) >> s 31)
			mov eax, [ebp + 8]
			sub eax, ebx
			jno skip
			neg eax
		skip :
			sar eax, 31
			mov edx, eax; move into edx

			//ecx = ((a xor b) & ((a - b) >> s 31))
			and ecx, edx

			//eax = a xor ecx
			mov eax, [ebp + 8]
			xor eax, ecx

			//return
			mov maximumInt, eax
	}
		
	return maximumInt;
}

int32_t obvious_max(int32_t a, int32_t b) {
	return a > b ? a : b;
}

void checkMax(int32_t a, int32_t b) {
	int32_t expected = obvious_max(a, b);
	int32_t actual = maximum(a, b);
	if (expected != actual) {
		std::cerr << "MAXIMUM INCORRECT: " << a << ", " << b << std::endl;
	}
}

int main() {
	//_____________________________________________
	/**                MINIMUM                  **/
	//Positive
	checkMin(7, 3);
	checkMin(3, 7);
	checkMin(3, 3);

	//Negative
	checkMin(-3,-80);
	checkMin(-3, -3);
	checkMin(-80, -3);

	//Positive and Negative
	checkMin(800, -5000);
	checkMin(-5000, 800);

	//Zeros w/ Neg and Pos
	checkMin(0, 0);
	checkMin(0, 3);
	checkMin(3, 0);
	checkMin(-3, 0);
	checkMin(0, -3);

	//Integer Min and Max as inputs
	checkMin(INT32_MIN, INT32_MIN);
	checkMin(INT32_MIN, INT32_MAX);
	checkMin(INT32_MAX, INT32_MIN);
	checkMin(INT32_MAX, INT32_MAX);

	//_____________________________________________
	/**                MAXIMUM                  **/
	//Positive
	checkMax(7, 3);
	checkMax(3, 7);
	checkMax(3, 3);

	//Negative
	checkMax(-3, -80);
	checkMax(-3, -3);
	checkMax(-80, -3);

	//Positive and Negative
	checkMax(800, -5000);
	checkMax(-5000, 800);

	//Zeros w/ Neg and Pos
	checkMax(0, 0);
	checkMax(0, 3);
	checkMax(3, 0);
	checkMax(-3, 0);
	checkMax(0, -3);

	//Integer Min and Max as inputs
	checkMax(INT32_MIN, INT32_MIN);
	checkMax(INT32_MIN, INT32_MAX);
	checkMax(INT32_MAX, INT32_MIN);
	checkMax(INT32_MAX, INT32_MAX);


	//Direct tests w/o check with obvious
	//std::cout << "Which is the minimum, 7 or 3? " << minimum(7, 3) << std::endl;
	//std::cout << "Which is the maximum, 12 or 5? " << maximum(12, 5) << std::endl;

	return 0;
}
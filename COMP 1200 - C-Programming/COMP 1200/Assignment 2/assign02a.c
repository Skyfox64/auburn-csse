/* 
John Carroll
COMP-1200: Assignment 02a
Date Completed: January 31, 2012

I worked on my assignment alone using course material only.

Program: BMI Calculation
----------------------------------------------------------------- 
Find the BMI for a given height(in inches) and weight(in pounds.)
------------------------------------------------------------------ 
*/
#include <stdio.h>
   int main() 
   { 
      double weight, height, convertedHeight, convertedWeight, bmi;
   
      printf("Enter the height in inches: "); // the prompt
      scanf("%lf",&height); // reads height
   
      printf("Enter the weight in pounds: "); // the prompt
      scanf("%lf",&weight); // reads weight
   
   	// Compute the conversions of the inputs
      convertedHeight = height*0.0254;
      convertedWeight = weight/2.2046;
         
      //Calculate the BMI, using the formula
      bmi = (convertedWeight)/(convertedHeight*convertedHeight);
         
      //Display BMI
      printf("The BMI is: %-6.4lf\n", bmi);
      return 0; 
   }
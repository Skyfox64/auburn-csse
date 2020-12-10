/* 
John Carroll
COMP-1200: Assignment 02b
Date Completed: January 31, 2012

I worked on my assignment alone using course material only.

Program: BMI Calculation
----------------------------------------------------------------- 
Find the BMI for a given height(in inches) and weight(in pounds.)
Modifies Lab02 part a by adding to following requirement.
Enter a target BMI and compute the target weight.
------------------------------------------------------------------ 
*/
#include <stdio.h>
   int main() 
   { 
      double weight, height, convertedHeight, convertedWeight, bmi, targetBmi, targetConvertedWeight, targetWeight;
   // Part a
   	//Prompt for height
      printf("Enter the height in inches: "); // the prompt
      scanf("%lf",&height); // reads height
		
   	//Prompt for weight
      printf("Enter the weight in pounds: "); // the prompt
      scanf("%lf",&weight); // reads weight
   
   	//Compute the conversions of the inputs
      convertedHeight = height*0.0254;
      convertedWeight = weight/2.2046;     
		 
      //Calculate the BMI, using the formula
      bmi = (convertedWeight)/(convertedHeight*convertedHeight);      
   
      //Display BMI
      printf("The BMI is: %-6.4lf\n", bmi);
   
      printf("\n"); // insert blank line
   
   /*-----------------------------------------------------------------------------------
    Part b
   */
      //Prompt for targetted BMI
      printf("Enter the target BMI: "); // the prompt
      scanf("%lf",&targetBmi); // reads BMI
   
   	//Calculate and then compute the conversions
      targetConvertedWeight = targetBmi*(convertedHeight*convertedHeight);
      targetWeight = targetConvertedWeight*2.2046;
		
      //Display target weight
      printf("The target weight is: %-6.4lf\n", targetWeight);
      return 0; 
   }
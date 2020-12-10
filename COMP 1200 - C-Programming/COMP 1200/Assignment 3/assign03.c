/* 
John Carroll
COMP-1200: Assignment 03
Date Completed: February 7th, 2012

I worked on my assignment alone, using only course material.

Program: BMI Calculation
----------------------------------------------------------------- 
Find the BMI for a given height(in inches) and weight(in pounds.)
Determine the BMI catagory.
Compute and display the target weight for a given BMI.
Compute the Idea Body Weight (IBW) for given height and gender.
------------------------------------------------------------------ 
*/
#include <stdio.h>
   int main() 
   {  //VARIABLES
      double weight, height, convertedHeight, convertedWeight, bmi, targetBmi, targetConvertedWeight, targetWeight, ibwWomen, ibwMen;
      char gender;
      /*-----------------------------------------------------------*/
   	//INPUT
      //Prompt for height
      printf("Enter the height in inches: "); // the prompt
      scanf("%lf",&height); // reads height
      
   	//Prompt for weight
      printf("Enter the weight in pounds: "); // the prompt
      scanf("%lf",&weight); // reads weight
      
      /*-----------------------------------------------------------*/
   	//COMPUTATION
   	
   	//Compute the conversions of the inputs
      convertedHeight = height*0.0254;
      convertedWeight = weight/2.2046;      
      
      //Calculate the BMI, using the formula
      bmi = (convertedWeight)/(convertedHeight*convertedHeight);      
      printf("\n"); // insert blank line
      
      /*-----------------------------------------------------------*/
   	//OUTPUT
   	
      //Display BMI
      printf("The BMI is: %-6.2lf\n", bmi);
      
      //Determine the BMI's catagory.
      if ( bmi < 25 )
         printf("BMI Classification: Normal\n"); 
      //Print if the BMI is in the normal category 
      else if ( bmi >= 25 && bmi < 30 ) 
         printf("BMI Classification: Overweight\n");
      //Print if the BMI is in the overweight category 
      else if ( bmi >= 30 )
         printf("BMI Classification: Obese\n"); 
      //Print if the BMI is in the obese category 
      printf("\n"); // insert blank line
      
      /*-----------------------------------------------------------*/  
   	/*-----------------------------------------------------------*/
      //INPUT
   	
      //Prompt for targetted BMI
      printf("Enter the target BMI: "); // the prompt
      scanf("%lf",&targetBmi); // reads BMI
      
   	/*-----------------------------------------------------------*/
      //COMPUTATION
   	
   	//Calculate and then compute the conversions
      targetConvertedWeight = targetBmi*(convertedHeight*convertedHeight);
      targetWeight = targetConvertedWeight*2.2046;
      
      /*-----------------------------------------------------------*/
      //OUTPUT
   	
      //Display target weight
      printf("The target weight is: %-6.2lf pounds.\n", targetWeight);
      printf("\n"); // insert blank line
   	
   	/*-----------------------------------------------------------*/
      /*-----------------------------------------------------------*/
      //INPUT
   	
      //Prompt for gender
      printf("Is the person a female or male? Enter F or M: "); // the prompt
      scanf(" %c", &gender); // reads gender
      
      /*-----------------------------------------------------------*/
      //COMPUTATION
   	
      //Compute the Idea Body Weight (IBW) for given height and gender.
      ibwWomen = ((45.5 + 2.3 * (height - 60))*(2.2046));
      ibwMen = ((50.0 + 2.3 * (height - 60))*(2.2046));  
       
   	/*-----------------------------------------------------------*/
   	//OUTPUT
   	
    	//if Female
      if ((gender == 'F') || (gender == 'f')) printf("The ideal weight is %-6.2lf pounds.\n", ibwWomen);
      
      //if Male
      else if ((gender == 'M') || (gender == 'm')) printf("The ideal weight is %-6.2lf pounds.\n", ibwMen);
      return 0;
   }
	
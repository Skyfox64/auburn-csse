/* 
John Carroll
COMP-1200: Assignment 04b
Due Date: February 15th, 2012

I worked on my assignment alone, using only course material.

Program: BMI Calculation
----------------------------------------------------------------- 
Find the BMI for a given height(in inches) and weight(in pounds.)
Determine the BMI catagory.
Compute and display the target weight for a given BMI.
Compute the Idea Body Weight (IBW) for given height and gender.
Prompt the user to enter the requested values until program is given good data.
Prompt the user for the number of people, then execute program that number of times.
------------------------------------------------------------------ 
*/
#include <stdio.h>
   int main()
   {  //VARIABLES
      double weight, height, convertedHeight, convertedWeight, bmi, targetBmi, targetConvertedWeight, targetWeight, ibwWomen, ibwMen, peopleQuantity, p;
      char gender;
      
      //Prompt user for the number of people
      printf( "Enter the number of people: " );
      scanf( "%lf", &peopleQuantity );
      
   	//For each person enter and compute stats
      for ( p=1; p<=peopleQuantity; p++ ){
      
      
      /*-----------------------------------------------------------
                       BMI
      -----------------------------------------------------------*/
         printf("\n"); // insert blank line
      //INPUT
      
      
      //Prompt for height
         do //Intializes the loop
         {
         //Items executed inside the loop statements
            printf("Enter the height in inches(59-78): "); //The prompt
            scanf("%lf",&height); //Reads height
         } while ( height < 59 || height > 78 ); //The loop is executed while these conditions are met
      
      //Prompt for weight
         do //Initializes the loop
         {
         //Items executed inside the loop
            printf("Enter the weight in pounds(90-350): "); //The prompt
            scanf("%lf",&weight); //Reads weight
         } while ( weight < 90 || weight > 350); //The loop is executed while these conditions are met
      
      /*-----------------------------------------------------------
                       BMI
      -----------------------------------------------------------*/
         printf("\n"); // insert blank line
      /*-----------------------------*/
      //COMPUTATION
      
      //Compute the conversions of the inputs
         convertedHeight = height*0.0254;
         convertedWeight = weight/2.2046;      
      
      //Calculate the BMI, using the formula
         bmi = (convertedWeight)/(convertedHeight*convertedHeight);      
         
      
      /*-----------------------------*/
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
      
      /*-----------------------------------------------------------
                  Target BMI and weight
      -----------------------------------------------------------*/
      //INPUT
      
      //Prompt for targetted BMI
         do //Initializes the loop
         {
         //Items executed inside the loop
            printf("Enter the target BMI(18.5-30.0): "); //The prompt
            scanf("%lf",&targetBmi); //Reads BMI
         } while ( targetBmi < 18.5 || targetBmi > 30.0 ); //The loop is executed while these conditions are met
      
      /*-----------------------------*/
      //COMPUTATION
      
      //Calculate and then compute the conversions
         targetConvertedWeight = targetBmi*(convertedHeight*convertedHeight);
         targetWeight = targetConvertedWeight*2.2046;
      
      /*-----------------------------*/
      //OUTPUT
      
      //Display target weight
         printf("The target weight is: %-6.2lf pounds.\n", targetWeight);
         printf("\n"); // insert blank line
      
      /*-----------------------------------------------------------
                       IBW
      -----------------------------------------------------------*/
      
      //INPUT
      
      //Prompt for gender
      
         do //Initializes the loop
         {
         //Items executed inside the loop
            printf("Is the person a female or male? Enter F or M: "); //The prompt
            scanf(" %c", &gender); //Reads gender
         } while (( gender != 'm') && (gender != 'f') && (gender != 'M') && (gender != 'F' ));//The loop is executed while these conditions are met
      
      
      /*-----------------------------*/
      //COMPUTATION
      
      //Compute the Idea Body Weight (IBW) for given height and gender.
         ibwWomen = ((45.5 + 2.3 * (height - 60))*(2.2046));
         ibwMen = ((50.0 + 2.3 * (height - 60))*(2.2046));  
       
      /*-----------------------------*/
      //OUTPUT
      
      //if 'Female', display it's corresponding weight
         if ((gender == 'F') || (gender == 'f')) printf("The ideal weight is %-6.2lf pounds.\n", ibwWomen);
         
         //if 'Male', display it's corresponding weight
         else if ((gender == 'M') || (gender == 'm')) printf("The ideal weight is %-6.2lf pounds.\n", ibwMen);
      }
      return 0;
   }
   

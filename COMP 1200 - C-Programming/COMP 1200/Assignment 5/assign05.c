/* 
John Carroll
COMP-1200: Assignment 05
Due Date: March 7th, 2012

I worked on my assignment alone, using only course material.

Program: Mountains - Distance to the Horizon
----------------------------------------------------------------- 
Open and read the file. Retrieve the mountains' heights from the 
data file. Convert the data into miles and then calculate the 
distance to the horizon for each mountain. Display the data in a 
table. Print the highest mountain on each planet at the end of the 
file.
------------------------------------------------------------------ 
*/
#include <stdio.h>
#include <math.h> //enable mathematical equations, namely the sqrt function
//CONSTANTS (Names = ALL CAPS)
#define FILENAME "mountainHeights.txt"
#define EARTH_DIAMETER 7926
#define MARS_DIAMETER 4217

   int main()
   {  
   	//Variables
      int planetNum, count, c;
      double horizonDistance, mountainHeight, convertedMountainHeight, diameter;
      double maxEarth = 0, maxMars = 0;
      /*-----------------------------------------------------------
                        Open File
      -----------------------------------------------------------*/
      FILE *myFile;
      myFile = fopen( FILENAME, "r" );
      if (myFile == NULL) printf("FILE OPEN ERROR. END PROGRAM.\n");
      else // good file open       
      { 
         fscanf( myFile, "%d", &count); //count=11
      
      
      /*-----------------------------------------------------------
                       Distance to the Horizon
      -----------------------------------------------------------*/
      //Display Table Headers
         printf("Distance from Mountain Peak and Horizon\nPlanet   Mountain    Horizon\nNumber    Height*   Distance*\n------   --------   --------\n");
      //Get data
         for (c=0; c<count; c++ )//'for loop' initialization, conditions and actions
         {
            //read the two columns on the data file
            fscanf(myFile, "%d", &planetNum);             
            fscanf(myFile, "%lf", &mountainHeight); 
            
            switch( planetNum )//switching function
            {
               case 3: //Earth (is planet number 3 from the sun)
                  convertedMountainHeight = mountainHeight/5280; //Earth mountains(ft) converted to miles
                  diameter = EARTH_DIAMETER;
                  if ( convertedMountainHeight > maxEarth )
                     maxEarth = convertedMountainHeight; //Highest mountain on Earth
                  break;
               case 4: //Mars (is planet number 4 from the sun)
                  convertedMountainHeight = mountainHeight/1.609344; //Mars mountains(km) converted to miles
                  diameter = MARS_DIAMETER;
                  if ( convertedMountainHeight > maxMars )
                     maxMars = convertedMountainHeight; //Highest mountain on Mars
                  break;
            }
            
         	
            horizonDistance = (sqrt(diameter * convertedMountainHeight + convertedMountainHeight * convertedMountainHeight));
         	
         
            printf( " %2d %11.1f %10.1f\n", planetNum, convertedMountainHeight, horizonDistance ); //Display the data
         }
      }
      printf("* Units = miles\n\n"); //Notes that the unit being used is miles
      
      /*-----------------------------------------------------------
                    Highest mountains
      -----------------------------------------------------------*/
      //The Display of the Highest mountains on each one of the two planets
      printf("The highest mountain on Mars: %4.1f miles\n", maxMars);
      printf("The highest mountain on Earth: %3.1f miles\n", maxEarth);
      
      return 0;
   }

/* 
John Carroll
COMP-1200: Assignment 06
Due Date: March 23rd, 2012

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

// CONSTANTS=========================================================
//(Names = ALL CAPS)
#define FILENAME       "mountainHeights.txt"
#define EARTH_DIAMETER 7926
#define MARS_DIAMETER  4217

// FUNCTION PROTOTYPES================================================ 
   double km2miles( double km ); // convert kilometers to miles 
   double feet2miles( double feet ); // convert feet to miles 
   double computeHorizonDist( double diameter, double height ); // compute the distance to the horizon 
// get information for planet 
   void getPlanetInfo( int planetNum, double mountainHeight, double *height, double *diameter, double *maxMars, double *maxEarth ); 
// print title and column headers 
   void printHeaders(); 
// print highest mountain height for each planet 
   void printMaxHeights( double maxMars, double maxEarth ); 


// MAIN================================================================ 
   int main()
   {  
   	//Variables
      int planetNum, count, c;
      double horizonDistance, mountainHeight, height, diameter, km, feet;
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
      // print title and column headers 
         printHeaders(); //Make table headers and columns
            //Get data
         for (c=0; c<count; c++ )//'for loop' initialization, conditions and actions
         {
            //read the two columns on the data file
            fscanf(myFile, "%d", &planetNum);             
            fscanf(myFile, "%lf", &mountainHeight); 
         
          //==== GET INFO ====
            //get information for planet 
            getPlanetInfo( planetNum, mountainHeight, &height, &diameter, &maxMars, &maxEarth );
            horizonDistance = computeHorizonDist( diameter, height);
            printf( " %2d %11.1f %10.1f\n", planetNum, height, horizonDistance ); //Display the data
         }
          // print highest mountain height for each planet 
         
         printf("* Units = miles\n\n"); //Notes that the unit being used is miles
         printMaxHeights( maxMars, maxEarth ); //prints highest mountains
      }
   	
      return 0;
   }
   
	
	// THE CONVERIONS FUNCTIONS ===================================================== 
	// convert kilometers to miles
   double km2miles( double km )
   {
      return km / 1.609344;
   }
	// convert feet to miles 
   double feet2miles( double feet )
   {
      return feet / 5280;
   }
   
	
	// compute the distant to the horizon 
   double computeHorizonDist( double diameter, double height )
   {
      double horizonDistance;
      return (sqrt(diameter * height + height * height));
   }

   
	
// GET INFO FUNCTION=============================================================
// get information for planet ---------------------------------------------------
   void getPlanetInfo( int planetNum, double mountainHeight, double *height, double *diameter, double *maxMars, double *maxEarth ){
      switch( planetNum )//switching function
      {
         case 3: //Earth (is planet number 3 from the sun)
            *height = feet2miles(mountainHeight); //Earth mountains(ft) converted to miles
            *diameter = EARTH_DIAMETER;
            if ( *height > *maxEarth )
               *maxEarth = *height; //Highest mountain on Earth
            break;
         case 4: //Mars (is planet number 4 from the sun)
            *height = km2miles(mountainHeight); //Mars mountains(km) converted to miles
            *diameter = MARS_DIAMETER;
            if ( *height > *maxMars )
               *maxMars = *height; //Highest mountain on Mars
            break;
      }     	
   }


 //PRINT TABLES FUNCTION==========================================================
 //Print Headers and Columns -----------------------------------------------------
   void printHeaders(){
   //Display Table Headers
      printf("Distance from Mountain Peak and Horizon\nPlanet   Mountain    Horizon\nNumber    Height*   Distance*\n------   --------   --------\n");
   }
   
	
//MAX HEIGHTS FUNCTION============================================================	
// print highest mountain height for each planet --------------------------------- 
   void printMaxHeights( double maxMars, double maxEarth ){
    /*-----------------------------------------------------------
                    Highest mountains
      -----------------------------------------------------------*/
      //The Display of the Highest mountains on each one of the two planets
      printf("The highest mountain on Mars: %4.1f miles\n", maxMars);
      printf("The highest mountain on Earth: %3.1f miles\n", maxEarth);
   }

/* 
John Carroll
COMP-1200: Assignment 08
Due Date: April 18th, 2012

I worked on my assignment alone, using only course material.

Program: 2012 Auburn Softball 
----------------------------------------------------------------- 
-insert narrative-
------------------------------------------------------------------ 
*/

#include <stdio.h>
#include <math.h>      
#include <string.h>    

/* CONSTANTS==================================(Names = ALL CAPS)*/
#define FILENAME    "data08c.txt" // data file name 
#define TITLELEN    30 // max title length 
#define MAXNUMGAMES 40 // max number of games in season 
#define NAMELEN     25 // max opponent name length 
#define CONFLEN      4 // length of conference name 
#define NUMINNINGS  10 // max number of innings for each team 
#define STATINNING   4 // runs after this inning for stats 
#define NUMCOLS      2 

//Function Prototypes=================================================
   int readDatafile(char title[], char dates[][NUMCOLS], 
   					  char oppNames[][NAMELEN], char conf[][CONFLEN], 
   					  int scoreAll[][NUMCOLS], int score4th[][NUMCOLS]); 
   void printReport(char title[], char dates[][NUMCOLS], 
   					  char oppNames[][NAMELEN], char conf[][CONFLEN], 
   					  int scoreAll[][NUMCOLS], int score4th[][NUMCOLS],
   					  int numGames); 
   void printHeader(char title[]);
	
// Main Function======================================================
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
      
      
      }
      return 0;
   }
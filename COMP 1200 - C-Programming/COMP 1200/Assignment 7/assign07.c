/* 
John Carroll
COMP-1200: Assignment 07
Due Date: April 11th, 2012

I worked on my assignment alone, using only course material.

Program: AUBURN TIGERS SOFTBALL - Games Results 
----------------------------------------------------------------- 
Open and read the file. Retrieve the Auburn 2012 softball season 
game results from the data file.  Display the data in a 
table. Print a report of the Auburn 2012 softball season game 
results. Mark the largest game attendance. Print the largest point
spreads for both Wins and Losses.
------------------------------------------------------------------ 
*/

#include <stdio.h>
#include <math.h>                   //enable mathematical equations

// CONSTANTS=========================================================
//(Names = ALL CAPS)
#define FILENAME     "data07.txt"   // text file

// FUNCTION PROTOTYPES================================================
   void printHeaders();
   int maxAttendence();
   int maxDiffIndex();
   int minDiffIndex();
   // MAIN================================================================ 
   int main(){
     //Variables
      int numGames = 28;    //number of games to be read
      int month[numGames], day[numGames], oppScore[numGames], AUscore[numGames];
      int attendence[numGames];
      char result[numGames];
      int maxAttend = 0, maxPointsLoss = 0, maxPointsWon = 0;
      int i, j, maxPointsIndex = 0, minPointsIndex = 0;
   
   /*-----------------------------------------------------------
                        Open File
      -----------------------------------------------------------*/
      FILE *dataFile;
      dataFile = fopen(FILENAME, "r");
   
      if(dataFile == NULL){printf("Error opening file \n");}
      else // good file open
      {
         printHeaders(); //Prints the header function
         //Scan the file and assign values to the arrays
         for(i=0;i<numGames;i++){
            fscanf(dataFile, "%d" "%d" "%d" "%d" "%d", &month[i],
               	&day[i], &oppScore[i], &AUscore[i], &attendence[i]);
            if(AUscore[i] < oppScore[i])      
            //determines if a win or a loss
            {
               result[i] = 'W';}
            else result[i] = 'L';
         
            //Find max attendence
            maxAttend = findMaxAttend(maxAttend, attendence[i]);
            
         	//Finds max point difference for highest win and highest loss
            if (pointDiff(AUscore[i], oppScore[i])>maxPointsLoss){
               maxPointsIndex = i;
               maxPointsLoss = pointDiff(AUscore[i], oppScore[i]);
            }
            if (pointDiff(oppScore[i], AUscore[i])>maxPointsWon){
               minPointsIndex = i;
               maxPointsWon = pointDiff(oppScore[i], AUscore[i]);
            }
         }
         
         //Print the array
         for(j=0;j<numGames;j++){
            if (attendence[j] == maxAttend){
               printf("     %02d/%02d  %d-%2d  %c   %4d#\n", month[j], day[j], 
                  oppScore[j], AUscore[j], result[j], attendence[j]);
            }
            else{
               printf("     %02d/%02d  %d-%2d  %c   %4d\n", month[j], day[j], 
                  oppScore[j], AUscore[j], result[j], attendence[j]);	
            }
         }
      
      //print largest game attendence and largest point spreads
         printf("# largest game attendence \n");
         printf("Largest Point Spread: \n");
         printf("Win:   %d on %02d/%02d \n", maxPointsWon, month[minPointsIndex], day[minPointsIndex]);
         printf("Loss: %d on %02d/%02d \n", maxPointsLoss, month[maxPointsIndex], day[maxPointsIndex]);
      }
   
      return 0;
   }

// USER-DEFINED FUNCTIONS ======================================================================== 

//Print Headers and Columns ---------------------------------------------------
   void printHeaders(){
      printf("   2012 AUBURN TIGERS SOFTBALL \n");
      printf("Auburn Games Results (as of 03/25) \n");
      printf("     Date  Score W-L Attend \n");
      printf("     ----- ----- --- ------\n");
   }
   
// Find Max Attendence --------------------------------------------------------
   int findMaxAttend(int game1, int game2){	
      int attendence;
      if(game1 > game2) attendence = game1;
      else attendence = game2;
      return attendence;
   }

// Find Max Point Difference --------------------------------------------------
   int pointDiff(int score1, int score2)	
   {
      int maxPointDiff = score1-score2;
      return maxPointDiff;
   }
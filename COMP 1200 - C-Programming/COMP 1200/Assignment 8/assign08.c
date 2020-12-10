/* 
John Carroll
COMP-1200: Assignment 08
Due Date: April 18th, 2012

I worked on my assignment alone, using only course material.

Program: 2012 Auburn Softball 
-------------------------------------------------------------------------------------------------------- 
- Store file name in a CONSTANT variable. Use the variable name in the program. 
- Do not continue program if there is a problem opening file. 
- Text file columns: 1 - month, 2 - day, 3 - Opponent score, 4 - Auburn score, etc
- Print a report of the season game results print * next to the highest attendance with legend for flags 
- Print largest win/loss point spread with date and opponent
--------------------------------------------------------------------------------------------------------
*/


#include <stdio.h>
#include <math.h>      
#include <string.h>    

/* CONSTANTS==========================================================
        (Names = ALL CAPS)*/
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
	void printHeaders(); 
	
	
   int main() 
   {     
   	//Variables
      int numGames = 36;
      int date[numGames][1];
      int AUscore[numGames][9];
      int oppScore[numGames][9];
      char oppName[NAMELEN], oppConf[4];
      int i, j, k, score1, score2;
      int secWin=0, secLoss=0, numWin=0, numLoss=0;
      char result;
      char year[4], college[10], sport[10];
      
   
      /*-----------------------------------------------------------
                        Open File
      -----------------------------------------------------------*/
   
      FILE *dataFile;
      dataFile = fopen(FILENAME, "r");//opens data file for reading
   
      if(dataFile == NULL)printf("error opening file \n");//makes sure data file exists
      else{
         fscanf(dataFile, "%s %s %s", year, college, sport);
         printf("		%s %s %s \n", year, college, sport);//prints the header
         printHeaders();   	//calls printHeader funcion
      	
         for(i=0;i<numGames;i++){//start for loops
         	//scans data file------------------------------------------------
            fscanf(dataFile, "%d %d %s %s", &date[i][0], &date[i][1],
               		oppConf, oppName);
            fscanf(dataFile, "%d %d %d %d %d %d %d %d %d %d",
               		&oppScore[i][0],&oppScore[i][1],&oppScore[i][2],&oppScore[i][3],
               		&oppScore[i][4],&oppScore[i][5],&oppScore[i][6],&oppScore[i][7],
               		&oppScore[i][8],&oppScore[i][9]);
            fscanf(dataFile, "%d %d %d %d %d %d %d %d %d %d",
               		&AUscore[i][0],&AUscore[i][1],&AUscore[i][2],&AUscore[i][3],
               		&AUscore[i][4],&AUscore[i][5],&AUscore[i][6],&AUscore[i][7],
               		&AUscore[i][8],&AUscore[i][9]);
         	//----------------------------------------------------------------
            score1 = 0;
            score2 = 0;
            for(j=0;j<10;j++){//calculates auburn and opponent scores and determines win/loss
               score1 += oppScore[i][j];
               score2 += AUscore[i][j];
            }
            if(score2<score1){
               result='L';
               numLoss+=1;
            }
            else if(score2>score1){
               result='W';
               numWin+=1;
            }
            else result='T';
         	
         
            printf("%02d/%02d	%19s		%02d-%02d 	%c \n", date[i][0], date[i][1],
               		oppName, score1, score2, result);//prints data
         }
         printf("Auburn Season Record: %02d-%02d \n", numWin, numLoss);      
      }
      return 0;
   }
   
// ======================================================== 
// FUNCTIONS 
// ======================================================== 

   void printHeaders(){//prints headers
      printf("\nDATE		OPPONENT		SCORE	W\n");
      printf("					OP-AU	L\n");
      printf("---------------------------------------------------------\n");
   }
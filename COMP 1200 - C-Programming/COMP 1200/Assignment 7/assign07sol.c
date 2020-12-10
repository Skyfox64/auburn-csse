// J Hundley 
// assign07 
// April 1, 2012 
/* - Store file name in a CONSTANT variable. Use the variable name in the program. 
- Do not continue program if there is a problem opening file. - Text file columns:
 1 - month, 2 - day, 3 - Opponent score, 4 - Auburn score, 5 - attendance - Print 
 a report of the season game results print * next to the highest attendance with 
 legend for flags - Print largest win/loss point spread with date and opponent */
 #include <stdio.h> 
 #define FILENAME "data07.txt" 
 #define MAXGAMES 40 
 
// *****PROTOTYPE***** 
   int maxInt(int array[], int count); 
   int maxDiffIndex(int array1[], int array2[], int count); 
 
   int main() { int numGames, g=0;           // games counters 
      int month[MAXGAMES], day[MAXGAMES],       // date 
       auScore[MAXGAMES], opScore[MAXGAMES], // scores 
       attend[MAXGAMES], maxAttend;          // attendance 
      int winSpreadIndex, lossSpreadIndex;      // index for max point spread 
      FILE * filePtr; 
   
      filePtr = fopen(FILENAME, "r"); 
      if (filePtr == NULL) printf("File does not exist"); 
      else // file does not exist 
      {                    // good open continue with program 
      // *****INPUT***** 
      // read 2012 softball game results 
         while(fscanf(filePtr, "%d %d %d %d %d", &month[g],&day[g], 
         	  &opScore[g],&auScore[g],&attend[g])!= EOF) g++; 
         numGames = g; 
         
      // *****COMPUTE***** 
      // find max Attendence 
         maxAttend = maxInt(attend, numGames); 
      // find largest win and loss point spread 
         winSpreadIndex = maxDiffIndex(auScore, opScore, numGames); 
         lossSpreadIndex = maxDiffIndex(opScore, auScore, numGames); 
         
      // *****OUTPUT***** 
      // print report of game results 
      // print headers 
         printf("\n 2012 AUBURN TIGERS SOFTBALL\n"); 
         printf(" Auburn Games Results (as of %02d/%02d)\n\n", 
            	  month[numGames-1],day[numGames-1]); 
         printf(" Date Score W-L Attend\n"); 
         printf(" ----- ----- --- ------\n");
      	
      // print results for each game 
         for (g=0; g<numGames; g++) 
         {
         // print date, AU-Opp score 
            printf(" %02d/%02d %02d-%02d", 
               month[g],day[g],opScore[g],auScore[g]); 
               
         // print W or L for win or loss 
            if (auScore[g] > opScore[g]) printf(" W "); 
            else
               printf(" L "); 
            
         // print attendance 
            printf("%5d",attend[g]); 
            
         // print flag for largest attendance 
            if (attend[g] == maxAttend) printf("#\n"); 
            else
               printf(" \n"); 
            
         } // end for each game loop 
            
      // print legend 
         printf(" # largest game attendance\n\n"); 
      // print the date for largest win and loss point spread 
         printf(" Largest point spread:\n"); 
         printf(" Win: %2d on %02d/%02d\n", 
            auScore[winSpreadIndex]-opScore[winSpreadIndex], 
            month[winSpreadIndex],day[winSpreadIndex]); 
         printf(" Loss: %2d on %02d/%02d\n", 
            opScore[lossSpreadIndex]-auScore[lossSpreadIndex], 
            month[lossSpreadIndex],day[lossSpreadIndex]); 
      		
      		
      } //end else good file open 
      
      return 0; 
   } 
   
// ======================================================== 
// FUNCTIONS 
// ======================================================== 

// find the max of a integer array 
   int maxInt(int array[], int count) 
   { 
      int c; 
      int max_x; 
   	
      max_x = array[0]; 
      for (c=1; c<count; c++) { 
         if (array[c] > max_x) 
            max_x = array[c]; 
      }
      return max_x; 
   }
   
// find the index of the largest difference 
   int maxDiffIndex(int array1[], int array2[], int count) 
   { 
      int c; 
      int maxDiff, maxIndex; 
   
      maxDiff = array1[0] - array2[0]; 
      for (c=1; c<count; c++) 
      { 
         if ( array1[c]-array2[c] > maxDiff) 
         { 
            maxDiff = array1[c]-array2[c]; 
            maxIndex = c; 
         } 
      }
      return maxIndex; 
   }
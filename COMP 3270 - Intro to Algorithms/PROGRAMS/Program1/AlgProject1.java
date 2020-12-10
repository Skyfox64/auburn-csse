//package com.company;

import java.io.*;
import java.util.Scanner;

/**
 * @author John Carroll
 * @version 10-27-2014
 */

public class AlgProject1 {
   //CONSTANTS
   private final static String userId = "jcc0044";
   //Global Counters & Variables
   private static int assignmentCount, comparisonCount, arraySize, heapSize;
   private static String currentSort = "";

   public static void main(String[] args) {
      String header = "     __________________________________________________________________________";
      header += "\n";
      header += "\n             COMP 3270 Intro To Algorithms - Program 1 " + "by " + userId;
      header += "\n     __________________________________________________________________________";
      System.out.println(header);
      boolean runProgram = true;
      while (runProgram == true) {
         //Prompt user for file name
         System.out.print("\n     Enter file name: ");
         String fileName = new Scanner(System.in).nextLine();
      
         //Check if they accidentally dropped a line/entered nothing
         if (fileName.trim().length() == 0) {
            System.out.println("\n       Your input was invalid. Try again. ");
            continue;}
      
         //Read in array from user input file.
         int[] originalArray;
         try{
            originalArray = AlgProject1.getDataViaScanner(fileName); //SCANNER
            runAlgorithms(originalArray); //Run Sorting Algorithms on this array (quantity 3)
         }
         catch(IOException fnfe) {
            System.out.println("\n        Could not find file at default directory." +
                   "\n        Search was done using util.scanner.class.");
            try {
               originalArray = AlgProject1.getDataViaBR(fileName); //BUFFEREDREADER approach
               runAlgorithms(originalArray); //Run Sorting Algorithms on this array (quantity 3)
            }
            catch (IOException ioe) {
               System.out.println("\n        Could not find file at path/working directory." +
                      "\n        Search was done using io.bufferedreader.class.");
               System.out.println("\n  ***Please make sure that the file is in the default and/or" +
                      " working directory.***");}
         }
         runProgram = repromptUser(); //Reprompt the user for more files
      }
      String end = "     _________________________________________________________________";
      end += "\n";
      end += "\n                     Thank you for running my program!";
      end += "\n     _________________________________________________________________";
      System.out.println(end);
      try {Thread.sleep(5000);  //5000 milliseconds is 5 seconds.
      }
      catch (InterruptedException ex) {Thread.currentThread().interrupt();}
   }
   /* Reprompt user for more files */
   private static boolean repromptUser() {
      String invalidMsg = "\n      Invalid. Please enter 'Y' for \"Yes\" OR 'N' for \"No\"";
      boolean runProgram = true;
      boolean reprompt = true;
      while (reprompt == true) {
         System.out.print("\n     Process more files? (Y/N):");
         String userInput = new Scanner(System.in).nextLine();
         if(userInput.trim().length() == 1) {
            char userChoiceChar = Character.toUpperCase(userInput.charAt(0));
            if (userChoiceChar == ('N')) {
               runProgram = false;
               reprompt = false; //break from this while-loop
            } 
            else if (userChoiceChar == ('Y')) {
               runProgram = true;
               reprompt = false; //continue this while-loop
            } 
            else {System.out.println(invalidMsg);}
         } 
         else {System.out.println(invalidMsg);}}
      return runProgram;
   }
   /* Read in array from file using Scanner from standard input */
   private static int[] getDataViaScanner(String fileName) throws FileNotFoundException {
      //Get Array Size
      Scanner sc = new Scanner(new File(fileName));
      for (int line; (line = Integer.parseInt(sc.nextLine())) != -1; arraySize++) {}
      int[] originalArray = new int[arraySize];
      //Populate Array
      int arrayIndex = 0;
      sc = new Scanner(new File(fileName));
      for (int line; (line = Integer.parseInt(sc.nextLine())) != -1; arrayIndex++) {originalArray[arrayIndex] = line;}
      return originalArray;
   }
   /* Read in array from file using BufferedReader from standard input */
   private static int[] getDataViaBR(String fileName) throws IOException {
      String workingDirectory = System.getProperty("user.dir") + "\\" + fileName;
      //Get Array Size
      BufferedReader br = new BufferedReader(new FileReader(workingDirectory));
      for (int line; (line = Integer.parseInt(br.readLine())) != -1; arraySize++) {}
      int[] originalArray = new int[arraySize];
      //Populate Array
      int arrayIndex = 0;
      br = new BufferedReader(new FileReader(workingDirectory));
      for (int line; (line = Integer.parseInt(br.readLine())) != -1; arrayIndex++) {originalArray[arrayIndex] = line;}
      return originalArray;
   }
   //Run Sorting Algorithms on this array (quantity 3)
   private static void runAlgorithms(int[] originalArray) {
      int[] inputArray;
      for (int i = 1; i < 4; i++) {
         resetCounts(); //Reset the global counters for prior to run.
         inputArray = originalArray.clone(); //This worked on my machine as opposed to true deep-copying.
         switch (i) {
            case (1):
               currentSort = "insertion";
               sortOutput(insertionSort(inputArray)); //Invoke Algorithm, print results
               break;
            case (2):
               currentSort = "heap";
               sortOutput(heapSort(inputArray)); //Invoke Algorithm, print results
               break;
            case (3):
               currentSort = "quick";
               sortOutput(quickSort(inputArray, 0, inputArray.length - 1)); //Invoke Algorithm, print results
               break;
            default:
         }
      }
   }
   /* Prints the output for each sorting algorithm's run. */
   private static void sortOutput(int[] A){
      String output;
      int j;
      for(int i = 0; i < A.length; i++){
         j = i + 1;
         output = userId + " " + currentSort + " #" + j + ": " + A[i];
         System.out.println(output);}
      output = userId + " " + currentSort + " assignments: "
             + assignmentCount + " comparisons: " + comparisonCount;
      System.out.println(output);
   }
   /* Reset global counters */
   private static void resetCounts(){
      assignmentCount = 0;
      comparisonCount = 0;
      arraySize = 0;
      heapSize = 0;
   }
   /* Exchanges two indices of an array. */
   private static void exchange(int A[], int i, int j) {
      int t = A[i];
      A[i] = A[j];
      A[j] = t;
   }
   /* Insertion-Sort */
   private static int[] insertionSort(int[] A) {
      int i = 0;
      for (int j = 1; j < A.length; j++) {
         int key = A[j];
         i = j - 1;
         while (i >= 0 && A[i] > key) {
            comparisonCount++;
            A[i + 1] = A[i];
            assignmentCount++;
            i--;
         }
         comparisonCount++;
         A[i + 1] = key;
         assignmentCount++;
      }
      return A;
   }
   /* Heap-sort */
   private static int[] heapSort(int[] A) {
      buildMaxHeap(A);
      for(int i = heapSize; i >= 1; i--) {
         exchange(A, 0, i);
         assignmentCount+= 2;
         heapSize--;
         maxHeapify(A, 0);}
      return A;
   }
   /* Method used in Heap-sort */
   private static void buildMaxHeap(int[] A) {
      heapSize = A.length - 1;
      for(int i = (heapSize/2); i >= 0; i--) {
         maxHeapify(A, i);}
   }
   /* Method used in Heap-sort */
   private static void maxHeapify(int[] A, int i) {
      int l = (2 * i) + 1;
      int r = (2 * i) + 2;
      int largest;
      if (A.length - 1 > 0) comparisonCount+=2;
      if(l <= heapSize && A[l] > A[i]) {
         largest = l;}
      else {
         largest = i;}
      if(r <= heapSize && A[r] > A[largest]) {
         largest = r;}
      if(largest != i) {
         exchange(A, i, largest);
         assignmentCount += 2;
         maxHeapify(A, largest);}
   }
   /* Quick-sort */
   private static int[] quickSort(int[] A, int p, int r) {
      int q;
      if(p < r) {
         q = partition(A, p, r);
         quickSort(A, p, (q - 1));
         quickSort(A, (q + 1), r);}
      return A;
   }
   /* Method used in Quick-sort */
   private static int partition(int[] A, int p, int r) {
      int x = A[r];
      int i = p - 1;
      for(int j = p; j < r; j++) {
         comparisonCount++;
         if(A[j] <= x) {
            i++;
            exchange(A, i, j);
            assignmentCount += 2;}
      }
      exchange(A, (i + 1), r);
      assignmentCount += 2;
      return i + 1;
   }
}
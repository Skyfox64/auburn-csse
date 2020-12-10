import java.util.Scanner;
import java.io.*;
import java.nio.*;

/**
*James Bass
*jcb0063
*Comp 3270 Project 1
*10/27/2014
*/
public class Multisort
{
   static int[] insertArray;
   static int[] heapArray;
   static int[] quickArray;
   static int size = 0;
   static int heapAssign = 0;
   static int heapComp = 0;
   static int heapSize = 0;
   static int quickAssign = 0;
   static int quickComp = 0;
   static int insertAssign = 0;
   static int insertComp = 0;
   static String fileName;
   
   /**
   *controls the program.
   */
   public static void main(String[] args)
   {
      readIn();
      insertSort(insertArray);
      insertOutput(insertArray);
      heapSort(heapArray);
      heapOutput(heapArray);
      quickSort(quickArray, 0, size - 1);
      quickOutput(quickArray);
   }
   
   /**
   *Uses insertion Sort algorithm to sort the array.
   */
   public static void insertSort(int[] A)
   {
      int key = 0;
      int j = 0;
      for(int i = 1; i < A.length; i++)
      {
         key = A[i];
         j = i - 1;
         while(j >= 0 && A[j] > key)
         {
            insertComp++;
            A[j + 1] = A[j];
            insertAssign++;
            j--;
         }
         insertComp++;
         A[j + 1] = key;
         insertAssign++;
      }
   }
   
   /**
   *Prints the contents of the array sorted by insertion sort with the number of comparisons and assignments.
   */
   public static void insertOutput(int[] A)
   {
      String output;
      int j;
      for(int i = 0; i < A.length; i++)
      {
         j = i + 1;
         output = "jcb0063";
         output += " insertion #" + j;
         output += ": " + A[i];
         System.out.println(output);
      }
      String output2 = "jcb0063 insertion assignments: ";
      output2 += insertAssign + " comparisons: ";
      output2 += insertComp;
      System.out.println(output2); 
   }
   
   /**
   *Uses heap Sort algorithm to sort the array.
   */
   public static void heapSort(int[] A)
   {
      buildMaxHeap(A);
      for(int i = A.length - 1; i > 0; i--)
      {
         swap(A,0, i);
         heapAssign += 2;
         heapSize--;
         maxHeapify(A,0);
      }
   }
   
   /**
   *Uses heap Sort algorithm to sort the array.
   */
   public static void buildMaxHeap(int[] A)
   {
      heapSize = A.length - 1;
      for(int i = heapSize / 2; i >= 0; i--)
      {
         maxHeapify(A, i);
      }
   }
   
   /**
   *Uses heap Sort algorithm to sort the array.
   */
   public static void maxHeapify(int[] A, int i)
   {
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      int max = i;
      if(size > 1)
      {
         heapComp += 2;
      }
      if(left <= heapSize && A[left] > A[i])
      {
         max = left;
      }
      if(right <= heapSize && A[right] > A[max])
      {
         max = right;
      }
      if (max != i)
      {
         swap(A, i, max);
         heapAssign += 2;
         maxHeapify(A, max);
      }
   }
   
   /**
   *Prints the contents of the array sorted by heap sort with the number of comparisons and assignments.
   */
   public static void heapOutput(int[] A)
   {
      String output;
      int j;
      for(int i = 0; i < A.length; i++)
      {
         j = i + 1;
         output = "jcb0063";
         output += " heap #" + j;
         output += ": " + A[i];
         System.out.println(output);
      }
      String output2 = "jcb0063 heap assignments: ";
      output2 += heapAssign + " comparisons: ";
      output2 += heapComp;
      System.out.println(output2); 
   }
   
   /**
   *swaps two elements of the array.
   */
   public static void swap(int A[], int i, int j)
   {
      int temp = A[i];
      A[i] = A[j];
      A[j] = temp; 
   }
   
   /**
   *Uses quick Sort algorithm to sort the array.
   */
   public static void quickSort(int[] A, int p, int r)
   {  
      if(p < r)
      {
         int q = partition(A, p, r);
         quickSort(A, p, q - 1);
         quickSort(A, q + 1, r);
      }
   }
   
   /**
   *Uses quick Sort algorithm to sort the array.
   */
   public static int partition(int[] A, int p, int r)
   {
      int x = A[r];
      int i = p - 1;
      for(int j = p; j < r; j++)
      {
         if(A[j] <= x)
         {
            i++;
            swap(A, i, j);
            quickAssign += 2;
         }
         quickComp++;
      }
      swap(A, i + 1, r);
      quickAssign += 2;
      return i + 1;
   }
   
   /**
   *Prints the contents of the array sorted by quick sort with the number of comparisons and assignments.
   */
   public static void quickOutput(int[] A)
   {
      String output;
      int j;
      for(int i = 0; i < A.length; i++)
      {
         j = i + 1;
         output = "jcb0063";
         output += " guick #" + j;
         output += ": " + A[i];
         System.out.println(output);
      }
      String output2 = "jcb0063 quick assignments: ";
      output2 += quickAssign + " comparisons: ";
      output2 += quickComp;
      System.out.println(output2); 
   }
   
   /**
   *reads in a file containing int values and creates an array for each sort.
   */
   public static void readIn()
   {
      int temp = 0;
      try
      {
         Scanner userInput = new Scanner(System.in);
         System.out.print("Enter a file name: ");
         fileName = userInput.nextLine();
         Scanner readfile = new Scanner(new File(fileName));
         while(readfile.hasNext())
         {
            temp = readfile.nextInt();
            if(temp > -1)
            {
               size++;
            }
         }
         insertArray = new int[size];
         heapArray = new int[size];
         quickArray = new int[size];
         Scanner readfile2 = new Scanner(new File(fileName));
         for(int i = 0; i < size; i++)
         {
            insertArray[i] = readfile2.nextInt();
            heapArray[i] = insertArray[i];
            quickArray[i] = insertArray[i];
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println("" + fileName + " not found.");
         readIn();
      }
   }
   
}
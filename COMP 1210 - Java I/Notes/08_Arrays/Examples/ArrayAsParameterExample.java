/**
 * Demonstrates the use of an initializer list
 * for an array of strings.
 */
public class ArrayAsParameterExample
{
/**
 * Creates an array of int and pass as a paramter.
 */
   public static void main (String[] args) 
   {
      int k = 688;
      printInt(k);
      int[] intList = {34, 45, 67, 78};
      printIntArray(intList);
   }
   
   static void printInt(int i)
   {
      System.out.println(i);
   }
   
   static void printIntArray(int[] list)
   {
      for(int i : list)
         System.out.print (i + " ");
   }
}

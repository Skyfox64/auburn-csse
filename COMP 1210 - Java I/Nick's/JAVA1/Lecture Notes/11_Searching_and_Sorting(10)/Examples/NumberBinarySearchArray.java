import java.util.Arrays;
import java.util.Scanner;
   
public class NumberBinarySearchArray {
   
   public static void main(String[] args) {
   
      Scanner scan = new Scanner(System.in);
      int[] nums = 
         {2, 4, 9, 23, 27, 29, 30, 34, 45, 59, 67, 76, 89, 92, 97};
      int target;
      
      System.out.print("Integer to find: ");
      target = Integer.parseInt(scan.nextLine()); 
   
      //Arrays.sort(nums);
       
      int foundAt = -1;
      int min = 0, max = nums.length - 1, mid = 0;
      	
      while (foundAt == -1 && min <= max) {
         mid = (min + max) / 2; // find center
         if (nums[mid] == target) {
            foundAt = mid;
         }
         else {
            if (nums[mid] > target) {
               max = mid - 1;
            }
            else {
               min = mid + 1;
            }
         }
      }
         
      if (foundAt == -1) {
         System.out.println(target + " not found.");
      }
      else {
         System.out.println(nums[foundAt] 
                       + " found at index " + foundAt + ".");
      }
   }   
}
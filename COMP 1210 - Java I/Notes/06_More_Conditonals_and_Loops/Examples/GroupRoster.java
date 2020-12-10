import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class GroupRoster {

   private static final int GROUP_MEMBERS = 5;

   public static void main(String[] args) {
      ArrayList<String> list = new ArrayList<String>();
      Scanner stdIn = new Scanner(System.in);
    
      for (int i = 0; i < GROUP_MEMBERS; i++) {
         System.out.print("Enter name #" + (i + 1) + ": ");
         list.add(stdIn.nextLine());
      }
   
     // The static sort method in Collections sorts
     // the ArrayList
      Collections.sort(list);
      
      System.out.println("\r\nNames in alphabetical order:");
      for (String name : list) {
         System.out.println(name);
      }
      
      System.out.println("\nThe length of name #3 is: ");   
      System.out.println(list.get(2).length());
   }

}
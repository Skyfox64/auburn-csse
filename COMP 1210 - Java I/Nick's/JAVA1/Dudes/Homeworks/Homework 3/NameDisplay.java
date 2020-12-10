   import java.util.Scanner;
	
   public class NameDisplay {
   
      public static void main(String[] args) {
      
         String name, nickName, result = "";
         int age, year;
			
         Scanner scan = new Scanner(System.in);
      
         System.out.print("Enter the current year: ");
			year = Integer.parseInt(scan.nextLine());
       	//year = ??  
      
         System.out.print("Enter your age (the age you will turn "
            + "this year): ");
			age = Integer.parseInt(scan.nextLine());	
         //age = ??
      
         System.out.print("Enter your first and last name, "
            + "separated by a space: ");
         name = scan.nextLine();
      	
         System.out.print("Enter your nickname: ");
         nickName = scan.nextLine();
         
      	//result = ??
      	result = name.replace(" ", " \"" + nickName + "\" ");
         System.out.println("\r\nYour information is " + result + " " + (year - age));
			

      }
   }
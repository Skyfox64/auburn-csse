import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
   
public class ReadLines 
{   
   public static void main(String[] args) //throws FileNotFoundException
   {   
      String fileName;
      Scanner fileInput;
      int lineCount = 0;
      Scanner keyboardInput = new Scanner(System.in);
         
      System.out.print("Enter a file name: ");
      fileName = keyboardInput.nextLine();
         
      try 
      {
         fileInput = new Scanner(new File(fileName));
      }
      catch (FileNotFoundException excepObj) {
         System.out.println("Error: Couldn't find the file.");
         System.out.println(excepObj);
         return;
      }  
      	
      while (fileInput.hasNextLine()) {
         lineCount++;
         System.out.println("Line " + lineCount + ": " 
               + fileInput.nextLine());
      }
         
      System.out.println("\r\nThere were " + lineCount 
            + " line(s) in the file.");
   }
}
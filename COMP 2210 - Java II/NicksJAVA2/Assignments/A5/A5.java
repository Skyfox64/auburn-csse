import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class A5 {

   public static void main(String[] args)  throws IOException {
   
      Dodgson2 d = new Dodgson2();
      //if (args != null){
         //d = new Dodgson(args[0]);
      //}
   
      Scanner fileScan = new Scanner(new File("diller.txt"));
      while (fileScan.hasNext()) {
         String line = fileScan.nextLine();
         Scanner lScan = new Scanner(line);
         lScan.useDelimiter(" ");
         String start = lScan.next();
         String end = lScan.next();
         System.out.println(start + " --> " + end);
         String output = d.getSequence(start, end);
         System.out.println(output + "\n");
      }
   }
}
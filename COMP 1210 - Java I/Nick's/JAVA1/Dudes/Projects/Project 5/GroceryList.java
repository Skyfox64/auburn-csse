   import java.util.ArrayList;
   import java.text.DecimalFormat;
   import java.io.*;
   import java.util.Scanner;
   import java.io.File;
   
/** 
 * Creates class in which a grocery store could
 * use to calculate total price catagorize goods
 * and to decide whether the input is valid.
 *
 * @author Tyler Rabren.
 * @version 9/28/2011.
 * 
 *
 */
   public class GroceryList {
   /**
   * driver program for class GroceryList.
   *@param args < T >
   */
   
   
      public static void  main(String[] args)throws IOException {
         /**@throws IOException
         */
         DecimalFormat decimal = new DecimalFormat("0.##");
      
         String  line, fileName, name, category;
         double base, totalPrice = 0.0, tax;
         
         
         ArrayList<GroceryItem> inputList = 
            new ArrayList<GroceryItem>();         
         
         
         Scanner userIn = new Scanner(System.in);
         System.out.print("File name: ");
         fileName = userIn.nextLine();
         
         Scanner userIn2 = new Scanner(new File(fileName)); 
         tax = userIn2.nextDouble(); 
         
         
         while (userIn2.hasNext())
         {   
            line = userIn2.nextLine();
            System.out.print(line);
         
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {
               name = lineScan.next();
               category = lineScan.next();
               base = lineScan.nextDouble();
                  	
               GroceryItem grocery = new GroceryItem(name, category);
               grocery.setBasePrice(base);
               totalPrice += grocery.calculateTotalPrice(tax);
               inputList.add(grocery);
               
            }     
         } 
         userIn2.close();
         
         System.out.println("Grocery List");
         System.out.println("------------");
      
         // System.out.println(inputList);
               	
               	
         System.out.println("General: ");
      
         for (int index = 0; index < inputList.size(); index++) {
            if (inputList.get(index).getCategory()
            .equals(GroceryItem.GENERAL)) {
               System.out.println("- " + inputList.get(index).getName());
               
            } 
          
         }
         System.out.println("");
         System.out.println("Produce: ");
      
         for (int index = 0; index < inputList.size(); index++) {
            if (inputList.get(index)
            .getCategory().equals(GroceryItem.PRODUCE)) {
               System.out.println("- " + inputList.get(index).getName());
              
            }
         
         }
         System.out.println("");
         System.out.println("Refrigerate:");
      
         for (int index = 0; index < inputList.size(); index++) {
          
            if (inputList.get(index).getCategory()
            .equals(GroceryItem.REFRIGERATED)) {
               System.out.println("- " + inputList.get(index).getName());
               
            }
          
         }
         System.out.println("");
         System.out.println("Frozen: ");
      
         for (int index = 0; index < inputList.size(); index++) {
            
            if (inputList.get(index)
            .getCategory().equals(GroceryItem.FROZEN)) {
               System.out.println("- " 
               + inputList.get(index).getName());
               
            }
           
         }
         System.out.println("");
         System.out.println("Total Cost of Items: $" 
         + (decimal.format(totalPrice)));
      }
   }
   import java.io.File;
   import java.io.IOException;
   import java.util.Scanner;
   
	/**
	* This class will store stacker's name and times and perform  
	* operations such as adding, deleting and finding fastest time.
	*
	* @author Nick DiChiara
	* @version 10-11-2012
	*/
   public class SportStackerApp {
   
   	/**
   	* Method to retrieve file name. Gather information from file. Send to 
   	* SportStacker for processing, and print the results.
   	* @param args the command line arguments.
   	* @throws IOException FileNotFoundException.
   	*/
   
      public static void main(String[] args) throws IOException {
      
         SportStacker stacker = null;
      
      	//R - Read in File    
         boolean getInfo = true;
         while (getInfo) {
                  
            if (args.length == 0) {
               System.out.println("File name expected as a run argument.\n"
                  + "Program ending.");
               return; 
            } 
                  
            Scanner parser = new Scanner(new File(args[0]));
            
            String name = parser.nextLine();
            int numOfTimes = Integer.parseInt(parser.nextLine());
            
            double[] times = new double[numOfTimes];
            
            for (int i = 0; i < times.length; i++) {
               if (parser.hasNext()) {
                  times[i] = parser.nextDouble();
               }
            }
            
            parser.close();
            
            SportStacker newStacker = new SportStacker(name, numOfTimes, times);
            stacker = newStacker;
            System.out.println("File read in and SportStacker created.");
            break;
         }
         
      
         String menu = "Sport Stacker App Menu\n";
         menu += "P - Print Report\n";
         menu += "A - Add A New Time\n";
         menu += "D - Delete Worst Time\n";
         menu += "F - Find Fastest Time\n";
         menu += "Q - Quit\n";
         System.out.print(menu);
      
         Scanner userInput = new Scanner(System.in);
         boolean quit = false;
         
      
         do {
            System.out.print("\n" + "Enter Code [P, A, D, F, or Q]: ");
         
            char input = Character.toLowerCase(userInput.nextLine().charAt(0));
         
            switch (input) {
               case 'p':
               //P - Print Report
                  System.out.print(stacker.toString() + "\n");
                  break;
                  
               case 'a':
               //A - Add A New Time
                  System.out.print("Time To Add: ");
                  stacker.addTime(Double.parseDouble(userInput.nextLine()));
                  break;
               	
               case 'd':
               //D - Delete Worst Time
                  System.out.print("Slowest Time Deleted: " 
                     + stacker.removeSlowestTime() + "\n");
                  break;
               
               case 'f':
               //F - Find Fastest Time
                  System.out.print("Fastest Time: "
                     + stacker.findFastestTime() + "\n");
                  break;
               	
               case 'q':
               	//Q - Quit
                  quit = true;
                  break;
               default:
                  System.out.println("Invalid choice.");			
            }
         } while (!quit);	
         
      }
   
   }
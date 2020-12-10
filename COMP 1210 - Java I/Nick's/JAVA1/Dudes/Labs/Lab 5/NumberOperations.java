   public class NumberOperations
   {
   
      int number;
   
      public NumberOperations(int numberIn)
      {
         number = numberIn;
      }
   
      public int getValue()
      {
         return number; 
      }
   
      public String oddsUnder()
      {
         String output = "";
         
         int i = 0;
         while (i < number) {
            if(i % 2 != 0) {
               output += i + "\t";
            }
            i++;
         }
         return output;
      }
   
      public String powersTwoUnder() 
      {
      	String output = "";
      	int powers = 1;
      	while (powers < number) {
      	output += powers + "\t"; // concatenate to output
      	powers = powers * 2; // get next power of 2
      	}
         return output;
      }
   
      public int isGreater (int compareNumber)
      {
      if (number > compareNumber) {
      	return 1;
      }
      if (number < compareNumber) {
      	return -1;
      }
      else {
         return 0;
         }
      }
   
      public String toString()
      {
      	if ( number < 0 && number % 2 == 0) {
      	String output = number + ": Number is negative even.";
      	}
      	if ( number < 0 && number % 2 != 0) {
      	String output = number + ": Number is negative odd.";
      	}
      	if ( number > 0 && number % 2 == 0) {
      	String output = number + ": Number is positive even.";
      	}
      	if ( number > 0 && number % 2 != 0) {
      	String output = number + ": Number is positive odd.";
      	} 
      	if ( number == 0) {
      	String output = Integer.toString(number);
      	}
         return number + "";
      }
   
   }
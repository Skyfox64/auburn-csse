   
   public class Rectangle 
   		implements TwoDShape, Comparable<Rectangle>
   {
      private double width, height;  
      
      public Rectangle(double widthIn, double heightIn) 
      {
         width = widthIn;
         height = heightIn;    
      }
   
      public boolean isSquare() {  
         return width == height;
      } 
      
      public double getArea() {
         return width * height;
      }
      
      public int getNumberSides() {
         return 4;
      }
      
      public double getPerimeter() {
         return width * 2 + height * 2;
      }
      
      public int compareTo(Rectangle other) { 
         int result = getArea() > other.getArea() ? 1 : 0;
         result = getArea() < other.getArea() ? -1 : result;
         return result;
      }  // Consider the optional use of the this reference.
         // Consider providing result with a value that 
   		// includes magnitude.
     
      public String toString() {  
         String output = "Rectangle Information:\r\n"
            + "   Width: " + width + "\r\n"
            + "   Height: " + height + "\r\n";
         if (isSquare()) {
            output += "   (Square)\r\n";
         }
         return output; 
      } 
   }

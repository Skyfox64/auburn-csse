   public class Triangle
   {
      private double s1; 
      private double s2; 
      private double s3;  
      
      private static final int NUM_SIDES = 3;
   
      public Triangle(double side1, double side2, double side3) 
      {
         setSides(side1, side2, side3);
      }
   	
      public void setSides(double side1, double side2, double side3) {
         if (side1 <= 0 || side2 <= 0 || side3 <= 0) { 
            throw new IllegalArgumentException("Sides: " + side1 + " " + side2 
               + " " + side3 + " must be greater than zero.");
         }
         if ((side1 >= side2 + side3) || (side2 >= side1 + side3) || (side3 >= side1 + side2)) {
            throw new InvalidTriangleException("Sides: " + side1 + " " + side2 + " " + side3
               + " are not a triangle."); 	
         }
         s1 = side1;
         s2 = side2;    
         s3 = side3;
      }
   
      public String getClassification() {  
         String result = "isosceles";  
         
         if ((s1 >= s2 + s3) || (s2 >= s1 + s3) || (s3 >= s1 + s2)) {
            result = "not a valid triangle";
         }
         else if ((s1 == s2) && (s2 == s3)) {  
            result = "equilateral";   
         } 
         else if ((s1 != s2) && (s1 != s3) && (s2 != s3)) { 
            result = "scalene";
         } 
          
         return result; 
      } 
      
      public int getNumberSides() {
         return NUM_SIDES;
      }
      
      public double getPerimeter() {
         return s1 + s2 + s3;
      }
   
      public String toString() {  
         String output = "Triangle Information:\r\n"
            + "Side 1 = " + s1 + " units.\r\n"
            + "Side 2 = " + s2 + " units.\r\n"
            + "Side 3 = " + s3 + " units.\r\n"
            + "The triangle is " + getClassification() + ".";
          
         return output; 
      } 
   }

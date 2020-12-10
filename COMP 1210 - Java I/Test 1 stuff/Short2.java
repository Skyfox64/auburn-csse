class Short2{
   public static void main(String [] args) {
      
      int x = 1;
      int y; 
      y = x++ + x;
      System.out.println("y is " + y);
      
      y = x + ++x;
      System.out.println("y is " +y);
      
      x = 2;
      y = 3;
      double z = Math.pow(y,x);
      
      System.out.println("Square Root of " +
         z + " = " + Math.sqrt(z));
         
   }
}
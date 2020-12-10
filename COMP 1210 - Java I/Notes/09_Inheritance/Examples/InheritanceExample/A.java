public class A
{
   protected int x;
   
   A()
   {
      x = 10;
      System.out.println("Class A's constructor called");
   }
   
   int getX()
   {
      return x;
   }
   
   String compute()
   {
      return Integer.toString(x);
   }
   
   // public boolean equals(Object a) {
   // 	
      // if (x == ((A)a).x)
         // return true;
      // else 
         // return false;
   // }
   
   public boolean equals(A a) {
   	
      if (x == a.x)
         return true;
      else 
         return false;
   }
}

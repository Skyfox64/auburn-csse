   class A
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
      
      Object compute()
      {
         return (Object)(Integer.toString(x));
      }
      
      public boolean equals(Object a) {
      	
         if (x == ((A)a).x)
            return true;
         else 
            return false;
      }
   }

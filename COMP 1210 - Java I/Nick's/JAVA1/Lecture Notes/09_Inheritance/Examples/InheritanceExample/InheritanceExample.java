   public class InheritanceExample
   {
      public static void main(String[] args)
      {
         System.out.println("Creating an instance of A");
         A myA = new A();
         Object a = myA.compute();
         
         System.out.println("\nCreating an instance of B");
         B myB = new B();
         String b = myB.compute();     
          
         System.out.println("\nCreating an instance of C");
         C myC = new C();
         String c = myC.compute();
         
         A myAC = new C(); 
         Object ac = myAC.compute();
         C myCA = (C)myAC;
        
         //C myCA2 = (C)new A();  // Fails at runtime
      
         System.out.println("\nmyA.x: " + myA.getX());
         System.out.println("myB.x: " + myB.getX());
         System.out.println("myC.x: " + myC.getX());
      
         System.out.println("myC.x ?: " + ((A)myC).getX());
      
         System.out.println("Done");
      }
   }

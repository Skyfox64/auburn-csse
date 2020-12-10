/**
 * Declares and intializes an example of each 
 * primitive type.  Set a breakpoint, run Debug 
 * and then open a viewer on each variable.  
 * Set the viewer to "Detail" view.
 */
   public class TypesExample
   {
   /**
    * Primitive types in Java.
    *    @param args - Standard commandline arguments
    */
      static final int MAXX = 1000;
    
      public static void main(String[]args)
      {
         byte b = 15;
         short s = 15;
         int i = 15;
         long j = 15;
      	
         float a = 15;
         float x = 999;
         double y = 999;
         double z = 0.1;
      	
         char c = 'A';
      	
         boolean bn = true;
      	
      	// These last two are declared as constants. 
         final int MIN = 0;
         final int MAX = 1000;
      	
      	// An attempt to change will be caught at compile time.
         //MAX = 500;
      	 
      }
   }
   import org.junit.Assert;
   import org.junit.Test;
   import java.lang.reflect.*;
   
 /** Tests methods in Triangle3 class 
  *  where the setSides method is private. 
  **/
   public class Triangle3Test {
   
     /** Tests equilateral classification. **/
      @Test public void equilateralTest() {
         Triangle3 t = new Triangle3(5, 5, 5);
         Assert.assertEquals("equilateral", 
                             t.getClassification());
      }
      
   	 /** Tests isosceles classification. **/
      @Test public void isoscelesTest() {
         Triangle3 t = new Triangle3(5, 7, 5);
         Assert.assertEquals("isosceles", 
                             t.getClassification());
      }   
   	
   	 /** Tests scalene classification after setSides. **/
      @Test public void scaleneAfterSetTest() {
         Triangle3 t = new Triangle3(5, 7, 5);
         //t.setSides(3, 4, 5);
      	// must use reflection to invoke the private method setSides.
         Class c = t.getClass();
         try {
            Method m = c.getDeclaredMethod("setSides", 
               new Class[]{double.class,double.class,double.class});
            m.setAccessible(true); 
            m.invoke(t, new Object[]{3,4,5});
         }
            catch (Exception e) {}
      
         Assert.assertEquals("scalene", 
            					  t.getClassification());
      }
      
   	 /** Tests scalene classification. **/
      // @Test public void scaleneTest() {
         // Triangle3 t = new Triangle3(5, 7, 8);
      //    // includes an error message if the output is incorrect
         // Assert.assertEquals("Scalene classification incorrect.", "scalene", 
            //                  t.getClassification());
      // }
      
   	/** Tests scalene output in toString. **/
      // @Test public void scaleneToStringTest() {
         // Triangle3 t = new Triangle3(5, 7, 8);
         // boolean hasExp = t.toString().contains("scalene");
         // Assert.assertTrue(hasExp);
      // }
   }

   import org.junit.Assert;
   import org.junit.Test;

 /** Tests methods in Triangle2 class. **/
   public class Triangle2Test {
   
     /** Tests equilateral classification. **/
      @Test public void equilateralTest() {
         Triangle2 t = new Triangle2(5, 5, 5);
         Assert.assertEquals("equilateral", 
                             t.getClassification());
      }
      
   	 /** Tests isosceles classification. **/
      @Test public void isoscelesTest() {
         Triangle2 t = new Triangle2(5, 7, 7);
         Assert.assertEquals("isosceles", 
                             t.getClassification());
      }   
   	
   	 /** Tests scalene classification after setSides. **/
      @Test public void scaleneAfterSetTest() {
         Triangle2 t = new Triangle2(5, 7, 5);
         t.setSides(3, 4, 5);
         Assert.assertEquals("scalene", 
            					  t.getClassification());
      }
      
   	 /** Tests scalene classification. **/
      @Test public void scaleneTest() {
         Triangle2 t = new Triangle2(5, 7, 8);
         // includes an error message if the output is incorrect
         Assert.assertEquals("Scalene classification incorrect.", "scalene", 
                             t.getClassification());
      }
      
   	/** Tests scalene output in toString. **/
      // @Test public void scaleneToStringTest() {
         // Triangle2 t = new Triangle2(5, 7, 8);
         // boolean hasExp = t.toString().contains("scalene");
         // Assert.assertTrue(hasExp);
      // }
   }

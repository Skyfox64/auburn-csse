/**
 * @author J. Cross
 */
   public class Publisher
   {
      private String name = new String("none");
      private String city = new String("none");
   
      public Publisher(String theName, String theCity)
      {
         name = theName;
         city = theCity;
      }
      public String toString ()
      {
         return ("\nPublisher: " + name +
            "\nCity: " + city);
      }
   }

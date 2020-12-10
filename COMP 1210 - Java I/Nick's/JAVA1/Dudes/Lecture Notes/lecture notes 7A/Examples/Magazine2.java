   public class Magazine2 
   {
      private String title;
      private int pages;
      private Publisher publisher;
      private static int count = 0; 
   
      public Magazine2(String title, int pages, 
       String thePublisher, String theCity)
      {
         this.title = title;
         this.pages = pages;
         publisher = new Publisher(thePublisher, theCity);
         count++;  
      }
   
      public String toString ()
      {
         return ("\nTitle: " + title +
            "\nPages: " + pages +
            publisher.toString());
      }
      
      public static int getCount()
      {
         return count;
      }
   }

   import java.util.Comparator;

/**
 * Client for a search library with a generic type.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2010-08-20
 *
 */
   public class SearchLibraryGenericCompClient
   {
   
    
   /**
    * Illustrates basic calls to search method.
    *
    * @param args Command line arguments not used.
    *
    */ 
      public static void main(String[] args)
      {
      
         Book[] a = {
               new Book("Smith", "Smith Book", 123),
               new Book("Jones", "Jones Book", 456),
               new Book("Baker", "Baker Book", 789)
               };
         Book target = new Book("Wilson", "Jones Book", 543);
      
      
         SearchLibraryGenericComp<Book> slgc = new SearchLibraryGenericComp<Book>();
      
         System.out.println(slgc.search(a, target));
         System.out.println(slgc.search(a, target, new CompareBooksByTitle()));
         System.out.println(slgc.search(a, target, new CompareBooksByAuthor()));
      
      }
   
   
    
   /**
    * Defines comparison of two books by title equality.
    *
    */	
      public static class CompareBooksByTitle implements Comparator<Book>
      {
      /**
       * Compares two books by title.
       *
       * @param o1	Object referencing the first Book
       * @param o2	Object referencing the second Book.
       * @return		zero if o1 and o1 are logically equal,
       *					positive if o1 > o2
       *					negative if o1 < o2
       */
         public int compare(Book b1, Book b2) 
         {
            return b1.getTitle().compareTo(b2.getTitle());
         }
      }  
   
   /**
    * Defines comparison of two books by author equality.
    *
    */	
      public static class CompareBooksByAuthor implements Comparator<Book>
      {
      /**
       * Compares two books by author.
       *
       * @param o1	Object referencing the first Book
       * @param o2	Object referencing the second Book.
       * @return		zero if o1 and o1 are logically equal,
       *					positive if o1 > o2
       *					negative if o1 < o2
       */
         public int compare(Book b1, Book b2) 
         {
            return b1.getAuthor().compareTo(b2.getAuthor());
         }
      }  
    
   }
   

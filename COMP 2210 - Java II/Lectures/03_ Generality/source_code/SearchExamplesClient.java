   import java.util.Comparator;
   import java.awt.Color;
    
   public class SearchExamplesClient
   {
   
      public static class CompareBooksByTitle implements Comparator
      {
         public int compare(Object o1, Object o2) 
         {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;
         
            return b1.getTitle().compareTo(b2.getTitle());
         }
      }  
   
      public static class CompareBooksByAuthor implements Comparator
      {
         public int compare(Object o1, Object o2) 
         {
            Book b1 = (Book) o1;
            Book b2 = (Book) o2;
         
            return b1.getAuthor().compareTo(b2.getAuthor());
         }
      }  
   
   
      public static void main(String[] args)
      {
         Book[] bookArray = {
               new Book("Smith", "Smith Book", 123),
               new Book("Jones", "Jones Book", 456),
               new Book("Baker", "Baker Book", 789)
               };
         Book bookTarget = new Book("Wilson", "Jones Book", 543);
      
         String[] stringArray = {"red", "orange", "yellow", "green", 
                                 "blue", "indigo", "violet"};
         String stringTarget = "blue";
         
         Integer[] integerArray = {2, 4, 6, 8, 10};
         Integer integerTarget = 8;
         
         Object[] mixedArray = {"red", 
                                new Book("Lewis", "Perelandra", 123), 
               					  new Integer(15)};
         
         Comparable[] comparableArray = {"red", 
                                new Book("Lewis", "Perelandra", 123), 
               					  new Integer(15)};
         
         Color[] colorArray = {new Color(253, 90, 30), 
               new Color(4, 28, 67), 
               new Color(0, 0, 0)};
         Color colorTarget = Color.ORANGE;
      
      	
         System.out.println(SearchExamples.searchObject(stringArray, stringTarget));
         System.out.println(SearchExamples.searchObject(integerArray, integerTarget));
         System.out.println(SearchExamples.searchObject(mixedArray, stringTarget));
         System.out.println(SearchExamples.searchObject(comparableArray, stringTarget));
         System.out.println(SearchExamples.searchObject(bookArray, bookTarget));
         System.out.println(SearchExamples.searchObject(colorArray, colorTarget));
      
         System.out.println(SearchExamples.searchComparable(stringArray, stringTarget));
         System.out.println(SearchExamples.searchComparable(integerArray, integerTarget));
         // Next line causes compile-time error
         //System.out.println(SearchExamples.searchComparable(mixedArray, stringTarget));
         // Next line causes run-time error
         //System.out.println(SearchExamples.searchComparable(comparableArray, stringTarget));
         System.out.println(SearchExamples.searchComparable(bookArray, bookTarget));
         // Next line causes compile-time error
         //System.out.println(SearchExamples.searchComparable(colorArray, colorTarget));
      
         System.out.println(SearchExamples.searchComparator(bookArray, bookTarget, new CompareBooksByTitle()));
         System.out.println(SearchExamples.searchComparator(bookArray, bookTarget, new CompareBooksByAuthor()));
      
         // The following five lines are not type safe, but they compile and run anyway
         // according to Java's type inferencing.
         System.out.println(SearchExamples.searchGeneric(stringArray, stringTarget));
         System.out.println(SearchExamples.searchGeneric(integerArray, integerTarget));
         System.out.println(SearchExamples.searchGeneric(mixedArray, stringTarget));
         System.out.println(SearchExamples.searchGeneric(comparableArray, stringTarget));
         System.out.println(SearchExamples.searchGeneric(bookArray, bookTarget));
         System.out.println(SearchExamples.searchGeneric(colorArray, colorTarget));
      
         // The following lines illustrate how to call generic methods in a type safe manner.
      	// Only the ones that should compile do compile. The typing errors are caught at compile-time.
         System.out.println(SearchExamples.<String>searchGeneric(stringArray, stringTarget));
         System.out.println(SearchExamples.<Integer>searchGeneric(integerArray, integerTarget));
         // Next line causes compile-time error
         //System.out.println(SearchExamples.<String>searchGeneric(mixedArray, stringTarget));
         // Next line causes compile-time error
         //System.out.println(SearchExamples.<String>searchGeneric(comparableArray, stringTarget));
         System.out.println(SearchExamples.<Book>searchGeneric(bookArray, bookTarget));
         System.out.println(SearchExamples.<Color>searchGeneric(colorArray, colorTarget));
      
      }
   }

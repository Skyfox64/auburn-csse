/**
 * Represents a Book.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @author  James Cross (crossjh@auburn.edu)
 * @version 2011-08-15
 *
 */
   public class Book implements Comparable
   {
      private String author;
      private String title;
      private int pages; 
      
   /**
    * Default constructor.
    *
    */	
      public Book()
      {
         author = new String("no author");
         title = new String("no title");
         pages = 0;
      }
   
   /**
    * Instantiates book with supplied fields.
    * 
    * @param theAuthor	the book's author
    * @param theTitle	the book's title
    * @param thePages	number of pages in the book
    *
    */
      public Book(String theAuthor, String theTitle, int thePages)
      {
         author = theAuthor; 
         title = theTitle;
         pages = thePages;  
      }
      
   /**
    * Getter for the author field.
    *
    * @return	the book's author
    *
    */	   
      public String getAuthor() 
      {
         return this.author;
      }
   
   /**
    * Getter for the title field.
    *
    * @return	the book's title
    *
    */	   
      public String getTitle() 
      {
         return this.title;
      }
   
   /**
    * Getter for the pages field.
    *
    * @return	the book's number of pages
    *
    */	   
      public int getPages() 
      {
         return this.pages;
      }
   
   
   /**
    * Compares this book to another book based on title.
    * Specifies the natural order of books.
    *
    * Note: This class has a natural ordering that is 
    * inconsistent with equals.
    *
    * @param obj	Other book to be compared to this book
    * @return		zero if this book == obj,
    *					positive if this book > obj
    *					negative if this book < obj
    * @see			java.lang.Comparable
    */	
      // public int compareTo(Object obj)
      // {
         // Book otherBook = (Book) obj;
         // return this.getTitle().compareTo(otherBook.getTitle());
      // }
   
   
   /**
    * Compares this book to another book based on title.
    * Specifies the natural order of books.
    *
    * @param obj	Other book to be compared to this book
    * @return		zero if this book == obj,
    *					positive if this book > obj
    *					negative if this book < obj
    * @see			java.lang.Comparable
    */	
      public int compareTo(Object obj)
      {
         Book otherBook = (Book) obj;
         int result = this.getTitle().compareTo(otherBook.getTitle());
         if (result == 0)
         {
            result = this.getAuthor().compareTo(otherBook.getAuthor());
         }
         return result;
      }
   
   
   /**
    * Checks equality of this book and another book based
    * on title.
    *
    * @param obj	Other book to be compared to this book
    * @return		true if this book == obj, false otherwise
    *
    */
      // @Override
      // public boolean equals(Object obj)
      // {
         // Book that = (Book) obj;
         // return this.title.equals(that.getTitle());
      // }
   
   
   /**
    * Checks equality of this book and another book based
    * on title.
    *
    * @param obj	Other book to be compared to this book
    * @return		true if this book equals obj, false otherwise
    *
    */
      // @Override
      // public boolean equals(Object obj)
      // {
         // return this.compareTo(obj) == 0;
      // }
   
   
   /**
    * Checks equality of this book and another book based
    * on both title and author fields.
    *
    * @param obj	Other book to be compared to this book
    * @return		true if this book equals obj, false otherwise
    *
    */
      @Override
      public boolean equals(Object obj)
      {
         if (obj == this) 
            return true;
      
         if (obj == null) 
            return false;
      
      /** Note the implications of getClass() v. instanceof */
         // if (obj.getClass() != this.getClass()) 
            // return false;
            
         if (!(obj instanceof Book))
         {
            return false; 
         }
      
         Book that = (Book) obj;
         
         return this.title.equals(that.getTitle()) &&
            this.author.equals(that.getAuthor());
      }
   
   
   /**
    * Creates a string representation of this book.
    *
    * @return		string representation of this book
    *
    */
      @Override   
      public String toString()
      {
         return ("\nAuthor: " + author
            + "\nTitle: " + title
            + "\nPages: " + pages);
      }
   }

public class OnlineBook extends OnlineTextItem
{
   protected String author;

   public OnlineBook(String nameIn, double priceIn)
   {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }

   public String toString()
   {
      return name + " - " + author + ": $" + price;
   }

   public void setAuthor(String authorIn)
   {
      author = authorIn;
   }
}
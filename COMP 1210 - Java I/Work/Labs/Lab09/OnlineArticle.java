public class OnlineArticle extends OnlineTextItem
{
   private int wordCount;

   public OnlineArticle(String nameIn, double priceIn, int wordCountIn)
   {
      super(nameIn, priceIn);
      wordCount = 0;
      setWordCount(wordCountIn);
   }

   public void setWordCount(int wordCountIn)
   {
      wordCount = wordCountIn;
   }
}
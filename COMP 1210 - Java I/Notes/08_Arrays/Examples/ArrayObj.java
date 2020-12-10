class ArrayObj
{
   public static void main (String[] args)
   {
      String[] array = new String[5];
      array[0] = "cat";
      //array[4] = "dog";
      System.out.println(array[0] + " " + array[4]);
      //System.out.println(array[0].toString());
      //System.out.println(array[0].length());
   	
      String s = new String();
      int j = s.length();
      s = null;
      
      System.out.println(s.toUpperCase());
   }
}
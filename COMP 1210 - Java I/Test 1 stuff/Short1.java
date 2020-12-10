class Short1{
   public static void main(String[] args) {
      String s1 = new String("Welcome to Java!");
      String s2 = s1.toUpperCase();
      
      System.out.println (s2);
      
      int index = s1.indexOf(" ");
      String s3 =  s1.substring (0, index);
      System.out.println (s3);
      
      s3 = s3.concat("!");
      System.out.println (s3);
      
      System.out.println(s1.length());
   }
}
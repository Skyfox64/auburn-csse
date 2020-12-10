   import javax.activation.MimetypesFileTypeMap;
   import java.io.File;

   class GetMimeType {
      public static void main(String args[]) throws Exception {
         File f = new File("cloud.txt");
         System.out.println("Mime Type of " + f.getName() + " is " +
                         new MimetypesFileTypeMap().getContentType(f));
         System.out.println(FileUtils.getMimeType("cloud.txt"));
            				 
      // expected output :
      // "Mime Type of gumby.gif is image/gif"
      }
   }
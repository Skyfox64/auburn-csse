   import java.net.FileNameMap;
   import java.net.URLConnection;

   public class FileUtils {
   
      public static void main(String args[]) throws Exception {
         String fname = "cloud.png";
         System.out.println("Your file "+ fname +" has been successfully "+
            					 "uploaded and is of the filetype "+
            						FileUtils.getMimeType(fname));
      }
      
      public static String getMimeType(String fileUrl)
      throws java.io.IOException
      {
         FileNameMap fileNameMap = URLConnection.getFileNameMap();
         String type = fileNameMap.getContentTypeFor(fileUrl);
      
         return type;
      }
   
   
   }
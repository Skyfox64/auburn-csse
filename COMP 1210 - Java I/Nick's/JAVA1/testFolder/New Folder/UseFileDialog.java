   import java.awt.*;
   public class UseFileDialog {
   
      public String loadFile
      (Frame f, String title, String defDir, String fileType) {
         FileDialog fd = new FileDialog(f, title, FileDialog.LOAD);
         fd.setFile(fileType);
         fd.setDirectory(defDir);
         fd.setLocation(50, 50);
         fd.show();
         return fd.getFile();
      }
   
      public String saveFile
      (Frame f, String title, String defDir, String fileType) {
         FileDialog fd = new FileDialog(f, title,    FileDialog.SAVE);
         fd.setFile(fileType);
         fd.setDirectory(defDir);
         fd.setLocation(50, 50);
         fd.show();
         return fd.getFile();
      }
   
      public static void main(String s[]) {
         UseFileDialog ufd = new UseFileDialog();
         System.out.println
            ("Loading : " 
            + ufd.loadFile(new Frame(), "Open...", ".\\", "*.java"));
         System.out.println
            ("Saving : " 
            + ufd.saveFile(new Frame(), "Save...", ".\\", "*.java"));
         System.exit(0);
      }
   }
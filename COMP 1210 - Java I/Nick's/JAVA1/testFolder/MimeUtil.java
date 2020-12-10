import eu.medsea.mimeutil.MimeUtil;

public class MimeUtil {
    public static void main(String[] args) {
        MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
        File f = new File ("c:/temp/mime/test.doc");
        Collection<?> mimeTypes = MimeUtil.getMimeTypes(f);
        System.out.println(mimeTypes);
        //  output : application/msword
    }
}
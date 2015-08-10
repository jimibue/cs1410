package assign12a;

import java.io.File;
/**
 * this class gets the extension of a file and is used with FileNameFilter
 * to help determine what files can be chosen.
 * @author James Yeates with help from oracle docs.
 *
 */

public class Utils {
	//acceptable extensions
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String bmp = "bmp";
    public final static String png = "png";

    //get the extension
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        //find the last '.'
        int i = s.lastIndexOf('.');
        //get the extension
        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

}
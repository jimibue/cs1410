package assign12a;

import java.io.File;

import javax.swing.filechooser.FileFilter;
/**
 * This class declares the acceptable files to shown in the JFileChooser.
 *   
 * @author James Yeates with help from oracle docs.
 *
 */
public class FileNameFilter extends FileFilter {

    //Accept all directories and all gif, jpg, bmp, tiff, or png  files.
    public boolean accept(File f) {
    	//if it is a directory let it be selected
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        //Acceptable extensions
        if (extension != null) {
            if (extension.equals(Utils.gif) ||
                extension.equals(Utils.jpeg) ||
                extension.equals(Utils.jpg) ||
                extension.equals(Utils.bmp) ||
                extension.equals(Utils.png)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter, which will be shown in the JFile chooser
    public String getDescription() {
        return "gif, jpg, bmp, tiff, or png ";
    }
}
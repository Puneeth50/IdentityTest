package fileUtility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by puneeth on 11/04/2018.
 */
public class FileObjects {

    /* Below method return FileServiceBean Object list for all the files in directory
    * */

    public List<FileServiceBean> getFiles(){

        List<FileServiceBean> filebean = new ArrayList<FileServiceBean>();

        File directory = new File(System.getProperty("user.dir")+"//src//main//resources//files");
        System.out.println(directory.getName());
        File[] files = directory.listFiles();
        for(File file: files){
            filebean.add(new FileServiceBean(file.getName(),getFileExtension(file),getMemeType(file),file.length()));

        }

        return filebean;
    }

    /* Below Method return file Meme Type
    * @Param File
    * @Return String fileMemeType
    * */

    public static String getMemeType(File file){
       String mimeType = null;
        try
        {
            Path p = Paths.get(file.getName());
            mimeType = Files.probeContentType(p);
            System.out.println("Mime type" + mimeType);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        return mimeType;

    }

    /* Below method returns file extension
    * */

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

}

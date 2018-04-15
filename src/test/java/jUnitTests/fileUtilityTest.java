package jUnitTests;

import com.google.common.collect.Lists;
import fileUtility.FileObjects;
import fileUtility.FileServiceBean;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by puneeth on 11/04/2018.
 */
public class fileUtilityTest {

    FileObjects files = new FileObjects();
    FileServiceBean serviceBean;
    List<String> fileNames = Lists.newArrayList("data.csv",
            "New Bitmap Image.bmp",
            "New Microsoft Office Access 2007 Database.accdb",
            "New Microsoft Office Excel Worksheet (2).xlsx",
           "New Microsoft Office PowerPoint Presentation.pptx",
            "New Microsoft Office Word Document.docx",
            "New Text Document (2).txt",
            "New Text Document.txt",
           "New WinRAR archive.rar",
            "New WinRAR ZIP archive.zip",
            "text.txt");
    List<String> fileExtensions = Lists.newArrayList("csv", "bmp", "accdb", "xlsx", "pptx", "docx", "txt", "txt", "rar", "zip", "txt");
    List<String> fileMimeTypes = Lists.newArrayList(
            "application/vnd.ms-excel",
            "image/bmp", "application/msaccess",
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
            "application/vnd.openxmlformats-officedocument.presentationml.presentation",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "text/plain",
            "text/plain", null, "application/x-zip-compressed", "text/plain");
    List<Integer> fileSizes = Lists.newArrayList(25, 0, 278528, 8714, 27566, 0, 0, 0, 20, 22, 0);

    @Test()
    public void verifyDirectoryFilesNames(){
        List<String> actualFileName = new ArrayList<String>();

        List<FileServiceBean> fileObjects = files.getFiles();
        for(FileServiceBean fileObject:fileObjects){
           actualFileName.add(fileObject.getFileName());
        }
        System.out.println("Actual File Names :" + actualFileName);
        System.out.println("Expected File Names :" + fileNames);

        Assert.assertEquals(actualFileName,fileNames);
    }

    @Test()
    public void verifyDirectoryFileExtensions(){
        List<String> actualFileExtensions = new ArrayList<String>();

        List<FileServiceBean> fileObjects = files.getFiles();
        for(FileServiceBean fileObject:fileObjects){
            actualFileExtensions.add(fileObject.getFileExtension());
        }
        System.out.println("Actual File Names :" + actualFileExtensions);
        System.out.println("Expected File Names :" + fileExtensions);

        Assert.assertEquals(actualFileExtensions,fileExtensions);
    }

    @Test()
    public void verifyDirectoryFileMimeTypes(){
        List<String> actualFileMimeTpes = new ArrayList<String>();

        List<FileServiceBean> fileObjects = files.getFiles();
        for(FileServiceBean fileObject:fileObjects){
            actualFileMimeTpes.add(fileObject.getFileMimeType());
        }
        System.out.println("Actual File Names :" + actualFileMimeTpes);
        System.out.println("Expected File Names :" + fileMimeTypes);

        Assert.assertEquals(actualFileMimeTpes,fileMimeTypes);
    }

    @Test()
    public void verifyDirectoryFileSizes(){
        List<Integer> actualFileSizes = new ArrayList<Integer>();

        List<FileServiceBean> fileObjects = files.getFiles();
        for(FileServiceBean fileObject:fileObjects){
            actualFileSizes.add(fileObject.getFileSize().intValue());
        }
        System.out.println("Actual File Names :" + actualFileSizes);
        System.out.println("Expected File Names :" + fileSizes);

        Assert.assertEquals(actualFileSizes,fileSizes);
    }
}

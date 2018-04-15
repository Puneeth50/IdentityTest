package fileUtility;

/**
 * Created by puneeth on 11/04/2018.
 */
public class FileServiceBean {

    private String fileName = null;
    private String fileExtension = null;
    private String fileMimeType = null;
    private long fileSize ;


    public FileServiceBean(String fileName, String fileExtension, String fileMimeType, long fileSize) {

        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.fileMimeType = fileMimeType;
        this.fileSize = fileSize;
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }
}

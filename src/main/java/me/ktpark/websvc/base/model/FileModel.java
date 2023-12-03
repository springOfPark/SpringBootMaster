package me.ktpark.websvc.base.model;

public class FileModel {

    private String fileId;
    private String uploadFileInputKey;
    private String viewFileName;
    private String storageFileName;
    private String filePath;
    private String fileExtension;
    private long fileSize;
    private String fileContentType;

    @Override
    public String toString() {
        return "FileModel{" +
                "fileId='" + fileId + '\'' +
                ", uploadFileInputKey='" + uploadFileInputKey + '\'' +
                ", viewFileName='" + viewFileName + '\'' +
                ", storageFileName='" + storageFileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", fileSize=" + fileSize +
                ", fileContentType='" + fileContentType + '\'' +
                '}';
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getUploadFileInputKey() {
        return uploadFileInputKey;
    }

    public void setUploadFileInputKey(String uploadFileInputKey) {
        this.uploadFileInputKey = uploadFileInputKey;
    }

    public String getViewFileName() {
        return viewFileName;
    }

    public void setViewFileName(String viewFileName) {
        this.viewFileName = viewFileName;
    }

    public String getStorageFileName() {
        return storageFileName;
    }

    public void setStorageFileName(String storageFileName) {
        this.storageFileName = storageFileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
}

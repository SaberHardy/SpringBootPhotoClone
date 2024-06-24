package com.springteestproject.photos_clone;

public class PhotoModel {

    public PhotoModel() {

    }

    public PhotoModel(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    // This class is for creating the photo model for the database
    private String id;
    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}

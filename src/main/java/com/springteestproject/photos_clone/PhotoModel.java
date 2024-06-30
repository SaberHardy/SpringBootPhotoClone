package com.springteestproject.photos_clone;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class PhotoModel {

    public PhotoModel() {

    }

    public PhotoModel(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    @JsonIgnore
    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    // This class is for creating the photo model for the database
    private String id;

    @NotEmpty
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

package com.springteestproject.photos_clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotosController {

    private List<PhotoModel> db = List.of(new PhotoModel("1", "Hello.jpg"));

    @GetMapping("/")
    public String hello() {
        return "hello from here!";
    }

    @GetMapping("/photos")
    public List<PhotoModel> getPhotos() {
        return db;
    }
}

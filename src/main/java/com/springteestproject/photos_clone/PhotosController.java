package com.springteestproject.photos_clone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotosController {
//    private List<PhotoModel> db = List.of(new PhotoModel("1", "Hello.jpg"));

    private final PhotoService photoService;

    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "hello from here!";
    }

    @GetMapping("/photos")
    public Collection<PhotoModel> getPhotos() {
        return photoService.getPhotos();
    }

    @GetMapping("/photos/{id}")
    public PhotoModel getPhoto(@PathVariable String id) {
        PhotoModel photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable String id) {
        PhotoModel photo = photoService.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photos")
    @ResponseStatus(HttpStatus.CREATED)
    public PhotoModel createPhoto(@RequestPart("data") MultipartFile file) throws Exception {
        return photoService.save(file.getOriginalFilename(), file.getBytes());
    }
}

package com.springteestproject.photos_clone;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotosController {
    // i will replace the list of photos with a hashmap
    private Map<String, PhotoModel> db = new HashMap<>() {{
        put("1", new PhotoModel("1", "Hello.jpg"));
    }};
//    private List<PhotoModel> db = List.of(new PhotoModel("1", "Hello.jpg"));


    @GetMapping("/")
    public String hello() {
        return "hello from here!";
    }

    @GetMapping("/photos")
    public Collection<PhotoModel> getPhotos() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public PhotoModel getPhoto(@PathVariable String id) {
        PhotoModel photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void deletePhoto(@PathVariable String id) {
        PhotoModel photo = db.remove(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photos")
    @ResponseStatus(HttpStatus.CREATED)
    public PhotoModel createPhoto(@RequestBody @Valid PhotoModel photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }
}

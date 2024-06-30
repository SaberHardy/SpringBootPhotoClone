package com.springteestproject.photos_clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

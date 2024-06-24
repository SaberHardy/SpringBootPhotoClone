package com.springteestproject.photos_clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotosController {
    @GetMapping("/")
    public String hello() {
        return "hello from here!";
    }
}

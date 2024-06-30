package com.springteestproject.photos_clone;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
@Service
public class PhotoService {
    // i will replace the list of photos with a hashmap
    private Map<String, PhotoModel> db = new HashMap<>() {{
        put("1", new PhotoModel("1", "Hello.jpg"));
    }};

    public Collection<PhotoModel> getPhotos() {
        return db.values();
    }

    public PhotoModel get(String id) {
        return db.get(id);
    }

    public PhotoModel remove(String id) {
        return db.remove(id);
    }

    public PhotoModel save(String fileName, byte[] data) {
        PhotoModel photo = new PhotoModel();

        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);

        photo.setData(fileName.getBytes());
        db.put(photo.getId(), photo);

        return photo;
    }
}

package io.swagger.model;

import java.util.HashMap;
import java.util.List;

public class PetPojo {

    private int id;
    private HashMap<Object,Object> category;
    private String name;
    private List<Object> photoUrls;
    private List<HashMap<Object, Object>> tags;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Object, Object> getCategory() {
        return category;
    }

    public void setCategory(HashMap<Object, Object> category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<Object> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<HashMap<Object, Object>> getTags() {
        return tags;
    }

    public void setTags(List<HashMap<Object, Object>> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


public static PetPojo getPetPojo(int id, int i, HashMap<Object,Object> category, String name, List<Object> photoUrls, List<HashMap<Object, Object>> tags, String status){
        PetPojo petPojo = new PetPojo();
        petPojo.setId(id);
        petPojo.setCategory(category);
        petPojo.setName(name);
        petPojo.setPhotoUrls(photoUrls);
        petPojo.setTags(tags);
        petPojo.setStatus(status);
        return petPojo;
    }
}

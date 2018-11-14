
package com.blogspot.randomtravelerofindia.travel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("image")
    @Expose
    private com.blogspot.randomtravelerofindia.travel.Image image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public com.blogspot.randomtravelerofindia.travel.Image getImage() {
        return image;
    }

    public void setImage(com.blogspot.randomtravelerofindia.travel.Image image) {
        this.image = image;
    }

}

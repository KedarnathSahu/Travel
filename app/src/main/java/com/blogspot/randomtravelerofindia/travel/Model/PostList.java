
package com.blogspot.randomtravelerofindia.travel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostList {

    @SerializedName("nextPageToken")
    @Expose
    private String nextPageToken;
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("items")
    @Expose
    private List<com.blogspot.randomtravelerofindia.travel.Item> items = null;
    @SerializedName("etag")
    @Expose
    private String etag;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<com.blogspot.randomtravelerofindia.travel.Item> getItems() {
        return items;
    }

    public void setItems(List<com.blogspot.randomtravelerofindia.travel.Item> items) {
        this.items = items;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }
}

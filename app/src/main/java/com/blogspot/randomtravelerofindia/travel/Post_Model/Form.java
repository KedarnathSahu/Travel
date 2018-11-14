
package com.blogspot.randomtravelerofindia.travel.Post_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Form {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("password")
    @Expose
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

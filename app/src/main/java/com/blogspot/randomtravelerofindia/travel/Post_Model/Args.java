
package com.blogspot.randomtravelerofindia.travel.Post_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Args {

    @SerializedName("login")
    @Expose
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}

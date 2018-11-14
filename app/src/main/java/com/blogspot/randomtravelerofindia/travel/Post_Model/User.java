
package com.blogspot.randomtravelerofindia.travel.Post_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("args")
    @Expose
    private Args args;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("files")
    @Expose
    private Files files;
    @SerializedName("form")
    @Expose
    private Form form;
    @SerializedName("headers")
    @Expose
    private Headers headers;
    @SerializedName("json")
    @Expose
    private Object json;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("url")
    @Expose
    private String url;

    public Args getArgs() {
        return args;
    }

    public void setArgs(Args args) {
        this.args = args;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Files getFiles() {
        return files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Object getJson() {
        return json;
    }

    public void setJson(Object json) {
        this.json = json;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

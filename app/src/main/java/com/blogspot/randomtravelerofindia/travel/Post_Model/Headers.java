
package com.blogspot.randomtravelerofindia.travel.Post_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headers {

    @SerializedName("Accept")
    @Expose
    private String accept;
    @SerializedName("Accept-Encoding")
    @Expose
    private String acceptEncoding;
    @SerializedName("Cache-Control")
    @Expose
    private String cacheControl;
    @SerializedName("Connection")
    @Expose
    private String connection;
    @SerializedName("Content-Length")
    @Expose
    private String contentLength;
    @SerializedName("Content-Type")
    @Expose
    private String contentType;
    @SerializedName("Host")
    @Expose
    private String host;
    @SerializedName("Postman-Token")
    @Expose
    private String postmanToken;
    @SerializedName("User-Agent")
    @Expose
    private String userAgent;

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public void setCacheControl(String cacheControl) {
        this.cacheControl = cacheControl;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPostmanToken() {
        return postmanToken;
    }

    public void setPostmanToken(String postmanToken) {
        this.postmanToken = postmanToken;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}

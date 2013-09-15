package org.ninjadev.blast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo  {
	private int id;
    private int height;
    private int width;

    @JsonProperty("posted_on")
    private double postedOn;

    @JsonProperty("resource_uri")
    private String resourceUri;

    @JsonProperty("picture_url")
	private String pictureUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(double postedOn) {
        this.postedOn = postedOn;
    }

    public String getResourceUri() {
        return resourceUri;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", height=" + height +
                ", width=" + width +
                ", postedOn=" + postedOn +
                ", resourceUri='" + resourceUri + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}

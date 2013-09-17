package org.ninjadev.blast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo implements Comparable<Photo> {
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

    @Override
    public int compareTo(Photo another) {
        if (this.getId() == another.getId()) {
            return 0;
        } else if (this.getId() > another.getId()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Photo other = (Photo) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

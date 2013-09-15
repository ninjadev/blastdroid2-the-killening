package org.ninjadev.blast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aleksanb on 9/15/13.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoWrapper {
    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("objects")
    private Photo[] photos;

    public Photo[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photo[] photos) {
        this.photos = photos;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}

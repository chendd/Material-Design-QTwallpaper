package us.wili.qtwallpaper.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qiu on 7/26/15.
 */
public class HotPicture {
    @SerializedName("url")
    private String url;

    @SerializedName("like")
    private String like;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

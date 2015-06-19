package us.wili.qtwallpaper.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qiu on 5/12/15.
 */
public class Picture {
    @SerializedName("id")
    private Integer id ;

    @SerializedName("star")
    private Integer star;

    @SerializedName("like")
    private String like;

    @SerializedName("name")
    private String name;

    @SerializedName("cover")
    private String url;

    @SerializedName("screen_name")
    private String screenName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
}
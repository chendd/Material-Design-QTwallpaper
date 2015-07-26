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
    private String cover;

    @SerializedName("url")
    private String url;

    @SerializedName("screen_name")
    private String screenName;


}

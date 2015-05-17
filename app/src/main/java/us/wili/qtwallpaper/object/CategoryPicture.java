package us.wili.qtwallpaper.object;

import com.google.gson.annotations.SerializedName;

/**
 * Created by qiu on 5/18/15.
 */
public class CategoryPicture {

    @SerializedName("name")
    private String name;

    @SerializedName("cover")
    private String url;

    @SerializedName("screen_name")
    private String screenName;

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

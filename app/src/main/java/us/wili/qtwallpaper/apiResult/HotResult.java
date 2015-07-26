package us.wili.qtwallpaper.apiResult;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import us.wili.qtwallpaper.object.HotPicture;

/**
 * Created by qiu on 5/17/15.
 */
public class HotResult {

    @SerializedName("count")
    private Integer count;

    @SerializedName("picture")
    private List<HotPicture> hotPictures;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<HotPicture> getHotPictures() {
        return hotPictures;
    }

    public void setHotPictures(List<HotPicture> hotPictures) {
        this.hotPictures = hotPictures;
    }
}

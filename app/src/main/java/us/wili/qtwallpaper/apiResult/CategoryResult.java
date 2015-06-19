package us.wili.qtwallpaper.apiResult;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import us.wili.qtwallpaper.object.CategoryPicture;

/**
 * Created by qiu on 5/17/15.
 */
public class CategoryResult extends GenericResult{

    @SerializedName("count")
    private Integer count;

    @SerializedName("category")
    private List<CategoryPicture> categorys;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<CategoryPicture> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<CategoryPicture> categorys) {
        this.categorys = categorys;
    }
}

package us.wili.qtwallpaper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import us.wili.qtwallpaper.config.GlobalConfig;
import us.wili.qtwallpaper.object.CategoryPicture;
import us.wili.qtwallpaper.utils.ColorUtils;

/**
 * Created by qiu on 5/11/15.
 */
public class CategoryListAdapter extends ArrayAdapter<CategoryPicture> {
    private int mResource;
    private ImageLoader imageLoader;
    private AbsListView.LayoutParams imgParams;

    public CategoryListAdapter(Context context, int resource) {
        super(context, resource);
        this.mResource = resource;
        imageLoader = ImageLoader.getInstance();
        int height = (int)((float)(GlobalConfig.screenWidth)/(float)GlobalConfig.categoryMaskWidth * GlobalConfig.categoryMaskHeight);
        imgParams = new AbsListView.LayoutParams(GlobalConfig.screenWidth, height);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(mResource, parent, false);
        }
        ((ImageView)convertView).setLayoutParams(imgParams);
        imageLoader.displayImage(getItem(position).getUrl(), (ImageView)convertView,
                new DisplayImageOptions.Builder().showImageOnLoading(ColorUtils.getRandomColor()).build());
        return convertView;
    }


}

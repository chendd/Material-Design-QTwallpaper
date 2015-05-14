package us.wili.qtwallpaper.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.config.GlobalConfig;

/**
 * Created by qiu on 5/11/15.
 */
public class CategoryListAdapter extends ArrayAdapter<HashMap<String, String>> {
    private int mResource;
    private ImageLoader imageLoader;
    private FrameLayout.LayoutParams imgParams;

    public CategoryListAdapter(Context context, int resource) {
        super(context, resource);
        this.mResource = resource;
        imageLoader = ImageLoader.getInstance();
        int height = (int)((float)(GlobalConfig.screenWidth)/(float)GlobalConfig.categoryMaskWidth * GlobalConfig.categoryMaskHeight);
        imgParams = new FrameLayout.LayoutParams(GlobalConfig.screenWidth, height);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img.setLayoutParams(imgParams);
        imageLoader.displayImage(getItem(position).get("url"), holder.img);
        return convertView;
    }

    private class ViewHolder{
        ImageView img;
    }

}

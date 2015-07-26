package us.wili.qtwallpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.apiResult.HotResult;
import us.wili.qtwallpaper.config.GlobalConfig;
import us.wili.qtwallpaper.config.MySingleton;
import us.wili.qtwallpaper.connect.QTApi;
import us.wili.qtwallpaper.object.CategoryPicture;
import us.wili.qtwallpaper.object.HotPicture;

/**
 * Created by qiu on 7/4/15.
 */
public class HotHeaderRecyclerAdapter extends RecyclerView.Adapter<HotHeaderRecyclerAdapter.HotViewHolder>{

    private List<HotPicture> pictures = new ArrayList<>();
    private AbsListView.LayoutParams imgParams;
    private ImageLoader imageLoader;

    public HotHeaderRecyclerAdapter(Context context){
        imageLoader = MySingleton.getInstance(context).getImageLoader();
        int height = (int)((float)(GlobalConfig.screenWidth)/(float)GlobalConfig.categoryMaskWidth * GlobalConfig.categoryMaskHeight);
        imgParams = new AbsListView.LayoutParams(GlobalConfig.screenWidth, height);
    }

    public void addAll(List<HotPicture> pictureList){
        this.pictures.addAll(pictureList);
        this.notifyDataSetChanged();
    }

    public void clear(){
        this.pictures.clear();
        this.notifyDataSetChanged();
    }

    public static class HotViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public HotViewHolder(ImageView imageView) {
            super(imageView);
            img = imageView;
        }
    }

    @Override
    public HotViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ImageView imageView = (ImageView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_list_item, viewGroup, false);
        imageView.setLayoutParams(imgParams);
        return new HotViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(HotViewHolder hotViewHolder, int i) {
        imageLoader.displayImage(pictures.get(i).getUrl() + QTApi.COMPRESS_20, hotViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }
}

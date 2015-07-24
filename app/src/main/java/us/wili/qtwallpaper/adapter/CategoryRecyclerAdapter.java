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
import us.wili.qtwallpaper.config.GlobalConfig;
import us.wili.qtwallpaper.config.MySingleton;
import us.wili.qtwallpaper.object.CategoryPicture;

/**
 * Created by qiu on 7/4/15.
 */
public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryViewHolder>{

    private List<CategoryPicture> pictures = new ArrayList<>();
    private AbsListView.LayoutParams imgParams;
    private ImageLoader imageLoader;

    public CategoryRecyclerAdapter(Context context){
        imageLoader = MySingleton.getInstance(context).getImageLoader();
        int height = (int)((float)(GlobalConfig.screenWidth)/(float)GlobalConfig.categoryMaskWidth * GlobalConfig.categoryMaskHeight);
        imgParams = new AbsListView.LayoutParams(GlobalConfig.screenWidth, height);
    }

    public void addAll(List<CategoryPicture> pictureList){
        this.pictures.addAll(pictureList);
        this.notifyDataSetChanged();
    }

    public void clear(){
        this.pictures.clear();
        this.notifyDataSetChanged();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;

        public CategoryViewHolder(ImageView imageView) {
            super(imageView);
            img = imageView;
        }
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ImageView imageView = (ImageView) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_list_item, viewGroup, false);
        imageView.setLayoutParams(imgParams);
        return new CategoryViewHolder(imageView);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder categoryViewHolder, int i) {
        imageLoader.displayImage(pictures.get(i).getUrl(), categoryViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }
}

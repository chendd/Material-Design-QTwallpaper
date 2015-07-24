package us.wili.qtwallpaper.config;

import android.app.Application;
import android.util.DisplayMetrics;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import us.wili.qtwallpaper.utils.ColorUtils;
import us.wili.qtwallpaper.utils.FileUtils;

/**
 * Created by qiu on 5/7/15.
 */
public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        new FileUtils(this);

        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        GlobalConfig.screenWidth = dm.widthPixels;
        GlobalConfig.screenHeight = dm.heightPixels;
    }


}

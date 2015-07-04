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

        initImageLoaderConfig();

        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        GlobalConfig.screenWidth = dm.widthPixels;
        GlobalConfig.screenHeight = dm.heightPixels;
    }

    private void initImageLoaderConfig(){
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.threadPoolSize(ImageLoaderConfiguration.Builder.DEFAULT_THREAD_POOL_SIZE);
        //default memory cache is LruMemoryCache
        config.memoryCacheSize(GlobalConfig.maxMemoryCacheSize);
        //default disk cache is UnlimitedDiscCache
        config.diskCacheFileNameGenerator(new HashCodeFileNameGenerator());
        config.diskCacheSize(GlobalConfig.maxDiskCacheSize);
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs();

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnLoading(ColorUtils.getRandomColor())
                .build();

        config.defaultDisplayImageOptions(options);
        ImageLoader.getInstance().init(config.build());
    }
}

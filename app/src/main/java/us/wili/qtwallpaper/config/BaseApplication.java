package us.wili.qtwallpaper.config;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

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

        ImageLoader.getInstance().init(config.build());
    }
}

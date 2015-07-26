package us.wili.qtwallpaper.config;

import android.app.Activity;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import us.wili.qtwallpaper.utils.ColorUtils;

/**
 * 单例类,高效使用Volley和ImageLoader
 * Created by qiu on 7/24/15.
 */
public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private MySingleton(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

        initImageLoaderConfig();
        mImageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }

    public static synchronized MySingleton getInstance(Activity activity) {
        if (mInstance == null) {
            mInstance = new MySingleton(activity.getApplicationContext());
        }
        return mInstance;
    }

    private void initImageLoaderConfig(){
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(mCtx.getApplicationContext());
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
        com.nostra13.universalimageloader.core.ImageLoader.getInstance().init(config.build());
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}

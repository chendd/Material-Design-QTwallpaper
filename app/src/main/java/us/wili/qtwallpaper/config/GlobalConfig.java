package us.wili.qtwallpaper.config;

/**
 * Created by qiu on 5/8/15.
 */
public class GlobalConfig {

    //Universal ImageLoader Config
    public static final int maxMemoryCacheSize = 1024 * 1024 * 5; //5MB
    public static final int maxDiskCacheSize = 1024 * 1024 * 50; //50MB

    //Device Config
    public static int screenWidth;
    public static int screenHeight;

    //Picture Config
    public static final int pictureMaskWidth = 744;
    public static final int pictureMaskHeight = 1392;
    public static final int categoryMaskWidth = 640;
    public static final int categoryMaskHeight = 380;
}

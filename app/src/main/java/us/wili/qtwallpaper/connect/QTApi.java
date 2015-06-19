package us.wili.qtwallpaper.connect;

import com.loopj.android.http.RequestParams;

/**
 * Created by qiu on 5/18/15.
 */
public class QTApi {
    public static final String BASE_URL = "http://bizhi.ima9ic.co";
    public static final String RECOMMENT_WALLPAPER = BASE_URL + "/wallpaper/?recommend";
    public static final String CATEGORY = BASE_URL + "/category";
    public static final String CATEGORY_DETAIL = BASE_URL + "/wallpaper/?category=";
    public static final String COMPRESS_20 = "?imageMogr2/thumbnail/!20p";
    public static final String STAR_WALLPAPER = BASE_URL + "/userstar";
    public static final String SET_STAR = BASE_URL + "/event/";
    public static final String POST_USERINFO = BASE_URL + "/userinfo/";

    private static com.loopj.android.http.AsyncHttpClient client = new com.loopj.android.http.AsyncHttpClient();

    public static void getData(String url, RequestParams params, GenericResultHandler handler){
        client.get(url, params, handler);
    }

    public static void postData(String url, RequestParams params, GenericResultHandler handler){
        client.post(url, params, handler);
    }
}

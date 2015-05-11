package us.wili.qtwallpaper.utils;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qiu on 5/9/15.
 */
public class ConnectUtils {
    public static final String BASE_URL = "http://bizhi.ima9ic.co";
    public static final String RECOMMENT_WALLPAPER = BASE_URL + "/wallpaper/?recommend";
    public static final String CATEGORY = BASE_URL + "/category";
    public static final String CATEGORY_DETAIL = BASE_URL + "/wallpaper/?category=";
    public static final String COMPRESS_20 = "?imageMogr2/thumbnail/!20p";
    public static final String STAR_WALLPAPER = BASE_URL + "/userstar";
    public static final String SET_STAR = BASE_URL + "/event/";
    public static final String POST_USERINFO = BASE_URL + "/userinfo/";

    //获取Hot推荐壁纸
    public static String loadRecommendWallpaper() {
        String result = "";
        try {
            URL infoUrl = new URL(RECOMMENT_WALLPAPER);
            HttpURLConnection conn = (HttpURLConnection) infoUrl
                    .openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(in);
            StringBuffer strBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                strBuffer.append(line);
            }
            result = strBuffer.toString();
        } catch (Exception ex) {
            LogUtils.printLogE("can not load recommend wallpaper");
        }
        return result;
    }

    //获取Category分类壁纸
    public static String loadCategory() {
        String result = "";
        try {
            URL infoUrl = new URL(CATEGORY);
            HttpURLConnection conn = (HttpURLConnection) infoUrl
                    .openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(in);
            StringBuffer strBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                strBuffer.append(line);
            }
            result = strBuffer.toString();
        } catch (Exception ex) {
            LogUtils.printLogE("can not load category wallpaper");
        }
        return result;
    }

    //获取分类详情
    public static String loadCategoryDetail(String category) {
        String result = "";
        try {
            URL infoUrl = new URL(CATEGORY_DETAIL + category);
            HttpURLConnection conn = (HttpURLConnection) infoUrl
                    .openConnection();
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(true);
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(in);
            StringBuffer strBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                strBuffer.append(line);
            }
            result = strBuffer.toString();
        } catch (Exception ex) {
            LogUtils.printLogE("can not load category detail");
        }
        return result;
    }

    //加载我的收藏
    public static String loadStar(String uid) {
        HttpClient httpClient = new DefaultHttpClient();
        String result = "";
        try {
            // 创建HttpPost对象。
            HttpPost post = new HttpPost(STAR_WALLPAPER);
            // 如果传递参数个数比较多的话可以对传递的参数进行封装
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            Map<String, String> map = new HashMap<String, String>();
            map.put("uid", uid);
            for (String key : map.keySet()) {
                // 封装请求参数
                params.add(new BasicNameValuePair(key, map.get(key)));
            }
            // 设置请求参数
            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            // 发送POST请求
            HttpResponse httpResponse = httpClient.execute(post);
            // 如果服务器成功地返回响应
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                // 获取服务器响应字符串
                result = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            LogUtils.printLogE("can not load star wallpaper");
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return result;
    }

    //设置我的收藏
    public static String setStar(String uid, int paperID, boolean reduce) {
        HttpClient httpClient = new DefaultHttpClient();
        String result = "";
        try {
            // 创建HttpPost对象。
            HttpPost post = new HttpPost(SET_STAR);
            // 如果传递参数个数比较多的话可以对传递的参数进行封装
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            Map<String, String> map = new HashMap<String, String>();
            map.put("uid", uid);
            map.put("type", "star");
            map.put("wallpaperID", String.valueOf(paperID));
            if(reduce)
                map.put("reduce", String.valueOf(reduce));
            for (String key : map.keySet()) {
                // 封装请求参数
                params.add(new BasicNameValuePair(key, map.get(key)));
            }
            // 设置请求参数
            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            // 发送POST请求
            HttpResponse httpResponse = httpClient.execute(post);
            // 如果服务器成功地返回响应
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                // 获取服务器响应字符串
                result = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            LogUtils.printLogE("can not set star");
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return result;
    }

    //设置喜欢壁纸
    public static String setLike(int paperID) {
        HttpClient httpClient = new DefaultHttpClient();
        String result = "";
        try {
            // 创建HttpPost对象。
            HttpPost post = new HttpPost(SET_STAR);
            // 如果传递参数个数比较多的话可以对传递的参数进行封装
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            Map<String, String> map = new HashMap<String, String>();
            map.put("type", "like");
            map.put("wallpaperID", String.valueOf(paperID));
            //map.put("reduce", "TRUE");
            for (String key : map.keySet()) {
                // 封装请求参数
                params.add(new BasicNameValuePair(key, map.get(key)));
            }
            // 设置请求参数
            post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            // 发送POST请求
            HttpResponse httpResponse = httpClient.execute(post);
            // 如果服务器成功地返回响应
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                // 获取服务器响应字符串
                result = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            LogUtils.printLogE("can not set like");
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return result;
    }
}

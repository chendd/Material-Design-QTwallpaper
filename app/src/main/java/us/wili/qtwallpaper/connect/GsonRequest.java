package us.wili.qtwallpaper.connect;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;

import us.wili.qtwallpaper.utils.LogUtils;

/**
 * Created by qiu on 7/22/15.
 */
public class GsonRequest<T> extends Request<T>{
    private Gson mGson;

    private Class<T> mClass;
    private Response.Listener<T> mListener;

    public GsonRequest(Class<T> tClass, Response.Listener<T> tListener,
                       int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
        mGson = new Gson();
        mClass = tClass;
        mListener = tListener;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            return Response.success(parseJsonResponse(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }



    //解析Json字符串
    protected T parseJsonResponse(String responseString) {
        LogUtils.printLogD("The response content is: " + responseString);
        Gson gson = new Gson();
        long start = Calendar.getInstance().getTimeInMillis();
        T jsonResult = null;
        try {
            jsonResult = (T) gson.fromJson(responseString, this.mClass);
        }catch (Exception e){
            LogUtils.printLogD("Can not parse response content : " + responseString);
        }
        long end = Calendar.getInstance().getTimeInMillis();
        LogUtils.printLogI("The time used for parsing is " + (end - start) + " millis");
        return jsonResult;

    }
}

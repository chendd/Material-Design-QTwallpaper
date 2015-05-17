package us.wili.qtwallpaper.connect;

import android.content.Context;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import java.util.Calendar;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.apiResult.GenericResult;
import us.wili.qtwallpaper.utils.LogUtils;

/**
 * Created by qiu on 5/17/15.
 */
public class GenericResultHandler<T extends GenericResult> extends TextHttpResponseHandler {
    private Context context;
    private Class<T> resultClass;

    public GenericResultHandler(Context context, Class<T> resultClass){
        super();
        this.resultClass = resultClass;
        this.context = context;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String responseString) {
        GenericResult result = this.parseJsonResponse(responseString);
        if(result != null && !GenericResult.class.getName().equals(this.resultClass.getName()) && result.getClass().getName().equals(GenericResult.class.getName())){
            this.onFail();
        }else {
            this.onSuccess((T) result);
        }
        this.onComplete();
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        this.onFail();
        this.onComplete();
    }

    //解析Json字符串
    protected T parseJsonResponse(String responseString) {
        LogUtils.printLogD("The response content is: " + responseString);
        Gson gson = new Gson();
        long start = Calendar.getInstance().getTimeInMillis();
        T jsonResult = null;
        try {
            jsonResult = (T) gson.fromJson(responseString, this.resultClass);
        }catch (Exception e){
            LogUtils.printLogD("Can not parse response content : " + responseString);
        }
        long end = Calendar.getInstance().getTimeInMillis();
        LogUtils.printLogI("The time used for parsing is " + (end - start) + " millis");
        return jsonResult;

    }

    public void onSuccess(T genericResult){

    }

    public void onFail(){
        if(this.context != null) {
            Toast.makeText(this.context, R.string.network_error_hint, Toast.LENGTH_SHORT).show();
        }
    }

    protected void onComplete(){

    }
}

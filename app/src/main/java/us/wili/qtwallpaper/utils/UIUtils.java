package us.wili.qtwallpaper.utils;

import android.view.View;

/**
 * Created by qiu on 5/17/15.
 */
public class UIUtils {

    public static void setImmersiveActivity(View decorView){
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_IMMERSIVE | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}

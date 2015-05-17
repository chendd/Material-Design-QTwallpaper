package us.wili.qtwallpaper.activity;

import android.app.Activity;
import android.os.Bundle;

import us.wili.qtwallpaper.utils.UIUtils;

/**
 * Created by qiu on 5/3/15.
 */
public class BaseActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIUtils.setImmersiveActivity(getWindow().getDecorView());
    }
}

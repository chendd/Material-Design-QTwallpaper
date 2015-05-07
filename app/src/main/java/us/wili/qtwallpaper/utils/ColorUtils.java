package us.wili.qtwallpaper.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by qiu on 5/7/15.
 */
public class ColorUtils {

    public static void setRefreshLayoutColor(SwipeRefreshLayout refreshLayout, Context context){
        Resources resources = context.getResources();
        refreshLayout.setColorSchemeColors(resources.getColor(android.R.color.holo_blue_bright),
                resources.getColor(android.R.color.holo_green_light),
                resources.getColor(android.R.color.holo_orange_light),
                resources.getColor(android.R.color.holo_red_light));
    }
}

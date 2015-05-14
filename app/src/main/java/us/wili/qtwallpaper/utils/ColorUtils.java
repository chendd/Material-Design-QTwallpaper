package us.wili.qtwallpaper.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;

import java.util.Random;

/**
 * Created by qiu on 5/7/15.
 */
public class ColorUtils {
    private static String colors[] = {"#AAC3DE","#B3CFC6","#9592AA","#A8DDC7","#928087","#E7F1FE","#F7F3CE","#A191AE"};
    private static Random random = new Random();

    public static void setRefreshLayoutColor(SwipeRefreshLayout refreshLayout, Context context){
        Resources resources = context.getResources();
        refreshLayout.setColorSchemeColors(resources.getColor(android.R.color.holo_blue_bright),
                resources.getColor(android.R.color.holo_green_light),
                resources.getColor(android.R.color.holo_orange_light),
                resources.getColor(android.R.color.holo_red_light));
    }

    public static int getRandomColor(){
        return Color.parseColor(colors[random.nextInt(8)]);
    }
}

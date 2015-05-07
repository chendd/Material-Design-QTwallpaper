package us.wili.qtwallpaper.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by qiu on 5/8/15.
 */
public class LogUtils {
    public static final String TAG = "Debug";

    private static final boolean DEBUG_FLAG = true;

    public static void println(String printInfo) {
        if (DEBUG_FLAG && null != printInfo) {
            System.out.println(printInfo);
        }
    }

    public static void print(String printInfo) {
        if (DEBUG_FLAG && null != printInfo) {
            System.out.print(printInfo);
        }
    }

    public static void printLogI(String logInfo) {
        printLogI(TAG, logInfo);
    }

    public static void printLogI(String tag, String logInfo) {
        if (DEBUG_FLAG && null != tag && null != logInfo) {
            Log.i(tag, logInfo);
        }
    }

    public static void printLogE(String logInfo) {
        printLogE(TAG, logInfo);
    }

    public static void printLogE(String tag, String logInfo) {
        if (DEBUG_FLAG && null != tag && null != logInfo) {
            Log.e(tag, logInfo);
        }
    }

    public static void printLogW(String logInfo) {
        printLogW(TAG, logInfo);
    }

    public static void printLogW(String tag, String logInfo) {
        if (DEBUG_FLAG && null != tag && null != logInfo) {
            Log.w(tag, logInfo);
        }
    }

    public static void printLogD(String logInfo) {
        printLogD(TAG, logInfo);
    }

    public static void printLogD(String tag, String logInfo) {
        if (DEBUG_FLAG && null != tag && null != logInfo) {
            Log.d(tag, logInfo);
        }
    }

    public static void printLogV(String logInfo) {
        printLogV(TAG, logInfo);
    }

    public static void printLogV(String tag, String logInfo) {
        if (DEBUG_FLAG && null != tag || null != logInfo) {
            Log.v(tag, logInfo);
        }
    }

    public static void printLogWtf(String logInfo) {
        printLogWtf(TAG, logInfo);
    }

    public static void printLogWtf(String tag, String logInfo) {
        if (DEBUG_FLAG && null != tag && null != logInfo) {
            Log.wtf(tag, logInfo);
        }
    }

    public static void showToast(Context context, String toastInfo) {
        if (null != context && null != toastInfo) {
            Toast.makeText(context, toastInfo, Toast.LENGTH_LONG).show();
        }
    }

    public static void showToast(Context context, String toastInfo, int timeLen) {
        if (null != context && null != toastInfo && (timeLen > 0)) {
            Toast.makeText(context, toastInfo, timeLen).show();
        }
    }
}

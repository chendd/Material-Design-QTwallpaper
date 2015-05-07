package us.wili.qtwallpaper.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by qiu on 5/8/15.
 */
public class FileUtils {
    private static String innerFileDir;
    private static String externalFileDir;

    public static String getInnerFileDir() {
        return innerFileDir;
    }

    public static String getExternalFileDir() {
        return externalFileDir;
    }

    public FileUtils(Context context){
        File inner = context.getFilesDir();
        if(!inner.exists()){
            inner.getParentFile().mkdirs();
        }
        innerFileDir = inner.getAbsolutePath();

        File exter;
        if(isExternalStorageWritable()){
            exter = context.getExternalFilesDir(null);
            if(!exter.exists()){
                exter.getParentFile().mkdirs();
            }
            externalFileDir = exter.getAbsolutePath();
        }else{
            externalFileDir = innerFileDir;
        }

    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}

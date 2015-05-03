package us.wili.qtwallpaper.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import us.wili.qtwallpaper.R;

/**
 * Created by qiu on 5/3/15.
 */
public class Hot extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot,container,false);
    }
}

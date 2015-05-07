package us.wili.qtwallpaper.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.utils.ColorUtils;

/**
 * Created by qiu on 5/3/15.
 */
public class Category extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout refreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_category,container,false);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(this);
        ColorUtils.setRefreshLayoutColor(refreshLayout, this.getActivity());
        return view;
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        },5000);
    }
}

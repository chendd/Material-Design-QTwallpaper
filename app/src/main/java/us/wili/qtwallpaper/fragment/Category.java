package us.wili.qtwallpaper.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.utils.ColorUtils;

/**
 * Created by qiu on 5/3/15.
 */
public class Category extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout refreshLayout;
    private ListView categoryList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        categoryList = (ListView) view.findViewById(R.id.list_view);

        ColorUtils.setRefreshLayoutColor(refreshLayout, this.getActivity());
        refreshLayout.setOnRefreshListener(this);
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

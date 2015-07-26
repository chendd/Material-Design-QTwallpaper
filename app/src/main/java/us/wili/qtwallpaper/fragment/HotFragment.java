package us.wili.qtwallpaper.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.adapter.HotHeaderRecyclerAdapter;
import us.wili.qtwallpaper.apiResult.HotResult;
import us.wili.qtwallpaper.config.MySingleton;
import us.wili.qtwallpaper.connect.GsonRequest;
import us.wili.qtwallpaper.connect.QTApi;
import us.wili.qtwallpaper.utils.ColorUtils;

/**
 * Created by qiu on 5/3/15.
 */
public class HotFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView hotList;
    private SwipeRefreshLayout refreshLayout;
    private HotHeaderRecyclerAdapter hotAdapter;

    private GsonRequest<HotResult> hotRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        hotList = (RecyclerView) refreshLayout.findViewById(R.id.recycler_view);

        hotList.setHasFixedSize(true);
        hotList.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        ColorUtils.setRefreshLayoutColor(refreshLayout, this.getActivity());
        refreshLayout.setOnRefreshListener(this);

        hotAdapter = new HotHeaderRecyclerAdapter(this.getActivity());
        hotList.setAdapter(hotAdapter);

        hotRequest = new GsonRequest<>(Request.Method.GET, QTApi.RECOMMENT_WALLPAPER, HotResult.class,
                new Response.Listener<HotResult>() {
                    @Override
                    public void onResponse(HotResult response) {
                        hotAdapter.clear();
                        hotAdapter.addAll(response.getHotPictures());
                        refreshLayout.setRefreshing(false);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                refreshLayout.setRefreshing(false);
            }
        });

        refresh();
        refreshLayout.setRefreshing(true);
    }

    private void refresh(){
        MySingleton.getInstance(this.getActivity()).addToRequestQueue(hotRequest);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}

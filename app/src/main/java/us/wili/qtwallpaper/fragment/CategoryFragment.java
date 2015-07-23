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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.adapter.CategoryRecyclerAdapter;
import us.wili.qtwallpaper.apiResult.CategoryResult;
import us.wili.qtwallpaper.connect.GsonRequest;
import us.wili.qtwallpaper.connect.QTApi;
import us.wili.qtwallpaper.utils.ColorUtils;

/**
 * Created by qiu on 5/3/15.
 */
public class CategoryFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView categoryList;
    private CategoryRecyclerAdapter listAdapter;

    private RequestQueue requestQueue;
    private GsonRequest<CategoryResult> categoryRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        categoryList = (RecyclerView) refreshLayout.findViewById(R.id.recycler_view);
        categoryList.setHasFixedSize(true);
        categoryList.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        ColorUtils.setRefreshLayoutColor(refreshLayout, this.getActivity());
        refreshLayout.setOnRefreshListener(this);

        listAdapter = new CategoryRecyclerAdapter();
        categoryList.setAdapter(listAdapter);

        requestQueue = Volley.newRequestQueue(this.getActivity());
        categoryRequest = new GsonRequest<>(CategoryResult.class, new Response.Listener<CategoryResult>() {
            @Override
            public void onResponse(CategoryResult response) {
                listAdapter.clear();
                listAdapter.addAll(response.getCategorys());
                refreshLayout.setRefreshing(false);
            }
        }, Request.Method.GET, QTApi.CATEGORY, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                refreshLayout.setRefreshing(false);
            }
        });

        refreshLayout.setRefreshing(true);
        refreshCategoryList();
    }

    private void refreshCategoryList(){
        requestQueue.add(categoryRequest);
    }

    @Override
    public void onRefresh() {
        refreshCategoryList();
    }
}

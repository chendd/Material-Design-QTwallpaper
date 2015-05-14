package us.wili.qtwallpaper.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import us.wili.qtwallpaper.R;
import us.wili.qtwallpaper.adapter.CategoryListAdapter;
import us.wili.qtwallpaper.object.Category;
import us.wili.qtwallpaper.utils.ConnectUtils;
import us.wili.qtwallpaper.utils.JsonUtils;

/**
 * Created by qiu on 5/3/15.
 */
public class CategoryFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout refreshLayout;
    private ListView categoryList;
    private CategoryListAdapter listAdapter;

    private Handler refreshHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh_layout);
        categoryList = (ListView) view.findViewById(R.id.list_view);

//        ColorUtils.setRefreshLayoutColor(refreshLayout, this.getActivity());
//        refreshLayout.setOnRefreshListener(this);

        listAdapter = new CategoryListAdapter(this.getActivity(), R.layout.category_list_item);
        categoryList.setAdapter(listAdapter);
        initRefreshHandler();
        refreshCategoryList();
    }

    private void initRefreshHandler(){
        refreshHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                listAdapter.clear();
                listAdapter.addAll((ArrayList<HashMap<String, String>>)msg.obj);
//                refreshLayout.setRefreshing(false);
            }
        };
    }

    private void refreshCategoryList(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                String categoryResult = ConnectUtils.loadCategory();
                if(!TextUtils.isEmpty(categoryResult)){
                    ArrayList<Category> catList = JsonUtils
                            .parseCategoryList(categoryResult);
                    ArrayList<HashMap<String, String>> imgUrlList = new ArrayList<HashMap<String, String>>();
                    for(int i=0;i<catList.size();++i){
                        HashMap<String, String> map=new HashMap<String, String>();
                        map.put("url", catList.get(i).cover);
                        map.put("name", catList.get(i).name);
                        map.put("screen_name", catList.get(i).screen_name);
                        imgUrlList.add(map);
                    }
                    Message message = new Message();
                    message.obj = imgUrlList;
                    refreshHandler.sendMessage(message);
                }
                Looper.loop();
            }
        }).start();
    }

    @Override
    public void onRefresh() {
        refreshCategoryList();
    }
}

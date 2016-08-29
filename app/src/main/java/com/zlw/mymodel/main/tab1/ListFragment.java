package com.zlw.mymodel.main.tab1;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zlw.mymodel.R;
import com.zlw.mymodel.adapter.RecyclerViewAdapter;
import com.zlw.mymodel.common.Const;
import com.zlw.mymodel.main.bean.ContentEntity;
import com.zlw.mymodel.main.tab1.presenter.Tab1Persenter;
import com.zlw.mymodel.main.tab1.presenter.Tab1PersenterImpl;
import com.zlw.mymodel.main.tab1.view.Tab1View;
import com.zlw.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * <页面一> 文字
 * Created by zlw on 2016/6/28 0028.
 */
public class ListFragment extends Fragment implements Tab1View {

    //变量
    private int type = Const.TYPE_TEXT;
    private int page = 1;  //默认为第一页


    //控件
    private PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    private Tab1Persenter persenter;

 
    public ListFragment(int type) {
        this.type = type;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        persenter = new Tab1PersenterImpl(this);
        return inflater.inflate(R.layout.fragment_tab1_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPullLoadMoreRecyclerView = (PullLoadMoreRecyclerView) view.findViewById(R.id.pullLoadMoreRecyclerView);
        // mPullLoadMoreRecyclerView.setRefreshing(true);//设置下拉刷新是否可见
        //mPullLoadMoreRecyclerView.setPullRefreshEnable(false);//设置是否下拉刷新
        //mPullLoadMoreRecyclerView.setPushRefreshEnable(false);//设置是否上拉刷新
        mPullLoadMoreRecyclerView.setFooterViewText("正在加载...");//设置上拉刷新文字
        mPullLoadMoreRecyclerView.setLinearLayout();
        persenter.initAdapter(type);

    }


    @Override
    public void loadData1(final List<ContentEntity> lists) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        List<ContentEntity> data = new ArrayList<ContentEntity>();
                        List<ContentEntity> tmp = mRecyclerViewAdapter.getDataList();
                        data.addAll(tmp);//原数据
                        data.addAll(lists);//新加载的数据
                        mRecyclerViewAdapter.setDataList(data);
                        mRecyclerViewAdapter.notifyDataSetChanged();
                        mPullLoadMoreRecyclerView.setPullLoadMoreCompleted();
                        page++;
                    }
                });
            }
        }, 100);

    }

    /**
     * 初始化数据适配器
     *
     * @param lists 数据适配器初始数据
     */
    @Override
    public void initAdapter(List<ContentEntity> lists) {
        //加载适配器
        mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(), lists);
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
        //设置监听事件
        mPullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreListener());
        mPullLoadMoreRecyclerView.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.empty_view, null));//setEmptyView
    }


    //============配置加载回调事件===============

    class PullLoadMoreListener implements PullLoadMoreRecyclerView.PullLoadMoreListener {
        /**
         * 上拉刷新回调
         */
        @Override
        public void onRefresh() {
            page = 1;
            mRecyclerViewAdapter.removeDataList();
            persenter.getData(type, page);
        }

        /**
         * 下拉加载回调
         */
        @Override
        public void onLoadMore() {
            persenter.getData(type, page);
        }
    }


}

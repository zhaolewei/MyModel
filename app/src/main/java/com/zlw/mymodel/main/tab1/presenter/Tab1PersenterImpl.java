package com.zlw.mymodel.main.tab1.presenter;

import android.util.Log;

import com.zlw.mymodel.main.bean.ContentEntity;
import com.zlw.mymodel.main.tab1.model.Tab1Model;
import com.zlw.mymodel.main.tab1.model.Tab1ModelImpl;
import com.zlw.mymodel.main.tab1.view.Tab1View;
import com.zlw.mymodel.service.Item;

import java.util.List;

/**
 * Created by 123 on 2016/6/29 0029.
 */
public class Tab1PersenterImpl implements Tab1Persenter {

    private Tab1View mTab1View;
    private Tab1Model mTab1Model;

    public Tab1PersenterImpl(Tab1View mTab1View) {
        this.mTab1View = mTab1View;
        mTab1Model = new Tab1ModelImpl();
    }

    /**
     * 获取数据并加载
     *
     * @param type
     * @param page
     */
    @Override
    public void getData(int type, int page) {
        mTab1Model.loadData(type, page, new Tab1Model.Tab1LoadDataListener() {
            // Tab1Model.Tab1LoadDataListener
            @Override
            public void onSuccess(List<ContentEntity> lists) {
                mTab1View.loadData1(lists);
            }

            @Override
            public void onFailure(String msg) {
            }
        });
    }

    @Override
    public void initAdapter(int type) {
        mTab1Model.loadData(type, 1, new Tab1Model.Tab1LoadDataListener() {
            @Override
            public void onSuccess(List<ContentEntity> lists) {
                mTab1View.initAdapter(lists);
            }

            @Override
            public void onFailure(String msg) {

            }
        });
    }


}

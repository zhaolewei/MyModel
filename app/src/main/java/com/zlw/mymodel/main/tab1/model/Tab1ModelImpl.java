package com.zlw.mymodel.main.tab1.model;

import android.util.Log;

import com.zlw.mymodel.main.bean.ContentEntity;
import com.zlw.mymodel.service.DataService2;
import com.zlw.mymodel.service.ILoadDataListener;
import com.zlw.mymodel.service.Item;
import com.zlw.mymodel.utils.LogUtil;

import java.util.List;

/**
 * Created by zlw on 2016/6/29 0029
 */
public class Tab1ModelImpl implements Tab1Model, ILoadDataListener {

    private Tab1LoadDataListener listener;

    @Override
    public void loadData(int type, int page, Tab1LoadDataListener listener) {
        this.listener = listener;
        DataService2 dataService2 = new DataService2();
        dataService2.getData(type,page,this);
    }

    /**
     * 加载获取到的数据
     *
     * @param result 数据List<ContentEntity> lists
     */
    @Override
    public void onParserSuccess(Object result) {
        List<ContentEntity> lists = (List<ContentEntity>) result;
        LogUtil.i("lists}|text:" + lists.get(0).getText());
        listener.onSuccess(lists);
    }
}

package com.zlw.mymodel.main.tab1.model;

import com.zlw.mymodel.main.bean.ContentEntity;
import com.zlw.mymodel.service.Item;

import java.util.List;

/**
 * Created by 123 on 2016/6/29 0029.
 */
public interface Tab1Model {

    void loadData(int type, int page, Tab1LoadDataListener listener);

    interface Tab1LoadDataListener {
        void onSuccess(List<ContentEntity> lists);

        void onFailure(String msg);
    }
}

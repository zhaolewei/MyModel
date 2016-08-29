package com.zlw.mymodel.main.tab1.view;

import com.zlw.mymodel.main.bean.ContentEntity;
import com.zlw.mymodel.service.Item;

import java.util.List;

/**
 * Created by 123 on 2016/6/29 0029.
 */
public interface Tab1View {
    /**
     * 加载初始数据（下拉刷新数据）
     *
     * @param lists 初始数据
     */
    void loadData1(List<ContentEntity> lists);

    /**
     * 初始化数据适配器
     *
     * @param lists 数据适配器初始数据
     */
    void initAdapter(List<ContentEntity> lists);
}

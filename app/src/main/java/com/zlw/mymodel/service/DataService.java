//package com.zlw.mymodel.service;
//
//import android.util.Log;
//
//import com.zlw.mymodel.utils.LogUtil;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * 模拟数据
// * Created by zlw on 2016/6/28 0028.
// */
//public class DataService {
//    private List<Item> lists;
//
//    public DataService() {
//        lists = new ArrayList<Item>();
//        initData();
//        //Test:
//        LogUtil.i("DataService2===========");
//        DataService2 service2 = new DataService2();
//        service2.getData();
//    }
//
//    private void initData() {
//        for (int i = 0; i < 60; i++) {
//            lists.add(new Item(i, "name" + i, "content" + i));
//        }
//    }
//
//
//    public List<Item> getDataByStart(int start, int count) {
//        int end = start + count;
//        List<Item> data = null;
//        if (end > lists.size()) {
//            end = lists.size();
//        }
//        if (start > lists.size()) {
//            start = lists.size();
//        }
//        data = lists.subList(start, end);
//        return data;
//    }
//
//}
